package ed2.pkg2doparcial;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Arbol A1 = new Arbol();
//        
//        A1.insertar(50);
//        A1.insertar(30);
//        A1.insertar(70);
//        A1.insertar(20);
//        A1.insertar(40);
//        A1.insertar(80);
//        A1.insertar(60);
//        A1.insertar(35);
//        A1.insertar(55);
//        A1.insertar(65);
//        A1.insertar(63);
//        A1.insertar(68);
//        A1.insertar(90);

        /* Metodo 1 - Metodo que muestra los elementos de la izq, la raiz y los elem de la derecha*/
//        A1.inOrden();
//        System.out.println("--------------------------------");

        /* Metodo 2 - Métodos lógico que devuelve True, si el elemento se encuentra en el árbol*/
//        System.out.println("¿se encuentra el elemento?: " + A1.seEncuentra(90));

        /* Metodo 3 - Método que muestra los elementos y el nivel donde se encuentra*/
//        A1.mostrarNivel();

        /* Metodo 4 - Método que devuelve la cantidad de nodos del árbol*/
//        System.out.println("cantidad de nodos: " + A1.cantidad());      
        
        /* Metodo 5 - Metodo que devuelve la cantidad de nodos con un solo hijo*/
//        System.out.println("Cantidad de Nodos con solo 1 Hijo(): " + A1.cantidadNodosConSoloUnHijo());

        /* Metodo 6 - Metodo que devuelve true si P es padre de H de un arbol*/
//        System.out.println("El P es padre de H: " + A1.esPadreDe(70,80));
        
        /**************************************************************************
                    5 metodos de consulta eliminando elementos de un ABB
        /**************************************************************************/
//          A1.inOrden();
//          System.out.println("--------------------------------");

        /* Metodo 1 - Método que elimina los nodos hoja de árbol*/
//        A1.eliminarHojas();

        /* Metodo 2 - Método que elimina el elemento menor del árbol*/
//        A1.eliminarMenor();

        /* Metodo 3 - Metodo que Elimina todos los nodos que contienen un valor específico y es hojas del árbol*/
//        A1.eliminarNodosHojasConValor(90);

        /* Metodo 4 - Método que elimina los nodos del árbol a partir del nivel n hacia abajo*/
//        A1.eliminardesdeNivel(2);

        /* Metodo 5 - Metodo que Elimina todos los nodos hojas en un nivel específico del árbol*/
//        A1.eliminarNodosHojasDelNivel(4);

        /* Este Metodo muestra como quedo el arbol*/
//        A1.inOrden();

        /**************************************************************************
                    5 metodos de consulta sobre frecuencia de elementos
        **************************************************************************/

//        Arbol A2 = new Arbol();
//
//        A2.insertar("manzana");
//        A2.insertar("somos");
//        A2.insertar("ana");
//        A2.insertar("somos");
//        A2.insertar("uva");
//        A2.insertar("somos");
//        A2.insertar("ana");
//        A2.insertar("verde");
//        A2.insertar("oro");
//        A2.insertar("ana");
//        A2.insertar("somos");
//        A2.insertar("oro");
        
        /* Metodo 1 - Mostrar las palabras de menor a mayor con sus respectivas frecuencias*/
//        A2.mostrarPalabrasConFrecuencias();

        /* Metodo 2 - Mostrar las palabras de menor a mayor por longitud, con sus frecuencias*/
//        A2.mostrarPalabrasPorLongitud();

        /* Metodo 3 - Mostrar Palabras que Comienzan con Vocal*/
//        A2.mostrarPalabrasComienzanConVocal();
//
        /* Metodo 4 - Mostrar palabras que son capicuas y su frecuencia*/
//        A2.mostrarPalabrasCapicuas();

        /* Metodo 5 - Método que obtiene la palabra con más frecuencia en el árbol*/
//        System.out.println("Palabra más frecuente: " + A2.obtenerPalabraMasFrecuente());
    }

}
