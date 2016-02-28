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
 class Nodo {

        int dato;
        String letra = null;
        int frecuencia;
        Nodo izq = null, der = null;

        public boolean isLeaf() {
            return izq == null && der == null;
        }
    }