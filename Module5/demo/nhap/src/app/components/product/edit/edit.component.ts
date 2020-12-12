import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {ServiceConnectService} from "../../../services/service-connect.service";
import {MatDatepicker} from "@angular/material/datepicker";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  public formEdit: FormGroup;
    public typeListEdit;
  public idNeed;
  public maxBirthday = new Date(2002,11,28);
  public startDateMin = new Date ();
  public startDateTS = new Date('yyyy/MM/dd');
  public endDateTS = new Date('yyyy/MM/dd');
  public testStartDate = 'true';
  public testEndDate = 'true';

  constructor(
    // --------------------- ON Dialog ------------------
    // public dialogRef: MatDialogRef<EditComponent>,
    // @Inject(MAT_DIALOG_DATA) public data: any,
    //----------------------------------------------------

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

    //----------------------------------------- Dialog -------------------------------------------------
    // this.formEdit = this.formBuilder.group({
    //   idFormat: [this.data.dataNeed.idFormat],
    //   name: [this.data.dataNeed.name],
    //   idCard: [this.data.dataNeed.idCard, [Validators.required, Validators.pattern('^[0-9]{9}')]],
    //   email: [this.data.dataNeed.email, [Validators.required, Validators.email]],
    //   birthday: [this.data.dataNeed.birthday, Validators.required],
    //   startDate: [this.data.dataNeed.startDate, Validators.required],
    //   endDate: [this.data.dataNeed.endDate, Validators.required],
    //   cost: [this.data.dataNeed.cost, [Validators.required,Validators.min(10000000), Validators.max(50000000)]],
    //   type: [this.data.dataNeed.type.name, [Validators.required]],
    // });

    //----------------------------------------------------------------------------------------------------

    //----------------------------------------- Change Page ----------------------------------------------
    this.formEdit = this.formBuilder.group({
      idFormat: [''],
      name: [''],
      idCard: ['', [Validators.required, Validators.pattern('^[0-9]{9}')]],
      email: ['', [Validators.required, Validators.email]],
      birthday: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      cost: ['', [Validators.required,Validators.min(10000000), Validators.max(50000000)]],
      type: ['', [Validators.required]],
    });

    this.activedRouter.params.subscribe(data => {
      this.idNeed = data.id;
      this.serviceConnectService.findByID(this.idNeed).subscribe(data => {

        for (let element of this.typeListEdit) {
          if (element.name === data.type.name) {
            data.type = element.name;
            break;
          }
        }

        this.formEdit.patchValue(data);
      })
    })
    //-----------------------------------------------------------------------------------------------------
  }


  edit() {
    if (this.formEdit.valid) {
      //------------------- Dialog -----------
      // this.idNeed = this.data.dataNeed.id;
      //---------------------------------------

      for (let element of this.typeListEdit) {
        if (element.name === this.formEdit.value.type) {
          this.formEdit.value.type = element;
          break;
        }
      }

      // --------------------------- Validate Date -------------------------------------
      if (this.testEndDate === 'false') {
        this.formEdit.value.startDate.setDate(this.startDateTS.getDate() - 91);
      }

      if (this.testStartDate === 'false') {
        this.formEdit.value.endDate.setDate(this.endDateTS.getDate() + 91);
      }
      //---------------------------------------------------------------------------------

      this.serviceConnectService.editService(this.formEdit.value, this.idNeed).subscribe(data => {
        // ------------------- Change Page --------------------
        this.router.navigateByUrl('list').then(_ => {
        });
        //----------------------------------------------------

        // ------- Dialog------
        // this.dialogRef.close();
      })
    }
  }

  // --------------------------- Validate Date -------------------------------------
  changeStartDate(startDate: MatDatepicker<any>, endDate: MatDatepicker<any>) {
    this.startDateTS = startDate._datepickerInput.value;
    this.endDateTS = endDate._datepickerInput.value;
    if (this.testStartDate === 'true') {
      console.log('change start date !');
      this.startDateTS.setDate(this.startDateTS.getDate() + 91);
      this.testEndDate = 'false'
    }
  }

  changeEndDate(endDate: MatDatepicker<any>, startDate: MatDatepicker<any>) {
    this.startDateTS = startDate._datepickerInput.value;
    this.endDateTS = endDate._datepickerInput.value;
    if (this.testEndDate === 'true') {
      console.log('change end date !');
      this.endDateTS.setDate(this.endDateTS.getDate() - 91);
      this.testStartDate = 'false';
    }
  }
  //---------------------------------------------------------------------------------
}

// const test = this.list.find(element => element.id === this.idNeed);
