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

/**
 *
 * @author Andres
 */
public class DecodificaArbol {
    
    private File files;
    private Stage stage;
    static String[] datos;
    static String[] datosL;
    
    public void leerDatos(){
        FileChooser fileCh = new FileChooser();
        fileCh.setTitle("Open");
        fileCh.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("txt", "*.txt")
        );
        files = fileCh.showOpenDialog(stage);
        if (files != null) {
            AllLines a = new AllLines(files.getPath());
            System.out.println("path--" + files.getPath());
            int lineas = a.getLines();
            System.out.println("lineas---" + lineas);
            datos = a.AllLines(lineas);
            //datosL = new String[2];

        }
    }
    
    
    public void decodificador(){
        String reco = "";
        for(int x = 0; x < datos.length; x++){
            reco = datos[x];
        }
        datosL= reco.split("11000001");
    }
    
}
