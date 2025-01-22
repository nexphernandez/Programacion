package es.ies.puerto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ejercicio10 {
    
    public static long calcularDiferenciaEnDias(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1 == null || fecha2 == null) {
            return -1l;
        }
        return ChronoUnit.DAYS.between(fecha1, fecha2);
    }
}
