import { Component, OnInit } from '@angular/core';
import { SpService } from 'src/app/service/sp.service';

@Component({
  selector: 'app-sp',
  templateUrl: './sp.component.html',
  styleUrls: ['./sp.component.css']
})


export class SpComponent implements OnInit{
  sps:any = [];
  spsStorico:any = [];
  constructor(private spService: SpService){}
  status : string = 'today';
  notstatus: string = 'storico';
  show:boolean = false;
  indice:number = 0;
  obj:any = [];
  
  ngOnInit(): void {
    console.log('ON INIT STATO PATRIMONIALE')
    this.spService.cryptoData().subscribe((res) => {
      this.sps= res;
      console.log(res);
    });

    this.spService.storicData().subscribe((res) => {
      this.spsStorico= res;
      console.log(res);
    });
  }

  onClickChange(){
    if(this.status==='today'){
      this.status = 'storico';
      this.notstatus = 'today';
      this.show=false;
      this.indice = 0;
      this.obj = [];
    }else{
      this.status = 'today';
      this.notstatus = 'storico';
      this.show=false;
      this.indice = 0;
      this.obj = [];
    }
  }

  showSP(i: number, obj:any){
    console.log(i);
    if(i === this.indice){
      this.show=!this.show
    }else{
      this.show=true;
    }
    this.indice = i;
    this.obj = obj;
  }
}
