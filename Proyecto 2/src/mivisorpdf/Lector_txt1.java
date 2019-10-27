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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Lector_txt1 {
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

    public Lector_txt1() {
    }

    public Vector txt(String ruta,String palabrabuscar) {
        File f = new File(ruta);
        readTXTFile(f);
        return buscar(Texto,palabrabuscar);
        
    }

    private static void readTXTFile(File F) {
        try {
            FileReader fr = new FileReader(F);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            int a = 0;

            String linea;
            for(int inicio = 0; (linea = br.readLine()) != null; inicio = 0) {
                
                if (a == 0) {
                    Texto = Texto + linea + "\n";
                    Texto = Texto.substring(4, linea.length());

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
                } else {
                    Texto = Texto + linea + "\n";

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
                }

                ArbolPalabras.insert(limpiar(linea.substring(inicio, i)));
            }

            ListaArboles.InsertarFinal(ArbolPalabras);
            Palabras = a;
            fr.close();
        } catch (IOException var7) {
        }

    }

    private static Vector buscar(String doc,String texto) {
        data=new Vector();
        try {
            entrada = new Scanner(doc);
            System.out.println("Texto a buscar: " + texto);
            System.out.println("Txt buscador");
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
        System.out.println("data " + data);
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
