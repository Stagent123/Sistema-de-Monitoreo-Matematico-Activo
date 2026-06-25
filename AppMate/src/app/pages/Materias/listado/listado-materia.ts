import { Component } from '@angular/core';
import { email } from '@angular/forms/signals';
import { MateriaService } from '../../../services/materia.service';
import { NgIf } from '../../../../../node_modules/@angular/common/types/_common_module-chunk';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-listado',
  imports: [NgIf, RouterLink],
  templateUrl: './listado-materia.html',
  styleUrl: './listado-materia.css',
})
export class ListadoMateria {

  listamaterias: any[] = [];
  mensajeError = '';

  constructor(private materiaservice:MateriaService ){}

  ngOnInit(): void {
    this.cargaMaterias();
  }

  cargaMaterias (): void{
    this.materiaservice.buscarTodos().subscribe({
      next:(datos) =>{
        this.listamaterias = datos;
        console.log('Materias encontradas' + datos.length);
      },
      error: (err) => {
        console.log('no se han encotrado materias',+ err)
        this.mensajeError = 'Error no se han encontrado materias dentro del sistema';
      }
    })
  }

  Borrar(id: number): void {
    const seguro = confirm ('Esta seguro de continuar?');
    if(seguro) {
      this.materiaservice.borrar(id).subscribe({
        next:(datos) => {
          console.log('Materia Borrado con exito', + datos);
          window.location.href = ('/home');
        }, error: (err) => {
          console.log('no se encontro ninguna materia con ese id')
        }
      })
    }      
  
    }



}
