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
      //  String[] tablaA = {"1:1:2","1:1:2","1:1:2","1:1:2","2:2:4","2:2:4","2:2:4","3:3:6","3:4:7","4:4:8","4:4:8","6:7:13","8:8:16","13:16:29"};
        String[] tablaA = {"1:1:2","1:1:2","1:1:2","1:1:2","2:2:4","2:2:4","2:2:4","3:4:7","4:4:8","4:5:9","6:7:13","8:9:17","13:17:30"};
        for (int i = tablaA.length-1; i >= 0; i--) {
            String[] aux = tablaA[i].split(":");
            int dato = Integer.parseInt(aux[2]);
            int datoIzq = Integer.parseInt(aux[0]);
            int datoDer = Integer.parseInt(aux[1]);            
            ar.insertar(dato, datoIzq, datoDer);
        }
       //  String[] tablaF = {"e:4","a:4","r:3","n:3","**:3","t:1","j:1","u:1","d:1","v:1","l:1","b:1","c:1","s:2","o:2"};
        String[] tablaF = {"j:2","a:2","v:1","i:1","e:6","r:5","d:1","s:3","u:1","f:1","l:1","o:1","h:1"," :4",};
         for (int i = 0; i < tablaF.length; i++) {
            String[] aux = tablaF[i].split(":");
            int frecuencia = Integer.parseInt(aux[1]);  
            
            ar.setLetra(aux[0], frecuencia);
        }
        
        ar.recorrer();
        ar.preOrder();
        System.out.println(ar.getArbolCodificado());
    }
    public String getArbol(){
        return ar.getArbol();
    }
    
}
