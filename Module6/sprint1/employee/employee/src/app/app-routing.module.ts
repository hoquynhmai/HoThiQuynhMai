import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PageNotFoundComponent} from './components/page-not-found/page-not-found.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {MaterialModule} from './material.module';
import {ListEmployeeComponent} from './components/employee/list-employee/list-employee.component';
import {CreateEmployeeComponent} from './components/employee/create-employee/create-employee.component';
import {DeleteEmployeeComponent} from './components/employee/delete-employee/delete-employee.component';
import {EditEmployeeComponent} from './components/employee/edit-employee/edit-employee.component';

const routes: Routes = [
  {path: '', component: ListEmployeeComponent},

  {path: 'list-employee', component: ListEmployeeComponent},
  {path: 'create-employee', component: CreateEmployeeComponent},
  {path: 'edit-employee/:id', component: EditEmployeeComponent},

  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), FormsModule, CommonModule, Ng2SearchPipeModule, NgxPaginationModule,
    ReactiveFormsModule, MaterialModule],
  exports: [RouterModule],
  declarations: [PageNotFoundComponent, ListEmployeeComponent, CreateEmployeeComponent, DeleteEmployeeComponent, EditEmployeeComponent]
})
export class AppRoutingModule {
}
