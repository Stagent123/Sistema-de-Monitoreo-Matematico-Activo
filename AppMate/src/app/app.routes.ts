import { Routes } from '@angular/router';
import { Login } from './pages/login/login';
import { MenuPrincipal } from './pages/menu-principal/menu-principal';

export const routes: Routes = [
    { path: '',redirectTo:'login',pathMatch:'full'},
    { path: 'login', component: Login },
    { path: 'home', component: MenuPrincipal}
];
