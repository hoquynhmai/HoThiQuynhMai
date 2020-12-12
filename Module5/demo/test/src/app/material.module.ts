import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatDialogModule} from '@angular/material/dialog';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {DeleteComponent} from './components/product/delete/delete.component';
import {CreateComponent} from './components/product/create/create.component';
import {EditComponent} from './components/product/edit/edit.component';
import {DetailComponent} from './components/product/detail/detail.component';

@NgModule({
  imports: [
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  exports: [
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [MatDatepickerModule],
  entryComponents: [DeleteComponent, CreateComponent, EditComponent, DetailComponent]
})

export class MaterialModule {
}
