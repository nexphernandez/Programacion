package es.ies.puerto;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.Set;
import java.util.HashSet;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio4 {
    /**
     * Funcion para saber si un dia es festivo nacional
     * @param fecha fecha para saber si es festivo
     * @return true/false
     */
    public static boolean esDiaFestivoNacional(LocalDate fecha) {
        if (fecha == null) {
            return false;
        }
        Set<MonthDay> diasFestivos = new HashSet<>();
        diasFestivos.add(MonthDay.of(Month.JANUARY, 1));
        diasFestivos.add(MonthDay.of(Month.JANUARY, 6));
        diasFestivos.add(MonthDay.of(Month.DECEMBER, 25));
        MonthDay diaMes = MonthDay.from(fecha);
        return (diasFestivos.contains(diaMes));
    }
}
