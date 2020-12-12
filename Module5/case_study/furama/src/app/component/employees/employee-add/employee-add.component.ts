import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {EmployeeService} from '../../../service/employee.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employee-add',
  templateUrl: './employee-add.component.html',
  styleUrls: ['./employee-add.component.css']
})
export class EmployeeAddComponent implements OnInit {
  public formAddNewEmployee: FormGroup;
  public positionList;
  public divisionList;
  public educationDegreeList;
  public router: Router;

  // Validatior Ngày Sinh (năm / tháng -1 / ngày)
  public maxDate = new Date(2012,11,31);
  public minDate = new Date (1920,0,1);

  constructor(
    public formBuilder: FormBuilder,
    public employeeService: EmployeeService
  ) {
  }

  ngOnInit(): void {
    this.formAddNewEmployee = this.formBuilder.group({
      name: ['', [Validators.required]],
      birthday: ['', [Validators.required]],
      idCard: ['', [Validators.required, Validators.pattern('^((\\d{9})|(\\d{12}))$')]],
      address: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', [Validators.required, Validators.pattern('(090|091|\\(84\\)(\\+90|\\+91))(\\d{7})')]],
      salary: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      division: [''],
      educationDegree: [''],
      position: [''],
    });

    this.employeeService.getAllPosition().subscribe(data=>{
      this.positionList = data;
      console.log(this.positionList);
    });

    this.employeeService.getAllDivision().subscribe(data=>{
      this.divisionList = data;
      console.log(this.divisionList);
    });

    this.employeeService.getAllEducationDegree().subscribe(data=>{
      this.educationDegreeList = data;
      console.log(this.educationDegreeList);
    })
  }

  addNewEmployee() {
    this.employeeService.addNewEmployeeService(this.formAddNewEmployee.value).subscribe(data => {
      this.router.navigateByUrl('employee-list').then(r => {})
    })
  }
}
