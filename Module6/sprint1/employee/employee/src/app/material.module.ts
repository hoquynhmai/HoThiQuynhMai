import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatDialogModule} from '@angular/material/dialog';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {DeleteEmployeeComponent} from './components/employee/delete-employee/delete-employee.component';
import {CreateEmployeeComponent} from './components/employee/create-employee/create-employee.component';
import {EditEmployeeComponent} from './components/employee/edit-employee/edit-employee.component';

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
  entryComponents: [DeleteEmployeeComponent, CreateEmployeeComponent, EditEmployeeComponent]
})

export class MaterialModule {
}
