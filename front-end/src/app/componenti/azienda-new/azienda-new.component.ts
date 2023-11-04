import {Component} from '@angular/core';

import { AziendeService } from 'src/app/service/aziende.service';


@Component({
  selector: 'app-azienda-new',
  templateUrl: './azienda-new.component.html',
  styleUrls: ['./azienda-new.component.css'],
})
export class AziendaNewComponent {

  body:any=[];
  constructor(aziendaService:AziendeService){}

  showData(){
    //console.log(this.name)
  }

  addNew(){
    //this.aziendaService.insertNew(this.body);
  }
}
