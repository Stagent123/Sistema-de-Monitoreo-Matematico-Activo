import { FabricObject } from "fabric";
/// Agregar mas propiedades segun sea necesario
declare module 'fabric' {
    interface FabricObject {
        id? : string;

    }
    interface FabricText {
        id? : string;

    }
    interface SerializedObjectProps {
        id? : string;

    }
}