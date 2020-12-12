import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {ServiceConnectService} from "../../../services/service-connect.service";
import {CreateComponent} from "../create/create.component";
import {DeleteComponent} from "../delete/delete.component";
import {EditComponent} from "../edit/edit.component";
import {DetailComponent} from "../detail/detail.component";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  public list;
  term: any;
  p: any;
  private create;
  public key ='id';
  public reverse = false;
  //------------- Search --------------
  keyArea: any;
  keyCost: any;
  keyFloor: any;
  //-----------------------------------


  constructor(
    public serviceConnectService: ServiceConnectService,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.serviceConnectService.getAll().subscribe(data => {
      this.list = data;
    })
  }

  resetSearch() {
    this.term = "";
    this.key = 'id';
    this.reverse = false;

    //-------------Search---------
    this.keyArea = "";
    this.keyCost = "";
    this.keyFloor = "";
    this.searchOfMe("", "", "");
    //----------------------------
  }

  createNewDialog() {
    const dialogRefCreate = this.dialog.open(CreateComponent, {
      width: '950px',
      height: '1500px',
      data: {dataNeed: this.create},
      disableClose: true
    });

    dialogRefCreate.afterClosed().subscribe(result => {
      this.ngOnInit()
    })
  }

  openDialogDelete(id: any): void {
    this.serviceConnectService.findByID(id).subscribe(varialble => {
      const dialogRef = this.dialog.open(DeleteComponent, {
        width: '750px',
        data: {dataNeed: varialble},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit()
      })
    });
  }

  openDialogEdit(id: any): void {
    this.serviceConnectService.findByID(id).subscribe(varialble => {
      // console.log(customer);
      const dialogRefEdit = this.dialog.open(EditComponent, {
        width: '950px',
        height: '1500px',
        data: {dataNeed: varialble},
        disableClose: true
      });

      dialogRefEdit.afterClosed().subscribe(result => {
        this.ngOnInit()
      })
    });
  }

  openDialogView(id: any) {
    this.serviceConnectService.findByID(id).subscribe(varialble => {
      // console.log(customer);
      const dialogRefEdit = this.dialog.open(DetailComponent, {
        width: '950px',
        height: '750px',
        data: {dataNeed: varialble},
        disableClose: true
      });

      dialogRefEdit.afterClosed().subscribe(result => {
        this.ngOnInit()
      })
    });
  }

  sortOfMe(key){
    this.key = key;
    this.reverse = !this.reverse;
  }

  //----------------------------- Search ----------------------------------
  searchOfMe(keyArea: string, keyCost: string, keyFloor: string) {
    if (keyCost !== "" && keyArea !== "" && keyFloor !== "") {
      this.serviceConnectService.findByAreaAndCostAndFloor(keyArea, keyCost, keyFloor).subscribe(data => {
        this.list = data;
      });
    } else {
      if (keyArea === "" && keyFloor === "") {
        this.serviceConnectService.findByCost(keyCost).subscribe(data => {
          this.list = data;
        });
      } else if (keyCost === "" && keyFloor === "") {
        this.serviceConnectService.findByArea(keyArea).subscribe(data => {
          this.list = data;
        });
      } else if (keyArea === "" && keyCost === "") {
        this.serviceConnectService.findByFloor(keyFloor).subscribe(data => {
          this.list = data;
        });
      }
    }
  }
  //-----------------------------------------------------------------------
}
