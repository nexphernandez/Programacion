package es.file.json.uno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class CaballeroService extends BasicOperationsCaballeros{
    private Set<Caballero> caballeros;
    private static String path = "src/main/resources/caballeros.json";
    /**
     * Constructor vacio
     */
    public CaballeroService() {
        super(path);
        caballeros = leerFichero();
    }

    /**
     * Funcion que busca un caballero por el id
     * @param id del caballero a buscar
     * @return el Caballero Buscado
     */
    public Caballero findById(int id) {
        Caballero caballero = new Caballero(id);
        for (Caballero caballeroBuscar : caballeros) {
            if (caballero.equals(caballeroBuscar)) {
                return caballeroBuscar;
            }
        }
        return null;
    }

    /**
     * Funcion que filtra los caballeros por un rango de fecha
     * @param startDate fecha de inicio del rango
     * @param endDate fecha fin del rango
     * @return lista de caballeros
     */
    public List<Caballero> findByDateRange(String startDate, String endDate) {
        if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
            return new ArrayList<>();
        }
        LocalDate fechaInicio = LocalDate.parse(startDate);
        LocalDate fechaFin = LocalDate.parse(endDate);
        List<Caballero> porRango = new ArrayList<>();
        for (Caballero caballero : caballeros) {
            LocalDate fechaCaballero = LocalDate.parse(caballero.getFechaIngreso());
            if (!(fechaCaballero.isAfter(fechaFin)) && !(fechaCaballero.isBefore(fechaInicio))) {
                porRango.add(caballero);
            }
        }
        return porRango;
    }

    /**
     * Funcion que encuentra la lista de caballeros
     * @return lista de caballeros
     */
    public List<Caballero> getList() {
        return new ArrayList<>(caballeros);
    }
    
    /**
     * Funcion que carga la lista de caballeros
     * @return lista de caballeros
     */
    public List<Caballero> loadAll() {
        return new ArrayList<>(caballeros);
    }
    
    /**
     * Funcion que aniade un caballero al fichero
     * @param obj caballero a aniadir
     * @return tre/false
     */
    public boolean add(Caballero obj) {
        if (obj == null ) {
            return false;
        }
        caballeros.add(obj);
        writeFichero(caballeros);
        return false;
    }

    /**
     * Funcio que borra un caballero del fichero
     * @param obj caballero a borrar
     * @return true/false
     */
    public boolean delete(Caballero obj) {
        if (obj == null ) {
            return false;
        }
        caballeros.remove(obj);
        writeFichero(caballeros);
        return false;
    }
        
}
