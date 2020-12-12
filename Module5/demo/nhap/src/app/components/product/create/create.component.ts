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
  public maxBirthday = new Date(2002,11,28);
  public startDateMin = new Date ();
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


    this.formCreateNew = this.formBuilder.group({
      idFormat: ['',
        [Validators.required, Validators.pattern('^KH-([0-9]{4})(-([A-Z][a-z]{2}))$')],
        [this.serviceConnectService.validateID()], {updateOn: 'blur'}
      ],
      name: [''],
      idCard: ['', [Validators.required, Validators.pattern('^([0-9]{3})( [0-9]{3}){2}$')]],
      email: ['', [Validators.required, Validators.email]],
      birthday: ['', [Validators.required]],
      startDate: ['', [Validators.required]],
      endDate: ['', [Validators.required]],
      cost: ['', [Validators.required,Validators.min(10000000), Validators.max(50000000)]],
      type: ['', [Validators.required]],

      // area: ['', Validators.required, Validators.pattern('^([1-9]+[0-9]{6}([.][0-9]+)?)$')],
      // floor: ['', Validators.required, Validators.pattern('^([1][0-5])$')],
    });
  }

  createNew() {

    this.formCreateNew.value.startDate.setDate(this.formCreateNew.value.startDate.getDate() - 91);
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
    this.startDateTS.setDate(this.startDateTS.getDate() + 91);
  }
}
