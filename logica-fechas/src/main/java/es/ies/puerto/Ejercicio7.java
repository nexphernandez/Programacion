package es.ies.puerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio7 {
    /**
     * Funcion para obtener el dia de la madre (Paises segundo domingo de mayo)
     * @param anio anio en el que buscar
     * @return fecha del dia de la madre / null
     */
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
