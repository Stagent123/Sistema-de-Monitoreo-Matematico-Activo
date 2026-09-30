import { Component, signal,Output,EventEmitter } from '@angular/core';
export interface Herramienta {
  id: number;
  nombre: string;
}

@Component({
  selector: 'app-barra-herramientas',
  standalone: true,
  imports: [],
  templateUrl: './barra-herramientas.html',
  styleUrl: './barra-herramientas.css',
})
export class BarraHerramientas {
  public herramienta_activa = 'none'
  @Output() abrirEditorEvent = new EventEmitter<boolean>();
  @Output() herramientaSeleccionada = new EventEmitter<string>();
  constructor() {
    this.herramienta_activa = 'Select';
  }
  
  herramientas = signal<Herramienta[]>([
    {id:1, nombre: 'Select' },
    {id:2, nombre: 'Lapiz' },
    {id:3, nombre: 'Cuadrados' },
    {id:4, nombre: 'Circulos' },
    {id:5, nombre: 'Texto' },
    {id:6, nombre: 'Formulas'}
  ])

  ActivarHerramienta(nombre : string) {

    this.herramienta_activa = nombre

    if (nombre === 'Formulas'){
      this.abrirEditorEvent.emit(true)
    }
    this.herramientaSeleccionada.emit(this.herramienta_activa)
  }

  

 
}
