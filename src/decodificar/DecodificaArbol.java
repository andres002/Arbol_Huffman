/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decodificar;
import Arbol.ArbolB;
import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import leerArchivo.AllLines;
import static arbolhuffman.FXMLDocumentController.datos;
import static arbolhuffman.FXMLDocumentController.mensajeDecodi;

/**
 *
 * @author Andres
 */
public class DecodificaArbol {
    
    private File files;
    private Stage stage;
    
    public static String[] datosL;
    
    ArbolB a = new ArbolB();;
    public void decodificador(){
        String reco = "";
        for(int x = 0; x < datos.length; x++){
            reco = datos[x];
        }
        System.out.println("reco "+reco);
        datosL = new String[2];
        datosL[0] = reco;
   /*   //    datosL= reco.split("11000001");
        String[] aux = new String[2];
       
       datosL = aux;
        System.out.println("Length"+datosL[0]);*/
        
    }
   
    public String get(){
       return  a.getArbol();
    }

    public void getArbol(){
        a.leerCodificado(datosL[0]);
       mensajeDecodi = a.mensaje();
       a.recorrer();
    }
    
    public String[] getCodificaciones(){
        return a.getCodificaciones();
    }
    
    public ArbolB getReferenciaA(){
        return a;
    }
    
}
