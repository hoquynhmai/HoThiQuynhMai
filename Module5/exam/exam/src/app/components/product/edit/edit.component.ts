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
  public danhSachDiemDi;
  public danhSachDiemDen;
  public idNeed;

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
    this.serviceConnectService.getAllDiemDi().subscribe(dataDi => {
      this.danhSachDiemDi = dataDi;
    });

    this.serviceConnectService.getAllDiemDen().subscribe(dataDen => {
      this.danhSachDiemDen = dataDen;
    });

    this.formEdit = this.formBuilder.group({
      bienSoXe: [this.data.dataNeed.bienSoXe, Validators.required],
      loai: [this.data.dataNeed.loai, Validators.required],
      ten: [this.data.dataNeed.ten, Validators.required],
      diaDiemDi: [this.data.dataNeed.diaDiemDen.ten, Validators.required],
      diaDiemDen: [this.data.dataNeed.diaDiemDi.ten, Validators.required],
      sdt: [this.data.dataNeed.sdt, [Validators.required,Validators.pattern('^(090|093|097)(\\d{7})$')]],
      email: [this.data.dataNeed.email, [Validators.required, Validators.pattern('^\\w{3,}@[a-z]{3,7}\\.[a-z]{2,3}$')]],
      gioDi: [this.data.dataNeed.gioDi, Validators.required],
      gioDen: [this.data.dataNeed.gioDen, Validators.required],
    });
  }


  edit() {
    if (this.formEdit.valid) {
      //------------------- Dialog -----------
      this.idNeed = this.data.dataNeed.id;
      //---------------------------------------

      for (let element of this.danhSachDiemDi) {
        if (element.ten === this.formEdit.value.diaDiemDi) {
          this.formEdit.value.diaDiemDi = element;
          break;
        }
      }

      for (let element of this.danhSachDiemDen) {
        if (element.ten === this.formEdit.value.diaDiemDen) {
          this.formEdit.value.diaDiemDen = element;
          break;
        }
      }

      this.serviceConnectService.editService(this.formEdit.value, this.idNeed).subscribe(data => {
        this.dialogRef.close();
      })
    }
  }
}

