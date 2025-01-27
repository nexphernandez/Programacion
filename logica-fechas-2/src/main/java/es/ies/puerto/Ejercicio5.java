package es.ies.puerto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.time.Duration;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio5 {
    
    /**
     * Funcion que calcula la edad en milisegundos a partir de la fecha de nacimiento
     * @param fechaNacimiento fecha de nacimiento
     * @return edad en milisegundos
     */
    public static long calcularEdadEnMilisegundos(LocalDateTime fechaNacimiento) {
        if (fechaNacimiento == null) {
            return -1l;
        }
        Duration duration = Duration.between(fechaNacimiento, LocalDateTime.now());
        return duration.toMillis();
    }
}
