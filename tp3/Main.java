package tp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TP3 — Búsqueda Lineal y Binaria <Lucas Leal, Eliable Borel>
 * 
 * Punto de partida del TP3. La lista de sospechosos YA está cargada: no hace
 * falta leerla de ningún archivo ni generarla ustedes.
 *
 * Vayan completando BuscadorLineal y BuscadorBinario, y usen este main para
 * probar sus propios métodos a medida que los escriben.
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("TP3 — Búsqueda Lineal y Binaria\n");
		// Cantdades de sospechosos para prueba
		int[] cantidades = { 500, 5000, 10000, 100000 };
		// El archivo "en bruto": ya viene cargado y desordenado.
		List<Sospechoso> archivo = ListaDeSospechosos.generar(cantidades[3]);
		System.out.println("Archivo cargado con " + archivo.size() + " sospechosos.\n");
//        System.out.println("Los Sospechosos: " + archivo.toString() + "\n");

		long tiempo = System.nanoTime();

		// PARTE 1: búsqueda lineal
		System.out.println("PARTE 1.1: búsqueda lineal mejor caso.");
		// Un código que sabemos que esta al principio.
		int codigoDePruebaI = archivo.get(0).getCodigo();
		Sospechoso encontrado = BuscadorLineal.buscarPorCodigoLineal(archivo, codigoDePruebaI);
		System.out.println("Buscando codigo " + codigoDePruebaI + " -> " + encontrado);
		long duracion = System.nanoTime() - tiempo;
		System.out.println("Tiempo de calculo de 1.1: " + duracion + "\n");

		tiempo = System.nanoTime();
		
		System.out.println("PARTE 1.2: búsqueda lineal medio caso.");
		// Un código que sabemos que esta al medio.
		int codigoDePruebaM = archivo.get(archivo.size() / 2).getCodigo();
		encontrado = BuscadorLineal.buscarPorCodigoLineal(archivo, codigoDePruebaM);
		System.out.println("Buscando codigo " + codigoDePruebaM + " -> " + encontrado);
		long duracionM = System.nanoTime() - tiempo;
		System.out.println("Tiempo de calculo de 1.2: " + duracionM + "\n");

		tiempo = System.nanoTime();
		
		System.out.println("PARTE 1.3: búsqueda lineal peor caso.");
		// Un código que sabemos que esta al final.
		int codigoDePruebaP = archivo.get(archivo.size() - 1).getCodigo();
		encontrado = BuscadorLineal.buscarPorCodigoLineal(archivo, codigoDePruebaP);
		System.out.println("Buscando codigo " + codigoDePruebaP + " -> " + encontrado);
		long duracionP = System.nanoTime() - tiempo;
		System.out.println("Tiempo de calculo de 1.3: " + duracionP + "\n");

		// ↓↓↓ Por alguna razon se bugea cuando se usa con cantidades[3] ↓↓↓
		// Buscar por ciudad y riesgo Minimo.
//		List<Sospechoso> filtrados = BuscadorLineal.buscarPorCiudadYRiesgoMinimo(archivo, "Rosario", 7);
//		System.out.println("Sospechosos en Rosario con riesgo >= 7: " + filtrados.size() + "\n" + filtrados);

		// PARTE 2: búsqueda binaria
		// OJO: la búsqueda binaria necesita la lista ORDENADA por código.
		// Hacemos una COPIA para no romper el orden del archivo original.
		List<Sospechoso> archivoOrdenado = new ArrayList<>(archivo);
		Collections.sort(archivoOrdenado);

		tiempo = System.nanoTime();
		
		System.out.println("\nPARTE 2.1: búsqueda binaria");
		Sospechoso encontradoBinaria = BuscadorBinario.buscarPorCodigo(archivoOrdenado, codigoDePruebaI);
		System.out.println("Buscando codigo " + codigoDePruebaI + " -> " + encontradoBinaria);
		duracion = System.nanoTime() - tiempo;
		System.out.println("Tiempo de calculo de 2.1: " + duracion);

		tiempo = System.nanoTime();
		
		System.out.println("\nPARTE 2.2: búsqueda binaria recursiva");
		encontradoBinaria = BuscadorBinario.buscarPorCodigoRecursiva(archivoOrdenado, codigoDePruebaI, 0,
				archivoOrdenado.size() - 1);
		System.out.println("Buscando codigo " + codigoDePruebaI + " -> " + encontradoBinaria);
		duracion = System.nanoTime() - tiempo;
		System.out.println("Tiempo de calculo de 2.2: " + duracion);
		
		tiempo = System.nanoTime();
		
		System.out.println("\nPARTE 2.3: buscar más parecido si no existe");
		int codigoInexistente = 67;
		encontradoBinaria = BuscadorBinario.buscarMasParecidoSiNoExiste(archivoOrdenado, codigoInexistente);
		System.out.println("El código " + codigoInexistente + " no existe, el mas cercano es: " + encontradoBinaria);
		duracion = System.nanoTime() - tiempo;
		System.out.println("Tiempo de calculo de 2.3: " + duracion);

		// Esto lo vemos juntos despues unu.

		// TODO: agreguen acá sus propias pruebas y mediciones con
		// System.nanoTime() para comparar lineal vs. binaria, como pide
		// el enunciado. Prueben con códigos al principio, en el medio
		// y al final de la lista.
	}
}
