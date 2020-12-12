import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './component/home/home.component';
import {PageNotFoundComponent} from './component/page-not-found/page-not-found.component';
import {EmployeeListComponent} from './component/employees/employee-list/employee-list.component';
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgxPaginationModule} from 'ngx-pagination';
import {EmployeeAddComponent} from './component/employees/employee-add/employee-add.component';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MaterialModule} from './material.module';
import { EmployeeDeleteComponent } from './component/employees/employee-delete/employee-delete.component';
import {MatDialogModule} from "@angular/material/dialog";
import { EmployeeEditComponent } from './component/employees/employee-edit/employee-edit.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'employee-list', component: EmployeeListComponent},
  {path: 'employee-add', component: EmployeeAddComponent},
  {path: 'employee-edit/:id', component: EmployeeEditComponent},

  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), CommonModule, FormsModule,
    NgxPaginationModule, ReactiveFormsModule, Ng2SearchPipeModule, MatDatepickerModule, MatFormFieldModule,
    MaterialModule, MatDialogModule],
  exports: [RouterModule, HomeComponent, EmployeeAddComponent],
  declarations: [HomeComponent, PageNotFoundComponent, EmployeeListComponent, EmployeeAddComponent, EmployeeDeleteComponent, EmployeeEditComponent]
})
export class AppRoutingModule {
}

