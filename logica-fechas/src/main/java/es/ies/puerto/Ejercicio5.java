package es.ies.puerto;

import java.time.LocalDate;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio5 {
    /**
     * Funcion para obtener el dia de la semana sumando ciertos dias
     * @param fecha fecha inicial
     * @param dias dias a sumar
     * @return dia de la semana/null
     */
    public static String obtenerDiaDeLaSemanaEnElFuturo(LocalDate fecha, int dias) {
        if (fecha == null) {
            return null;
        }
        String dia = fecha.plusDays(dias).getDayOfWeek().toString();
        return dia;
    }
}
