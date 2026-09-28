package tp3;

import java.util.ArrayList;
import java.util.List;

/**
 * Búsqueda lineal.
 *
 * Completen los métodos de esta clase. No usen métodos de búsqueda ya hechos de
 * Java (indexOf, contains, streams con filter, etc.): la idea es recorrer la
 * lista "a mano".
 */
public class BuscadorLineal {

	/**
	 * Debe recorrer la lista elemento por elemento y devolver el Sospechoso cuyo
	 * código coincida con el buscado, o null si no existe ningún sospechoso con ese
	 * código.
	 *
	 * No olviden medir el tiempo con System.nanoTime() y contar cuántas
	 * comparaciones hicieron (parte del informe pide esos datos).
	 */
	public static Sospechoso buscarPorCodigoLineal(List<Sospechoso> lista, int codigo) {
		// Implementación de búsqueda lineal
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCodigo() == codigo) {
				return lista.get(i);
			}
		}
		return null;
	}

	/**
	 * Debe devolver TODOS los sospechosos que sean de la ciudad indicada Y tengan
	 * nivelDeRiesgo mayor o igual al indicado. Si no hay ninguno, devolver una
	 * lista vacía (no null).
	 */
	public static List<Sospechoso> buscarPorCiudadYRiesgoMinimo(List<Sospechoso> lista, String ciudad,
			int riesgoMinimo) {
		// Implementación de filtro lineal
		
		List<Sospechoso> listaSospechososCiudad = new ArrayList<>();

		for (int i = 0; i < lista.size(); i++) {
			Sospechoso s = lista.get(i);

			if ((s.getCiudad().equalsIgnoreCase(ciudad)) && (lista.get(i).getNivelDeRiesgo() >= riesgoMinimo)) {
				listaSospechososCiudad.add(s);
			}
		}

		return listaSospechososCiudad;
	}
}
