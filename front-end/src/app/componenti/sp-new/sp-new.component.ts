import { Component, OnInit } from '@angular/core';
import {
  FormControl,
  FormGroupDirective,
  NgForm,
  Validators,
  FormsModule,
  ReactiveFormsModule,
} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import {NgIf} from '@angular/common';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-sp-new',
  templateUrl: './sp-new.component.html',
  styleUrls: ['./sp-new.component.css']
})
export class SpNewComponent implements OnInit{
  name = new FormControl('');
  codiceAteco = new FormControl('');
  indirizzo = new FormControl('');
  dipendenti = new FormControl('');
  nome: any = [];

  constructor(private activatedRoute:ActivatedRoute){}
  ngOnInit(): void {
    this.nome = this.activatedRoute.snapshot.paramMap.get('nome')!;   
  }
  showData(){
    this.nome = this.activatedRoute.snapshot.paramMap.get('nome')!;   
    console.log(this.name)
  }
}
