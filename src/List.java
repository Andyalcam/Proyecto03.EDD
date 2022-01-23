import java.util.Iterator;
/**
 * Clase que implementa la interfaz TDAList para crear listas simplemente ligadas.
 * @author Alfonso Mondragon Segoviano
 * @author Andrea Alvarado Camacho
 * @version 2.0
 */
public class List<T> implements TDAList<T>{

    private Node head;
    private int size;

    /**
     * Inserta un nuevo elemento <i>e</i> en la posición <i>i</i>.
     *
     * @param i la posición donde agregar el elemento.
     * @param e el elemento a insertar.
     * @throws IndexOutOfBoundException si el índice está fuera de rango.
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
        }else{//Cuando se agrega en cualquier otra posición
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
     * @throws IndexOutOfBoundException si el índice está fuera de rango.
     */
    @Override
    public T get(int i) throws IndexOutOfBoundsException {
        if( i < 0 || i > size){
            throw new IndexOutOfBoundsException();
        }else if(isEmpty()){
            return null;
        }else if(i == 0){
            return (T) head.getElement();
        }else{
            Node aux = head;
            for(int j = 0; j < i; j++){
                aux = aux.getNext();
            }
            return (T) aux.getElement();
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
     * Elimina el elemento en la posición <i>i</i>.
     *
     * @param e el elemento a eliminar.
     * @throws IndexOutOfBoundException si el índice está fuera de rango.
     */
    public void remove(T e) throws IndexOutOfBoundsException{
        Node aux = head;
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
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
     * @throws IndexOutOfBoundException si el índice está fuera de rango.
     */
    @Override
    public T remove(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i > size ){
            throw new IndexOutOfBoundsException();
        }
        T element;
        // Eliminar la cabeza
        if(i == 0){
            element = (T) head.getElement();
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
            element = (T) aux.getNext().getElement();
            aux.setNext(aux.getNext().getNext());

        }
        size--;
        return element;
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
    public class Node{

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
     * Método para imprimir la lista simplemente ligada.
     * @return String - con la cadena de elementos que contiene la lista y si es vacía, lo indica.
     */
    @Override
    public String toString() {
        if(!isEmpty()) {
            StringBuilder result = new StringBuilder();
            Node aux = head;
            while (aux != null) {
                result.append(aux.getElement()).append(" ");
                aux = aux.getNext();
            }
            return result.substring(0, result.length() - 1);
        }
        return "La lista es vacía";
    }
}