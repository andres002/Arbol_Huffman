/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhuffman;

import Arbol.ArbolB;
import Arbol.ArbolGrafico;
import decodificar.DecodificaArbol;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import leerArchivo.AllLines;

/**
 *
 * @author Javier
 */
public class FXMLDocumentController implements Initializable {

    public static String mensaje;
    public static String[] datos;
    public static String mensajeDecodi = "";
    @FXML
    private File files;
    private Stage stage;
    int[] frecuecias;
    @FXML
    TextArea tabF, tabL, tabLC, tabC, tabR, txtArbol, txtCo, mensajeArbol, tabLC2, tabC2;
    @FXML
    AnchorPane codificar, decodificar, inicio;
    TFrecuencias tf = new TFrecuencias();
    DecodificaArbol arD = new DecodificaArbol();
    Codificacion co = new Codificacion();
    private volatile boolean isThreadRunning = false;

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
            frecuecias = new int[tf.getTabla().length];
            TablaF(tf.getTabla());

        }

        co.setArbol(co.getRegistroReemplazo(frecuecias), tf.getTabla());
        txtArbol.setText(co.getArbol());
        txtCo.setText(co.getArbolCo());
        TablaR(co.getRetornoTR());
        setCod();

    }

    public void TablaR(String[] tabla) {
        for (int i = 0; i < tabla.length; i++) {
            tabR.setText(tabR.getText() + tabla[i] + "\n");
        }
    }

    @FXML
    public void guardar() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("huffman", "*.huffman")
        );
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            FileWriter fw = null;
            BufferedWriter bw = null;
            try {
					// EL segundo parametro es un boolean
                // En true escribe al final
                // En false escribe al inicio
                fw = new FileWriter(file, false);
                bw = new BufferedWriter(fw);

                String texto = txtCo.getText();
                bw.write(texto, 0, texto.length());
            } catch (Exception e) {
                txtCo.appendText(e.toString());
            } finally {
                try {
                    bw.close();
                } catch (Exception e2) {
                    txtCo.appendText(e2.toString());
                }
            }
        }

    }

    public void setCod() {
        String[] tCodificaciones = co.getCodificaciones();
        for (int i = 0; i < tCodificaciones.length; i++) {
            String[] aux = tCodificaciones[i].split(":");
            tabLC.setText(tabLC.getText() + aux[0] + "\n");
            tabC.setText(tabC.getText() + aux[1] + "\n");
        }
    }

    @FXML
    public void leerDatos() {
        FileChooser fileCh = new FileChooser();
        fileCh.setTitle("Open");
        fileCh.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("huffman", "*.huffman")
        );
        files = fileCh.showOpenDialog(stage);
        if (files != null) {
            AllLines a = new AllLines(files.getPath());
            System.out.println("path--" + files.getPath());
            int lineas = a.getLines();
            System.out.println("lineas---" + lineas);
            datos = a.AllLines(lineas);
            //datosL = new String[2];

            arD.decodificador();
            arD.getArbol();
            String[] tCodificaciones = arD.getCodificaciones();
            mensajeArbol.setText(mensajeDecodi);
            System.out.println("tCodificacioneeeeeeeees  " + tCodificaciones.length);
            for (int i = 0; i < tCodificaciones.length; i++) {
                System.out.println("i   " + i);
                String[] aux = tCodificaciones[i].split(":");
                tabLC2.setText(tabLC2.getText() + aux[0] + "\n");
                tabC2.setText(tabC2.getText() + aux[1] + "\n");
            }

        }

    }

    @FXML
    public void showArbol(ActionEvent ev) {
        createAndSetSwingContent(co.getReferenciaA());
    }

    @FXML
    public void showArbolD(ActionEvent ev) {

        createAndSetSwingContent(arD.getReferenciaA());
    }

    private void createAndSetSwingContent(ArbolB ar) {

        SwingUtilities.invokeLater(() -> {
            JFrame pane = new JFrame("Arbol de Huffman");
            pane.add(new ArbolGrafico(ar));
            pane.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //para terminar hilo
            pane.setSize(1350, 720);
            pane.setVisible(true);
        });

    }

    @FXML
    public void cod() {
        inicio.setVisible(false);
        decodificar.setVisible(false);
        codificar.setVisible(true);
    }

    @FXML
    public void decod() {
        inicio.setVisible(false);
        decodificar.setVisible(true);
        codificar.setVisible(false);
    }

    @FXML
    public void volver() {
        inicio.setVisible(true);
        decodificar.setVisible(false);
        codificar.setVisible(false);
        tabF.setText("");
        tabL.setText("");
        tabLC.setText("");
        tabC.setText("");
        tabR.setText("");
        txtArbol.setText("");
        txtCo.setText("");
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
