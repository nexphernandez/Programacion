package es.file.json.dos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * @author nexphernandez
 * @version 1.0.0
 */


public class TributoService extends es.file.json.dos.BasicOperationsTributo{
    private static String path = "src/main/resources/tributos.json";
    private Set<Tributo> tributos;
    
    /**
     * Constructor vacio
     */
    public TributoService() {
        super(path);
        tributos = leerFichero();
    }

    /**
     * Funcion que busca un tributo en el fichero por la id
     * @param id a buscar 
     * @return tributo buscado/null
     */
    public Tributo findById(int id) {
        Tributo tributo = new Tributo(id);
        for (Tributo TributoBuscar : tributos) {
            if (tributo.equals(TributoBuscar)) {
                return TributoBuscar;
                
            }
        }
        return null;
    }

    /**
     * Funcion que busca un tributo por un rango de fecha
     * @param startDate fecha inicial
     * @param endDate fecha final
     * @return lista con los tributos/ lista vacia
     */
    public List<Tributo> findByDateRange(String startDate, String endDate) {
        if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
            return new ArrayList<>();
        }
        LocalDate fechaInicial = LocalDate.parse(startDate);
        LocalDate fechaFinal = LocalDate.parse(endDate);
        List<Tributo> tributosByRange = new ArrayList<>();
        for (Tributo tributoBucar : tributos) {
            LocalDate tributoFecha = LocalDate.parse(tributoBucar.getFechaSeleccion());
            if (!tributoFecha.isAfter(fechaFinal) && !tributoFecha.isBefore(fechaInicial)) {
                tributosByRange.add(tributoBucar);
            }
        }    
        return tributosByRange;
    }

    /**
     * Funcion que encuentra la lista de tributos
     * @return lista de tributos
     */
    public List<Tributo> getList() {
        return new ArrayList<>(tributos);
    }
    
    /**
     * Funcion que encuentra la lista de tributos
     * @return lista de tributos
     */
    public List<Tributo> loadAll() {
        return new ArrayList<>(tributos);
    } 
    
    /**
     * Funcion que aniade tributos al fichero
     * @param obj tributo a aniadir
     * @return true/false
     */
    public boolean add(Tributo obj) {
        if (obj == null) {
            return false;
        }
        if (tributos.contains(obj)) {
            return false;
        }
        tributos.add(obj);
        writeFichero(tributos);
        return true;
    }

    /**
     * Funcion que borra un tributo del fichero
     * @param obj hechizo a borrar
     * @return true/false
     */
    public boolean delete(Tributo obj) {
        if (obj == null) {
            return false;
        }
        if (!tributos.contains(obj)) {
            return false;
        }
        tributos.remove(obj);
        writeFichero(tributos);
        return true;
    }
    
    
}
