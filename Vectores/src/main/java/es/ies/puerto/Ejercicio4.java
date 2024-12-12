package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author nexphernandez
 * @version 1.0.0
 * Copiar elementos a otro vector
 * Función: copiarElementosPares()
 * Descripción: Copiar números pares de un vector a otro.
 * Métodos a utilizar: add(), get(), addAll().
 * Resultado esperado: Vector original: [1, 2, 3, 4, 5]. Vector pares: [2, 4].
 */
public class Ejercicio4 {
    static Vector<Integer> numeros = new Vector<>(Arrays.asList(1,2,3,4,5));
    public static void main(String[] args) {
        Vector<Integer> pares = new Vector<>(copiarElementosPares(numeros));
        System.out.println(pares);
    }
    /**
     * Funcion para copiar los elementos pares de una lista en otra
     * @param lista a copiar los elemetos
     * @return lista con los elementos pares
     */
    public static List<Integer> copiarElementosPares(List<Integer> lista){
        List<Integer> numeros = new ArrayList<>();
        if (lista.isEmpty() || lista == null) {
            return numeros;
        }
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) % 2 == 0) {
                numeros.add(lista.get(i)); 
             }
        }
        return numeros;
    }
}