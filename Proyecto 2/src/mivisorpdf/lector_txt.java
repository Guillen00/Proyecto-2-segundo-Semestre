/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mivisorpdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author leona
 */
public class lector_txt {
    
    public lector_txt(){}
    
    public String lector_txt(String ruta,String texto) {

        Scanner entrada = null;
        String linea;
        int numeroDeLinea = 1;
        boolean contiene = false;
        String listo;
        if (texto.length()== 0){ 
        System.out.println("No se encontro");}
        else{
            try {

                //creamos un objeto File asociado al fichero seleccionado
                File f = new File(ruta);
                //creamos un Scanner para leer el fichero
                entrada = new Scanner(f);
                //mostramos el texto a buscar
                System.out.println("Texto a buscar: " + texto);
                while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                    linea = entrada.nextLine();  //se lee una línea
                    if (linea.contains(texto)) {   //si la línea contiene el texto buscado se muestra por pantalla
                        System.out.println("Linea " + numeroDeLinea + ": " + linea);
                        listo =linea;
                        contiene = true;
                    }
                    numeroDeLinea++; //se incrementa el contador de líneas
                }
                if(!contiene){ //si el archivo no contienen el texto se muestra un mensaje indicándolo

                    System.out.println(texto + " no se ha encontrado en el archivo");
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.toString());
            } catch (NullPointerException e) {
                System.out.println(e.toString() + "No ha seleccionado ningún archivo");
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                if (entrada != null) {
                    entrada.close();
                }
            }
    }
        return "No se encontro";
     }
}
