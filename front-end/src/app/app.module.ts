import { NgModule } from '@angular/core';
 import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AziendeComponent } from './componenti/aziende/aziende.component';
import { SpComponent } from './componenti/sp/sp.component';
import { CeComponent } from './componenti/ce/ce.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatMenuModule} from '@angular/material/menu';
import {MatTableModule} from '@angular/material/table'
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import {MatButtonModule} from '@angular/material/button'; 
import {MatCardModule} from '@angular/material/card'; 
import {MatGridListModule} from '@angular/material/grid-list';
import {MatSidenavModule} from '@angular/material/sidenav';  
import {MatInputModule} from '@angular/material/input'; 


import { HighlightDirective } from './directive/highlight.directive';
import { AziendeService } from './service/aziende.service';
import { HttpClientModule } from '@angular/common/http';
import { HighlightNavbarDirective } from './directive/highlight-navbar.directive';
import { AnalisiTempoComponent } from './componenti/analisi-tempo/analisi-tempo.component';
import { AnalisiSpazioComponent } from './componenti/analisi-spazio/analisi-spazio.component';
import { AziendaNewComponent } from './componenti/azienda-new/azienda-new.component';
import { SpNewComponent } from './componenti/sp-new/sp-new.component';
import { CeNewComponent } from './componenti/ce-new/ce-new.component';

@NgModule({
  declarations: [
    AppComponent,
    AziendeComponent,
    SpComponent,
    CeComponent,
    HighlightDirective,
    HighlightNavbarDirective,
    AnalisiTempoComponent,
    AnalisiSpazioComponent,
    AziendaNewComponent,
    SpNewComponent,
    CeNewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    MatButtonModule,
    MatCardModule,
    MatGridListModule,
    MatSidenavModule,
    MatMenuModule,
    MatInputModule,
    MatTableModule,
    HttpClientModule,
  ],
  providers: [AziendeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
