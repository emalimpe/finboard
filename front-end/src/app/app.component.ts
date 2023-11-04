import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import {MatMenuModule} from '@angular/material/menu';
import {MatTableModule} from '@angular/material/table'
import {MatButtonModule} from '@angular/material/button';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'bozza';

  constructor(private router:Router){}
  ngOnInit(): void {  }

  goHome(){
    this.router.navigate(['']);
  }
  goSP(){
    this.router.navigate(['statopatrimoniale']);
  }
  goCE(){
    this.router.navigate(['contoeconomico']);
  }

  goNewAzienda(){
    this.router.navigate(['azienda/new']);
  }


}
