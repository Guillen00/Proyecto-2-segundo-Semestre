
package mivisorpdf;

import java.util.Vector;

/**
 *
 * En esta clase se dearrollará el metodo BubbleSort para ordenar los valores de fechas de creación de la tabla de resultados 
 */
public class BubbleSort {
    Vector cambio;
    String Fecha;
    /**Función que inicializa toda la clase para el algoritmo de BubbleSort , compara si es mayor de dos en dos y cambia su posición si es así*/
    void bubbleSort(Vector arr) 
    { 
        int n = arr.size(); 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++){
                if ((convertir((String)cambio(arr,j).get(1)))>(convertir((String)(cambio(arr,j+1).get(1))))) 
                {
                    // swap arr[j+1] and arr[i]
                    Object temp = cambio(arr,j);
                    arr.set(j, cambio(arr,j+1));
                    arr.set(j+1, temp);
                } else {
                }} 
    } 
  
    /**Función que llama a todas las demás y retorna un Vector que trasporta las ocurrencias a la clase principal*/
    public  Vector Bubble(Vector arr) 
    { 
        bubbleSort(arr);
        return arr;
    } 
    /**Cambia del vector general a un vector que esta en su interior para poder acceder a cierta información en este caso la fecha */
    public Vector cambio(Vector arr,int i){
            cambio = new Vector();
            cambio = (Vector) arr.get(i);
            return cambio;
        }
    /**Convierte el string y le quita los espacios, guiones y punto y coma para convertir a int*/
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
    /** Misma funcion anterior pero ordenando de mayor a menor, Función que inicializa toda la clase para el algoritmo de BubbleSort , compara si es mayor de dos en dos y cambia su pisicion si es así*/
    void bubbleSort1(Vector arr) 
    { 
        int n = arr.size(); 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++){
                if ((convertir((String)cambio(arr,j).get(1)))<(convertir((String)(cambio(arr,j+1).get(1))))) 
                {
                    // swap arr[j+1] and arr[i]
                    Object temp = cambio(arr,j);
                    arr.set(j, cambio(arr,j+1));
                    arr.set(j+1, temp);
                } else {
                }} 
    } 
  /**Función que llama a todas las demás y retorna un Vector que trasporta las ocurrencias a la clase principal*/
    public  Vector Bubble1(Vector arr) 
    { 
        bubbleSort1(arr); 
        return arr;
    } 
} 