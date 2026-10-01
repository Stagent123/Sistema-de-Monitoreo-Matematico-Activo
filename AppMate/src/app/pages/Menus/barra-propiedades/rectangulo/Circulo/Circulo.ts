import {Component,output,signal} from '@angular/core'
export interface propiedadesCirculo {
    tipo: string,
    radio: number
    grosor: number,
    color: string
}

export interface prop {
    nombre: keyof propiedadesCirculo,
    valor: any
}

@Component({
    selector: 'app-Circulo',
    standalone: true,
    imports: [],
    templateUrl: './Circulo.html',
    styleUrl: './Circulo.css'
})

export class Circulo {
    valores = output<propiedadesCirculo>();

    propiedades = signal<prop[]>([
        {nombre:'radio',valor: 50},
        {nombre:'grosor',valor: 1}
    ])

    val: propiedadesCirculo = {
        tipo: 'Circulo',
        radio:50,
        grosor:1,
        color: 'white'
    }

    actualizarCampo(campo: keyof propiedadesCirculo, nuevovalor:any): void {
        const valorfinal = campo ==='color' ? nuevovalor: Number(nuevovalor);
        (this.val as any)[campo] = valorfinal;
        this.enviardatos()
    }
    enviardatos(): void {
        this.valores.emit(this.val);
        console.log("dato enviado: ", this.val)
    }
}