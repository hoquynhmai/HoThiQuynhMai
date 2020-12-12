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
  public statusListEdit;
  public idNeed;
  public startDateTS = new Date('yyyy/MM/dd');
  public endDateTS = new Date('yyyy/MM/dd');
  public testStartDate = 'true';
  public testEndDate = 'true';

  constructor(
    // --------------------- ON Dialog ------------------
    public dialogRef: MatDialogRef<EditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
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

    this.serviceConnectService.getAllStatus().subscribe(dataStatus => {
      this.statusListEdit = dataStatus;
    });

    //----------------------------------------- Dialog -------------------------------------------------
    this.formEdit = this.formBuilder.group({
      idFormat: [this.data.dataNeed.idFormat],
      area: [this.data.dataNeed.area, [Validators.required, Validators.pattern('^([0-9]+([.][0-9]+)?)$'),
        Validators.min(20)]],
      floor: [this.data.dataNeed.floor, [Validators.required, Validators.pattern('^([0-9]+([0-9]+)?)$'), Validators.max(15)]],
      cost: [this.data.dataNeed.cost, [Validators.required, Validators.pattern('^([0-9]+([.][0-9]+)?)$'),
        Validators.min(1000000)]],
      startDate: [this.data.dataNeed.startDate, Validators.required],
      endDate: [this.data.dataNeed.endDate, Validators.required],
      type: [this.data.dataNeed.type.name],
      status: [this.data.dataNeed.status.name]
    });

    //----------------------------------------------------------------------------------------------------

    //----------------------------------------- Change Page ----------------------------------------------
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
    //-----------------------------------------------------------------------------------------------------
  }


  edit() {
    if (this.formEdit.valid) {
      //------------------- Dialog -----------
      this.idNeed = this.data.dataNeed.id;
      //---------------------------------------

      for (let element of this.typeListEdit) {
        if (element.name === this.formEdit.value.type) {
          this.formEdit.value.type = element;
          break;
        }
      }

      for (let element of this.statusListEdit) {
        if (element.name === this.formEdit.value.status) {
          this.formEdit.value.status = element;
          break;
        }
      }

      // --------------------------- Validate Date -------------------------------------
      if (this.testEndDate === 'false') {
        this.formEdit.value.startDate.setDate(this.startDateTS.getDate() - 7);
      }

      if (this.testStartDate === 'false') {
        this.formEdit.value.endDate.setDate(this.endDateTS.getDate() + 7);
      }
      //---------------------------------------------------------------------------------

      this.serviceConnectService.editService(this.formEdit.value, this.idNeed).subscribe(data => {
        // ------------------- Change Page --------------------
        // this.router.navigateByUrl('list').then(_ => {
        // });
        //----------------------------------------------------

        // ------- Dialog------
        this.dialogRef.close();
      })
    }
  }

  // --------------------------- Validate Date -------------------------------------
  changeStartDate(startDate: MatDatepicker<any>, endDate: MatDatepicker<any>) {
    this.startDateTS = startDate._datepickerInput.value;
    this.endDateTS = endDate._datepickerInput.value;
    if (this.testStartDate === 'true') {
      console.log('change start date !');
      this.startDateTS.setDate(this.startDateTS.getDate() + 7);
      this.testEndDate = 'false'
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
  //---------------------------------------------------------------------------------
}

// const test = this.list.find(element => element.id === this.idNeed);
