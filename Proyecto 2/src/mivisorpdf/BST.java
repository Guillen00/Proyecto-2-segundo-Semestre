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
/**Creación de la raíz del arbol*/
public class BST {
    private BST.Nodo root = null;

    public BST() {
    }

    boolean isEmpty() {
    /**Devuelve la raíz como nulo*/
        return this.root == null;
    }

    public boolean contains(String e) {
        return this.containsAux(e.toLowerCase(), this.root);
    }
/**Compara dato con un nodo para ver si debe seguir por la izquierda o derecha de las ramas del árbol */
    private boolean containsAux(String e, BST.Nodo current) {
        if (current == null) {
            return false;
        } else {
            int cmp = e.compareTo(current.element);
            if (cmp < 0) {
                return this.containsAux(e, current.left);
            } else {
                return cmp > 0 ? this.containsAux(e, current.right) : true;
            }
        }
    }

    public BST.Nodo findMin() {
        return this.findMin(this.root);
    }
    /**Busca los extremos del árbol */
    private BST.Nodo findMin(BST.Nodo current) {
        if (current == null) {
            return null;
        } else {
            return current.left == null ? current : this.findMin(current.left);
        }
    }
    /**Inserta el nodo el una posición indicada*/
    public void insert(String e) {
        this.root = this.insertAux(e.toLowerCase(), this.root);
    }
    /**Función auxiliar de la función insertar compara si es por la derecha o izquierda */
    private BST.Nodo insertAux(String e, BST.Nodo current) {
        if (current == null) {
            return new BST.Nodo(e);
        } else {
            if (e.compareTo(current.element) < 0) {
                current.left = this.insertAux(e, current.left);
            } else if (e.compareTo(current.element) > 0) {
                current.right = this.insertAux(e, current.right);
            }

            return current;
        }
    }

    public void Eliminar(int n) {
    }
/** Clase nodo define los nodos */
    public static class Nodo {
        String element;
        BST.Nodo right;
        BST.Nodo left;
/**Define al nodo*/
        Nodo(String element) {
            this.element = element;
        }
/**Retorna el valor del elemento */
        public String getElement() {
            return this.element;
        }
    }
}