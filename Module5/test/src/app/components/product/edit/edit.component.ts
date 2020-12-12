import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {ServiceConnectService} from "../../../services/service-connect.service";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  public formEdit: FormGroup;
  public typeListEdit;
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
    this.serviceConnectService.getAllType().subscribe(dataType => {
      this.typeListEdit = dataType;
    });

    //----------------------------------------- Dialog -------------------------------------------------
    this.formEdit = this.formBuilder.group({
      idFormat: [this.data.dataNeed.idFormat],
      name: [this.data.dataNeed.name, Validators.required],
      price: [this.data.dataNeed.price, [Validators.required, Validators.pattern('^([0-9]+([.][0-9]+)?)$')]],
      status: [this.data.dataNeed.status, Validators.required],
      type: [this.data.dataNeed.type.name]
    });
    //----------------------------------------------------------------------------------------------------

    //----------------------------------------- Change Page ----------------------------------------------
    // this.formEdit = this.formBuilder.group({
    //   idFormat: [''],
    //   name: ['', Validators.required],
    //   price: ['', [Validators.required, Validators.pattern('^([0-9]+([.][0-9]+)?)$')]],
    //   status: ['', Validators.required],
    //   type: ['']
    // });
    //
    // this.activedRouter.params.subscribe(data => {
    //   this.idNeed = data.id;
    //   this.serviceConnectService.findByID(this.idNeed).subscribe(data => {
    //
    //     for (let element of this.typeListEdit) {
    //       if (element.name === data.type.name) {
    //         data.type = element.name;
    //         break;
    //       }
    //     }
    //
    //     this.formEdit.patchValue(data);
    //   })
    // })
    //-----------------------------------------------------------------------------------------------------
  }


  edit() {
    //------------------- Dialog -----------
    this.idNeed = this.data.dataNeed.id;
    //---------------------------------------

    for (let element of this.typeListEdit) {
      if (element.name === this.formEdit.value.type) {
        this.formEdit.value.type = element;
        break;
      }
    }

    this.serviceConnectService.editService(this.formEdit.value, this.idNeed).subscribe(data => {
      // ------------------- Change Page --------------------
      // this.router.navigateByUrl('list').then(_ => {
      // });
      //----------------------------------------------------

      // ------- Dialog------
      this.dialogRef.close();
    })
  }
}

// const test = this.list.find(element => element.id === this.idNeed);
