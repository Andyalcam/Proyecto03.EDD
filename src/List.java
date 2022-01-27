import java.io.Serializable;
import java.util.Iterator;
/**
 * Clase que implementa la interfaz TDAList para crear listas simplemente ligadas.
 * @author Alfonso Mondragon Segoviano
 * @author Andrea Alvarado Camacho
 * @version 2.1
 */
public class List<T> implements TDAList<T>, Serializable {

    private Node head;
    private int size;

    /**
     * Inserta un nuevo elemento <i>e</i> en la posición <i>i</i>.
     *
     * @param i la posición donde agregar el elemento.
     * @param e el elemento a insertar.
     * @throws IndexOutOfBoundsException si el índice está fuera de rango.
     */
    @Override
    public void add(int i, T e) throws IndexOutOfBoundsException {
        if(i < 0 || i > size){
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(e);

        if(head == null){//Si la lista es vacia
            head = newNode;
        }else if(i == 0){//Si se va agregar al inicio
            newNode.setNext(head);
            head = newNode;
        }else if(i == size) { //Cuando se agrega al final
            Node iterator = head;
            Node last = iterator;
            while (iterator!=null){
                last = iterator;
                iterator = iterator.getNext();
            }
            last.setNext(newNode);
        }else {//Cuando se agrega en cualquier otra posición
            Node iterator = head;
            for(int j = 0; j < i; j++){
                iterator = iterator.getNext();
            }
            newNode.setNext(iterator.getNext());
            iterator.setNext(newNode);
        }
        size++;
    }

    /**
     * Inserta un nuevo elemento <i>e</i> al final de la lista.
     *
     * @param e el elemento a insertar.
     */
    public void add(T e) {
        add(size,e);
    }

    /**
     * Inserta un nuevo elemento <i>e</i> en orden de mayor a menor.
     *
     * @param e el elemento a insertar.
     */
    public void addScore(T e){
        Node newNode = new Node(e);

        if(isEmpty()){
            head = newNode;
        }else{
            Node nodeAux = head;
            Node iterator = head;
            System.out.println();
            while (nodeAux != null) {
                if ((int) newNode.getElement() > (int) nodeAux.getElement()) {
                    if(nodeAux == head){
                        newNode.setNext(head);
                        head = newNode;
                        return;
                    }else{
                        while (iterator.getNext() != nodeAux) {
                            iterator = iterator.getNext();
                        }
                        newNode.setNext(iterator.getNext());
                        iterator.setNext(newNode);
                        return;
                    }
                }else if ((int) newNode.getElement() == (int) nodeAux.getElement()) {
                    if (nodeAux == head) {
                        newNode.setNext(head.getNext());
                        head.setNext(newNode);
                        return;
                    } else {
                        while (iterator.getNext() != nodeAux) {
                            iterator = iterator.getNext();
                        }
                        newNode.setNext(iterator.getNext());
                        iterator.setNext(newNode);
                        return;
                    }
                } else {
                    if(nodeAux.getNext() == null) {
                        nodeAux.setNext(newNode);
                        return;
                    }
                }
                nodeAux = nodeAux.getNext();
            }
        }
        size++;
    }

    /**
     * Limpia la lista. Elimina todos los elementos.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Verifica si un elemento está contenido en la lista.
     *
     * @param e el elemento a verificar si está contenido.
     * @return true si el elemento está contenid, false en otro caso.
     */
    @Override
    public boolean contains(T e) {
        Node aux = head;
        if(isEmpty()){
            return false;
        }

        for(int i = 0; i < size; i++){
            if(aux.getElement().equals(e)){
                return true;
            }
            aux = aux.getNext();
        }

        return false;
    }

    /**
     * Obtiene el elemento en la posición <i>i</i>.
     *
     * @param i el índice a obtener elemento.
     * @throws IndexOutOfBoundsException si el índice está fuera de rango.
     */
    @Override
    public T get(int i) throws IndexOutOfBoundsException {
        if( i < 0 || i > size){
            throw new IndexOutOfBoundsException();
        }else if(isEmpty()){
            return null;
        }else if(i == 0){
            return head.getElement();
        }else{
            Node aux = head;
            for(int j = 0; j < i; j++){
                aux = aux.getNext();
            }
            return aux.getElement();
        }
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista no contiene elementos, false en otro caso.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Elimina el elemento <i>e</i> de la lista.
     *
     * @param e el elemento a eliminar.
     * @throws NullPointerException si el elemento no se encuentra en la lista.
     */
    public void remove(T e) throws NullPointerException{
        Node aux = head;
        if(isEmpty()){
            throw new NullPointerException();
        }

        for(int i = 0; i < size; i++){
            if(aux.getElement().equals(e)){
                remove(i);
                return;
            }
            aux = aux.getNext();
        }
    }

    /**
     * Elimina el elemento en la posición <i>i</i>.
     *
     * @param i el índice del elemento a eliminar.
     * @return el elemento eliminado.
     * @throws IndexOutOfBoundsException si el índice está fuera de rango.
     */
    @Override
    public T remove(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i > size ){
            throw new IndexOutOfBoundsException();
        }
        T element;
        // Eliminar la cabeza
        if(i == 0){
            element = head.getElement();
            if(size == 1){
                head = null;
            }else{
                head = head.getNext();
            }
        }else{
            Node aux = head;
            for(int j = 0; j < i-1; j++){
                aux = aux.getNext();
            }
            element = aux.getNext().getElement();
            aux.setNext(aux.getNext().getNext());

        }
        size--;
        return element;
    }

    /**
     * Metodo que verifica si dos listas son iguales o no
     * @param lista - Lista con la que se va a comparar
     * @return boolean - true si son iguales, false en caso contrario
     */
    public boolean comparar(List<T> lista){
        if(size != lista.size()){
            return false;
        }
        for (int i = 0; i < size; i++) {
            if(!get(i).equals(lista.get(i))){
                return false;
            }

        }
        return true;
    }

    /**
     * Regresa la cantidad de elementos contenidos en la lista.
     *
     * @return la cantidad de elementos contenidos.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Revierte los elementos de la lista. Esto es, da la reversa de la lista.
     */
    @Override
    public void revert() {
    }

    /**
     * Da la mitad derecha o izquierda de una lista.
     *
     * @param side la mitad que recortar de la lista original.
     *             true - mitad derecha.
     *             false - mitad izquierda.
     * @return una nueva lista con la mitad de los elementos.
     */
    @Override
    public TDAList cut(boolean side) {
        return null;
    }

    /**
     * Da un iterador para la lista.
     *
     * @return un iterador para la estructura.
     */
    @Override
    public Iterator listIterador() {
        return null;
    }


    // Clase Node encargada de implementar la lista simplemente ligada.
    public class Node implements Serializable{

        T element;
        Node next;

        /**
         * Constructor para crear un nodo.
         * @param element - objeto de tipo generico.
         */
        public Node(T element) {
            this.element = element;
        }

        /**
         * Metodo para obtener el elemento del nodo.
         * @return T - objeto de tipo generico que representa el nodo.
         */
        public T getElement() {
            return element;
        }

        /**
         * Metodo que regresa el nodo siguiente respecto a uno.
         * @return Node - nodo siguiente.
         */
        public Node getNext() {
            return next;
        }

        /**
         * Metodo para asignarle a un nodo un nodo siguiente.
         * @param next - objeto de tipo nodo.
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }

    /**
     * Método para imprimir la lista simplemente ligada. Separada por espacios
     * @return String - con la cadena de elementos que contiene la lista y si es vacía, lo indica.
     */
    @Override
    public String toString() {
        if(!isEmpty()) {
            StringBuilder result = new StringBuilder();
            Node aux = head;
            while (aux != null) {
                result.append(aux.getElement()+"").append(" ");
                aux = aux.getNext();
            }
            return result.substring(0, result.length() - 1);
        }
        return "La lista es vacía";
    }

    /**
     * Método para imprimir la lista simplemente ligada. Separada por comas.
     * @return String - con la cadena de elementos que contiene la lista y si es vacía, lo indica.
     */
    public String toStringAux() {
        if(!isEmpty()) {
            StringBuilder result = new StringBuilder();
            Node aux = head;
            while (aux != null) {
                result.append(aux.getElement()+"").append(", ");
                aux = aux.getNext();
            }
            return result.substring(0, result.length() - 1);//String.valueOf(result);
        }
        return "La lista es vacía";
    }

    /**
     * Método para imprimir la lista simplemente ligada. Separada por enters
     * @return String - con la cadena de elementos que contiene la lista y si es vacía, lo indica.
     */
    public String toStringAuxx() {
        if(!isEmpty()) {
            StringBuilder result = new StringBuilder();
            Node aux = head;
            while (aux != null) {
                result.append(aux.getElement()+"").append("\n");
                aux = aux.getNext();
            }
            return result.substring(0, result.length() - 1);
        }
        return "La lista es vacía";
    }
}