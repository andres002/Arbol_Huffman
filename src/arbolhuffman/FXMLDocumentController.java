/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhuffman;

import decodificar.DecodificaArbol;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import leerArchivo.AllLines;

/**
 *
 * @author Javier
 */
public class FXMLDocumentController implements Initializable {
    public static String mensaje;
    public static String[] datos;
    @FXML
    private File files;
    private Stage stage;
    int[] frecuecias;
    @FXML TextArea tabF, tabL, tabLC, tabC, tabR,txtArbol,txtCo;
    @FXML AnchorPane codificar, decodificar, inicio;
    TFrecuencias tf = new TFrecuencias();
    

    @FXML
    public void archivo() throws IOException {
        tabF.setText("");
        tabL.setText("");
        FileChooser fileCh = new FileChooser();
        fileCh.setTitle("Open");
        fileCh.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("txt", "*.txt")
        );
        files = fileCh.showOpenDialog(stage);
        if (files != null) {
            tf.calcula(files.getPath());
           frecuecias = new int[ tf.getTabla().length];
            TablaF(tf.getTabla());

        }
        Codificacion co = new Codificacion();        
        co.setArbol(co.getRegistroReemplazo(frecuecias),tf.getTabla());
        txtArbol.setText(co.getArbol());
        txtCo.setText(co.getArbolCo());
        
    }

    @FXML
    public void leerDatos() {
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
            DecodificaArbol arD = new DecodificaArbol();
            arD.decodificador();
            arD.getArbol();
                    
        }

        
    }
    
    @FXML 
        public void cod(){
            inicio.setVisible(false);
            decodificar.setVisible(false);
            codificar.setVisible(true);
        }
        
        @FXML 
        public void decod(){
            inicio.setVisible(false);
            decodificar.setVisible(true);
            codificar.setVisible(false);
        }
        
        @FXML
        public void volver(){
            inicio.setVisible(true);
            decodificar.setVisible(false);
            codificar.setVisible(false);
            tabF.setText("");
            tabL.setText("");
            tabLC.setText("");
            tabC.setText("");
            tabR.setText("");
            txtArbol.setText("");
        }


    public void TablaF(String[] datos) {
        for (int i = 0; i < datos.length; i++) {
            String y[] = datos[i].split(":");
            String p1 = y[0]; //numero
            frecuecias[i] = Integer.parseInt(y[0]);
            String p2 = y[1]; //letra
            System.out.println(p1);
            tabF.setText(tabF.getText() + p1 + "\n");
            System.out.println(p2);
            tabL.setText(tabL.getText() + p2 + "\n");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
