
package latiendita;

public class Nodo {
    private Producto dato;
    private Nodo ant;
    private Nodo sig;

    public Nodo(Producto dato) {
        this.dato = dato;
    }

    public Nodo(Producto dato, Nodo sig) {
        this.dato = dato;
        this.sig = sig;
    }

    public Producto getDato() {
        return dato;
    }

    public void setDato(Producto dato) {
        this.dato = dato;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    
    
}
