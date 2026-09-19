import { Component,signal } from '@angular/core';
export interface prop {
  alto: number;
  largo: number;
  color: string;
  grosor: number;
  angle: number;
} 
@Component({
  selector: 'app-rectangulo',
  standalone: true,
  imports: [],
  templateUrl: './rectangulo.html',
  styleUrl: './rectangulo.css',
})
export class Rectangulo {

propiedades = signal<prop[]>([
  {alto: 50,largo: 50,color:'white',grosor: 1,angle: 0}
])

}
