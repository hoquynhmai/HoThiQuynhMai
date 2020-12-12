import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {EmployeeService} from "../../../service/employee.service";

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {
  public employeeName;
  public employeeId;

  constructor(
    public dialogRef: MatDialogRef<EmployeeDeleteComponent>,
    public employeeService: EmployeeService,

    @Inject(MAT_DIALOG_DATA) public data: any) {}

  ngOnInit(): void {
    this.employeeName = this.data.data.name;
    this.employeeId = this.data.data.id;
  }

  deleteEmployee() {
    this.employeeService.deleteEmployeeService(this.employeeId).subscribe(data=>{
      this.dialogRef.close();
    })
  }
}
