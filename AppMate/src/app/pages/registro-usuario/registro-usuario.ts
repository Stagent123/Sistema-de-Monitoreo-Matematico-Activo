import { Component } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { UsuarioService } from '../../services/usuario.service';

@Component({
  selector: 'app-registro-usuario',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './registro-usuario.html',
  styleUrl: './registro-usuario.css',
})
export class RegistroUsuario {
  
  datosFormulario = {
    email: '',
    password: '',
    nombre: ''
  }

  constructor(private usuarioService: UsuarioService) {}

  onRegister() {
    this.usuarioService.registrar(this.datosFormulario).subscribe({
      next: (respuesta) => {
        console.log('Registro Exitoso!',respuesta);
        alert('Usuario Registrado');
        window.location.href = ("http://www.localhost:4200/home")
      }
    })
  }

}
