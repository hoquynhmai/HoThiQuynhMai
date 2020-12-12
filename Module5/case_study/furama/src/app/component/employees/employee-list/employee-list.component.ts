import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../../service/employee.service'
import {MatDialog} from "@angular/material/dialog";
import {EmployeeDeleteComponent} from "../employee-delete/employee-delete.component";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  public employees;
  p: any;
  term: any;

  constructor(public employeeService: EmployeeService,
              public dialog: MatDialog) { }

  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe(data=>{
      this.employees = data;
      console.log(this.employees);
    })
  }

  openDialog(id: any): void {
    this.employeeService.findById(id).subscribe(dataEmployee=>{
      const dialogRef = this.dialog.open(EmployeeDeleteComponent, {
        width: '650px',
        data: {data: dataEmployee},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

}
