package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Ejercicio 2: Verificar si Todos los Elementos Son Pares
 * Escribe una función que verifique si todos los números en una lista son pares.
 * Función: allEven
 * Entrada:
 * Lista de números: [2, 4, 6, 8]
 * Salida: true
 */
public class Ejercicio2 {
    static List<Integer> evenList = new ArrayList<>(Arrays.asList(2, 4, 6, 8));

    public static void main(String[] args) {
    
    }

    /**
     * Funcion que verifique que todos los elementos son pares o no
     * @param list a verificar
     * @return true/false
     */
    public static boolean allEven(List<Integer> list) {
        if (list.contains(null)) {
            return false;
        }
        if (list.isEmpty()) {
            return true;
        }
        if (list == null) {
            return false;
        }
        for (Integer numero : list) {
            if (numero %2 != 0) {
                return false;
            }
        }
        return true;
    }
}