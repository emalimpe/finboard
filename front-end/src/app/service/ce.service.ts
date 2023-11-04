import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',
  }),
};

@Injectable({
  providedIn: 'root'
})
export class CeService implements OnInit {

  private status: string = 'today';
  private ceUrl = 'http://localhost:8080/contoeconomico/today';
  private ceUrlStorico = 'http://localhost:8080/contoeconomico';
  ceCurrent:any=[];
  ceStorico:any=[];

  constructor(private http: HttpClient) {}
  ngOnInit(): any {
    this.ceCurrent = this.http.get(this.ceUrl, httpOptions);
    this.ceStorico = this.http.get(this.ceUrlStorico,httpOptions);
  }
  cryptoData() {
      return this.http.get(this.ceUrl, httpOptions);
  }
  storicData(){
    return this.http.get(this.ceUrlStorico,httpOptions);
  }
}
