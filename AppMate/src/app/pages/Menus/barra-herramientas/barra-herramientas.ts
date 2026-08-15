import { Component, signal, OnInit } from '@angular/core';
import { NgClass } from "@angular/common/";

export interface Herramienta {
  id: number;
  nombre: string;
}

@Component({
  selector: 'app-barra-herramientas',
  imports: [NgClass],
  templateUrl: './barra-herramientas.html',
  styleUrl: './barra-herramientas.css',
})
export class BarraHerramientas {
  public herramienta_activa = 'none'
  
  constructor() {
    this.herramienta_activa = 'Select';
  }

  
  herramientas = signal<Herramienta[]>([
    {id:1, nombre: 'Select' },
    {id:2, nombre: 'Pincel' },
    {id:3, nombre: 'Lapiz' },
    {id:4, nombre: 'Balde' },
    {id:5, nombre: 'CuentaGotas' },
    {id:6, nombre: 'Cuadrados' },
    {id:7, nombre: 'Circulos' },
    {id:8, nombre: 'Formulas' },
    {id:9, nombre: 'Texto' },
  ])

  ActivarHerramienta(nombre : string) {
    this.herramienta_activa = nombre;
  }




}
