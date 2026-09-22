package tp3;
/**
 * Representa un registro dentro del archivo de la agencia.
 * Implementa Comparable por "codigo" porque ese es el campo
 * que se usa para ordenar la lista antes de aplicar búsqueda binaria.
 *
 * Esta clase ya está completa: no hace falta modificarla.
 */
public class Sospechoso implements Comparable<Sospechoso> {

    private final int codigo;
    private final String alias;
    private final String ciudad;
    private final int nivelDeRiesgo; // 1 a 10

    public Sospechoso(int codigo, String alias, String ciudad, int nivelDeRiesgo) {
        this.codigo = codigo;
        this.alias = alias;
        this.ciudad = ciudad;
        this.nivelDeRiesgo = nivelDeRiesgo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getAlias() {
        return alias;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getNivelDeRiesgo() {
        return nivelDeRiesgo;
    }

    @Override
    public int compareTo(Sospechoso otro) {
        return Integer.compare(this.codigo, otro.codigo);
    }

    @Override
    public String toString() {
//        return String.format("#%05d | %-12s | %-12s | riesgo %d",
//                codigo, alias, ciudad, nivelDeRiesgo);
//        return String.format(" codigo:"+codigo+" alias:"+alias+
//        		             " ciudad:"+ciudad+" nivelDeRiesgo "+nivelDeRiesgo);    
        return String.format(codigo+"/"+alias+"/"+ciudad+"/"+nivelDeRiesgo);
    }
    
}
