
package mivisorpdf;

/**
 *
 * En la clase Lista Enlazada , como su nombre lo insinua se van creando nodos que irán conectados en un orden especíico
 */
public class ListaEnlazada<T> {
    private ListaEnlazada.Nodo<T> cabeza;
    private int largo;

    public ListaEnlazada() {
    }
/**
 *
 * Se inserta información y nodo a la cabeza o sea el último dato
 */
    public void InsertarInicio(T archivo) {
        ListaEnlazada.Nodo<T> nodo = new ListaEnlazada.Nodo(archivo);
        nodo.siguiente = this.cabeza;
        this.cabeza = nodo;
        ++this.largo;
    }
/**
 *
 * Se envia el nodo al final de la lista enlazada 
 */
    public void InsertarFinal(T archivo) {
        ListaEnlazada.Nodo<T> nodo = new ListaEnlazada.Nodo(archivo);
        if (this.cabeza == null) {
            this.InsertarInicio(archivo);
        } else {
            ListaEnlazada.Nodo puntero;
            for(puntero = this.cabeza; puntero.siguiente != null; puntero = puntero.siguiente) {
            }

            puntero.siguiente = nodo;
            ++this.largo;
        }

    }
/**
 *
 * Inserta el Nodo evisando que este exista y que el último valor no sea nulo
 */
    public void Insertar(int indice, T archivo) {
        ListaEnlazada.Nodo<T> nodo = new ListaEnlazada.Nodo(archivo);
        if (this.cabeza != null && indice != 0) {
            ListaEnlazada.Nodo<T> puntero = this.cabeza;

            for(int contador = 0; contador < indice && puntero.siguiente != null; ++contador) {
                puntero = puntero.siguiente;
            }

            nodo.siguiente = puntero.siguiente;
            puntero.siguiente = nodo;
            ++this.largo;
        } else {
            this.InsertarInicio(archivo);
        }

    }
/**
 *
 * Obtiene un indice de la Lista Enlazada, recorre con el for todo la lista hasta encontar que sean nulos
 */
    public T Obtener(int indice) {
        if (this.cabeza == null) {
            return null;
        } else {
            ListaEnlazada.Nodo<T> puntero = this.cabeza;

            int contador;
            for(contador = 0; contador < indice && puntero.siguiente != null; ++contador) {
                puntero = puntero.siguiente;
            }

            return contador != indice ? null : puntero.archivo;
        }
    }
/**
 *
 * Obtiene el largo de la lista
 */
    public int getLargo() {
        return this.largo;
    }
/**
 *
 * Elimina el primer datos que estaba a la cabeza de la lista 
 */
    public void eliminarPrimero() {
        if (this.cabeza != null) {
            ListaEnlazada.Nodo<T> primer = this.cabeza;
            this.cabeza = this.cabeza.siguiente;
            primer.siguiente = null;
            --this.largo;
        }

    }
/**
 *
 * Confirma si en el nodo cabeza esta solo para borrar o tiene algo más lo recorre hasta encontrar que sea nulo 
 */
    public void eliminarUltimo() {
        if (this.cabeza != null) {
            if (this.cabeza.siguiente == null) {
                this.cabeza = null;
            } else {
                ListaEnlazada.Nodo puntero;
                for(puntero = this.cabeza; puntero.siguiente.siguiente != null; puntero = puntero.siguiente) {
                }

                puntero.siguiente = null;
                --this.largo;
            }
        }

    }
/**
 *
 * Elimina datos si el indice de la lista es cero elimina el primero sino iguala el nodo puntero con la cabeza 
 */
    public void eliminar(int indice) {
        if (this.cabeza != null) {
            if (indice == 0) {
                this.eliminarPrimero();
            } else if (indice < this.largo) {
                ListaEnlazada.Nodo<T> puntero = this.cabeza;

                for(int contador = 0; contador < indice - 1; ++contador) {
                    puntero = puntero.siguiente;
                }

                ListaEnlazada.Nodo<T> temp = puntero.siguiente;
                puntero.siguiente = temp.siguiente;
                temp.siguiente = null;
                --this.largo;
            }
        }

    }
/**
 *
 * Declara el valor del nodo siguiente y de la variable archivo 
 */
    public static class Nodo<T> {
        public ListaEnlazada.Nodo<T> siguiente = null;
        public T archivo;

        public Nodo(T archivo) {
            this.archivo = archivo;
        }
    }
}
