package es.ies.puerto;

import java.util.Vector;

/**
 * @author nexphernandez
 * @version 1.0.0
 * Crear un vector y agregar elementos
 * Función: crearVectorFrutas()
 * Descripción: Crear un vector de tipo String y agregar cinco nombres de frutas.
 * Métodos a utilizar: add(), toString().
 * Resultado esperado: [Manzana, Banana, Cereza, Mango, Uva].
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        Vector<String> frutas = crearVectorFrutas();
        System.out.println(frutas);
    }
    /**
     * Funcion que agrega un elemento si no e null o esta vacio
     * @param vector donde agregar
     * @param elemento a agregar
     * @return true/false
     */
    public static boolean add(Vector<String> vector, String elemento){
        if (vector == null) {
            return false;
        }
        if (elemento == null || elemento.isEmpty()) {
            return false;
        }
        vector.add(elemento);
        return true;
    }
    /**
     * Funcion que crea un vector con elementos dentro
     * @return vector creado
     */
    public static Vector<String> crearVectorFrutas(){
        Vector<String> frutas = new Vector<>();
        add(frutas,"manzana");
        add(frutas,"pera");
        add(frutas,"sandia");
        add(frutas,"melon");
        add(frutas,"platano");
        return frutas;
    }
}