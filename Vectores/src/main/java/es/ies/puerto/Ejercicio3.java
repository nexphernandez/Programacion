package es.ies.puerto;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author nexphernandez
 * @version 1.0.0
 * Eliminar elementos por condición
 * Función: eliminarPorCondicion()
 * Descripción: Eliminar colores que comiencen con "A".
 * Métodos a utilizar: add(), remove(), startsWith().
 * Resultado esperado: Vector antes: [Azul, Amarillo, Verde, Anaranjado]. Vector después: [Verde].
 */
public class Ejercicio3 {
    static Vector<String> colores = new Vector<>(Arrays.asList("Azul", "Amarillo", "Verde", "Anaranjado"));
    public static void main(String[] args) {
        System.out.println(colores);
        eliminarPorCondicion(colores, "A");
        System.out.println(colores);
    }
    /**
     * Funcion que elimina elementos de una lista por una condicion
     * @param lista a eliminar elementos
     * @param letra condicion a eliminar
     * @return true/false
     */
    public static boolean eliminarPorCondicion(List<String> lista, String letra){
        if (lista.isEmpty() || lista == null) {
            return false;
        }
        if (letra == null || letra.isEmpty()) {
            return false;
        }
        return lista.removeIf(palabra -> palabra.startsWith(letra));
        
    }
}