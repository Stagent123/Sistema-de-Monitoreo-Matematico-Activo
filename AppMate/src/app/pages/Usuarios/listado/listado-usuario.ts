import { Component, ChangeDetectionStrategy } from '@angular/core';
import { email } from '@angular/forms/signals';
import { UsuarioService } from '../../../services/usuario.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-listado-usuario',
  imports: [NgIf],
  templateUrl: './listado-usuario.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './listado-usuario.css',
})
export class ListadoUsuario {
  listausuarios: any[] = [];
  mensajeError = '';

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.cargarusuarios();
  }

  cargarusuarios(): void {
    this.usuarioService.buscarTodos().subscribe({
      next: (datos) => {
        this.listausuarios = datos;
        console.log('Usuarios encontrados');
      },
      error: (err) => {
        console.log('No se han encontrado usuarios', +err);
        this.mensajeError = 'Error no se han encontrado usuarios, intentelo mas tarde ';
      },
    });
  }
  Borrar(id: number): void {
    const seguro = confirm('Esta seguro de continuar?');
    if (seguro) {
      this.usuarioService.borrar(id).subscribe({
        next: (datos) => {
          console.log('Usuario Borrado con exito', +datos);
          window.location.href = '/home';
        },
        error: (err) => {
          console.log('no se encontro ningun usuario con ese id,+err');
        },
      });
    }
  }
}
