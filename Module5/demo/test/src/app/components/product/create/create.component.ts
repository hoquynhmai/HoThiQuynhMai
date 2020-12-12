import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {ServiceConnectService} from '../../../services/service-connect.service';
import {MatDatepicker} from '@angular/material/datepicker';
import DateTimeFormat = Intl.DateTimeFormat;

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  public formCreateNew: FormGroup;
  public typeList;
  public startDateTS = new Date('yyyy/MM/dd');

  constructor(
    private serviceConnectService: ServiceConnectService,

    // ----- OFF Dialog -----
    public dialogRef: MatDialogRef<CreateComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,

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
        [Validators.required, Validators.pattern('^(SP-)[0-9]{4}$')],
        [this.serviceConnectService.validateID()], { updateOn: 'blur' }
      ],

      name: ['', Validators.required],
      price: ['', [Validators.required, Validators.pattern('^([0-9]+([.][0-9]+)?)$')]],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      type: ['', Validators.required]
    });
  }

  createNew() {
    this.formCreateNew.value.startDate.setDate(this.formCreateNew.value.startDate.getDate() - 7);

    for (const element of this.typeList) {
      if (element.name === this.formCreateNew.value.type) {
        this.formCreateNew.value.type = element;
        break;
      }
    }

    this.serviceConnectService.createNewService(this.formCreateNew.value).subscribe(data => {
      // this.router.navigateByUrl('list').then(_ => { });

      // ----- OFF Dialog -----
      this.dialogRef.close();
    });
  }

  changeStartDate(startDate: MatDatepicker<any>) {
    this.startDateTS = startDate._datepickerInput.value;
    this.startDateTS.setDate(this.startDateTS.getDate() + 7);
  }
}
