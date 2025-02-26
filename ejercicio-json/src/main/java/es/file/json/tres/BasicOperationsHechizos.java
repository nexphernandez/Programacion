package es.file.json.tres;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public abstract class BasicOperationsHechizos {
    private ObjectMapper objectMapper;
    private File file;

    /**
     * Constructor con el path
     * @param path path del documento
     */
    protected BasicOperationsHechizos(String path){
        file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        objectMapper = new ObjectMapper();
    }


    /**
     * Funcion que pasa los datos de un fichero json a una lista
     * @return Set con los datos
     */
    public Set<Hechizo>leerFichero(){
        try {  
            return objectMapper.readValue(file, new TypeReference<Set<Hechizo>>(){});
        } catch (Exception e) {
            return new HashSet<>();
        } 
    }

    /**
     * Funcion que escribe en el fichero json los datos de un set
     * @param set con los datos a aniadir en el json
     * @return true/false
     */
    public boolean writeFichero(Set<Hechizo> set){
        try {
            objectMapper.writeValue(file, set);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
