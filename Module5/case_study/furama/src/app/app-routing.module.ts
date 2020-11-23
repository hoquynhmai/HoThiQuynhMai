import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { EmployeeListComponent } from './component/employees/employee-list/employee-list.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'employee-list', component: EmployeeListComponent},
  {path:'**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule, HomeComponent],
  declarations: [HomeComponent, PageNotFoundComponent, EmployeeListComponent]
})
export class AppRoutingModule { }
