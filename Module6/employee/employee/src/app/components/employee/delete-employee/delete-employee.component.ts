import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {ServiceEmployeeService} from '../../../services/service-employee.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete-employee.component.html',
  styleUrls: ['./delete-employee.component.css']
})
export class DeleteEmployeeComponent implements OnInit {
  public employee;
  private idDelete: any;

  constructor(
    public dialogRef: MatDialogRef<DeleteEmployeeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private serviceConnectService: ServiceEmployeeService
  ) { }

  ngOnInit() {
    this.employee = this.data.dataNeed;
    this.idDelete = this.data.dataNeed.id;
  }

    deleteEmployee() {
      this.serviceConnectService.deleteEmployee(this.idDelete).subscribe(data => {
        this.dialogRef.close();
      });
    }
}
