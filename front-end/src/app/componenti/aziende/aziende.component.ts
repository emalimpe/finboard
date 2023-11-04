import { Component } from '@angular/core';
import { Route } from '@angular/router';
import { AziendeService } from 'src/app/service/aziende.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-aziende',
  templateUrl: './aziende.component.html',
  styleUrls: ['./aziende.component.css']
})


export class AziendeComponent {

  aziende : any = [];
  constructor(private aziendeService: AziendeService, private router:Router){}

  ngOnInit(): void {
    this.aziendeService.cryptoData().subscribe((res) => {
      this.aziende= res;
      console.log(res);
    });
  }


  onClickAnalisiSpazio(nome:string){
    console.log('analisi/settore/'+nome+'/'+(new Date()).getFullYear());
     this.router.navigate(['analisi/settore/'+nome+'/'+(new Date()).getFullYear()]);
  }  
  onClickAnalisiTempo(nome:string){
    console.log('analisi/'+nome);
    this.router.navigate(['analisi/'+nome]);
  }

  onClickNewCE(nome:string){    this.router.navigate(['ce/new/'+nome]);}
  onClickNewSP(nome:string){    this.router.navigate(['sp/new/'+nome]);}
  onClickDelete(nome: string){
    this.aziendeService.deleteById(nome);
  }
}

