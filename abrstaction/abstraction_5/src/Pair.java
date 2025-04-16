public class Pair<K,V> {
    K key;
    V value;
    Pair(K k, V v){
       key = k;
       value = v;

    }
    public K getKey(){
        return this.key;
    }
    public V getValue(){
        return this.value;

    }

    @Override
    public String toString() {
        return
              "La chiave é: " + key +
                "\nIl valore é: " + value
                ;
    }
}
