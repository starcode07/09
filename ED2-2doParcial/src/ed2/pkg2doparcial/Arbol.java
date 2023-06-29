package ed2.pkg2doparcial;

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

    // Metodo A1.insertar(x) : Método que inserta el elemento en el árbol
    public void insertar(int elem) {
        raiz = insertar(raiz, elem);
    }

    public Nodo insertar(Nodo p, int elem) {

        if (p == null) {
            p = new Nodo(elem);
            return p;
        }
        if (elem < p.elemento) {
            p.izq = insertar(p.izq, elem);
        } else {
            p.der = insertar(p.der, elem);
        }
        return p;
    }

    /***************************************************************************
             5 metodos de consulta sobre elementos de un ABB
     *************************************************************************/

    /* Metodo 1 - Metodo que muestra los elementos de la izq, la raiz y los elem de la derecha*/
    public void inOrden() {
        realizarInOrden(raiz);
    }

    private void realizarInOrden(Nodo p) {
        if (p == null) {
            return;
        }
        realizarInOrden(p.izq);
        System.out.println(p.elemento);
        realizarInOrden(p.der);
    }

    /* Metodo 2 - Métodos lógico que devuelve True, si el elemento se encuentra en el árbol*/
    public boolean seEncuentra(int x) {
        return seEncuentra(raiz, x);
    }

    private boolean seEncuentra(Nodo p, int x) {
        if (p == null) {
            return false;
        }
        if (x == p.elemento) {
            return true;
        } else if (x < p.elemento) {
            return seEncuentra(p.izq, x);
        } else {
            return seEncuentra(p.der, x);
        }
    }

    /* Metodo 3 - Método que muestra los elementos y el nivel donde se encuentra*/
    public void mostrarNivel() {
        mostrarNivel(raiz, 1);
    }

    public void mostrarNivel(Nodo p, int nivel) {
        if (p == null) {
            return;
        }
        mostrarNivel(p.izq, nivel + 1);
        System.out.println(p.elemento + " " + nivel);
        mostrarNivel(p.der, nivel + 1);
    }

    /* Metodo 4 - Método que devuelve la cantidad de nodos del árbol*/
    public int cantidad() {
        return cantidad(raiz);
    }

    private int cantidad(Nodo p) {
        if (p == null) {
            return 0;
        }
        return 1 + cantidad(p.izq) + cantidad(p.der);
    }

    /* Metodo 5 - Metodo que devuelve la cantidad de nodos con un solo hijo*/
    public int cantidadNodosConSoloUnHijo() {
        return contarNodosUnicoHijo(raiz);
    }

    public int contarNodosUnicoHijo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int contador = 0;
        if ((nodo.izq != null && nodo.der == null) || (nodo.izq == null && nodo.der != null)) {
            contador++;
        }
        contador += contarNodosUnicoHijo(nodo.izq);
        contador += contarNodosUnicoHijo(nodo.der);
        return contador;
    }

    /* Metodo 6 - Metodo que devuelve true si P es padre de H de un arbol*/
    public boolean esPadreDe(int p, int h) {
        return esPadreDeEnArbol(raiz, p, h);
    }

    private boolean esPadreDeEnArbol(Nodo nodo, int p, int h) {
        if (nodo == null) {
            return false;
        }
        if (nodo.elemento == p) {
            return nodo.izq.elemento == h || nodo.der.elemento == h;
        }
        return esPadreDeEnArbol(nodo.izq, p, h) || esPadreDeEnArbol(nodo.der, p, h);
    }

    /**************************************************************************
                5 metodos de consulta eliminando elementos de un ABB
    /**************************************************************************/
    
    /* Metodo 1 - Método que elimina los nodos hoja de árbol*/
    public void eliminarHojas() {
        raiz = eliminarHojas(raiz);
    }

    private Nodo eliminarHojas(Nodo p) {
        if (p == null) {
            return null;
        }
        if (p.izq == null && p.der == null) {
            return null;
        }
        p.izq = eliminarHojas(p.izq);
        p.der = eliminarHojas(p.der);
        return p;
    }

    /* Metodo 2 - Método que elimina el elemento menor del árbol*/
    public void eliminarMenor() {
        raiz = eliminarMenor(raiz);
    }

    private Nodo eliminarMenor(Nodo p) {
        if (p == null) {
            return null;
        }
        if (p.izq != null) {
            p.izq = eliminarMenor(p.izq);
            return p;
        }
        return p.der;
    }

    /* Metodo 3 - Metodo que Elimina todos los nodos que contienen un valor específico y es hojas del árbol*/
    public void eliminarNodosHojasConValor(int valor) {
        raiz = eliminarNodosHojasConValor(raiz, valor);
    }

    private Nodo eliminarNodosHojasConValor(Nodo p, int valor) {
        if (p == null) {
            return null;
        }
        if (p.izq == null && p.der == null && p.elemento == valor) {
            return null;
        }
        p.izq = eliminarNodosHojasConValor(p.izq, valor);
        p.der = eliminarNodosHojasConValor(p.der, valor);
        return p;
    }

    /* Metodo 4 - Método que elimina los nodos del árbol a partir del nivel n hacia abajo*/
    public void eliminardesdeNivel(int n) {
        raiz = eliminardesdeNivel(raiz, n, 0);
    }

    private Nodo eliminardesdeNivel(Nodo p, int nivelActual, int nivel) {
        if (p == null) {
            return null;
        }
        if (nivel == nivelActual) {
            return null;
        }
        p.izq = eliminardesdeNivel(p.izq, nivelActual, nivel + 1);
        p.der = eliminardesdeNivel(p.der, nivelActual, nivel + 1);
        return p;
    }

    /* Metodo 5 - Metodo que Elimina todos los nodos hojas en un nivel específico del árbol*/
    public void eliminarNodosHojasDelNivel(int nivel) {
        raiz = eliminarNodosHojasDelNivel(raiz, nivel, 1);
    }

    private Nodo eliminarNodosHojasDelNivel(Nodo p, int nivel, int nivelActual) {
        if (p == null) {
            return null;
        }
        if (nivelActual == nivel && p.izq == null && p.der == null) {
            return null;
        }
        p.izq = eliminarNodosHojasDelNivel(p.izq, nivel, nivelActual + 1);
        p.der = eliminarNodosHojasDelNivel(p.der, nivel, nivelActual + 1);
        return p;
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

    /* Metodo 1 - Mostrar las palabras de menor a mayor con sus respectivas frecuencias*/
    public void mostrarPalabrasConFrecuencias() {
        mostrarPalabrasConFrecuencias(raiz);
    }

    private void mostrarPalabrasConFrecuencias(Nodo p) {
        if (p == null) {
            return;
        }
        mostrarPalabrasConFrecuencias(p.izq);
        System.out.println(p.palabra + ": " + p.frecuencia);
        mostrarPalabrasConFrecuencias(p.der);
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
        String vocales = "aeiouAEIOU";
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
