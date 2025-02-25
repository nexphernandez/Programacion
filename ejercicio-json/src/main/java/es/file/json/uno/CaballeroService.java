package es.file.json.uno;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;

import es.file.json.BasicOperations;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class CaballeroService extends BasicOperations{
    private File file = new File("src/main/resources/caballeros.json");
    private TypeReference<Set<Caballero>> typeReference = new TypeReference<Set<Caballero>>() {}; 
    Set<Caballero> caballeros;
    
    /**
     * Constructor vacio
     */
    public CaballeroService() {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        caballeros = BasicOperations.leerFichero(file, typeReference);
        
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
        BasicOperations.writeFichero(caballeros, file);
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
        BasicOperations.writeFichero(caballeros, file);
        return false;
    }
        
}
