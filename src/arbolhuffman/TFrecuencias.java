package arbolhuffman;

import java.io.*;
import java.util.*;

/**
 *
 * @author Josseline
 */
public class TFrecuencias {

    String texto = "";
    String[] datos;
    public static int Numdatos;

    public void leerArchivo(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            cadena=cadena.toLowerCase();
            this.texto = cadena;
        }
        b.close();
    }

    public char[] getCadena() {
        return texto.toCharArray();
    }
    
       public void tablaF(char[] caracteres){
       ArrayList<String> tabla = new ArrayList<String>();
       int cont=0;
       char aux=0;
       for (int i=0;i<caracteres.length ;i++ ) {
        if (caracteres[i]!=0){
            aux=caracteres[i];
            for (int x=0;x<caracteres.length ;x++ ) {
                if(aux==caracteres[x]){
                    cont++;
                    caracteres[x]=0;
                }
            }
            tabla.add(cont+":"+aux);
            cont=0;
        }

    }

    Collections.sort(tabla);
    for (int z=0;z<tabla.size() ;z++ ) {
        datos= new String [tabla.size()];
        tabla.toArray(datos);

    }
    Numdatos = datos.length;
}

public String [] getTabla(){
    return datos;
}

public void calcula(String name) throws IOException{
    leerArchivo(name);
    tablaF(getCadena());
    for (int i=0; i< getTabla().length; i++) {
        System.out.println("["+getTabla()[i]+"]");
    }
}

    public static void main(String[] args) throws IOException {
        TFrecuencias ah = new TFrecuencias();
        Scanner x = new Scanner(System.in);
        System.out.print("\nIngrese el nombre de archivo: ");
        String name = x.next();
        ah.calcula(name);
    }
}
