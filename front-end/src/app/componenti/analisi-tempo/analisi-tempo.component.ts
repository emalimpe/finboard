import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AnalisiService } from 'src/app/service/analisi.service';
import Chart from 'chart.js/auto';
@Component({
  selector: 'app-analisi-tempo',
  templateUrl: './analisi-tempo.component.html',
  styleUrls: ['./analisi-tempo.component.css']
})
export class AnalisiTempoComponent implements OnInit{
  analisiCurr: any = [];
  nome : any = [];
  anno : any = [];
  rod  : any = [];
  ros  : any = [];
  roi  : any = [];
  roe  : any = [];
  anni : any = [];
  datasets : any = [];
  indiceDiRigidita : any = [];
  quozienteDiRigiditaDegliImpieghi : any = [];
  quozienteDiStrutturaPrimario: any = [];
  margineTesoreria : any = [];
  quozienteDiDisponibilita : any = [];
  quozienteTesoreria: any = [];

  constructor(private route:ActivatedRoute, private analisiService: AnalisiService){}  
  ngOnInit(): void {
    this.nome = this.route.snapshot.paramMap.get('nome');
    this.analisiService.tempoData(this.nome).subscribe((res) => {
      this.analisiCurr = res;
      console.log(res);
      for(let i = 0; i < this.analisiCurr.length; i++){
        this.anni.unshift(this.analisiCurr[i]['stilatura']);
      }
      for(let i = 0; i < this.analisiCurr.length; i++){
        this.rod.unshift(this.analisiCurr[i]['analisi']['rigiditaRotazioni']['rod']);
        this.ros.unshift(this.analisiCurr[i]['analisi']['rigiditaRotazioni']['ros']);
        this.roi.unshift(this.analisiCurr[i]['analisi']['rigiditaRotazioni']['roi']);
        this.roe.unshift(this.analisiCurr[i]['analisi']['rigiditaRotazioni']['roe']);

      }
      console.log(this.anni);
      console.log(this.rod);
      console.log('ROS')
      console.log(this.ros);


      new Chart('canvas', {
                            type: 'line',
                            data: {
                              labels:this.anni,
                              datasets: [
                                {
                                  label: 'rod',
                                  data: this.rod,
                                  borderWidth: 1,
                                },
                                {
                                  label: 'ros',
                                  data: this.ros,
                                  borderWidth: 1,
                                },
                                {
                                  label: 'roe',
                                  data: this.roe,
                                  borderWidth: 1,
                                },
                                {
                                  label: 'roi',
                                  data: this.roi,
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

for(let i = 0; i < this.analisiCurr.length; i++){
  this.quozienteDiStrutturaPrimario.unshift(this.analisiCurr[i]['analisi']['solidita']['quozienteDiStrutturaPrimario']);
  this.quozienteDiRigiditaDegliImpieghi.unshift(this.analisiCurr[i]['analisi']['struttura']['quozienteDiRigiditaDegliImpieghi']);
  this.indiceDiRigidita.unshift(this.analisiCurr[i]['analisi']['struttura']['indiceDiRigidita']);
}    

new Chart('canvas2', {
                      type: 'bar',
                      data: {
                        labels:this.anni,
                        datasets: [
                          {

                            label:'quozStrutt_1',
                            data: this.quozienteDiStrutturaPrimario,
                            borderWidth: 1,
                          },
                          {
                            label:'quozRigImpieghi',
                            data: this.quozienteDiRigiditaDegliImpieghi,
                            borderWidth: 1,
                          },
                          {
                            label:'indiceRigidita',
                            data: this.indiceDiRigidita,
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

// margineTesoreria: 0.00074384315
// ​​​​
// quozienteDiDisponibilita: 3.7981468e-7
// ​​​​
// quozienteTesoreria: 3.7630323e-7

for(let i = 0; i < this.analisiCurr.length; i++){
  this.margineTesoreria.unshift(this.analisiCurr[i]['analisi']['tesoreria']['margineTesoreria']);
  this.quozienteDiDisponibilita.unshift(this.analisiCurr[i]['analisi']['tesoreria']['quozienteDiDisponibilita']);
  this.quozienteTesoreria.unshift(this.analisiCurr[i]['analisi']['tesoreria']['quozienteTesoreria']);
}    

console.log(this.margineTesoreria)
console.log(this.quozienteDiDisponibilita)
console.log(this.quozienteTesoreria)

new Chart('canvas3', {
                      type: 'bar',
                      data: {
                        labels:this.anni,
                        datasets: [
                          {

                            label:'margineTesoreria',
                            data: this.margineTesoreria,
                            borderWidth: 1,
                          },
                          {
                            label:'quozDispo',
                            data: this.quozienteDiDisponibilita,
                            borderWidth: 1,
                          },
                          {
                            label:'quozTesoreria',
                            data: this.quozienteTesoreria,
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




    })
  }
}
