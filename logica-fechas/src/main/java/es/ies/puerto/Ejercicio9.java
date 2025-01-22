package es.ies.puerto;

import java.time.LocalDate;

public class Ejercicio9 {
    public static LocalDate obtenerPrimerLunesDelMes(int anio, int mes) {
        if (mes < 1 || anio < 1 || mes > 12) {
            return null;            
        }
        LocalDate localDate = LocalDate.of(anio, mes, 1);
        while (localDate.getDayOfWeek().getValue() != 1) {
            localDate = localDate.plusDays(1);
        }
        return localDate;
    }
}
