import { HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { CeService } from 'src/app/service/ce.service';

@Component({
  selector: 'app-ce',
  templateUrl: './ce.component.html',
  styleUrls: ['./ce.component.css']
})


export class CeComponent {
  ces:any = [];
  cesStorico:any = [];
  constructor(private ceService: CeService){}
  status : string = 'today';
  notstatus : string = 'storico';
  show:boolean = false;
  indice:number = 0;
  obj:any = [];

  ngOnInit(): void {
    console.log('ON INIT CONTO ECONOMICO')
    this.ceService.cryptoData().subscribe((res) => {
      this.ces= res;
      console.log(res);
    });
    this.ceService.storicData().subscribe((res) => {
      this.cesStorico= res;
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


  showCE(i: number, obj:any){
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
