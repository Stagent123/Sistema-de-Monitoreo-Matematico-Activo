import {Injectable} from '@angular/core'
import {Canvas, FabricObject } from 'fabric'

FabricObject.customProperties = ['id','type']

@Injectable ({
    providedIn: 'root'
})

export class PizarraService {
    private canvas!: Canvas;

    public isinCanvas(canvasEl: HTMLCanvasElement):Canvas {
        this.canvas = new Canvas(canvasEl);
        return this.canvas;
    }
    
    
}