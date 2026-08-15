import { Routes } from '@angular/router';
//import pages...
import { MenuPrincipal } from './pages/Menus/menu-principal/menu-principal';

//User pages / paginas del Usuario 
import { RegistroUsuario } from './pages/Usuarios/registro/registro-usuario';
import { ListadoUsuario } from './pages/Usuarios/listado/listado-usuario';
import { Login } from './pages/Usuarios/login/login';
import { PizarraAlumno } from './pages/Pizarras/pizarra-alumno/pizarra-alumno';


export const routes: Routes = [
    //Ejemplo de como añadir una pagina al router...
    { path: '', component: MenuPrincipal},
    
    //Ejemplo como añadir una pagina que recibe un dato al router
    // enrutamiento paginas relacionadas con el Usuario
    { path: 'usuario/login', component: Login },
    { path: 'usuario/registro/:Id', component: RegistroUsuario },
    { path: 'usuario/registro' , component: RegistroUsuario },
    { path: 'usuario/listado', component: ListadoUsuario },
    { path: 'Pizarra', component: PizarraAlumno }

    //

    
];
