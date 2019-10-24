package mivisorpdf;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author leona
 */


import java.util.Arrays;
import java.util.Vector;




public class QuickSort 
{       Vector cambio;
	/* This function takes last element as pivot, 
	places the pivot element at its correct 
	position in sorted array, and places all 
	smaller (smaller than pivot) to left of 
	pivot and all greater elements to right 
	of pivot */
	int partition(Vector arr, int low, int high) 
	{ 
		String pivot = (String) cambio(arr,high).get(0); 
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{ 
			// If current element is smaller than the pivot 
			if (((String)cambio(arr,j).get(0)).compareToIgnoreCase(pivot)<0) 
			{ 
				i++; 

				// swap arr[i] and arr[j] 
				Object temp = cambio(arr,i); 
				arr.set(i,cambio(arr,j)); 
				arr.set(j,temp); 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		Object temp = (Object) cambio(arr,i+1); 
		arr.set(i+1, cambio(arr,high)); 
		arr.set(high, temp); 

		return i+1; 
	} 


	/* The main function that implements QuickSort() 
	arr[] --> Array to be sorted, 
	low --> Starting index, 
	high --> Ending index */
	void sort(Vector arr, int low, int high) 
	{ 
		if (low < high) 
		{ 
			/* pi is partitioning index, arr[pi] is 
			now at right place */
			int pi = partition(arr, low, high); 

			// Recursively sort elements before 
			// partition and after partition 
			sort(arr, low, pi-1); 
			sort(arr, pi+1, high); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(Vector arr) 
	{ 
		int n = arr.size(); 
		for (int i=0; i<n; ++i) 
			System.out.print(arr.get(i) +" "); 
		System.out.println(); 
	} 

	// Driver program 

    /**
     *
     * @param arr
     * @return
     */
	public Vector QuickSort(Vector arr ) 
	{       //Object[][] arr = new Object [4][1];
		
                /*arr[0][0]= "casa";
                arr[1][0]= "ardilla";
                arr[2][0]= "mesa";
                arr[3][0]= "dedo";*/
            
                int n = arr.size(); 
                /*System.out.println(arr);
                System.out.println(n);*/
		// ob = new QuickSort(); 
		sort(arr, 0, n-1); 

		System.out.println("sorted array"); 
		printArray(arr); 
                return arr;
	} 
        public Vector cambio(Vector arr,int i){
            cambio = new Vector();
            cambio = (Vector) arr.get(i);
            return cambio;
        }
        public Vector insertar(Vector cambio,Vector arr,int i){
            arr.set(i, cambio);
            return null;
        }
} 
