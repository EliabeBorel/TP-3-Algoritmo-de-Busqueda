package temas8;

import java.util.ArrayList;

public class Busqueda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> mochila = new ArrayList<>();
		mochila.add(3);
		mochila.add(5);
		mochila.add(7);
		mochila.add(9);
		mochila.add(10);
		mochila.add(11);

		for (int i = 0; i < 10; i++) {
			int posicionEncontrada = encontrarPocion(mochila, i);
			if (posicionEncontrada != -1) {
				System.out.println("Se encontró una pocion con valor " + i + " en: " + posicionEncontrada);
			}
		}
	}

	public static int encontrarPocion(ArrayList<Integer> mochila, int valorBuscado) {
		for (int pocion = 0; pocion < mochila.size(); pocion++) {
			if (mochila.get(pocion) == valorBuscado) {
				return pocion;
			}
		}

		return -1;
	}
	
	
	public static ArrayList<Integer> dosPocionesAdyacentes(ArrayList<Integer> mochila, int deficitVida) {
		ArrayList<Integer> indicesEncontrados = new ArrayList<>();
		for (int pocion = 0; pocion < mochila.size() -1; pocion++) {
			if (mochila.get(pocion) + mochila.get(pocion + 1) == deficitVida) {
				indicesEncontrados.add(pocion);
				indicesEncontrados.add(pocion + 1);
				break;
			}
		}
		return indicesEncontrados;
	}
	
	
	public static ArrayList<Integer> dosPociones(ArrayList<Integer> mochila, int deficitVida) {
		ArrayList<Integer> indicesEncontrados = new ArrayList<>();

		for (int pocion = 0; pocion < mochila.size() -1; pocion++) {
			int deficitFaltante = deficitVida - mochila.get(pocion);
			
			// busqueda binaria al resto de la mochila
			int indiceBusquedaBinaria = busquedaBinaria(mochila, deficitFaltante, pocion + 1, mochila.size() -1);
			
			if (indiceBusquedaBinaria != -1) {
				indicesEncontrados.add(pocion,indiceBusquedaBinaria);
				break;
			}
		}
		
		return indicesEncontrados;
	}
	
	private static int busquedaBinaria(ArrayList<Integer> mochila, int deficitFaltante, int inicio, int end) {
		while ( inicio <= end) {
			int medio = inicio + ((end - inicio) / 2);
			if (mochila.get(medio) == deficitFaltante) {
				return medio;
			} else if(deficitFaltante > mochila.get(medio)) {
				inicio = medio +1;
			} else {
				end = medio - 1;
			}
		}
		return -1;
	}
	
	

}
