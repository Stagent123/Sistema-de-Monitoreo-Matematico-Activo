import { Component, ElementRef, ViewChild,EventEmitter,Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

// Declaramos MathJax para informarle a TypeScript que existe en el scope global (window)
declare const MathJax: any;

@Component({
  selector: 'app-editor-ecuaciones',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './editor-ecuaciones.html',
  styleUrl: './editor-ecuaciones.css',
})
export class EditorEcuaciones {
  @Output() ecuacionCreada = new EventEmitter<string>();
  // Estado y variables del componente
  public estaAbierto: boolean = false;
  public ecuacionLatex: string = '';
  public ResultadoFinal: string = '';
  @ViewChild('dialogElement') dialogRef!: ElementRef<HTMLDialogElement>;
  // Referencia a la vista previa mediante ViewChild
  @ViewChild('preview') previewRef!: ElementRef<HTMLDivElement>;

  // Método para agregar comandos LaTeX desde botones
  public addEcuacion(codigo: string): void {
    this.ecuacionLatex += codigo;
    this.actualizarVistaPrevia();
  }

  // Método para abrir/cerrar el modal desde la barra
  public setEstadoModal(abrir: any): void {
  console.log('Valor bruto recibido:', abrir, 'Tipo:', typeof abrir);

  // Si llega un objeto (ej. { valor: true } o un Event), extraemos o convertimos a boolean
  if (typeof abrir === 'object' && abrir !== null) {
    // Si es un objeto, intentamos extraer una propiedad interna o forzamos el chequeo
    this.estaAbierto = abrir.hasOwnProperty('abrir') ? Boolean(abrir.abrir) : true;
  } else {
    this.estaAbierto = Boolean(abrir);
  }

  console.log('Resultado limpio asignado a estaAbierto:', this.estaAbierto);

  // Abrimos el dialog mediante la API nativa de HTML5
  setTimeout(() => {
      if (this.dialogRef?.nativeElement) {
        if (this.estaAbierto) {
          // Si el dialog ya está abierto no lo reabrimos para evitar excepciones
          if (!this.dialogRef.nativeElement.open) {
            this.dialogRef.nativeElement.showModal();
          }
        } else {
          this.dialogRef.nativeElement.close();
        }
      } else {
        console.error('El elemento dialogRef sigue sin estar disponible en el DOM');
      }
    }, 0);
  }


  // Renderiza la fórmula usando MathJax
  public actualizarVistaPrevia(): void {
    if (this.previewRef && typeof MathJax !== 'undefined') {
      this.previewRef.nativeElement.innerHTML = `\\[ ${this.ecuacionLatex} \\]`;
      MathJax.typesetPromise([this.previewRef.nativeElement]);
    }
  }

  public insertarYCerrar(): void {
    // 1. Emitimos la ecuación escrita al Padre
    this.ecuacionCreada.emit(this.ecuacionLatex);
    this.ResultadoFinal =this.ecuacionLatex
    
    
    // 2. Limpiamos y cerramos
    this.ecuacionLatex = '';
    this.setEstadoModal(false);
  }
}