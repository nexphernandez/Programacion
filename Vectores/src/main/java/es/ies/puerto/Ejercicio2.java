package es.ies.puerto;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author nexphernandez
 * @version 1.0.0
 * Obtener y modificar elementos
 * Función: modificarElementoVector()
 * Descripción: Crear un vector de números enteros, mostrar el tercer elemento y cambiarlo.
 * Métodos a utilizar: get(), set().
 * Resultado esperado: Antes: 5, Después: [1, 2, 10, 4, 5].
 */
public class Ejercicio2 {
    static Vector<Integer> numeros = new Vector<>(Arrays.asList(1,2,3,4,5));
    public static void main(String[] args) {
        System.out.println(numeros);
        modificarElementoVector(numeros, 2, 10);
        System.out.println(numeros);
    }
    /**
     * Funcion para modificar elementos de un vector en una posicion especifica
     * @param lista donde modificar un elemento
     * @param posicion donde se encuetra el elemento a cambiar
     * @param valor a cambiar por el elemento
     * @return true/false
     */
    public static boolean modificarElementoVector(List<Integer> lista, int posicion, int valor){
        if (lista.isEmpty() || lista == null) {
            return false;
        }
        if (posicion < 0 || posicion > lista.size()) {
            return false;
        }
        lista.set(posicion, valor);
        return true;
    }
}