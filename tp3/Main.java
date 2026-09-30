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
		System.out.println("TP3 — Búsqueda Lineal y Binaria: Lucas Leal, Eliable Borel.\n");
		// Cantdades de sospechosos para prueba
		//                   0    1      2       3        4          5           6
		int[] cantidades = { 500, 5_000, 10_000, 100_000, 1_000_000, 10_000_000, 20_000_000};
		int cantidad = 5;
		// El archivo "en bruto": ya viene cargado y desordenado.
		List<Sospechoso> archivo = ListaDeSospechosos.generar(cantidades[cantidad]);
		System.out.println("Archivo cargado con " + archivo.size() + " sospechosos.\n");
//        System.out.println("Los Sospechosos: " + archivo.toString() + "\n");

		// PARTE 2: búsqueda binaria, ordenamiento.
		// OJO: la búsqueda binaria necesita la lista ORDENADA por código.
		// Hacemos una COPIA para no romper el orden del archivo original.
		List<Sospechoso> archivoOrdenado = new ArrayList<>(archivo);
		long tiempoSort = System.nanoTime();
		Collections.sort(archivoOrdenado);
		long duracionSort = System.nanoTime() - tiempoSort;
		System.out.println("Tiempo de ordenamiento de la lista: " + (duracionSort / 1_000_000) + " ms\n");
		
		
		/*
		* ==========================================
		* CALENTAMIENTO DE LA JVM (Warm-up)
		* ==========================================
		*/
		System.out.println("Ejecutando calentamiento de la JVM...");
		
		// Muestra de solo 1,000 elementos para el calentamiento
				List<Sospechoso> muestraWarmUp = archivo.subList(0, Math.min(1000, archivo.size()));
				int codigoWarmUp = muestraWarmUp.get(muestraWarmUp.size() - 1).getCodigo();

				// Muestra pequeña y ordenada para calentar la Búsqueda Binaria de forma instantánea
				List<Sospechoso> muestraWarmUpBinaria = new ArrayList<>(muestraWarmUp);
				Collections.sort(muestraWarmUpBinaria);

				for (int i = 0; i < 50_000; i++) {
				    BuscadorLineal.buscarPorCodigoLineal(muestraWarmUp, codigoWarmUp);
				    BuscadorBinario.buscarPorCodigo(muestraWarmUpBinaria, codigoWarmUp);
				}

		System.out.println("Calentamiento finalizado.\n");
		
		/*
		* ==========================================
		* PARTE 1: búsqueda lineal
		* ==========================================
		*/
		System.out.println("================= PARTE 1: búsqueda lineal =================");
		// Un código que sabemos que esta al principio.
		System.out.println("PARTE 1.1: búsqueda lineal mejor caso.");
		int codigoDePruebaI = archivo.get(0).getCodigo();

		long tiempo = System.nanoTime();
		Sospechoso encontrado = BuscadorLineal.buscarPorCodigoLineal(archivo, codigoDePruebaI);
		long duracion = System.nanoTime() - tiempo;

		System.out.println("Buscando codigo " + codigoDePruebaI + " -> " + encontrado);
		System.out.println("Tiempo de calculo de 1.1: " + (duracion / 1_000) + "µs\n");

		
		// Un código que sabemos que esta al medio.
		System.out.println("PARTE 1.2: búsqueda lineal medio caso.");
		int codigoDePruebaM = archivo.get(archivo.size() / 2).getCodigo();
		
		tiempo = System.nanoTime();
		encontrado = BuscadorLineal.buscarPorCodigoLineal(archivo, codigoDePruebaM);
		duracion = System.nanoTime() - tiempo;

		System.out.println("Buscando codigo " + codigoDePruebaM + " -> " + encontrado);
		System.out.println("Tiempo de calculo de 1.2: " + (duracion / 1_000) + "ms\n");

		
		// Un código que sabemos que esta al final.
		System.out.println("PARTE 1.3: búsqueda lineal peor caso.");
		int codigoDePruebaP = archivo.get(archivo.size() - 1).getCodigo();
		
		tiempo = System.nanoTime();
		encontrado = BuscadorLineal.buscarPorCodigoLineal(archivo, codigoDePruebaP);
		duracion = System.nanoTime() - tiempo;
		
		System.out.println("Buscando codigo " + codigoDePruebaP + " -> " + encontrado);
		System.out.println("Tiempo de calculo de 1.3: " + (duracion / 1_000) + "ms\n");

		
		/* ↓↓↓ Por alguna razon se bugea cuando se usa con cantidades[3] o más y no muestra el resto del
		* código, para solucionarlo hicimos qeu no se muestren todos datos de los sospechosos,
		* solo dice cuanta candidad hay ↓↓↓
		*/
		// Buscar por ciudad y riesgo Minimo.
		List<Sospechoso> filtrados = BuscadorLineal.buscarPorCiudadYRiesgoMinimo(archivo, "Rosario", 7);
		System.out.println("Sospechosos en Rosario con riesgo >= 7: " + filtrados.size() + /*"\n" + filtrados +*/ "\n\n");

		/*
		* ==========================================
		* PARTE 2: búsqueda binaria
		* ==========================================
		*/
		System.out.println("================= PARTE 2: búsqueda Binaria. =================");
		// PARTE 2.1: búsqueda binaria iterativa.
		
		System.out.println("PARTE 2.1: búsqueda binaria iterativa (Caso medio o mejor).");
		
		int codigoOrdenadoDePruebaM = archivoOrdenado.get((archivo.size() - 1) / 2).getCodigo();
		tiempo = System.nanoTime();
		Sospechoso encontradoBinaria = BuscadorBinario.buscarPorCodigo(archivoOrdenado, codigoOrdenadoDePruebaM);
		duracion = System.nanoTime() - tiempo;
		
		System.out.println("Buscando codigo " + codigoOrdenadoDePruebaM + " -> " + encontradoBinaria);
		System.out.println("Tiempo de calculo de 2.1: " + (duracion / 1_000) + "µs\n");

		
		// PARTE 2.2: búsqueda binaria recursiva.
		System.out.println("PARTE 2.2: búsqueda binaria recursiva (Caso inicial o peor).");

		int codigoOrdenadoDePruebaI = archivoOrdenado.get(0).getCodigo(); // usamos el archivo ordenado para realizar las mediciones, de otra manera el buscador siempre buscara codigos en posiciones "aleatorias".
		tiempo = System.nanoTime();
		encontradoBinaria = BuscadorBinario.buscarPorCodigoRecursiva(archivoOrdenado, codigoOrdenadoDePruebaI, 0,
				archivoOrdenado.size() - 1);
		duracion = System.nanoTime() - tiempo;

		System.out.println("Buscando codigo " + codigoOrdenadoDePruebaI + " -> " + encontradoBinaria);
		System.out.println("Tiempo de calculo de 2.2: " + (duracion / 1_000) + "µs\n");
		
		
		// PARTE 2.3: búsqueda binaria mas parecido.
		System.out.println("PARTE 2.3: buscar más parecido si no existe");
		int codigoInexistente = archivoOrdenado.get(archivo.size() / 3).getCodigo();
		
		tiempo = System.nanoTime();
		encontradoBinaria = BuscadorBinario.buscarMasParecidoSiNoExiste(archivoOrdenado, codigoInexistente);
		duracion = System.nanoTime() - tiempo;
		
		System.out.println("El código " + codigoInexistente + " no existe, el mas cercano es: " + encontradoBinaria);
		System.out.println("Tiempo de calculo de 2.3: " + (duracion / 1_000) + "µs\n");

		
		// EXTRA: PARTE 2.4: búsqueda binaria con un caso muy probable.
		System.out.println("EXTRA. PARTE 2.4: búsqueda binaria caso probable (casi medio)");
		
		tiempo = System.nanoTime();
		encontradoBinaria = BuscadorBinario.buscarPorCodigo(archivoOrdenado, encontradoBinaria.getCodigo());
		duracion = System.nanoTime() - tiempo;
		
		System.out.println("Buscando codigo " + encontradoBinaria.getCodigo() + " -> " + encontradoBinaria);
		System.out.println("Tiempo de calculo de 2.4: " + (duracion / 1_000) + "µs\n");

		
		
		// TODO: agreguen acá sus propias pruebas y mediciones con
		// System.nanoTime() para comparar lineal vs. binaria, como pide
		// el enunciado. Prueben con códigos al principio, en el medio
		// y al final de la lista.
		/*
		* ==========================================
		* PARTE 3: Comparación
		* ==========================================
		*/
		System.out.println("================= PARTE 3: Comparación de tiempos. =================");
		System.out.println("Cantidad | Caso | Lineal | Binaria (Ya ordenado, el tiempo de ordenacion es de ≈" + (duracionSort / 1_000_000) + " ms)");
		
		int repeticiones = 100;
		
		for (int i = 0; i < 3; i++) {
			System.out.print(cantidades[cantidad] + " | ");
			
			int objetivoLineal = 0;
			int objetivoBinario = 0;

			if (i == 0) {
			    System.out.print("inicio | ");
			    objetivoLineal = archivo.get(0).getCodigo();
			    objetivoBinario = archivoOrdenado.get(0).getCodigo(); // usamos el archivo ordenado para realizar las mediciones, de otra manera el buscador siempre buscara codigos en posiciones "aleatorias".
			} else if (i == 1) {
			    System.out.print("medio  | ");
			    objetivoLineal = archivo.get(archivo.size() / 2).getCodigo();
			    
			    // Cálculo exacto de la primera mitad que calcula la Búsqueda Binaria
			    int primerMid = (archivoOrdenado.size() - 1) / 2;
			    objetivoBinario = archivoOrdenado.get(primerMid).getCodigo();
			} else if (i == 2) {
			    System.out.print("final  | ");
			    objetivoLineal = archivo.get(archivo.size() - 1).getCodigo();
			    objetivoBinario = archivoOrdenado.get(archivoOrdenado.size() - 1).getCodigo();
			}
			
			
			tiempo = System.nanoTime();
			for (int k = 0; k < repeticiones; k++) { // Al hacer las mediciones muchas veces el promedio eliminara el ruido del JVM.
			encontrado = BuscadorLineal.buscarPorCodigoLineal(archivo, objetivoLineal);
			}
			duracion = System.nanoTime();
			
			long promedio = (duracion - tiempo) / repeticiones;

			System.out.print((promedio / 1_000_000) + "ms | ");

			tiempo = System.nanoTime();
			for (int l = 0; l < repeticiones * 1000; l++) { // Al hacer las mediciones muchas veces el promedio eliminara el ruido del JVM.
			encontrado = BuscadorBinario.buscarPorCodigo(archivoOrdenado, objetivoBinario);
			}
			duracion = System.nanoTime();
			
			promedio = (duracion - tiempo) / (repeticiones * 1000);

			System.out.print((promedio) + "ns\n");
		}
		
	}
} 
