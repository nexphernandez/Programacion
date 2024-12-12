package es.ies.puerto;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author nexphernandez
 * @version 1.0.0
 * Calcular el promedio de números
 * Función: calcularPromedio()
 * Descripción: Calcular el promedio de calificaciones almacenadas en un vector.
 * Métodos a utilizar: add(), size(), get().
 * Resultado esperado: Calificaciones: [80.0, 90.0, 70.0]. Promedio: 80.0.
 */
public class Ejercicio10 {
    static Vector<Float> numeros = new Vector<>(Arrays.asList(80.0f, 90.0f, 70.0f));
    public static void main(String[] args) {
        System.out.println(calcularPromedio(numeros));
    }
    /**
     * Funcion para calcular el promedio de numero en una lista
     * @param lista a calcular el promedio
     * @return promedio
     */
    public static float calcularPromedio(List<Float>lista){
        float suma = 0;
        for (float numero : lista) {
            suma += numero;
        }
        float promedio = suma/lista.size();
        return promedio;
    }
}