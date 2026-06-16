import { Component } from '@angular/core';
import { UsuarioService } from '../../services/usuario.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  datosFormulario = {
    email: '',
    pass: ''
  };

  constructor(private usuarioService: UsuarioService) {}

  onLogin() {
    this.usuarioService.login(this.datosFormulario).subscribe({
      next: (respuesta) => {
        console.log('Login exitoso!',respuesta);
        localStorage.setItem('token',respuesta.token);
        alert('Bienvenido ' + respuesta.nombre);
      },
      error: (err) => {
        console.error ('Error en el login', err);
        alert('Credenciales incorrectas: ' + err.error)
      }
    })
  }


}
