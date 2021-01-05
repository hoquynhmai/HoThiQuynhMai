import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ServiceEmployeeService} from '../../../services/service-employee.service';
import {MatDatepicker} from '@angular/material/datepicker';

@Component({
  selector: 'app-edit',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  public formEdit: FormGroup;
  public genderListEdit;
  public idNeed;

  constructor(
    public formBuilder: FormBuilder,
    public serviceEmployeeService: ServiceEmployeeService,
    public router: Router,
    private activedRouter: ActivatedRoute
  ) {
  }

  ngOnInit() {
    this.serviceEmployeeService.getAllGender().subscribe(dataGender => {
      this.genderListEdit = dataGender;
    });

    this.formEdit = this.formBuilder.group({
      employeeCode: [''],
      fullName: [''],
      birthDay: [''],
      gender: [''],
      email: [''],
      password: [''],
      numberPhone: [''],
      role: ['']
    });

    this.activedRouter.params.subscribe(data => {
      this.idNeed = data.id;
      this.serviceEmployeeService.findByID(this.idNeed).subscribe(data => {

        for (let element of this.genderListEdit) {
          if (element.name === data.gender.name) {
            data.gender = element.name;
            break;
          }
        }

        this.formEdit.patchValue(data);
      })
    })
  }

  edit() {
    for (const element of this.genderListEdit) {
      if (element.name === this.formEdit.value.gender) {
        this.formEdit.value.gender = element;
        break;
      }
    }

    this.serviceEmployeeService.editEmployee(this.formEdit.value, this.idNeed).subscribe(data => {
      this.router.navigateByUrl('list-employee').then(_ => {});
    });
  }
}
