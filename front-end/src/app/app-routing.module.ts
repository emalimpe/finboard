import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AziendeComponent } from './componenti/aziende/aziende.component';
import { CeComponent } from './componenti/ce/ce.component';
import { SpComponent } from './componenti/sp/sp.component';
import { AnalisiSpazioComponent } from './componenti/analisi-spazio/analisi-spazio.component';
import { AnalisiTempoComponent } from './componenti/analisi-tempo/analisi-tempo.component';
import { AziendaNewComponent } from './componenti/azienda-new/azienda-new.component';
import { SpNewComponent } from './componenti/sp-new/sp-new.component';
import { CeNewComponent } from './componenti/ce-new/ce-new.component';
const routes: Routes = [
  {path:'',component: AziendeComponent,children:[
                                                        {path:'sp/new/:nome', component:SpNewComponent},
                                                        {path:'ce/new/:nome',component:CeNewComponent},
                                                ]},
  {path:'aziende',component: AziendeComponent,children:[
                                                        {path:'sp/new/:nome', component:SpNewComponent},
                                                        {path:'ce/new/:nome',component:CeNewComponent},
                                                ]},
  {path:'azienda/new',component:AziendaNewComponent},
  {path:'statopatrimoniale',component: SpComponent},
  {path:'contoeconomico',component: CeComponent},
  {path:'analisi/:nome',component: AnalisiTempoComponent},
  {path:'analisi/settore/:nome/:anno',component: AnalisiSpazioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
