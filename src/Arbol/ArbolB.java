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
        String letra;
        int frecuencia;
        Nodo izq, der;

        public boolean isLeaf() {
            return izq == null && der == null;
        }
    }
    Nodo raiz;
    boolean encontrado = false;
    Nodo encontradoN;

    public ArbolB() {
        raiz = null;
    }
      private void buscarNodo (Nodo reco,int dato){
      if (reco != null) {
        if(reco.dato == dato && reco.isLeaf() && !encontrado){
            encontrado = true;
            encontradoN = reco;
            
        }
            
        buscarNodo(reco.izq,dato);
        buscarNodo (reco.der,dato);
        
      }
    }

    public void buscarNodo (int dato){
      encontrado = false;
      encontradoN = null;
      buscarNodo (raiz,dato);
    }

     private void preOrder (Nodo reco){
      if (reco != null)
      { 
        System.out.println(reco.dato);
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
            if(encontrado && encontradoN != null){
                System.out.println("dato: "+dato+"  nodod: "+encontradoN.dato);
                System.out.println("datoizq: "+datoIzq +"datoder: "+datoDer);
                encontradoN.izq = nuevo;
                encontradoN.der = nuevo2;
            }
        }
       
        }
    }
