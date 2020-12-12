import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ServiceConnectService} from "../../../services/service-connect.service";

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  public product;
  private idDelete: any;

  constructor(
    public dialogRef: MatDialogRef<DeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private serviceConnectService: ServiceConnectService
  ) { }

  ngOnInit() {
    this.product = this.data.dataNeed;
    this.idDelete = this.data.dataNeed.id;
    // console.log(this.data)
  }

  deleteCustomer() {
    this.serviceConnectService.deleteService(this.idDelete).subscribe(data => {
      this.dialogRef.close();
    })
  }
}
