package es.ies.puerto;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio1 {
    
    /**
     * Funcion que calcula la diferencia entre dfechas
     * @param fechaInicio fecha de inicio
     * @param fechaFin fecha final
     * @return LocalDateTime diferencia de fechas
     */
    public static LocalDateTime calcularDiferenciaFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        if (fechaFin == null || fechaInicio == null) {
            return null;
        }
        if (fechaFin == fechaInicio) {
            return fechaInicio;
        }
        if (fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha final.");
        }
    return fechaInicio.from(fechaFin);
    }
}
