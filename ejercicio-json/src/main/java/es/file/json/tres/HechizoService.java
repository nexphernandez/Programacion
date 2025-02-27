package es.file.json.tres;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * @author nexphernandez
 * @version 1.0.0
 */

public class HechizoService  extends BasicOperationsHechizos {
    private Set<Hechizo> hechizos;

    /**
     * Constructor vacio
     */
    public HechizoService() {
        super();
        hechizos = leerFichero();
    }

    /**
     * Funcion que busca un hechizo por el id
     * @param id del hechizo a buscar
     * @return hechizo buscado/null
     */
    public Hechizo findById(int id) {
        Hechizo hechizo = new Hechizo(id);
        for (Hechizo hechizoBuscar : hechizos) {
            if (hechizoBuscar.equals(hechizo)) {
                return hechizoBuscar;
            }
        }
        return null;
    }

    /**
     * Funcion que busca un hechizo por un rango de fecha
     * @param startDate fecha inicial
     * @param endDate fecha final
     * @return lista de hechizo con los rangos/ lista vacia
     */
    public List<Hechizo> findByDateRange(String startDate, String endDate) {
        if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
            return new ArrayList<>();
        }
        LocalDate fechaInicio = LocalDate.parse(startDate);
        LocalDate fechaFin = LocalDate.parse(endDate);
        List<Hechizo> hechizos2 = new ArrayList<>();
        for (Hechizo hechizoBuscado : hechizos) {
            LocalDate hechizo = LocalDate.parse(hechizoBuscado.getFechaCreacion());
            if (!hechizo.isAfter(fechaFin) && !hechizo.isBefore(fechaInicio)) {
                hechizos2.add(hechizoBuscado);
            }
        }
        return hechizos2;
    }
    
    /**
     * Funcion que encuentra la lista de hechizos
     * @return lista de hechizos
     */
    public List<Hechizo> loadAll() {
        return new ArrayList<>(hechizos);
    }
    
    /**
     * Funcion que aniade hechizos al fichero
     * @param obj hechizo a aniadir
     * @return true/false
     */
    public boolean add(Hechizo obj) {
        if (obj == null) {
            return false;
        }
        if (hechizos.contains(obj)) {
            return false;
        }
        hechizos.add(obj);
        writeFichero(hechizos);
        return true;
    }

    /**
     * Funcion que borra un hechizo del fichero
     * @param obj hechizo a borrar
     * @return true/false
     */
    public boolean delete(Hechizo obj) {
        if (obj == null) {
            return false;
        }
        if (!hechizos.contains(obj)) {
            return false;
        }
        hechizos.remove(obj);
        writeFichero(hechizos);
        return true;
    }
    
    
}
