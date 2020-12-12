import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
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
      idFormat: this.data.dataNeed.idFormat,
      area: this.data.dataNeed.area,
      floor: this.data.dataNeed.floor,
      cost: this.data.dataNeed.cost,
      startDate: this.data.dataNeed.startDate,
      endDate: this.data.dataNeed.endDate,
      type: this.data.dataNeed.type.name,
      status: this.data.dataNeed.status.name
    }
  }

  closeDialog() {
    // this.router.navigateByUrl('list').then(_ => {
    // });
    this.dialogRef.close();
  }
}
