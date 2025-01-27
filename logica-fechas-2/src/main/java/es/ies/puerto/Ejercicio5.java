package es.ies.puerto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.time.Duration;

public class Ejercicio5 {
    
    public static long calcularEdadEnMilisegundos(LocalDateTime fechaNacimiento) {
        if (fechaNacimiento == null) {
            return -1l;
        }
        Duration duration = Duration.between(fechaNacimiento, LocalDateTime.now());
        return duration.toMillis();
    }
}
