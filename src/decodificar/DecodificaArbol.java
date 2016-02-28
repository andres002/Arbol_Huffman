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

/**
 *
 * @author Andres
 */
public class DecodificaArbol {
    
    private File files;
    private Stage stage;
    
    static String[] datosL;
    
    ArbolB a;
    public void decodificador(){
        String reco = "";
        for(int x = 0; x < datos.length; x++){
            reco = datos[x];
        }
        System.out.println("reco "+reco);
        datosL= reco.split("11000001");
        
    }
  
    public void getArbol(){
        a = new ArbolB();
        a.leerCodificado(datosL[0]);
    }
    public ArbolB getReferenciaA(){
        return a;
    }
    
}
