package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author nexphernandez
 * @version 1.0.0
 * Fusionar dos vectores
 * Función: fusionarVectores()
 * Descripción: Combinar dos vectores y eliminar duplicados.
 * Métodos a utilizar: add(), contains().
 * Resultado esperado: Vector A: [Perro, Gato]. Vector B: [Gato, Caballo]. Combinado: [Perro, Gato, Caballo]
 */
public class Ejercicio8 {
    static Vector<String> vectorA = new Vector<>(Arrays.asList("Perro", "Gato"));
    static Vector<String> vectorB = new Vector<>(Arrays.asList("Gato", "Caballo"));
    public static void main(String[] args) {
        Vector<String> resultado = new Vector<>(fusionarVectores(vectorA, vectorB));
        System.out.println(resultado);
        System.out.println(vectorA);
        System.out.println(vectorB);
    }
    /**
     * Funcion que fuciona dos lista
     * @param lista1 a fucionar
     * @param lista2 a fucionar
     * @return lista fucionada
     */
    public static List<String> fusionarVectores(List<String>lista1, List<String>lista2){
        if (lista1.isEmpty() || lista1.isEmpty() ) {
            return new ArrayList<>();
        }
        if (lista2.isEmpty() || lista2.isEmpty() ) {
            return new ArrayList<>();
        }
        List<String> resultado = new ArrayList<>();
        resultado.addAll(lista1);
        for (String palabra : lista2) {
            if (!resultado.contains(palabra)) {
                resultado.add(palabra);
            }
        }
        return resultado;
    }
}