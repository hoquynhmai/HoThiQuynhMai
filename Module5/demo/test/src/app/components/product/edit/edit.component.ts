import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ServiceConnectService} from '../../../services/service-connect.service';
import {MatDatepicker} from '@angular/material/datepicker';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  public formEdit: FormGroup;
  public typeListEdit;
  public idNeed;
  public startDateTS = new Date('yyyy/MM/dd');
  public endDateTS = new Date('yyyy/MM/dd');
  public testStartDate = 'true';
  public testEndDate = 'true';

  constructor(

    // ----- ON Dialog -----
    public dialogRef: MatDialogRef<EditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,

    public formBuilder: FormBuilder,

    public serviceConnectService: ServiceConnectService,
    public router: Router,

    private activedRouter: ActivatedRoute
  ) {
  }

  ngOnInit() {
    this.serviceConnectService.getAllType().subscribe(dataType => {
      this.typeListEdit = dataType;
    });

    this.formEdit = this.formBuilder.group({
      idFormat: [this.data.dataNeed.idFormat],
      name: [this.data.dataNeed.name, Validators.required],
      price: [this.data.dataNeed.price, [Validators.required, Validators.pattern('^([0-9]+([.][0-9]+)?)$')]],
      startDate: [this.data.dataNeed.startDate, Validators.required],
      endDate: [this.data.dataNeed.endDate, Validators.required],
      type: [this.data.dataNeed.type.name]
    });

    // this.formEdit = this.formBuilder.group({
    //   idFormat: [''],
    //   name: ['', Validators.required],
    //   price: ['', [Validators.required, Validators.pattern('^([0-9]+([.][0-9]+)?)$')]],
    //   status: ['', Validators.required],
    //   type: ['']
    // });
    //
    // this.activedRouter.params.subscribe(data => {
    //   this.idNeed = data.id;
    //   this.serviceConnectService.findByID(this.idNeed).subscribe(data => {
    //
    //     for (let element of this.typeListEdit) {
    //       if (element.name === data.type.name) {
    //         data.type = element.name;
    //         break;
    //       }
    //     }
    //
    //     this.formEdit.patchValue(data);
    //   })
    // })
  }

  edit() {
    this.idNeed = this.data.dataNeed.id;

    if (this.testEndDate === 'false') {
      this.formEdit.value.startDate.setDate(this.startDateTS.getDate() - 7);
    }

    if (this.testStartDate === 'false') {
      this.formEdit.value.endDate.setDate(this.endDateTS.getDate() + 7);
    }

    for (const element of this.typeListEdit) {
      if (element.name === this.formEdit.value.type) {
        this.formEdit.value.type = element;
        break;
      }
    }

    this.serviceConnectService.editService(this.formEdit.value, this.idNeed).subscribe(data => {
      // this.router.navigateByUrl('list').then(_ => {});
      this.dialogRef.close();
    });
  }

  changeStartDate(startDate: MatDatepicker<any>, endDate: MatDatepicker<any>) {
    this.startDateTS = startDate._datepickerInput.value;
    this.endDateTS = endDate._datepickerInput.value;
    if (this.testStartDate === 'true') {
      console.log('change start date !');
      this.startDateTS.setDate(this.startDateTS.getDate() + 7);
      this.testEndDate = 'false';
    }
  }

  changeEndDate(endDate: MatDatepicker<any>, startDate: MatDatepicker<any>) {
    this.startDateTS = startDate._datepickerInput.value;
    this.endDateTS = endDate._datepickerInput.value;
    if (this.testEndDate === 'true') {
      console.log('change end date !');
      this.endDateTS.setDate(this.endDateTS.getDate() - 7);
      this.testStartDate = 'false';
    }
  }
}

// const test = this.list.find(element => element.id === this.idNeed);
