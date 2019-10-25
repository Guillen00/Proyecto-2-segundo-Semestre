/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mivisorpdf;

import java.util.Vector;

/**
 *
 * @author leona
 */
// Java program for implementation of Bubble Sort 
public class BubbleSort {
    Vector cambio;
    String Fecha;
    void bubbleSort(Vector arr) 
    { 
        int n = arr.size(); 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++){
                //System.out.print(convertir((Vector)cambio(arr,j).get(1)));
                if ((convertir((String)cambio(arr,j).get(1)))>(convertir((String)(cambio(arr,j+1).get(1))))) 
                {
                    // swap arr[j+1] and arr[i]
                    Object temp = cambio(arr,j);
                    arr.set(j, cambio(arr,j+1));
                    arr.set(j+1, temp);
                } else {
                }} 
    } 
  
    /* Prints the array */
    /*void printArray(Vector arr) 
    { 
        int n = arr.size(); 
        for (int i=0; i<n; ++i) 
            System.out.print(arr.get(i) + " "); 
        System.out.println(); 
    } */
  
    // Driver method to test above 
    public  Vector Bubble(Vector arr) 
    { 
        //int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
        bubbleSort(arr); 
        //System.out.println("Sorted array"); 
        //printArray(arr); 
        return arr;
    } 
    public Vector cambio(Vector arr,int i){
            cambio = new Vector();
            cambio = (Vector) arr.get(i);
            return cambio;
        }
    public int convertir (String cambio){
        Fecha = (String)cambio;
        String uno = Fecha.replace(" ", "");
        String dos = uno.replace("-", "");
        String tres = dos.replace(":", "");
        
        int numEntero = Integer.parseInt(tres);
        //System.out.println(numEntero+"  fecha int "); 
        return numEntero;
    
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    void bubbleSort1(Vector arr) 
    { 
        int n = arr.size(); 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++){
                //System.out.print(convertir((Vector)cambio(arr,j).get(1)));
                if ((convertir((String)cambio(arr,j).get(1)))<(convertir((String)(cambio(arr,j+1).get(1))))) 
                {
                    // swap arr[j+1] and arr[i]
                    Object temp = cambio(arr,j);
                    arr.set(j, cambio(arr,j+1));
                    arr.set(j+1, temp);
                } else {
                }} 
    } 
  
    public  Vector Bubble1(Vector arr) 
    { 
        //int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
        bubbleSort1(arr); 
        //System.out.println("Sorted array"); 
        //printArray(arr); 
        return arr;
    } 
} 