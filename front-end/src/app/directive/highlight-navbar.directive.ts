import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appHighlightNavbar]'
})
export class HighlightNavbarDirective {

  constructor(private element: ElementRef) { 
    this.cambiaColore('#6f6f3f'); 
  }

  // @HostListener('mouseenter') onMouseEnter(){
  //   this.cambiaColore('#000000'); 
  // }
  // @HostListener('mouseleave') onMouseLeave(){
  //   this.cambiaColore('#9a9a9a'); 
  // }

  cambiaColore(colore:string){
    this.element.nativeElement.style.backgroundColor = colore; 
  }
}
