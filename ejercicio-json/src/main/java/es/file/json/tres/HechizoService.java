package es.file.json.tres;


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

public class HechizoService   {
    private File file = new File("src/main/resources/cars.json");
    private TypeReference <Set<Hechizo>> typeReference = new TypeReference<Set<Hechizo>>() {};
    private Set<Hechizo> hechizos;

    /**
     * Constructor vacio
     */
    public HechizoService() {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        hechizos = BasicOperations.leerFichero(file, typeReference);
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
        for (Hechizo hechizoBuscado : hechizos) {
            LocalDate hechizo = LocalDate.parse(hechizoBuscado.getFechaCreacion());
            
        }
        return null;
    }

    public List<Hechizo> getList() {
        return null;
    }
    
    public List<Hechizo> loadAll() {
        return null;
    }
    
    
    
    public boolean add(Hechizo obj) {
        return false;
    }

    public boolean delete(Hechizo obj) {
        return false;
    }
    
    
}
