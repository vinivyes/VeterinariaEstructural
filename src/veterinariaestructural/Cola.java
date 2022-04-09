package veterinariaestructural;

public class Cola {
    
    private Nodo frente;
    private Nodo ultimo;

    public Nodo atiende(){

      Nodo aux = frente;

      if(frente != null){
          if(frente == ultimo){
              ultimo = null;
          }
          frente = frente.getAtras();
          aux.setAtras(null);
      }

      return aux;
    }

    public void encola(Nodo nuevoNodo){
        if(frente == null){
            frente = nuevoNodo;
            ultimo = nuevoNodo;
            return;
        }

        ultimo.setAtras(nuevoNodo);
        ultimo = nuevoNodo;
    }

    public Nodo getUltimo() {
      return ultimo;
    }
    public Nodo getFrente() {
      return frente;
    }

    public void setFrente(Nodo frente) {
      this.frente = frente;
    }
    public void setUltimo(Nodo ultimo) {
      this.ultimo = ultimo;
    }
}
