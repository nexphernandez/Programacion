package es.ies.puerto;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author nexphernandez 
 * @version 1.0.0
 * Verificar si un elemento está presente
 * Función: verificarPresenciaElemento()
 * Descripción: Verificar si un país ingresado por el usuario está en el vector.
 * Métodos a utilizar: add(), contains().
 * Resultado esperado: País: "España". Resultado: true o false.
 */
public class Ejercicio6 {
    static Vector<String> paises = new Vector<>(Arrays.asList("España", "Francia", "Portugal"));
    public static void main(String[] args) {
        System.out.println(verificarPresenciaElemento(paises, "España"));
    }
    /**
     * Funcion que verifica si el elemento ingresado se encuentra en la lista o no
     * @param lista a verificar
     * @param palabra a buscar
     * @return true/false
     */
    public static boolean verificarPresenciaElemento(List<String>lista, String palabra){
        if (lista.isEmpty() || lista == null) {
            return false;
        }
        if (lista.contains(palabra)) {
            return true;
        }
        return false;
    }
}