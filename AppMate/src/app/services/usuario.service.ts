import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ObjectEncodingOptions } from 'fs';

@Injectable({
    providedIn: 'root'
})

export class UsuarioService {
    private API_URL = 'http://localhost:8080/api/usuarios';

    constructor(private http: HttpClient){  }

    login(datoLogin: any): Observable<any> {
        return this.http.post(`${this.API_URL}/login`, datoLogin);
    }

    registrar(usuario: any): Observable<any> {
        return this.http.post(`${this.API_URL}/registar`,usuario);
    }

    buscarTodos(): Observable<any[]> {
        return this.http.get<any[]>(`${this.API_URL}/todos`);
    }

    borrar(usuario: any): Observable<any> {
        return this.http.delete(`${this.API_URL}/borrar` , {body:usuario});
    }

    buscaPorEmail(email: string): Observable<any> {
        return this.http.get<any>(`${this.API_URL}/buscar?email=${email}`);
    }

    desencriptarToken(): string | null {
        const token = localStorage.getItem('token');
        if(!token) return null;

        try{
            const payloadBase64 = token.split('.')[1];
            const payloadDecodificado = atob(payloadBase64);
            const Datostoken = JSON.parse(payloadDecodificado);
            return Datostoken.sub;
        } catch(error) {
            console.error('Error al decodificar el token' , error ) ;
            return null;
        }
    }

}
