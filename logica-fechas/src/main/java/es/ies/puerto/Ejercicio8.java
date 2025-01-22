package es.ies.puerto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio8 {
    /**
     * Funcion que respecto a una fecha devuleve cuantos dias hay desde el inicio del anio
     * @param fecha fecha a verificar
     * @return dias desde principio de anio / -1l
     */
    public static long diasDesdeInicioDelanio(LocalDate fecha) {
        if (fecha == null) {
            return -1L;
        }
        LocalDate primerDiaDelAnio = LocalDate.of(fecha.getYear(), 1,1);
        return ChronoUnit.DAYS.between(primerDiaDelAnio, fecha) + 1;
    }
}
