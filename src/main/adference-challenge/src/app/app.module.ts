import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TroubleshootCarComponent } from './troubleshoot-car/troubleshoot-car.component';
import { TroubleshootcarServiceService } from './service/troubleshootcar-service.service';

@NgModule({
  declarations: [
    AppComponent,
    TroubleshootCarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ TroubleshootcarServiceService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
