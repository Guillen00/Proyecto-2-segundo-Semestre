
package mivisorpdf;

/**
 *
 * En esta clase se desarrollara el algoritmo de ordenamiento RadixSort para ordenar los datos por medio de los tamaños de los documentos
 */
import java.io.*; 
import java.util.*; 
  /**
     *
     * Clase principal que contiene las funciones importantes para este metodo
     */
public class Radix  { 
    static Vector cambio;
     static QuickSort ob; 
    /**
     *
     * Obtiene el valor máximo de los tamaños 
     */
    public static int getMax(Vector arr, int n) 
    {   
        int mx = (int) cambio(arr,0).get(2); 
        for (int i = 1; i < n; i++) 
            if ((int) cambio(arr,i).get(2) > mx) 
                mx = (int) cambio(arr,i).get(2); 
        return mx; 
    } 
  
    /**
     *
     * Comoda en una lista segundaria según el digito seleccionado y luego vuelve a acomodar en la lista original 
     */
    public static void countSort(Vector arr, int n, int exp) 
    { 
        Vector output[] = new Vector[n]; // output array 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (int i = 0; i < n; i++){ 
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
            arr.set(i,output[i]);
    } 
            
    }
  
    /**
     *
     * Metodo donde se llama a todos los metodos para que funcionen correctamente 
     */
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
  
  
    /**
     *
     * Clase que se llama desde la clase principal
     */
    public Vector radix (Vector arr) 
    { 
        int n = arr.size(); 
        radixsort(arr, n); 
        return arr;
    }
    public static Vector cambio(Vector arr,int i){
            cambio = new Vector();
            cambio = (Vector) arr.get(i);
            return cambio;
        }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *
     * Las siguientes funciones hacen lo mismo que el anterior pero de forma descendente 
     */
    public Vector radix1 (Vector arr) 
    { 
        int n = arr.size(); 
        radixsort1(arr, n);
        return arr;
    }
    public static int getMax1(Vector arr, int n) 
    {   
        int mx = (int) cambio(arr,0).get(2); 
        for (int i = 1; i < n; i++) 
            if ((int) cambio(arr,i).get(2) > mx) 
                mx = (int) cambio(arr,i).get(2); 
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