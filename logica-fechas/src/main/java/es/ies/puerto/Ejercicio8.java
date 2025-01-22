package es.ies.puerto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ejercicio8 {
    public static long diasDesdeInicioDelanio(LocalDate fecha) {
        if (fecha == null) {
            return -1L;
        }
        LocalDate primerDiaDelAnio = LocalDate.of(fecha.getYear(), 1,1);
        return ChronoUnit.DAYS.between(primerDiaDelAnio, fecha) + 1;
    }
}
