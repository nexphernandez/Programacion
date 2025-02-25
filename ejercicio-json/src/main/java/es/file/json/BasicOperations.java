package es.file.json;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public abstract class BasicOperations {
    ObjectMapper objectMapper;
    File file;

    /**
     * Constructor vacio
     */
    protected BasicOperations(){
        objectMapper = new ObjectMapper();
    }

    /**
     * Constructor con el path
     * @param path path del documento
     */
    protected BasicOperations(String path){
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
     * @param <T> Tipo generico de los elementos de la lista
     * @param file json con los datos
     * @param typeReference de la lista con el tipo generico
     * @return Set con los datos
     */
    public  <T> Set<T>leerFichero(TypeReference<Set<T>> typeReference){
        try {  
            return objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            return new HashSet<>();
        } 
    }

    /**
     * Funcion que escribe en el fichero json los datos de un set
     * @param <T> Tipo generico de los elemenos del set
     * @param set con los datos a aniadir en el json
     * @param file donde aniadir los datos
     * @return true/false
     */
    public  <T> boolean writeFichero(Set<T> set){
        try {
            objectMapper.writeValue(file, set);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
