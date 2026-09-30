 package tp3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Esta clase representa el "archivo robado" a ser cargado en memoria,
 * como un ArrayList<Sospechoso> con N registros desordenados.
 * 
 * Usar el método generar(int cantidad) para generar la lista
 * 
 * No hace falta leer ningún archivo externo ni entender cómo se generan
 * estos datos: alcanza con usar la lista generada directamente.
 */
public class ListaDeSospechosos {

    private static final String[] ALIAS = {
            "Sombra", "Vector", "Eco", "Fantasma", "Cifra", "Nomada",
            "Relampago", "Ceniza", "Espejo", "Cuervo", "Brujula", "Vertigo"
    };

    private static final String[] CIUDADES = {
            "Buenos Aires", "Rosario", "Cordoba", "Mendoza", "La Plata",
            "Salta", "Neuquen", "Bariloche"
    };

    public static List<Sospechoso> generar(int cantidad) {
        
    	// misma semilla siempre  serán los mismos datos para todos
        final long semilla = 42L; 
        Random random = new Random(semilla);
        
        //utiliza una cantidade de códigos major que lo necesário
        //esto torna la lista mas diversificada
        List<Integer> codigosDisponibles = new ArrayList<>();
        for (int i = 1; i <= cantidad * 3; i++) {
            codigosDisponibles.add(i);
        }
        Collections.shuffle(codigosDisponibles, random);

        List<Sospechoso> lista = new ArrayList<>(cantidad);
        for (int i = 0; i < cantidad; i++) {
            int codigo = codigosDisponibles.get(i);
            String alias = ALIAS[random.nextInt(ALIAS.length)] + "-" + random.nextInt(100);
            String ciudad = CIUDADES[random.nextInt(CIUDADES.length)];
            int riesgo = 1 + random.nextInt(10);
            lista.add(new Sospechoso(codigo, alias, ciudad, riesgo));
        }

        Collections.shuffle(lista, random); // el archivo llega desordenado
        return lista;
    }
}
