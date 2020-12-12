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
  public danhSachDiemDi;
  public danhSachDiemDen;
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
    this.serviceConnectService.getAllDiemDi().subscribe(dataDi => {
      this.danhSachDiemDi = dataDi;
    });

    this.serviceConnectService.getAllDiemDen().subscribe(dataDen => {
      this.danhSachDiemDen = dataDen;
    });


    this.formCreateNew = this.formBuilder.group({
      bienSoXe: ['', [Validators.required]],
      loai: ['', Validators.required],
      ten: ['', Validators.required],
      diaDiemDi: ['', Validators.required],
      diaDiemDen: ['', Validators.required],
      sdt: ['', [Validators.required, Validators.pattern('^(090|093|097)(\\d{7})$')]],
      email: ['', [Validators.required, Validators.pattern('^\\w{3,}@[a-z]{3,7}\\.[a-z]{2,3}$')]],
      gioDi: ['', Validators.required],
      gioDen: ['', Validators.required],
    });
  }

  createNew() {

    // this.formCreateNew.value.startDate.setDate(this.formCreateNew.value.startDate.getDate() - 91);
    for (let element of this.danhSachDiemDi) {
      if (element.ten === this.formCreateNew.value.diaDiemDi) {
        this.formCreateNew.value.diaDiemDi = element;
        break;
      }
    }

    for (let element of this.danhSachDiemDen) {
      if (element.ten === this.formCreateNew.value.diaDiemDen) {
        this.formCreateNew.value.diaDiemDen = element;
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

}
