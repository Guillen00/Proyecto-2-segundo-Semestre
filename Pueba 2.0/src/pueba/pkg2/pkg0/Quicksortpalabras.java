/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pueba.pkg2.pkg0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author leona
 */
public class Quicksortpalabras {
    static String vector[];
    public Quicksortpalabras(){}
    
    public static void  main (String [] args){
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
        int contador =0;
        String [] vector= new String [6];
        Radix(vector);
        while (contador !=6){
            System.out.print("Ingrese una palabra ");
            vector [contador]= in.readLine();
                contador ++;}
        ordenar();
        mostrar();
            }catch (Exception e){}}
    
    
    public static void Radix(String vector[]){
        Quicksortpalabras.vector = vector;
    }
    public static void ordenar(){
    for(int i=0;i<vector.length;i++){
        for(int j=0;j<vector.length && i !=j;j++){
            if(vector[i].compareToIgnoreCase(vector[j])<0){
                String aux = vector[i];
                vector[i] = vector[j];
                vector [j] =aux;
            }
                }
    }
    
    }
    public static void mostrar(){
        for(String a :vector){
            System.out.println(a);
        }
    }
}
