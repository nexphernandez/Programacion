package es.ies.puerto;

import java.time.LocalDate;
import java.time.Month;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio6 {
    /**
     * Funcion para obtener cuantos dias fines de semana tiene un mes
     * @param anio anio 
     * @param mes mes
     * @return dias fines de semana / -1
     */
    public static int obtenerFinesDeSemana(int anio, Month mes) {
        if (mes == null || anio < 1) {
            return -1;
        }
        LocalDate localDate = LocalDate.of(anio, mes, 1);
        int contador = 0;
        
        while (localDate.getMonth() == mes) {
            if (localDate.getDayOfWeek().getValue() == 6|| localDate.getDayOfWeek().getValue() == 7) {
                contador++;
            }
            localDate = localDate.plusDays(1);
        }
        return contador;
    }
}
