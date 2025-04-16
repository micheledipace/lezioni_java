package SpotifyItems;

import utils.PlayListInterface;
// dobbiamo pensare ad una struttura dati che si popola nel tempo
// creare i collegamenti
// ogni brano avrà collegamento a quello successivo
// stiamo realizzando una lista di elementi
// incapsuliamo i "nodi" o "capsule" della lista
// l'insieme di capsule può essere vista solo dalla classe PlayList
public class PlayList<T> implements PlayListInterface<T> {
    private class Node<T> {
        private T data; //abbiamo il dato
        private Node<T> next; // riferimento all'elemento successivo

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
    private Node<T> head;
    private Node<T> tail;
    public Playlist(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    // aggiunta di un elemento


    @Override
    public void add(T t) {

        Node<T> newNode = new Node<>(t);
        if (size == 0){
            head=newNode;
        }
        tail.setNext(newNode);
        size++;
    }

    // per rimuovere un elemento bisogna prima trovarlo, sapendo che un nodo ha solo riferimento al suo successivo
    // fin tanto che non trovo l'elemento desiderato, scorro in avanti -> ciclo while
    @Override
    public T remove(T t) {
        Node<T> cursore = head;
        Node<T> prev = null;
        while(!cursore.getData().equals(t) || cursore.getNext() != null ) { // non dovrebbe essere != ??
            prev = cursore;
            cursore = cursore.getNext();

        }
        // if cursore.getNext() == null -> Exception
        prev.setNext(cursore.getNext());
        size--;
        return cursore.getData();
    }
}
