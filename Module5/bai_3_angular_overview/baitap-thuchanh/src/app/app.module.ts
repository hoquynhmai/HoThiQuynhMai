import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontSizeComponent } from './font-size/font-size.component';
import { PetComponent } from './pet/pet.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { ColorComponent } from './color/color.component';
import { HackernewsComponent } from './hackernews/hackernews.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeComponent,
    PetComponent,
    CalculatorComponent,
    ColorComponent,
    HackernewsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
