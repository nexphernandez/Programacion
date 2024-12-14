package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author nexphernandez
 * @verion 1.0.0
 * Ejercicio 3: Crear una Lista de Longitudes de Palabras
 * Escribe una función que reciba una lista de palabras y genere una nueva lista con las longitudes de cada
 * palabra.
 * Función: wordLengths
 * Entrada:
 * Lista de palabras: ["Hola", "Mundo", "Java"]
 * Salida: [4, 5, 4]
 */

public class Ejercicio3 {
    static List<String> words = new ArrayList<>(Arrays.asList("Hola", "Mundo", "Java"));

    public static void main(String[] args) {
        
    }

    /**
     * Funcion que recibe un lisa y genera otra con la longitud de cada palabra
     * @param words lista recibida
     * @return lista con las longitudes
     */
    public static List<Integer> wordLengths(List<String> words) {
        List<Integer> tamanioPalabras = new ArrayList<>();
        if (words == null) {
            return tamanioPalabras;
        }
        if (words.isEmpty()) {
            return tamanioPalabras;
        }
        if (words.contains(null)) {
            return tamanioPalabras;
        }
        for (String numero : words) {
            tamanioPalabras.add(numero.length());
        }
        return tamanioPalabras;
    }
}
