package mivisorpdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

/**
 * Clase Lector_docx que se encarga de la lectura y manejo de documentos .DOCX
 */

public class Lector_docx {
	
	
	/**
     * Variable en la que se guardan los Ã¡rboles creados de cada archivo
     */
    final static ListaEnlazada<BST> ListaArboles = new ListaEnlazada<>();
    /**
     * Variable que almacena las palabras del archivo en un Ã¡rbol binario
     */
    final static BST ArbolPalabras = new BST();
    /**
     * Variable que contiene el nÃºmero de palabras en el documento
     */
    static int Palabras;
    /**
     * Varibale que contiene el nÃºmero de archivo
     */
    public int numArchivo;
    /**
     * Variable que almacena la fecha en la que se agregÃ³ el documento a la biblioteca
     */
    public LocalDateTime Date;
    /**
     * Variable que almacena la ruta del archivo
     */
    private File URL;
    /**
     * Variable que almacena el texto del archivo
     */
    public static String Texto;
    /**
     * Variable para almacenar el nombre del archivo
     */
    public String Nombre;

    //esto es para el metodo buscar texto
    
    static Scanner entrada = null;
    /**
     * Variable para leer los datos
     */

    static String linea;
    /**
     * Variable para almacenar el texto
     */

    static int numeroDeLinea = 1;
    /**
     * Variable para identificar en que numero de linea esta la palabra o frase
     */

    static boolean contiene = false;
    /**
     * Variable para saber si una linea contiene el texto a buscar
     */

    static Scanner sc = new Scanner(System.in);
    /**
     * Variable para saber si una linea contiene el texto a buscar
     */

    static Vector data;
    /**
     * Variable para guardar información
     */
    static String datos;
    /**
     * @param
     * Variable para guardar información
     */
    private static FileNameExtensionFilter filtro;
    /**
     * 
     * Variable para asignar el debido filtro del tipio de documento a buscar
     */

	public  Vector docx(String ruta,String palabrabuscar) {
            File f = new File(ruta);
            
        try {
            //llamada a los metodos de leer docx y luego automaticamente al de busqueda
            readDocxFile(f);
        } catch (IOException ex) {
            Logger.getLogger(Lector_docx.class.getName()).log(Level.SEVERE, null, ex);
        }
            return buscar(Texto,palabrabuscar);

	}
	
	
	/**
     * MÃ©todo que lee el archivo *.docx
     * @param file Ruta del archivo
     * @throws IOException ExcepciÃ³n si el archivo no es correcto
     */
    private static void readDocxFile(File file) throws IOException {
 
    	System.out.println(file);
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        XWPFDocument document = new XWPFDocument(fis);
        System.out.println(document);
        XWPFWordExtractor doc = new XWPFWordExtractor(document);
        String documento = doc.getText();
        
        String[] lines = documento.split("\\r\\n\\r\\n");
        int i,inicio=0,a=0;
        for (String linea : lines) {
            Texto+=linea+"\n";
            Texto = Texto.substring(4, linea.length());
            
          
            for (i = 0; i < linea.length(); i++) {
                if (i == 0) {
                    if (linea.charAt(i) != ' ') {
                        inicio = i;
                        a++;
                    }
                } else {
                    if (linea.charAt(i - 1) == ' ') {
                        if (linea.charAt(i) != ' ') {
                            ArbolPalabras.insert(limpiar(linea.substring(inicio, i)));
                            inicio = i;
                            a++;
                        }
                    }
                }
            }
           
            System.out.println("Texto obtenido del pdf: "+"\n"+Texto);
            ArbolPalabras.insert(limpiar(linea.substring(inicio,i)));
            inicio = 0;
        }
        
        ListaArboles.InsertarFinal(ArbolPalabras);
        Palabras = a;
        document.close();

    }
    
    /**
     * Metodo que busca la palabra en el archivo *.docx
     * @param doc texto del documento elegido
     */

    private static Vector buscar(String doc,String texto) {
        data=new Vector();
    	try {
    	
            entrada = new Scanner(doc);
            //mostramos el nombre del fichero
           
            //mostramos el texto a buscar
            System.out.println("Texto a buscar: " + texto);
            while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                linea = entrada.nextLine();  //se lee una lÃ¬nea
                if (linea.contains(texto)) {   //si la lÃ¬nea contiene el texto buscado se muestra por pantalla
                    System.out.println("Linea " + numeroDeLinea + ": " + linea);
                    contiene = true;
                    data.add("Linea " + numeroDeLinea + ": " + linea);
                }
                numeroDeLinea++; //se incrementa el contador de lÃ¬neas
            }
            if(!contiene){ //si el archivo no contienen el texto se muestra un mensaje indicÃ¡ndolo

                System.out.println(texto + " no se ha encontrado en el archivo");
            }
        }  catch (NullPointerException e) {
            System.out.println(e.toString() + "No ha seleccionado ningÃºn archivo");
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    	return data;
    }
    
    
    /**
     * MÃ©todo para establecer la fecha de ingreso del documento a la biblioteca
     */
    private void setDate(){
        this.Date = LocalDateTime.now();
    }

    /**
     * MÃ©todo que retorna el Ã¡rbol binario del archivo deseado
     * @return Ãrbol binario del archivo
     */
    public BST getArbolPalabras() {
        return ArbolPalabras;
    }

    /**
     * MÃ©todo que retorna la cantidad de palabras en el documento
     * @return Cantidad de  palabras en el documento
     */
    public int getPalabras() {
        return Palabras;
    }

    /**
     * MÃ©todo que retorna el nÃºmero de archivo
     * @return Entero correspondiente al nÃºmero del archivo
     */
    public int getNumArchivo() {
        return numArchivo;
    }

    /**
     * MÃ©todo que retorna la ruta del archivo
     * @return Ruta del archivo deseado
     */
    public File getURL() {
        return URL;
    }

    /**
     * MÃ©todo que retorn el texto del archivo
     * @return Texto del archivo
     */
    public String getTexto() {
        return Texto;
    }

    /**
     * MÃ©todo que retorna el nombre del archivo
     * @return Nombre del archivo
     */
    public String getNombre() {
        return Nombre;
    }

public static String limpiar(String s){
    return s.replaceAll("[^a-zA-Z0-9]", "");
}

	

}
