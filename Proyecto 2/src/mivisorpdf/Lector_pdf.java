/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mivisorpdf;

/**
 *
 * @author leona
 */

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import static mivisorpdf.Lector_txt1.data;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Lector_pdf {
    static final ListaEnlazada<BST> ListaArboles = new ListaEnlazada();
    static final BST ArbolPalabras = new BST();
    static int Palabras;
    public int numArchivo;
    public LocalDateTime Date;
    private File URL;
    public static String Texto;
    public String Nombre;
    static Scanner entrada = null;
    static String linea;
    static int numeroDeLinea = 1;
    static boolean contiene = false;
    static Scanner sc;
    private static FileNameExtensionFilter filtro;
    static Vector data;
    static String datos;

    static {
        sc = new Scanner(System.in);
    }

    public Lector_pdf() {
    }

    public Vector PDF (String ruta, String palabrabuscar)  {
        
        if (ruta.charAt(ruta.length() - 1) == 'f') {
            File f = new File(ruta);
            PDFTextStripper tStripper = null;
            try {
                tStripper = new PDFTextStripper();
            } catch (IOException ex) {
                Logger.getLogger(Lector_pdf.class.getName()).log(Level.SEVERE, null, ex);
            }
            tStripper.setStartPage(1);
            tStripper.setEndPage(3);
            PDDocument document = null;
            try {
                document = PDDocument.load(f);
            } catch (IOException ex) {
                Logger.getLogger(Lector_pdf.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print(f);
            document.getClass();
            if (!document.isEncrypted()) {
                String pdfFileInText = null;
                try {
                    pdfFileInText = tStripper.getText(document);
                } catch (IOException ex) {
                    Logger.getLogger(Lector_pdf.class.getName()).log(Level.SEVERE, null, ex);
                }
                String[] lines = pdfFileInText.split("\\r\\n\\r\\n");
                int inicio = 0;
                int a = 0;
                String[] var14 = lines;
                int var13 = lines.length;
                int var12 = 0;

                while(true) {
                    if (var12 >= var13) {
                        System.out.println("Texto obtenido del pdf: \n" + Texto);
                        ListaArboles.InsertarFinal(ArbolPalabras);
                        Palabras = a;
                        break;
                    }

                    String linea = var14[var12];
                    Texto = Texto + linea + "\n";
                    Texto = Texto.substring(4, linea.length());

                    int i;
                    for(i = 0; i < linea.length(); ++i) {
                        if (i == 0) {
                            if (linea.charAt(i) != ' ') {
                                inicio = i;
                                ++a;
                            }
                        } else if (linea.charAt(i - 1) == ' ' && linea.charAt(i) != ' ') {
                            ArbolPalabras.insert(limpiar(linea.substring(inicio, i)));
                            inicio = i;
                            ++a;
                        }
                    }

                    ArbolPalabras.insert(limpiar(linea.substring(inicio, i)));
                    inicio = 0;
                    ++var12;
                }
            }

            try {
                document.close();
            } catch (IOException ex) {
                Logger.getLogger(Lector_pdf.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return buscar(Texto,palabrabuscar);
    }

    private static Vector buscar(String doc,String texto) {
        data=new Vector();
        try {
            
            entrada = new Scanner(doc);
            System.out.println("Texto a buscar: " + texto);
            System.out.println("PDF buscador");
            for(; entrada.hasNext(); ++numeroDeLinea) {
                linea = entrada.nextLine();
                if (linea.contains(texto)) {
                    System.out.println("Linea " + numeroDeLinea + ": " + linea);
                    contiene = true;
                    data.add("Linea " + numeroDeLinea + ": " + linea);
                
                }
                ++numeroDeLinea;
            }

            if (!contiene) {
                System.out.println(texto + " no se ha encontrado en el archivo");
            }
        } catch (NullPointerException var6) {
            System.out.println(var6.toString() + "No ha seleccionado ningÃºn archivo");
        } catch (Exception var7) {
            System.out.println(var7.toString());
        } finally {
            if (entrada != null) {
                entrada.close();
            }

        }
        return data;
    }

    private void setDate() {
        this.Date = LocalDateTime.now();
    }

    public BST getArbolPalabras() {
        return ArbolPalabras;
    }

    public int getPalabras() {
        return Palabras;
    }

    public int getNumArchivo() {
        return this.numArchivo;
    }

    public File getURL() {
        return this.URL;
    }

    public String getTexto() {
        return Texto;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public static String limpiar(String s) {
        return s.replaceAll("[^a-zA-Z0-9]", "");
    }
}

