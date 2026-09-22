package tp3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TP3 — Búsqueda Lineal y Binaria 
 * <ALUMNO>
 * 
 * Punto de partida del TP3. La lista de sospechosos YA está cargada:
 * no hace falta leerla de ningún archivo ni generarla ustedes.
 *
 * Vayan completando BuscadorLineal y BuscadorBinario, y usen este
 * main para probar sus propios métodos a medida que los escriben.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("TP3 — Búsqueda Lineal y Binaria\n");
        //cantdades de sospechosos para prueba
        int[] cantidades= {500,5000,10000,100000};
        // El archivo "en bruto": ya viene cargado y desordenado.
        List<Sospechoso> archivo = ListaDeSospechosos.generar(cantidades[3]);
        System.out.println("Archivo cargado con " + archivo.size() + " sospechosos.\n");
        System.out.println("Los Sospechosos: " + archivo.toString() + "\n");
        
        long tiempo1 = System.nanoTime();

        // PARTE 1: búsqueda lineal
        System.out.println("PARTE 1: búsqueda lineal");
        // un código que sabemos que existe
        int codigoDePrueba = archivo.get(250).getCodigo(); 
        Sospechoso encontrado = BuscadorLineal.buscarPorCodigo(archivo, codigoDePrueba);
        System.out.println("Buscando codigo " + codigoDePrueba + " -> " + encontrado);
        long duracion = System.nanoTime()-tiempo1;
        System.out.println("Parte1 Ejemplo de calculo de tiempo: " + duracion);
        
        List<Sospechoso> filtrados = BuscadorLineal.buscarPorCiudadYRiesgoMinimo(archivo, "Rosario", 7);
        System.out.println("Sospechosos en Rosario con riesgo >= 7: " + filtrados.size());
        
        tiempo1 = System.nanoTime();
        // PARTE 2: búsqueda binaria
        System.out.println("\nPARTE 2: búsqueda binaria");
        // OJO: la búsqueda binaria necesita la lista ORDENADA por código.
        // Hacemos una COPIA para no romper el orden del archivo original.
        List<Sospechoso> archivoOrdenado = new ArrayList<>(archivo);
        Collections.sort(archivoOrdenado);
        

        Sospechoso encontradoBinaria = BuscadorBinario.buscarPorCodigo(archivoOrdenado, codigoDePrueba);
        System.out.println("Buscando codigo " + codigoDePrueba + " -> " + encontradoBinaria);
        
        duracion = System.nanoTime()-tiempo1;        
        System.out.println("Parte2 Ejemplo de calculo de tiempo: " + duracion);
        
        // TODO: agreguen acá sus propias pruebas y mediciones con
        // System.nanoTime() para comparar lineal vs. binaria, como pide
        // el enunciado. Prueben con códigos al principio, en el medio
        // y al final de la lista.
    }
}
