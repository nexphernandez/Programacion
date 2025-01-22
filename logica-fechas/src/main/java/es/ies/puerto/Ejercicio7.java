package es.ies.puerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class Ejercicio7 {
    public static LocalDate obtenerDiaDeLaMadre(int anio) {
        if (anio <1) {
            return null;
        }
        LocalDate primerDiaDeMayo = LocalDate.of(anio, Month.MAY, 1);
        LocalDate primerDomingoMayo = primerDiaDeMayo.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate segundoDomingoMayo = primerDomingoMayo.plusWeeks(1);
        return segundoDomingoMayo;
    }
}
