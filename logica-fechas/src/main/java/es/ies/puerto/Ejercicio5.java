package es.ies.puerto;

import java.time.LocalDate;

public class Ejercicio5 {
    public static String obtenerDiaDeLaSemanaEnElFuturo(LocalDate fecha, int dias) {
        if (fecha == null) {
            return null;
        }
        String dia = fecha.plusDays(dias).getDayOfWeek().toString();
        return dia;
    }
}
