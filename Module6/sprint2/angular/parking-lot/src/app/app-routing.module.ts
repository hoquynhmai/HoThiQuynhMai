import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListParkingSlotComponent } from './parking-lot/list-parking-slot/list-parking-slot.component';
import { CreateParkingSlotComponent } from './parking-lot/create-parking-slot/create-parking-slot.component';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {OrderModule} from 'ngx-order-pipe';


const routes: Routes = [
  // Mai :
  {path: 'list-parking-slot', component: ListParkingSlotComponent},
  {path: 'create-parking-slot', component: CreateParkingSlotComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes), CommonModule, ReactiveFormsModule, FormsModule, NgxPaginationModule, OrderModule],
  exports: [RouterModule],
  declarations: [ListParkingSlotComponent, CreateParkingSlotComponent]
})
export class AppRoutingModule { }
