package mivisorpdf;
/*
 * 
 */


/**
 *
 * En esta clase se realiza el algoritmo de QickSort para ordenar datos con letras 
 */


import java.util.Arrays;
import java.util.Vector;



  /**
 *
 *  Clase principal dponde contiene a todas las demas funciones importantes de la clase 
 */
public class QuickSort 
{       Vector cambio;
	  /**
 *
 *  Esta recibe como parametros la lista y dos indices dode agarra un pivot para compararlo con todos los datos e ir ordenando intercambiando datos en el vector principal
 */
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
     * En esta función se recibe un vector que sera el que se utilizará en todo el proceso de ordenamiento, llama al sort para que inicie el ordenamiento  
     */
	public Vector QuickSort(Vector arr ) 
	{       
            
                int n = arr.size(); 
		sort(arr, 0, n-1); 

		System.out.println("sorted array"); 
                return arr;
	} 
        /**Cambia del vector general a un vector que esta en su interior para poder acceder a cierta información en este caso la fecha */
        public Vector cambio(Vector arr,int i){
            cambio = new Vector();
            cambio = (Vector) arr.get(i);
            return cambio;
        }
        /**
     *
     * Se reciben dos vectores y un indice , introduciendo un vector en la pocicion del indice dentro del otro 
     */
        public Vector insertar(Vector cambio,Vector arr,int i){
            arr.set(i, cambio);
            return null;
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        /**
     *
     * Las siguientes funciones hacen lo mismo que el anterior pero de forma descendente 
     */
        public Vector QuickSort1(Vector arr ) 
	{       
                int n = arr.size();
		sort1(arr, 0, n-1); 
                return arr;
	} 
        int partition1(Vector arr, int low, int high) 
	{ 
		String pivot = (String) cambio(arr,high).get(0); 
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{ 
			// If current element is smaller than the pivot 
			if (((String)cambio(arr,j).get(0)).compareToIgnoreCase(pivot)>0) 
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
	void sort1(Vector arr, int low, int high) 
	{ 
		if (low < high) 
		{ 
			/* pi is partitioning index, arr[pi] is 
			now at right place */
			int pi = partition1(arr, low, high); 

			// Recursively sort elements before 
			// partition and after partition 
			sort1(arr, low, pi-1); 
			sort1(arr, pi+1, high); 
		} 
	} 
} 
