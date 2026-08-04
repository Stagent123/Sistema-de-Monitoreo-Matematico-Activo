import { Component, ChangeDetectionStrategy } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MateriaService } from '../../../services/materia.service';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './registro-materia.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './registro-materia.css',
})
export class RegistroMateria {
  DatosFormulario = {
    id: '',
    nombre: '',
    CodigoAcceso: '', //Esto es momentaneo luego añadire sistema de equivalencias e solicitud de inscripcion y (invitaciones).
  };

  constructor(private materiaService: MateriaService) {}

  Registro() {
    this.materiaService.register(this.DatosFormulario).subscribe({
      next: (respuesta) => {
        console.log('Registro Exitoso', respuesta);
        const confirmar = confirm('Usuario Registrado con exito desea volver al menu principal? ');
        if (confirmar === true) {
          window.location.href = '/home';
        }
      },
      error: (err) => {
        console.log('no pudo crear la Materia...');
      },
    });
  }
}
