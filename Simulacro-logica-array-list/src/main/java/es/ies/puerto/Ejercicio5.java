package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * @author nexxphernadez
 * @version 1.0.0
 * Ejercicio 5: Invertir una Lista
 * Escribe una función que revierta el orden de los elementos en una lista.
 * Función: reverseList
 * Entrada:
 * Lista de números: [1, 2, 3, 4]
 * Salida: [4, 3, 2, 1]
 */
public class Ejercicio5 {
    static List<Integer> reverseListInput = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

    public static void main(String[] args) {
        
    }

    /**
     * función que revierte el orden de los elementos en una lista
     * @param list a revertir el orden
     * @return lista con el orden invertido
     */
    public static List<Integer> reverseList(List<Integer> list) {
        if (list.isEmpty() || list == null || list.contains(null)) {
            return new ArrayList<>();
        }
        Collections.reverse(list);
        return list;
    }
}
