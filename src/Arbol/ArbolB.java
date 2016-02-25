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
public class ArbolB {

    class Nodo {

        int dato;
        String letra = null;
        int frecuencia;
        Nodo izq = null, der=null;

        public boolean isLeaf() {
            return izq == null && der == null;
        }
    }
    Nodo raiz;
    boolean encontrado = false;
    Nodo encontradoN;
    Nodo encontradoNL; //almacena el nodo para insertarle una letra 

    public ArbolB() {
        raiz = null;
    }
      private void buscarNodo (Nodo reco,int dato){
      if (reco != null) {
        if(reco.dato == dato && reco.isLeaf() && !encontrado){
            encontrado = true;
            encontradoN = reco;
        }
        if(reco.dato == dato && reco.isLeaf() && reco.letra == null){
            encontradoNL = reco;
        }
            
        buscarNodo(reco.izq,dato);
        buscarNodo (reco.der,dato);
        
      }
    }

    public void buscarNodo (int dato){
      encontrado = false;
      encontradoN = null;
      encontradoNL = null;
      buscarNodo (raiz,dato);
    }

     private void preOrder (Nodo reco){
      if (reco != null)
      { 
        System.out.print(reco.dato);
        if(reco.letra != null)
              System.out.print("--- "+reco.letra);
          System.out.println("");
        preOrder (reco.izq);
        preOrder (reco.der);
      }
    }

    public void preOrder ()
    {
      preOrder (raiz);
      System.out.println();
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
                
        if(raiz == null){
            Nodo base = new Nodo();
            base.dato = dato;
            base.izq = nuevo;
            base.der = nuevo2;
            raiz = base;
        }else{
            buscarNodo(dato);
            if(encontrado){
                System.out.println("dato: "+dato+"  nodod: "+encontradoN.dato);
                System.out.println("datoizq: "+datoIzq +"datoder: "+datoDer);
                encontradoN.izq = nuevo;
                encontradoN.der = nuevo2;
            }
        }
       
        }
        
        public void setLetra(String letra, int valor){
            buscarNodo(valor);
            if(encontradoNL != null){
                encontradoNL.letra = letra;
                System.out.println("insertado");
            }
        }
    }
