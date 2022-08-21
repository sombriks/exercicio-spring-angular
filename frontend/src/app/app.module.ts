import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';

import {DocumentosComponent} from './views/documentos/documentos.component';
import {ApiService} from "./api/api.service";

@NgModule({
  declarations: [
    AppComponent,
    DocumentosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
