package SpotifyItems;

import utils.EmptyPlayListException;
import utils.PlayListInterface;

import java.util.EmptyStackException;

// dobbiamo pensare ad una struttura dati che si popola nel tempo
// creare i collegamenti
// ogni brano avrà collegamento a quello successivo
// stiamo realizzando una lista di elementi
// incapsuliamo i "nodi" o "capsule" della lista
// l'insieme di capsule può essere vista solo dalla classe PlayList
// esempio di linked list
public class PlayList<T> implements PlayListInterface<T> {
    private class Node<T> {
        private T data; //abbiamo il dato
        private Node<T> next; // riferimento all'elemento successivo (nodo successivo). puntatore ad un altro nodo

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public T getData() {
            return data;
        }
    }

    // attributi della playlist
    private int size;
    private Node<T> head; //primo nodo della linked list
    private Node<T> tail; //ultimo nodo della linked list
    private Node<T> current; // brano corrente

    public PlayList() {
        this.size = 0;
        this.head = null;
        this.tail = null; // tail non viene mai aggiornato??
        this.current = null;
    }

    // aggiunta di un elemento


     @Override
    public void add(T t) { // puó ricevere solamente PlayableItem e per un casting per estensione possiamo avere anche elementi eterogenei nella lista (hanno in comune la classe PlayableItem)

        Node<T> newNode = new Node<>(t);
        if (size == 0) {
            head = newNode;
        } else { //Per addFirst
            // newNode.setnext(head);
            //head = newNode;
            // addLast:
            tail.setNext(newNode);
        }

        tail = newNode;
        size++;
    }

    // per rimuovere un elemento bisogna prima trovarlo, sapendo che un nodo ha solo riferimento al suo successivo
    // fin tanto che non trovo l'elemento desiderato, scorro in avanti -> ciclo while
    // Analisi asintotica : O(size)
    // potremmo implementare anche un contains e separare il 'remove' dal 'linearSearch'
    /*@Override
    public T remove(T t) {
        if (size == 0) {
            return null;
        }
        Node<T> cursore = head;
        Node<T> prev = null;
        while (!cursore.getData().equals(t) && cursore.getNext() != null) { // non dovrebbe essere != ?? cambiato la logica da || a &&
            prev = cursore;
            cursore = cursore.getNext();

        }
        if (!cursore.getData().equals(t)) {
            return null;} // lanciare un'eccezione
        //eliminazione in testa (il primo elemento della lista é quello da eliminare)
        if (prev == null) {
            head = cursore.getNext();
        return cursore.getData(); //il return fa uscire dalla funzione.


        }
        if (cursore.getNext() == null) {
            tail = prev ;


        }
        prev.setNext(cursore.getNext());
        size--;
        return cursore.getData();
    }*/
    private int search(T t){
        Node <T> cursore = head;
        int count = 0;
        while (!cursore.getData().equals(t) && cursore.getNext() != null) { // non dovrebbe essere != ?? cambiato la logica da || a &&
            cursore = cursore.getNext();
            count++; // "funziona" come indice della lista
        }
        if (!cursore.getData().equals(t)){
            return -1; //elemento non presente
        }
        return count;
    }
    public T remove(T t) throws EmptyPlayListException{

        if (size == 0) {
            throw new EmptyPlayListException("Impossibile rimuovere il brano perché la playlist é vuota!"); //add Exception EmptyPlayList
        }
        int index = search(t); // la seconda versione del remove esegue prima il metodo 'search'.
        if (index == -1){
            return null;// lanciare eccezione ObjectNotFound
        }
        Node<T> cursore = head;
        Node<T> prev = null;
        while (index !=0) { // non dovrebbe essere != ?? cambiato la logica da || a &&
            prev = cursore;
            cursore = cursore.getNext();
            index --;

        }

        //eliminazione in testa (il primo elemento della lista é quello da eliminare)
        if (prev == null) {
            head = cursore.getNext();
            return cursore.getData(); //il return fa uscire dalla funzione.


        }
        if (cursore.getNext() == null) { // settare la nuova tail se l'eliminazione avviene in coda
            tail = prev ;


        }
        prev.setNext(cursore.getNext());
        size--;
        return cursore.getData();
    }

    // metodi per il comportamento vero e proprio della playlist
    @Override
    public void play() throws EmptyPlayListException {
    if (size==0){
        throw new EmptyPlayListException("Impossibile riprodurre un brano perché la playlist é vuota!"); //add Exception EmptyPlayList
    }
    if (current == null) {
        current = head;
    }
    System.out.println(current.getData());
    current = current.getNext();
    }

    @Override
    public void skip()  throws EmptyPlayListException {
    if (size==0){
        throw new EmptyPlayListException("Impossibile saltare un brano perché la playlist é vuota!"); //add Exception EmptyPlayList
    }
    if (current == null) {
            current = head;
        }
    current = current.getNext();

    }
    @Override
    public void pause(){

    }
}

