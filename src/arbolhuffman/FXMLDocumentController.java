/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhuffman;

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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Javier
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private File files;
    private Stage stage;
    
    @FXML TextArea tabF, tabL, tabLC, tabC, tabR;
    
    TFrecuencias tf = new TFrecuencias();
    
    
    @FXML
    public void archivo() throws IOException{
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
           TablaF(tf.getTabla());
           
        }
    }
    
    public void TablaF(String [] datos){
        for (int i=0; i< datos.length; i++) {
        String y[] = datos[i].split(":");
        String p1 = y[0];
        String p2 = y[1];
        System.out.println(p1);
        tabF.setText(tabF.getText()+p1+"\n");
        System.out.println(p2);
        tabL.setText(tabL.getText()+p2+"\n");
    }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Codificacion co = new Codificacion();
        co.setArbol();
    }    
    
}
