package veterinariaestructural;

public class Nodo<T> {
  
    private Nodo<T> abajo;
    private Nodo<T> atras;
    
    private Nodo next;
    private Nodo previous;

    public Nodo(T _elemento){
        elemento = _elemento;
    }
    
    private T elemento;

    public Nodo<T> getAbajo() {
        return abajo;
    }

    public void setAbajo(Nodo<T> abajo) {
        this.abajo = abajo;
    }

    public Nodo<T> getAtras() {
        return atras;
    }

    public void setAtras(Nodo<T> atras) {
        this.atras = atras;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getPrevious() {
        return previous;
    }

    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }
}
