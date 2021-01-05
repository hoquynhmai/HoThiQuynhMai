import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {ServiceEmployeeService} from '../../../services/service-employee.service';
import {CreateEmployeeComponent} from '../create-employee/create-employee.component';
import {DeleteEmployeeComponent} from '../delete-employee/delete-employee.component';

@Component({
  selector: 'app-list',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
  public list;
  term: any;
  private create;
  key:any;

  constructor(
    public serviceEmployeeService: ServiceEmployeeService,
    public dialog: MatDialog
  ) {
  }

  ngOnInit() {
    this.serviceEmployeeService.getAll().subscribe(data => {
      this.list = data;
    });
  }

  resetSearch() {
    this.term = '';
  }

  createNewDialog() {
    const dialogRefCreate = this.dialog.open(CreateEmployeeComponent, {
      width: '950px',
      height: '1500px',
      data: {dataNeed: this.create},
      disableClose: true
    });

    dialogRefCreate.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

  openDialogDelete(id: any): void {
    this.serviceEmployeeService.findByID(id).subscribe(varialble => {
      const dialogRef = this.dialog.open(DeleteEmployeeComponent, {
        width: '750px',
        data: {dataNeed: varialble},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    });
  }
}
