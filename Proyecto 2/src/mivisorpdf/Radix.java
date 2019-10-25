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
import java.io.*; 
import java.util.*; 
  
public class Radix  { 
    static Vector cambio;
     static QuickSort ob; 
    // A utility function to get maximum value in arr[] 
    public static int getMax(Vector arr, int n) 
    {   
        int mx = (int) cambio(arr,0).get(2); 
        for (int i = 1; i < n; i++) 
            if ((int) cambio(arr,i).get(2) > mx) 
                mx = (int) cambio(arr,i).get(2); 
        //System.out.println(mx +"   mayor");
        return mx; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    public static void countSort(Vector arr, int n, int exp) 
    { 
        Vector output[] = new Vector[n]; // output array 
        //int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (int i = 0; i < n; i++){ 
            //arr.set(((int)cambio(arr,i).get(2)/exp)%10, cambio(arr,i));
            count[ ((int) cambio(arr,i).get(2)/exp)%10 ]++; 
        }
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (int i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (int i = n - 1; i >= 0; i--) 
        { 
            output[count[ ((int) cambio(arr,i).get(2)/exp)%10 ] - 1] = cambio(arr,i); 
            count[ ((int) cambio(arr,i).get(2)/exp)%10 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (int i = 0; i < n; i++) {
            //System.out.println(output[i] + "  primero  1");
            arr.set(i,output[i]);
    } 
            
    }
  
    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    public static void radixsort(Vector arr, int n) 
    { 
        // Find the maximum number to know number of digits 
        int m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
  
    // A utility function to print an array 
    /*public static void print(Vector arr, int n) 
    { 
        for (int i=0; i<n; i++) 
            System.out.print(arr.get(i)+" "); 
    } 

    public Radix() {
        
    }
  
  
    /*Driver function to check for above function*/
    public Vector radix (Vector arr) 
    { 
        //int arr[] = {170, 45, 75, 90, 802, 24, 2, 66,1000,372732276}; 
        int n = arr.size(); 
        radixsort(arr, n); 
        //print(arr, n); 
        return arr;
    }
    public static Vector cambio(Vector arr,int i){
            cambio = new Vector();
            cambio = (Vector) arr.get(i);
            return cambio;
        }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Vector radix1 (Vector arr) 
    { 
        //int arr[] = {170, 45, 75, 90, 802, 24, 2, 66,1000,372732276}; 
        int n = arr.size(); 
        radixsort1(arr, n); 
        //print(arr, n); 
        return arr;
    }
    public static int getMax1(Vector arr, int n) 
    {   
        int mx = (int) cambio(arr,0).get(2); 
        for (int i = 1; i < n; i++) 
            if ((int) cambio(arr,i).get(2) > mx) 
                mx = (int) cambio(arr,i).get(2); 
        //System.out.println(mx +"   mayor");
        return mx; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    public static void countSort1(Vector arr, int n, int exp) 
    { 
        Vector output[] = new Vector[n]; // output array 
        //int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (int i = 0; i < n; i++){ 
            //arr.set(((int)cambio(arr,i).get(2)/exp)%10, cambio(arr,i));
            count[ ((int) cambio(arr,i).get(2)/exp)%10 ]++; 
        }
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (int i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (int i = 0; i >n; i++) 
        { 
            output[count[ ((int) cambio(arr,i).get(2)/exp)%10 ] - 1] = cambio(arr,i); 
            count[ ((int) cambio(arr,i).get(2)/exp)%10 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (int i = 0; i < n; i++) {
            //System.out.println(output[i] + "  primero  1");
            arr.set((n-1)-i,output[i]);
    } 
            
    }
  
    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    public static void radixsort1(Vector arr, int n) 
    { 
        // Find the maximum number to know number of digits 
        int m = getMax1(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort1(arr, n, exp); 
    } 
} 