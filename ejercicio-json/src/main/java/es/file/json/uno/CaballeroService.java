package es.file.json.uno;

import java.io.File;
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
    private TypeReference<List<Caballero>> typeReference2 = new TypeReference<List<Caballero>>() {};
    Set<Caballero> caballeros2;
    List<Caballero> caballeros1;
    
    public CaballeroService() {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        caballeros1 = BasicOperations.leerFichero(file, typeReference2);
        
    }

    public Caballero findById(int id) {
        return null;
    }

    public List<Caballero> findByDateRange(String startDate, String endDate) {
        return null;
    }

    public List<Caballero> getList() {
        return null;
    }
    
    public List<Caballero> loadAll() {
        return null;
    }
    
    
    
    public boolean add(Caballero obj) {
        return false;
    }

    public boolean delete(Caballero obj) {
        return false;
    }
        
    
}
