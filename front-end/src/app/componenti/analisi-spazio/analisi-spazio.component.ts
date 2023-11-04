import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AnalisiService } from 'src/app/service/analisi.service';
import Chart from 'chart.js/auto';

@Component({
  selector: 'app-analisi-spazio',
  templateUrl: './analisi-spazio.component.html',
  styleUrls: ['./analisi-spazio.component.css']
})
export class AnalisiSpazioComponent implements OnInit{

  analisiCurr: any = [];
  nome : any = [];
  anno : any = [];


  title = 'ng-chart';
  rN : any = [];
  chart2: any = [];
  chart: any = [];
  result: any;
  stilatura: any;
  coinName: any;
  rar: any[] = [];
  rarK: any[] = [];
  rarS: string[] = [];
  rarN: number[][] = [[],[],[],[]];
  grafo: any = [];


  constructor(private route:ActivatedRoute, private analisiService: AnalisiService){}
  
  ngOnInit(): void {
    this.nome = this.route.snapshot.paramMap.get('nome');
    this.anno = this.route.snapshot.paramMap.get('anno');
    this.analisiService.spazioData(this.nome,this.anno).subscribe((res) => {
      this.analisiCurr = res;
      console.log(res);
      
      console.log(this.analisiCurr[0].stilatura)
      this.result = this.analisiCurr
      this.stilatura = this.result[0].stilatura;
      for(let i = 0; i < this.result.length; i++){
         this.rarN[0].push(this.result[i]['analisi']['rigiditaRotazioni']['rod']);
         this.rarS.push(this.result[i]['azienda']['nome']);
      }
      for(let i = 0; i < this.result.length; i++){
       this.rarN[1].push(this.result[i]['analisi']['rigiditaRotazioni']['roi']);
      }
      for(let i = 0; i < this.result.length; i++){
         this.rarN[2].push(this.result[i]['analisi']['rigiditaRotazioni']['roe'] );
      }
      for(let i = 0; i < this.result.length; i++){
       this.rarN[3].push(this.result[i]['analisi']['rigiditaRotazioni']['ros'] );
      }

      console.log(this.rarS)
      console.log(this.rarN)

      this.grafo = new Chart('canvas', {
                                        type: 'bar',
                                        data: {
                                          labels:this.rarS,
                                          datasets: [
                                            {
                                              label: 'rod',
                                              data: this.rarN[0],
                                              borderWidth: 1,
                                            },
                                            {
                                              label: 'roi',
                                              data: this.rarN[1],
                                              borderWidth: 1,
                                            },
                                            {
                                              label: 'roe',
                                              data: this.rarN[2],
                                              borderWidth: 1,
                                            },
                                            {
                                              label: 'ros',
                                              data: this.rarN[3],
                                              borderWidth: 1,
                                            },
                                          ]
                                              },
                                        options: {
                                          scales: {
                                            y: {
                                              beginAtZero: true,
                                            },
                                          },
                                        },
                                      }

      );

      
      this.rarK = Object.keys(this.rar);
      this.rarS = ['immobilizzazioniMateriali','debitiAzionisti','passivitaCorrenti','passivo'];
      let rN : number[] = [];
      let nomeAzienda = this.result[0]['azienda']['nome'];

      let statoPatrimoniale = this.result[0]['analisi']['statoPatrimoniale'];
      let attivo: number = statoPatrimoniale['attivo'];

//----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------


let buffer : any = [];

     for(let j = 0; j < this.result.length; j++){
        if(this.result[j]['azienda']['nome'] === this.nome){
          this.rN = this.result[j];
          break;
        }
     }
          console.log(this.rN)
          nomeAzienda = this.rN['azienda']['nome']
          // this.rarN.push(this.result[i]['statoPatrimoniale']['immobilizzazioniMateriali']);
          // this.rarN.push(this.result[i]['statoPatrimoniale']['immobilizzazioniImmateriali']);
          // this.rarN.push(this.result[i]['statoPatrimoniale']['immobilizzazioniFinanziarie']);
          // this.rarN.push(this.result[i]['statoPatrimoniale']['attivoCircolante']);
      

          statoPatrimoniale = this.rN['analisi']['statoPatrimoniale'];
          attivo = statoPatrimoniale['attivo'];
          buffer.push(statoPatrimoniale['immobilizzazioniMateriali']);
          buffer.push(statoPatrimoniale['debitiAzionisti']);
          buffer.push(statoPatrimoniale['passivitaCorrenti']);
          buffer.push(statoPatrimoniale['passivo']);
          this.chart2 = new Chart('canvas3', {
                                              type:'doughnut',
                                              data: {
                                                labels:this.rarS,
                                                datasets: [
                                                            {
                                                              label: nomeAzienda,
                                                              data: buffer,
                                                              borderWidth: 1,
                                                            },

                                                          ],
                                                    },
                                              options: {
                                                scales: {
                                                  y: {
                                                    beginAtZero: true,
                                                  },
                                                },
                                              },
                                            }
                                  );




    });
  }


}
