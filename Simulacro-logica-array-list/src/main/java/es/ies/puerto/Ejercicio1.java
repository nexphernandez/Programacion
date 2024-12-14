package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Reemplazar el Mínimo Elemento
 * Crea una función que encuentre el menor elemento en una lista, lo reemplace por un nuevo valor, y
 * devuelva la lista actualizada.
 * Función: replaceMinimum
 * Entrada:
 * Lista de números: [10, 5, 7, 3, 8]
 * Nuevo valor: 20
 * Salida: [10, 5, 7, 20, 8]
 */
public class Ejercicio1 {
    static List<Integer> replaceList = new ArrayList<>(Arrays.asList(10, 5, 7, 3, 8));
    static int newValue = 20;

    public static void main(String[] args) {

    }
    /**
     * Funcion que reemplaza el elemento minimo
     * @param list a remplazar
     * @param newValue elemento usado para cambiar el reemplazo
     * @return lista con el elemento reemplazado
     */
    public static List<Integer> replaceMinimum(List<Integer> list, int newValue) {

        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        if (list.contains(null)) {
            return new ArrayList<>();
        }
        list.set(list.indexOf(Collections.min(list)), newValue);   
        return list;
    }
}