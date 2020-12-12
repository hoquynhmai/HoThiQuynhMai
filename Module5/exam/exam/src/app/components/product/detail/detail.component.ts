import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Router} from "@angular/router";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  public formView;

  constructor(
    public dialogRef: MatDialogRef<DetailComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public formBuilder: FormBuilder,
    public router: Router
  ) {
  }

  ngOnInit() {
    this.formView = {
      bienSoXe: this.data.dataNeed.bienSoXe,
      loai:this.data.dataNeed.loai,
      ten: this.data.dataNeed.ten,
      diaDiemDi: this.data.dataNeed.diaDiemDen.ten,
      diaDiemDen: this.data.dataNeed.diaDiemDi.ten,
      sdt: this.data.dataNeed.sdt,
      email: this.data.dataNeed.email,
      gioDi: this.data.dataNeed.gioDi,
      gioDen: this.data.dataNeed.gioDen,
    }
  }

  closeDialog() {
    this.dialogRef.close();
  }
}
