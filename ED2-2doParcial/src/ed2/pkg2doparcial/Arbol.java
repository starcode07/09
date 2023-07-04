package ed2.pkg2doparcial;

// Librerias utilizadas
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Arbol {

    //Atributo
    public Nodo raiz; // Este atributo representa la raíz del árbol

    //Constructor
    public Arbol() {
        this.raiz = null;
    }

    /**************************************************************************
                5 metodos de consulta sobre frecuencia de elementos
    **************************************************************************/
    
    /* Metodo que Insertar palabra al arbol */
    public void insertar(String palabra) {
        raiz = insertar(raiz, palabra);
    }

    private Nodo insertar(Nodo p, String palabra) {
        if (p == null) {
            return new Nodo(palabra);
        }
        // retorna -, si palabra < p.palabra;  0, si palabra = p.palabra; +, si palabra > p.palabra
        int comparacion = palabra.compareTo(p.palabra);
        
        if (comparacion < 0) {
            p.izq = insertar(p.izq, palabra);
        } else if (comparacion > 0) {
            p.der = insertar(p.der, palabra);
        } else {
            p.frecuencia++;
        }
        return p;
    }

    /* Metodo 1 - Mostrar las palabras de menor a mayor con sus respectivas frecuencias (InOrden)*/
    public void mostrarPalabrasConFrecuencias() {
        palabrasConFrec(raiz);
    }

    private void palabrasConFrec(Nodo p) {
        if (p == null) {
            return;
        }
        palabrasConFrec(p.izq);
        System.out.println(p.palabra + ": " + p.frecuencia);
        palabrasConFrec(p.der);
    }

    /* Metodo 2 - Mostrar las palabras de menor a mayor por longitud, con sus frecuencias*/
    public void mostrarPalabrasPorLongitud() {
        List<Nodo> palabrasFrecuencias = new ArrayList<>();
        
        obtenerPalabrasConFrecuencias(raiz, palabrasFrecuencias);
        
        palabrasFrecuencias.sort(Comparator.comparingInt((Nodo nodo) -> nodo.palabra.length()));
        for (Nodo nodo : palabrasFrecuencias) {
            System.out.println(nodo.palabra + ": " + nodo.frecuencia);
        }
    }

    private void obtenerPalabrasConFrecuencias(Nodo p, List<Nodo> palabrasFrecuencias) {
        if (p == null) {
            return;
        }
        obtenerPalabrasConFrecuencias(p.izq, palabrasFrecuencias);
        palabrasFrecuencias.add(p);
        obtenerPalabrasConFrecuencias(p.der, palabrasFrecuencias);
    }

    /* Metodo 3 - Mostrar Palabras que Comienzan con Vocal*/
    public void mostrarPalabrasComienzanConVocal() {
        mostrarPalabrasComienzanConVocal(raiz);
    }

    private void mostrarPalabrasComienzanConVocal(Nodo p) {
        if (p == null) {
            return;
        }
        mostrarPalabrasComienzanConVocal(p.izq);
        if (comienzaConVocal(p.palabra)) {
            System.out.println(p.palabra + ": " + p.frecuencia);
        }
        mostrarPalabrasComienzanConVocal(p.der);
    }
    private boolean comienzaConVocal(String palabra) {
        String vocales = "aeiou";
        char primerCaracter = Character.toLowerCase(palabra.charAt(0));
        return vocales.contains(String.valueOf(primerCaracter));
    }

    /* Metodo 4 - Mostrar palabras que son capicuas y su frecuencia*/
    public void mostrarPalabrasCapicuas() {
        mostrarPalabrasCapicuas(raiz);
    }

    private void mostrarPalabrasCapicuas(Nodo p) {
        if (p == null) {
            return;
        }
        mostrarPalabrasCapicuas(p.izq);
        if (esCapicua(p.palabra)) {
            System.out.println(p.palabra + ": " + p.frecuencia);
        }
        mostrarPalabrasCapicuas(p.der);
    }

    private boolean esCapicua(String palabra) {
        int longitud = palabra.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(longitud - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /* Metodo 5 - Método que obtiene la palabra con más frecuencia en el árbol*/
    public String obtenerPalabraMasFrecuente() {
        Nodo nodo = obtenerNodoMasFrecuente(raiz);
        if (nodo != null) {
            return nodo.palabra;
        }
        return null;
    }

    private Nodo obtenerNodoMasFrecuente(Nodo p) {
        if (p == null) {
            return null;
        }
        Nodo nodoIzq = obtenerNodoMasFrecuente(p.izq);
        Nodo nodoDer = obtenerNodoMasFrecuente(p.der);
        Nodo nodoMax = p;
        
        if (nodoIzq != null && nodoIzq.frecuencia > nodoMax.frecuencia) {
            nodoMax = nodoIzq;
        }
        if (nodoDer != null && nodoDer.frecuencia > nodoMax.frecuencia) {
            nodoMax = nodoDer;
        }
        return nodoMax;
    }
}
