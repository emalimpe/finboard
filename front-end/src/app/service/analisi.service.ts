import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',
  }),
};

@Injectable({
  providedIn: 'root'
})
export class AnalisiService implements OnInit{

  private analysisUrl = 'http://localhost:8080/analisi/';
  
  constructor(private http: HttpClient) {}
  ngOnInit(): any {
    return this.http.get(this.analysisUrl, httpOptions);
  }

  tempoData(nome : string) {
    console.log(this.analysisUrl+nome)
      return this.http.get(this.analysisUrl+nome, httpOptions);
  }

  spazioData(nome:string, anno:string) {
    console.log(this.analysisUrl+ 'settore/' + nome + '/' + anno)
    return this.http.get(this.analysisUrl + 'settore/' + nome + '/' + anno, httpOptions);
}
}
