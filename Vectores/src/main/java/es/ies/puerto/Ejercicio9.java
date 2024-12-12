package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author nexphernandez
 * @version 1.0.0
 * Vector dinámico
 * Función: crearVectorDinamico()
 * Descripción: Crear un vector vacío y agregar números hasta que el usuario ingrese "0".
 * Métodos a utilizar: add(), toString().
 * Resultado esperado: Entrada: 1, 2, 3, 0. Vector: [1, 2, 3].
 */
public class Ejercicio9 {
    static Vector<Integer> numeros = new Vector<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Inserte numeros para hacer la lista, el numero 0 termina la lista:");
        crearVectorDinamico(numeros);
        System.out.println(numeros);
    }
    /**
     * Funcion para crear una lista dinamica
     * @param lista a crear
     * @return lista creada
     */
    public static List<Integer> crearVectorDinamico(List<Integer> lista){
        if (lista == null) {
            return new ArrayList<>();
        }
        int numero = sc.nextInt();
        while (numero != 0) {
            lista.add(numero);
            numero = sc.nextInt();
        }
        return lista;
    }
}