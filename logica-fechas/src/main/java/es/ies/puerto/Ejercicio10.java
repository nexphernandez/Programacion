package es.ies.puerto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio10 {
    /**
     * Funcion que calcula la diferencia de dias respecto a dos fecha
     * @param fecha1 primera fecha a verificar
     * @param fecha2 segunda fecha a verificar
     * @return diferencia de dias / null
     */
    public static long calcularDiferenciaEnDias(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1 == null || fecha2 == null) {
            return -1l;
        }
        return ChronoUnit.DAYS.between(fecha1, fecha2);
    }
}
