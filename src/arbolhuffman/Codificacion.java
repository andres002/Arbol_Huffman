/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhuffman;

/**
 *
 * @author Javier
 */
public class Codificacion {
    String[] datos;
    public void setDatos(String[] datos){
        this.datos = datos;
    }
    public int[] getTablaFrecuencia(){
        //leer archivo desde controller y pasarlo a esta clase
        //regresar un arreglo nuevo con el formato ["letra:frecuencia"]
        //ordenar de menor a mayor segun frecuencias
        return new int[2]; //regresar arreglo con formato de frecuencias
    }
    
    public String[] getRegistroReemplazo(int[] tablaFrecuencias){
        //sumar de par en par;
        //ordenar despues de cada suma
        //guardar sumas en un arreglo con el formato: [numero1:numero2:resultado]
         return new String[2]; //regresar arreglo de registro
    }
    
    public String[] getCodificaciones(){
        // recorrer el árbol para obtener codificaciones
        //guardar codificaciones en arreglo con el formato [letra:frecuencia]
        return new String[2];
    }
    
}
