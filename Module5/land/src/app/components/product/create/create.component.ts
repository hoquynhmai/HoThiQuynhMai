import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Router} from "@angular/router";
import {ServiceConnectService} from "../../../services/service-connect.service";
import {MatDatepicker} from "@angular/material/datepicker";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  public formCreateNew: FormGroup;
  public typeList;
  public statusList;
  public startDateTS = new Date('yyyy/MM/dd');

  constructor(
    private serviceConnectService: ServiceConnectService,
    // ------------------------ OFF Dialog -----------------
    public dialogRef: MatDialogRef<CreateComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    // ------------------------------------------------------

    public formBuilder: FormBuilder,
    public router: Router
  ) {
  }

  ngOnInit() {
    this.serviceConnectService.getAllType().subscribe(dataType => {
      this.typeList = dataType;
    });

    this.serviceConnectService.getAllStatus().subscribe(dataStatus => {
      this.statusList = dataStatus;
    });

    this.formCreateNew = this.formBuilder.group({
      idFormat: ['',
        [Validators.required, Validators.pattern('^([A-Z0-9]){3}(-([A-Z0-9]){2}){2}$')],
        [this.serviceConnectService.validateID()], {updateOn: 'blur'}
      ],
      area: ['', [Validators.required, Validators.pattern('^([0-9]+([.][0-9]+)?)$'),
        Validators.min(20)]],
      floor: ['', [Validators.required, Validators.pattern('^([0-9]+([0-9]+)?)$'), Validators.max(15)]],
      cost: ['', [Validators.required, Validators.pattern('^([0-9]+([.][0-9]+)?)$'),
        Validators.min(1000000)]],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      type: [''],
      status: ['']

      // area: ['', Validators.required, Validators.pattern('^([1-9]+[0-9]{6}([.][0-9]+)?)$')],
      // floor: ['', Validators.required, Validators.pattern('^([1][0-5])$')],
    });
  }

  createNew() {

    this.formCreateNew.value.startDate.setDate(this.formCreateNew.value.startDate.getDate() - 7);

    for (let element of this.statusList) {
      if (element.name === this.formCreateNew.value.status) {
        this.formCreateNew.value.status = element;
        break;
      }
    }
    for (let element of this.typeList) {
      if (element.name === this.formCreateNew.value.type) {
        this.formCreateNew.value.type = element;
        break;
      }
    }

    this.serviceConnectService.createNewService(this.formCreateNew.value).subscribe(data => {
      // --------------------- Change Page --------------------
      // this.router.navigateByUrl('list').then(_ => { });

      // ----- OFF Dialog -----
      this.dialogRef.close();
    })
  }

  changeStartDate(startDate: MatDatepicker<any>) {
    this.startDateTS = startDate._datepickerInput.value;
    this.startDateTS.setDate(this.startDateTS.getDate() + 7);
  }
}
