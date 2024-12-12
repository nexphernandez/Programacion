package es.ies.puerto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * @author nexphernandez
 * @version 1.0.0
 * Ordenar elementos
 * Función: ordenarVector()
 * Descripción: Ordenar un vector con números aleatorios en orden ascendente.
 * Métodos a utilizar: add(), sort() (de Collections).
 * Resultado esperado: Antes: [4, 2, 5, 1, 3]. Después: [1, 2, 3, 4, 5]
 */
public class Ejercicio5 {
    static Vector<Integer> numeros = new Vector<>(Arrays.asList(4, 2, 5, 1, 3));
    public static void main(String[] args) {
        ordenarVector(numeros);
        System.out.println(numeros);
    }
    /**
     * Metodo que ordena una lista
     * @param lista lista a ordenar
     */
    public static void ordenarVector(List<Integer> lista){
        if (lista.isEmpty() || lista == null) {
            return;
        }
        Collections.sort(lista);
    }
}