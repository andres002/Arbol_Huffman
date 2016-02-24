/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhuffman;

import Arbol.ArbolB;

/**
 *
 * @author Javier
 */
public class Codificacion {
    ArbolB ar = new ArbolB();
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
    public void setArbol(){
        String[] tablaA = {"1:1:2","1:1:2","1:1:2","1:1:2","2:2:4","2:2:4","2:2:4","3:4:7","4:4:8","4:5:9","6:7:13","8:9:17","13:17:30"};
        for (int i = tablaA.length-1; i >= 0; i--) {
            String[] aux = tablaA[i].split(":");
            int dato = Integer.parseInt(aux[2]);
            int datoIzq = Integer.parseInt(aux[0]);
            int datoDer = Integer.parseInt(aux[1]);            
            ar.insertar(dato, datoIzq, datoDer);
        }
        ar.preOrder();
    }
    
}
