import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PageNotFoundComponent} from './components/page-not-found/page-not-found.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {NgxPaginationModule} from "ngx-pagination";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {MaterialModule} from "./material.module";
import {ListComponent} from './components/product/list/list.component';
import {CreateComponent} from './components/product/create/create.component';
import {DeleteComponent} from './components/product/delete/delete.component';
import {EditComponent} from './components/product/edit/edit.component';
import {DetailComponent} from './components/product/detail/detail.component';

const routes: Routes = [
  {path: '', component: ListComponent},

  {path: 'list', component: ListComponent},
  {path: 'create', component: CreateComponent},
  {path: 'edit/:id', component: EditComponent},
  {path: 'detail', component: DetailComponent},

  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), FormsModule, CommonModule, Ng2SearchPipeModule, NgxPaginationModule,
    ReactiveFormsModule, MaterialModule],
  exports: [RouterModule],
  declarations: [PageNotFoundComponent, ListComponent, CreateComponent, DeleteComponent, EditComponent, DetailComponent]
})
export class AppRoutingModule {
}
