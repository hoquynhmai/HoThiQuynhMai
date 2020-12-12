import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {ServiceConnectService} from '../../../services/service-connect.service';
import {CreateComponent} from '../create/create.component';
import {DeleteComponent} from '../delete/delete.component';
import {EditComponent} from '../edit/edit.component';
import {DetailComponent} from '../detail/detail.component';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  public list;
  public listChoose: Array<any> = [];
  term: any;
  p: any;
  private create;
  keyName: any;
  keyPrice: any;

  constructor(
    public serviceConnectService: ServiceConnectService,
    public dialog: MatDialog
  ) {
  }

  ngOnInit() {
    this.serviceConnectService.getAll().subscribe(data => {
      this.list = data;
    });
  }

  resetSearch() {
    this.term = '';
    this.keyName = '';
    this.keyPrice = '';
    this.listChoose = [];
    this.searchOfMe('', '');
  }

  createNewDialog() {
    const dialogRefCreate = this.dialog.open(CreateComponent, {
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
    this.serviceConnectService.findByID(id).subscribe(varialble => {
      const dialogRef = this.dialog.open(DeleteComponent, {
        width: '750px',
        data: {dataNeed: varialble},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
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
        this.ngOnInit();
      });
    });
  }

  openDialogView(id: any) {
    this.serviceConnectService.findByID(id).subscribe(varialble => {
      // console.log(varialble);
      const dialogRefEdit = this.dialog.open(DetailComponent, {
        width: '950px',
        height: '750px',
        data: {dataNeed: varialble},
        disableClose: true
      });

      dialogRefEdit.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    });
  }

  // ---------------------------------------- Search ---------------------------------------------
  searchOfMe(keyName: string, keyPrice: string) {
    if (keyPrice !== '' && keyName !== '') {
      // this.serviceConnectService.findByNameAndPrice(keyName, keyPrice).subscribe(data => {
      this.serviceConnectService.findByNameAndType(keyName, keyPrice).subscribe(data => {
        // console.log(data);
        this.list = data;
      });
    } else {
      if (keyName === '') {
        // this.serviceConnectService.findByPrice(keyPrice).subscribe(data => {
        this.serviceConnectService.findByType(keyPrice).subscribe(data => {
          // console.log(data);
          this.list = data;
        });
      } else if (keyPrice === '') {
        this.serviceConnectService.findByName(keyName).subscribe(data => {
          // console.log(data);
          this.list = data;
        });
      }
    }
  }
  // -------------------------------------------------------------------------------------------------

  // ------------------------------------------- Sort ------------------------------------------------
  sort(attribute: any, arrange: any) {
    if (arrange === 'asc' && attribute === 'price') {
      this.serviceConnectService.sortByPriceASC().subscribe(data => {
        this.list = data;
      });
    }
    if (arrange === 'desc' && attribute === 'price') {
      this.serviceConnectService.sortByPriceDESC().subscribe(data => {
        this.list = data;
      });
    }

    if (arrange === 'asc' && attribute === 'name') {
      this.serviceConnectService.sortByNameASC().subscribe(data => {
        this.list = data;
      });
    }
    if (arrange === 'desc' && attribute === 'name') {
      this.serviceConnectService.sortByNameDESC().subscribe(data => {
        this.list = data;
      });
    }

    if (arrange === 'asc' && attribute === 'id') {
      this.serviceConnectService.sortByIDASC().subscribe(data => {
        this.list = data;
      });
    }
    if (arrange === 'desc' && attribute === 'id') {
      this.serviceConnectService.sortByIDDESC().subscribe(data => {
        this.list = data;
      });
    }
  }
  // ----------------------------------------------------------------------------------------------------

  // ---------------------------------------- Xóa hàng loạt --------------------------------------------
  chooseDelete(value: any) {
    let test = 'true';
    if (this.listChoose.length === 0) {
      this.listChoose.push(value);
    } else {
      for (const element of this.listChoose) {
        if (element === value) {
          test = 'false';
        }
      }
      if (test === 'true') {
        this.listChoose.push(value);
      }
    }
  }

  deleteAllChoosed() {
    if (this.listChoose.length !== 0) {
      this.serviceConnectService.deleteService(this.listChoose.shift()).subscribe(data => {
        this.deleteAllChoosed();
      });
    }
    if (this.serviceConnectService.getAll().subscribe()) {
      this.ngOnInit();
    }
  }
  // ------------------------------------------------------------------------------------------------------
}
