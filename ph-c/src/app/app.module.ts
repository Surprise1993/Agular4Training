import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppLoginComponent } from './app.login-component';
import { AppHomeComponent } from './app.home-component';
import { WjGridModule } from 'wijmo/wijmo.angular2.grid';
import { WjInputModule } from 'wijmo/wijmo.angular2.input';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { ProPrsStatisticService } from './service/ProPrsStatistic-service';
import { Util } from './util/Util';

@NgModule({
  declarations: [
    AppLoginComponent, AppHomeComponent
  ],
  imports: [
    BrowserModule, WjGridModule,
    WjInputModule, HttpModule, FormsModule
  ],
  providers: [ProPrsStatisticService, Util],
  bootstrap: [AppLoginComponent, AppHomeComponent]
})
export class AppModule { }
