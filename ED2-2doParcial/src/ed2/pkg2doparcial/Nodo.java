package ed2.pkg2doparcial;

public class Nodo {
    // Atributos
    public Nodo izq;
    public Nodo der;
    public int elemento;
    public String palabra;
    public int frecuencia;

    // Constructor
    public Nodo(int elemento) {
        this.izq = null;
        this.der = null;
        this.elemento = elemento;
    }
    
    public Nodo(String palabra) {
        this.izq = null;
        this.der = null;
        this.palabra = palabra;
        this.frecuencia = 1;
    }
}
