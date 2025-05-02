package utils;
// viene aggiunta alle possibili eccezioni del mio sistema
public class EmptyPlayListException extends Exception {
    public EmptyPlayListException(String message) {
        super(message);
    }
}
