/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decodificar;
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
    
    
    public void decodificador(){
        String reco = "";
        for(int x = 0; x < datos.length; x++){
            reco = datos[x];
        }
        datosL= reco.split("11000001");
    }
    
}
