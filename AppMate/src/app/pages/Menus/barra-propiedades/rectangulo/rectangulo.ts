import { Component,output,signal } from '@angular/core';
export interface propiedadesRectangulo {
  tipo: string,
  alto: number,
  ancho: number,
  grosor: number,
  angulo: number,
  color: string
} 

export interface prop {
  nombre: keyof propiedadesRectangulo,
  valor: any
}

@Component({
  selector: 'app-rectangulo',
  standalone: true,
  imports: [],
  templateUrl: './rectangulo.html',
  styleUrl: './rectangulo.css',
})



export class Rectangulo {
  valores = output<propiedadesRectangulo>();

  propiedades = signal<prop[]>([
    {nombre: 'alto', valor: 50},
    {nombre: 'ancho', valor: 50},
    {nombre: 'grosor', valor: 1},
    {nombre: 'angulo', valor: 0},
  ])


  val: propiedadesRectangulo = {
    tipo: 'Cuadrado',
    alto: 50,
    ancho: 50,
    grosor: 1,
    angulo: 0,
    color: 'White'
  }

  actualizarCampo(campo: keyof propiedadesRectangulo, nuevovalor: any): void {
    const valorfinal = campo ==='color' ? nuevovalor : Number(nuevovalor);
    (this.val as any )[campo] = valorfinal;
    this.enviardatos()
  } 

  enviardatos(): void{
    this.valores.emit(this.val);
    console.log("dato enviado: ", this.val)
  }

}
