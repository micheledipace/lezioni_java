package utils;
// inseriremo solo i metodi di una playlist, che potrà contenere oggetti differenti (e.g playlist di video, playlist di podcast, playlist di brani)
// utilizzeremo i generics
public interface PlayListInterface<T> {
    public void add (T t);

    public T remove(T t);

    public void play(); // programmazione sincrona : tutti gli step che eseguiamo non sono interrompibli. (la play dovrebbe essere asincrona)

    public void pause();

    public void skip();
}
