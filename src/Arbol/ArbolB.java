/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

/**
 *
 * @author Javier
 */
import static arbolhuffman.TFrecuencias.Numdatos;
import static decodificar.DecodificaArbol.datosL;
import java.util.ArrayList;
import javafx.collections.ObservableList;

public class ArbolB {

   
    Nodo raiz;
    boolean encontrado = false;
    Nodo encontradoN;
    String aCodificado = "";
    String arbol = "";
    String camino = "";
    String[] tCodificaciones;
    String codigoDes = "";
    boolean bandera = true;
    int cont = 0;

    Nodo encontradoNL; //almacena el nodo para insertarle una letra 

    public ArbolB() {
        raiz = null;
    }
    public Nodo getRaiz(){
        return raiz;
    }
    private void buscarNodo(Nodo reco, int dato) {
        if (reco != null) {
            if (reco.dato == dato && reco.isLeaf() && !encontrado) {
                encontrado = true;
                encontradoN = reco;
            }
            if (reco.dato == dato && reco.isLeaf() && reco.letra == null) {
                encontradoNL = reco;
            }

            buscarNodo(reco.izq, dato);
            buscarNodo(reco.der, dato);

        }
    }

    public void leerCodificado(String codigo) {
        Numdatos = 0;
        codigoDes = codigo;
        raiz = null;
        if (getBit().equals("0")) {
            raiz = new Nodo();
            crear(raiz);
        }
        

        System.out.println("raiz =" + raiz.dato);
        preOrder();
    }

 
    public String getLetra(){
        String aux = (char)Integer.parseInt(codigoDes.substring(0, 8), 2) + "";
        codigoDes = codigoDes.substring(8);
        if(codigoDes.substring(0,8).equals("11000001")){
            datosL[1] = codigoDes.substring(8);
            codigoDes = "";
        }
        return aux;
        
    }
    public String getBit(){
        String aux = codigoDes.substring(0,1);
        codigoDes = codigoDes.substring(1);
        return aux;
    }
    public Nodo crear(Nodo reco) {

        if (reco.dato != 0) {
            reco.letra = getLetra();
            return reco;
        } else {
            
            if (getBit().equals("0")) {
                reco.izq = new Nodo(); 
                crear(reco.izq);
            } else {
                reco.izq = new Nodo();
                reco.izq.dato = 1;
                crear(reco.izq);
            }
            if (getBit().equals("0")) {
                reco.der = new Nodo(); 
                crear(reco.der);
            } else {
                reco.der = new Nodo();
                reco.der.dato = 1;
                crear(reco.der);
            }
        }
        return reco;

    }

    public void buscarNodo(int dato) {
        encontrado = false;
        encontradoN = null;
        encontradoNL = null;
        buscarNodo(raiz, dato);
    }

    private void preOrder(Nodo reco) {
        if (reco != null) {
            if (!reco.isLeaf()) {
                aCodificado += "0";
            }
            arbol += "( ";
            if(reco.isLeaf()){
                arbol += 1 ;
                arbol += "--"+reco.letra;
            }else{
                arbol += 0 + " ";
            }
            System.out.print(reco.dato);
            if (reco.letra != null) {
                aCodificado += "1";

                setArbolC(reco.letra);
                System.out.print("--- " + reco.letra);
            }
            
            //arbol += reco.dato + " ";
            
            System.out.println("");
            preOrder(reco.izq);
            preOrder(reco.der);
            arbol += ")";
        }
    }

    public void preOrder() {
        aCodificado = "";
        preOrder(raiz);
        System.out.println();
        System.out.println(arbol);
    }

    public String getArbol() {
        return arbol;
    }
  
   

    public void insertar(int dato, int datoIzq, int datoDer) {
        Nodo nuevo = new Nodo();
        nuevo.dato = datoIzq;
        nuevo.izq = null;
        nuevo.der = null;
        Nodo nuevo2 = new Nodo();
        nuevo2.dato = datoDer;
        nuevo2.izq = null;
        nuevo2.der = null;

        if (raiz == null) {
            Nodo base = new Nodo();
            base.dato = dato;
            base.izq = nuevo;
            base.der = nuevo2;
            raiz = base;
        } else {
            buscarNodo(dato);
            if (encontrado) {
                // System.out.println("dato: "+dato+"  nodod: "+encontradoN.dato);
                // System.out.println("datoizq: "+datoIzq +"datoder: "+datoDer);
                encontradoN.izq = nuevo;
                encontradoN.der = nuevo2;
            }
        }

    }

    public void recorrer() {
        cont = 0;
        tCodificaciones = new String[Numdatos];
        System.out.println("hola" + tCodificaciones.length);
        recorrer(raiz);
        System.out.println();
    }

    public void recorrer(Nodo reco) {

        if (!reco.isLeaf()) {

            if (reco.izq != null) {

                camino = camino + "0";
                recorrer(reco.izq);
            }

            if (reco.der != null) {

                camino = camino + "1";
                recorrer(reco.der);
            }
        } else {

            guardar(reco, camino);

        }
        if (camino.length() > 0) {
            camino = camino.substring(0, camino.length() - 1);
        }
    }

    private void setArbolC(String letra) {
        aCodificado += getBinario(letra);
        Numdatos++;
    }
      public String codificarMensaje(String mensaje){
              String codigo = "";
          for (int k = 0; k < mensaje.length(); k++) {
              String a  = mensaje.charAt(k)+"";

              for (int i = 0; i < tCodificaciones.length; i++) {
                String[] aux =  tCodificaciones[i].split(":");
                
                if(a.equals(aux[0]) ){
                    codigo += aux[1];
                }
            }
          }
        
        return codigo;
    }

    public String getArbolCodificado(String mensaje) {
        cont = 0;
        recorrer(raiz);
        preOrder();
       String aux = codificarMensaje(mensaje);
        System.out.println("El mensaje es:"+aux);
        return aCodificado+"11000001"+aux;
    }

    private String getBinario(String a) {
        return (String.format("%8s", Integer.toBinaryString(a.getBytes()[0])).replace(' ', '0'));
    }

    private void guardar(Nodo reco, String camino) {
        String codifi = reco.letra + ":" + camino;
        System.out.println("codifi++++ " + codifi);
        tCodificaciones[cont] = codifi;
        cont++;
    }

    public void imprimir() {
        for (int i = 0; i < tCodificaciones.length; i++) {
            System.out.println("**" + tCodificaciones[i]);
        }
    }

    public void setLetra(String letra, int valor) {
        buscarNodo(valor);
        if (encontradoNL != null) {
            encontradoNL.letra = letra;
            // System.out.println("insertado");
        }
    }

    
     public String mensaje() {
        return mensaje(raiz);
    }

    public String mensaje(Nodo reco) {
        String mensaje="";
        System.out.println("El mensaje es:"+datosL[1]);
        String enc = datosL[1];
        int letras = 0;
        System.out.println("length   " + enc.length());
        while (letras < enc.length()) {
            while (!reco.isLeaf()) {
                char c = enc.charAt(letras);
                if (c == '0') {
                    System.out.println("izq");
                    reco = reco.izq;
                }
                if (c == '1') {
                    reco = reco.der;
                    System.out.println("der");
                }
                letras ++;
            }
            mensaje += reco.letra;
            System.out.println("letra  " + reco.letra);
            reco = raiz;
        }
        return mensaje;
    }
        
   
    public String[] getCodificaciones(){
        return tCodificaciones;
    }

}
