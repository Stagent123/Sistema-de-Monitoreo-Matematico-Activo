import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { ObjectEncodingOptions } from "fs";

@Injectable({
    providedIn: 'root'
})

export class MateriaService {
    private API_URL = 'http://localhost:8080/api/materia';

    constructor(private http: HttpClient) {}

    register(materia: any) : Observable<any> {
        return this.http.post(`${this.API_URL}/registro`,materia)
    }

    buscarTodos(): Observable<any[]> {
        return this.http.get<any[]>(`${this.API_URL}/todos`);    
    }

    borrar(id: number): Observable<any>{
        return this.http.delete(`${this.API_URL}/borrar/${id}`);
    }
}