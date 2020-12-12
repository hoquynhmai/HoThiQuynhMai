import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {ServiceEmployeeService} from '../../../services/service-employee.service';
import {MatDatepicker} from '@angular/material/datepicker';

@Component({
  selector: 'app-create',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  public formCreateNew: FormGroup;
  public genderList;

  constructor(
    private serviceConnectService: ServiceEmployeeService,
    public formBuilder: FormBuilder,
    public router: Router
  ) {
  }

  ngOnInit() {
    this.serviceConnectService.getAllGender().subscribe(dataGender => {
      this.genderList = dataGender;
    });

    this.formCreateNew = this.formBuilder.group({
      employeeCode: [''],
      fullName: [''],
      birthDay: [''],
      gender: [''],
      email: [''],
      password: [''],
      numberPhone: [''],
      role: ['']
    });
  }

  createNew() {
    for (const element of this.genderList) {
      if (element.name === this.formCreateNew.value.gender) {
        this.formCreateNew.value.gender = element;
        break;
      }
    }

    this.serviceConnectService.createNewEmployee(this.formCreateNew.value).subscribe(data => {
      this.router.navigateByUrl('list-employee').then(_ => {
      });
    });
  }

  resetAll() {
    if (this.formCreateNew.valid) {
      this.formCreateNew.reset();
    }

    this.ngOnInit();
  }
}
