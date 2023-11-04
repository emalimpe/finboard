import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {

  constructor(private element: ElementRef) { 
    this.cambiaColore('white'); 
  }

  @HostListener('mouseenter') onMouseEnter(){
    this.cambiaColore('#edc001'); 
  }
  @HostListener('mouseleave') onMouseLeave(){
    this.cambiaColore('white'); 
  }

  cambiaColore(colore:string){
    this.element.nativeElement.style.backgroundColor = colore; 
  }
}
