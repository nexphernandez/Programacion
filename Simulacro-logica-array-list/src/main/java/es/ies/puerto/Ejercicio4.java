package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Ejercicio 4: Eliminar los Elementos Más Pequeños hasta que Queden N
 * Crea una función que elimine los elementos más pequeños de una lista hasta que queden exactamente N
 * elementos.
 * Función: reduceToSizeN
 * Entrada:
 * Lista de números: [5, 1, 8, 3, 2]
 * Tamaño N: 3
 * Salida: [5, 8, 3]
 */
public class Ejercicio4 {
  
    static List<Integer> reduceList = new ArrayList<>(Arrays.asList(5, 1, 8, 3, 2));

    public static void main(String[] args) {
    
    } 
  
    /**
     * función que elimina los elementos más pequeños de una lista hasta que queden exactamente N
     * @param list a eliminar elementos
     * @param n tamanio de la lista final
     * @return lista final
     */
    public static List<Integer> reduceToSizeN(List<Integer> list, int n) {
        if (list == null || list.contains(null) || list.isEmpty()) {
            return new ArrayList<>();
        }

        while (list.size() > n) {
            list.remove(Collections.min(list));
        }
        return list;
    }

}
