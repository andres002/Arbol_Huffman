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
import java.util.ArrayList;
import java.util.List;

public class ArbolB {

    class Nodo {

        int dato;
        String letra = null;
        int frecuencia;
        Nodo izq = null, der = null;

        public boolean isLeaf() {
            return izq == null && der == null;
        }
    }
    Nodo raiz;
    boolean encontrado = false;
    Nodo encontradoN;
    String aCodificado = "";
    String arbol = ""; 
    String camino = "";
    String[] tCodificaciones;
    int cont = 0;

    Nodo encontradoNL; //almacena el nodo para insertarle una letra 

    public ArbolB() {
        raiz = null;
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

    public void buscarNodo(int dato) {
        encontrado = false;
        encontradoN = null;
        encontradoNL = null;
        buscarNodo(raiz, dato);
    }

    private void preOrder(Nodo reco) {
        if (reco != null) {
            if(!reco.isLeaf())
            aCodificado += "0";
            
            System.out.print(reco.dato);
            if (reco.letra != null) {
                aCodificado += "1";
                
                 setArbolC(reco.letra);
                System.out.print("--- " + reco.letra);
            }
                arbol += "( ";
                arbol += reco.dato+" ";
            
            
            System.out.println("");
            preOrder(reco.izq);
            preOrder(reco.der);
           arbol +=")";
        }
    }
    public String getArbol(){
        return arbol;
    }
    public void preOrder() {
       
        preOrder(raiz);
        System.out.println();
        System.out.println(arbol);
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
        System.out.println("hola"+tCodificaciones.length);
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
    private void setArbolC(String letra){
        aCodificado += getBinario(letra);
    }
    public String getArbolCodificado(){
        cont = 0;
        recorrer(raiz);
        return aCodificado;
    }
    private String getBinario(String a){
       return(String.format("%8s", Integer.toBinaryString(a.getBytes()[0])).replace(' ', '0'));
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
}
