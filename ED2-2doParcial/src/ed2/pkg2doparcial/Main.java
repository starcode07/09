package ed2.pkg2doparcial;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arbol A2 = new Arbol();

        A2.insertar("manzana");
        A2.insertar("somos");
        A2.insertar("ana");
        A2.insertar("somos");
        A2.insertar("uva");
        A2.insertar("somos");
        A2.insertar("ana");
        A2.insertar("verde");
        A2.insertar("oro");
        A2.insertar("ana");
        A2.insertar("somos");
        A2.insertar("oro");
        
        /* Metodo 1 - Mostrar las palabras de menor a mayor con sus respectivas frecuencias*/
        System.out.println("--- Palabras menor a mayor con frec: ---");
        A2.mostrarPalabrasConFrecuencias();

        /* Metodo 2 - Mostrar las palabras de menor a mayor por longitud, con sus frecuencias*/
        System.out.println("--- Palabras de menor a mayor por longitud: ---");
        A2.mostrarPalabrasPorLongitud();

        /* Metodo 3 - Mostrar Palabras que Comienzan con Vocal*/
        System.out.println("--- Palabras que Comienzan con Vocal: ---");
        A2.mostrarPalabrasComienzanConVocal();

        /* Metodo 4 - Mostrar palabras que son capicuas y su frecuencia*/
          System.out.println("--- Palabras son capicuas y su frecuencia: ---");
        A2.mostrarPalabrasCapicuas();

        /* Metodo 5 - Método que obtiene la palabra con más frecuencia en el árbol*/
        System.out.println("--- Palabra más frecuente: " + A2.obtenerPalabraMasFrecuente());
    }

}
