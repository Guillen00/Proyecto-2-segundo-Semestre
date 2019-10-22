/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pueba.pkg2.pkg0;

/**
 *
 * @author leona
 */


import java.util.Arrays;
import java.util.Random;
import static pueba.pkg2.pkg0.Quicksortpalabras.vector;



class QuickSort 
{ 
	/* This function takes last element as pivot, 
	places the pivot element at its correct 
	position in sorted array, and places all 
	smaller (smaller than pivot) to left of 
	pivot and all greater elements to right 
	of pivot */
	int partition(String arr[], int low, int high) 
	{ 
		String pivot = arr[high]; 
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{ 
			// If current element is smaller than the pivot 
			if (arr[j].compareToIgnoreCase(pivot)<0) 
			{ 
				i++; 

				// swap arr[i] and arr[j] 
				String temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		String temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 

		return i+1; 
	} 


	/* The main function that implements QuickSort() 
	arr[] --> Array to be sorted, 
	low --> Starting index, 
	high --> Ending index */
	void sort(String arr[], int low, int high) 
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
	static void printArray(String arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	// Driver program 
	public static void main(String args[]) 
	{ 
		String arr[] = {"casa", "hotel", "ardilla","Zorro","xilofono"}; 
		int n = arr.length; 

		QuickSort ob = new QuickSort(); 
		ob.sort(arr, 0, n-1); 

		System.out.println("sorted array"); 
		printArray(arr); 
	} 
} 
