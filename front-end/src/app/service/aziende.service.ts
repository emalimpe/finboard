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
export class AziendeService implements OnInit {

  private aziendeUrl = 'http://localhost:8080/aziende';
  private insertUrl = 'http://localhost:8080/aziende/new';

  constructor(private http: HttpClient) {}
  ngOnInit(): any {
    return this.http.get(this.aziendeUrl, httpOptions);
  }

  cryptoData() {
      return this.http.get(this.aziendeUrl, httpOptions);
  }

  deleteById(nome:string){
    console.log(this.aziendeUrl +nome)
    return this.http.delete(this.aziendeUrl + '/'+nome).subscribe(() => 'Delete succesful');
  }

  insertNew(body:any){
    return this.http.post(this.insertUrl,body,httpOptions);
  }
}
