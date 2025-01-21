package es.ies.puerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class Ejercicio3 {
    public static LocalDate obtenerUltimoViernes(int anio, Month mes) {
        if (mes == null || anio < 1) {
            return null;
        }
        int ultimoDia = mes.length(Year.isLeap(anio));
        LocalDate localDate = LocalDate.of(anio, mes, ultimoDia);
        while (localDate.getDayOfWeek() != DayOfWeek.FRIDAY) {
            localDate = localDate.minusDays(1);
        }
        return localDate;
    }
}
