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
public class ListaEnlazada<T> {
    private ListaEnlazada.Nodo<T> cabeza;
    private int largo;

    public ListaEnlazada() {
    }

    public void InsertarInicio(T archivo) {
        ListaEnlazada.Nodo<T> nodo = new ListaEnlazada.Nodo(archivo);
        nodo.siguiente = this.cabeza;
        this.cabeza = nodo;
        ++this.largo;
    }

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

    public int getLargo() {
        return this.largo;
    }

    public void eliminarPrimero() {
        if (this.cabeza != null) {
            ListaEnlazada.Nodo<T> primer = this.cabeza;
            this.cabeza = this.cabeza.siguiente;
            primer.siguiente = null;
            --this.largo;
        }

    }

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

    public static class Nodo<T> {
        public ListaEnlazada.Nodo<T> siguiente = null;
        public T archivo;

        public Nodo(T archivo) {
            this.archivo = archivo;
        }
    }
}
