package es.ies.puerto;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author nexphernandez
 * @version 1.0.0
 * Contar elementos con una propiedad específica
 * Función: contarNombresLargos()
 * Descripción: Contar cuántos nombres tienen más de cinco caracteres.
 * Métodos a utilizar: add(), size(), length().
 * Resultado esperado: [Ana, Francisco, María, Alejandro]. Resultado: 2
 */
public class Ejercicio7 {
    static Vector<String> palabras = new Vector<>(Arrays.asList("Ana", "Francisco", "María", "Alejandro"));
    public static void main(String[] args) {
        System.out.println(contarNombresLargos(palabras, 5));
    } 
    /**
     * Funcion para contar nombres largo segun un tamaño
     * @param lista a contar los nombres largos
     * @param tamanio para ser un nombre largo
     * @return cuantos nombres largos hay
     */
    public static int contarNombresLargos(List<String> lista, int tamanio){
        if (lista.isEmpty() || lista == null) {
            return 0;
        }
        if (tamanio < 0) {
            return 0;
        }
        int contador = 0;
        for (String palabra : lista) {
            if (palabra.length() > tamanio) {
                contador ++;
            }
        }
        return contador;
    }
}