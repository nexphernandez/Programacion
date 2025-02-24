package es.file.json;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public abstract class BasicOperations {
    private static ObjectMapper objectMapper;

    /**
     * Constructor vacio
     */
    protected BasicOperations(){
        objectMapper = new ObjectMapper();
    }

    /**
     * Funcion que pasa los datos de un fichero json a una lista
     * @param <T> Tipo generico de los elementos de la lista
     * @param file json con los datos
     * @param typeReference de la lista con el tipo generico
     * @return Lista con los datos
     */
    public static <T> List<T>leerFichero(File file, TypeReference<List<T>> typeReference){
        try {  
            return objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } 
    }

    /**
     * Funcion que escribe en el fichero json los datos de un set
     * @param <T> Tipo generico de los elemenos del set
     * @param set con los datos a aniadir en el json
     * @param file donde aniadir los datos
     * @return true/false
     */
    public static <T> boolean writeFichero(Set<T> set, File file){
        try {
            objectMapper.writeValue(file, set);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
