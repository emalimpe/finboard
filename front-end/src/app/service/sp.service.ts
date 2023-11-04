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
export class SpService implements OnInit{

  private status: string = 'today';
  private spUrl = 'http://localhost:8080/statopatrimoniale/today';
  private spUrlStorico = 'http://localhost:8080/statopatrimoniale';
  spCurrent: any=[];
  spStorico: any=[];

  constructor(private http: HttpClient) {}
  ngOnInit(): void {
    this.spCurrent = this.http.get(this.spUrl, httpOptions);
    this.spStorico = this.http.get(this.spUrl, httpOptions);
  }
  cryptoData() {
      return this.http.get(this.spUrl, httpOptions);
  }
  storicData() {
    return this.http.get(this.spUrlStorico, httpOptions);
}

}
