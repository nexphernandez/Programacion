package es.ies.puerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio3 {
    /**
     * Funcion para obtener el ultimo viernes del mes
     * @param anio anio del cual obtener el ultimo viernes del mes
     * @param mes mes para obtener el ultimo viernes del mes
     * @return LocalDate del ultimo viernes del mes/null
     */
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
