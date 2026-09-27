package tp3;

import java.util.List;

/**
 * TODO: Búsqueda binaria.
 *
 * PRE-CONDICIÓN OBLIGATORIA: la lista que reciben estos métodos debe estar
 * ordenada por código (ascendente). Si no lo está, el resultado no tiene ningún
 * sentido, aunque el código "corra" sin errores.
 *
 * No usen Arrays.binarySearch ni Collections.binarySearch: hay que
 * implementarla a mano, con low/high/medio.
 */
public class BuscadorBinario {
	/**
	 * Búsqueda binaria iterativa. Devuelve el Sospechoso si el código existe en la
	 * lista, o null si no existe.
	 *
	 * Recuerden medir tiempo y contar comparaciones para el informe.
	 */
	public static Sospechoso buscarPorCodigo(List<Sospechoso> listaOrdenada, int codigo) {
		// Implementación de búsqueda binaria iterativa (low, high, medio)

		int low = 0;
		int high = listaOrdenada.size() - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (listaOrdenada.get(mid).getCodigo() == codigo)
				return listaOrdenada.get(mid);

			else if (listaOrdenada.get(mid).getCodigo() > codigo)
				high = mid - 1;

			else
				low = mid + 1;
		}

		return null;
	}

	/**
	 * Desafío: la misma búsqueda binaria, pero recursiva en vez de iterativa.
	 */
	public static Sospechoso buscarPorCodigoRecursiva(List<Sospechoso> listaOrdenada, int codigo, int low, int high) {
		// Implementación de búsqueda binaria recursiva

		if (low <= high) {
			int mid = (low + high) / 2;

			if (listaOrdenada.get(mid).getCodigo() == codigo)
				return listaOrdenada.get(mid);

			else if (listaOrdenada.get(mid).getCodigo() > codigo)
				return buscarPorCodigoRecursiva(listaOrdenada, codigo, low, mid - 1);

			return buscarPorCodigoRecursiva(listaOrdenada, codigo, mid + 1, high);
		}

		return null;
	}

	/**
	 * El "giro final" del TP: si el código no existe, en vez de solo decir "no
	 * encontrado", este método debe devolver el sospechoso cuyo código es el más
	 * cercano por abajo al buscado (el último candidato antes de que la búsqueda se
	 * quede sin rango). Si no hay ninguno más chico, devolver null.
	 *
	 * Pista: piensen qué vale la variable "low" o "high" en el momento exacto en
	 * que el bucle de la búsqueda binaria termina sin encontrar el valor.
	 */
	public static Sospechoso buscarMasParecidoSiNoExiste(List<Sospechoso> listaOrdenada, int codigo) {
		// TODO: implementar usando la lógica de la búsqueda binaria
		return null;
	}

}
