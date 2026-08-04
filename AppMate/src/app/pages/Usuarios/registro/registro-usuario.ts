import { Component, ChangeDetectionStrategy } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from '../../../services/usuario.service';

@Component({
  selector: 'app-registro-usuario',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './registro-usuario.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './registro-usuario.css',
})
export class RegistroUsuario {
  datosFormulario = {
    id: '',
    email: '',
    password: '',
    nombre: '',
    rol: '',
  };

  esadmin: boolean = false;

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.buscarusuario();
    this.esAdmin();
  }
  buscarusuario() {
    this.usuarioService.buscaPorID; //Crear un metodo Buscar Id en el Backend
  }

  esAdmin() {
    const emailUsuario = this.usuarioService.desencriptarToken();

    if (emailUsuario) {
      this.usuarioService.buscaPorEmail(emailUsuario).subscribe({
        next: (usuario) => {
          this.esadmin = usuario.rol === 'ADMIN';
        },
      });
    }
  }

  onRegister() {
    this.usuarioService.registrar(this.datosFormulario).subscribe({
      next: (respuesta) => {
        console.log('Registro Exitoso!', respuesta);
        alert('Usuario Registrado');
        window.location.href = 'http://www.localhost:4200/home';
      },
    });
  }
}
