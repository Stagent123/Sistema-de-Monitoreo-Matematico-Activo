import { Component, ChangeDetectionStrategy, AfterViewInit,Inject, PLATFORM_ID, inject, viewChild, ViewChild } from '@angular/core';
// Importa las clases concretas que vayas a usar
import { Canvas, Rect, Circle, PencilBrush, FabricText, Textbox } from 'fabric';
import { BarraHerramientas } from "../../Menus/barra-herramientas/barra-herramientas";
import { isPlatformBrowser } from '@angular/common';
import { EditorEcuaciones } from '../editor-ecuaciones/editor-ecuaciones';

@Component({
  selector: 'app-pizarra-alumno',
  standalone: true,
  imports: [BarraHerramientas,EditorEcuaciones],
  templateUrl: './pizarra-alumno.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrl: './pizarra-alumno.css',
})
export class PizarraAlumno implements AfterViewInit {

  @ViewChild(EditorEcuaciones) editormodal!: EditorEcuaciones
  // El tipo de dato es directamente 'Canvas'
  public canvas!: Canvas;
  public herramienta = "abc"
  private platformId = inject(PLATFORM_ID)

  public abrirEditorModal(): void {
    if (this.editormodal) {
      this.editormodal.setEstadoModal(true);
    }
  }

  public alInsertarEcuacion(ecuacionLatex: string): void {
    console.log('Insertar en el lienzo:', ecuacionLatex);
    // Aquí agregas la lógica para pintar el LaTeX en tu pizarra
  }

  ngAfterViewInit(): void {
      if(isPlatformBrowser(this.platformId)){
        this.canvas = new Canvas('canvas',{
        height:800,
        width:1000
     });
      this.canvas.on('mouse:down', (options) => {
        if (this.canvas.isDrawingMode) return;
        if(options.e){
          const point = this.canvas.getScenePoint(options.e)
          if(point){
            this.CuandoClickee(point.x, point.y)
          }
        }
      });
      this.canvas.on('mouse:down', (e) =>{
        if (e.target){

           const tipo = (e.target as any).tipo;
          /// Falta crear las propiedades especiales del objeto id y tipo talvez otro mas aparte de esos
          switch(tipo){
            case "Cuadrados":
              return
        }
        }
      })
    }
  }

  onHerramientaCambiada(X: string){
    this.herramienta = X
    if (!this.canvas) return;
    
    if(this.herramienta === "Lapiz"){
      this.canvas.isDrawingMode = true;
      const lapiz = new PencilBrush(this.canvas);
      lapiz.color = '#000000';
      lapiz.width = 5;
      this.canvas.freeDrawingBrush = lapiz;
    } else {
      this.canvas.isDrawingMode = false;
    }

    
  }

   CuandoClickee(x:number ,y:number){
    switch(this.herramienta){
      case "Select":
        return
      case "Cuadrados":
        const Cuadrados = new Rect ({
          left: x-25,
          top: y-25,
          height: 50,
          width: 50,
          fill: 'blue',
          angle: 0,
          strokeWidth: 1
        })
        this.canvas.add(Cuadrados)
        this.canvas.requestRenderAll();
        this.onHerramientaCambiada("Select")
        return 
      case "Circulos":
        const circulo = new Circle({
          left: x-25,
          top: y-25,
          fill: 'red',
          radius: 50
        })
          this.canvas.add(circulo)
          this.canvas.requestRenderAll();
          this.onHerramientaCambiada("Select")
        return  
      case "Formulas":
        return
      case "Texto":
        const texto = new Textbox('Ejemplo',{
          left: x,
          top: y,
          fill: '#880E4F',
          stroke: '#D81B60'
          

        })
        this.canvas.requestRenderAll();
        this.canvas.add(texto)
        this.onHerramientaCambiada("Select")
        return
      default:
        
        return
    }
  }




}