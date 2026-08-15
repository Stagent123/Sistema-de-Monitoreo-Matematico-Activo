import { Component, ChangeDetectionStrategy, AfterViewInit } from '@angular/core';
// Importa las clases concretas que vayas a usar
import { Canvas, Rect } from 'fabric';

@Component({
  selector: 'app-pizarra-alumno',
  imports: [],
  templateUrl: './pizarra-alumno.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './pizarra-alumno.css',
})
export class PizarraAlumno implements AfterViewInit {
  // El tipo de dato es directamente 'Canvas'
  public canvas!: Canvas;

  ngAfterViewInit(): void {
    // Inicialización directamente con new Canvas(...)
    this.canvas = new Canvas('C');

    // Ejemplo de cómo agregar una figura en v7:
    const rect = new Rect({
      left: 100,
      top: 100,
      fill: 'red',
      width: 50,
      height: 50,
    });

    this.canvas.add(rect);
  }
}