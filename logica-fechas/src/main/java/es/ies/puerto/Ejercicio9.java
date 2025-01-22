package es.ies.puerto;

import java.time.LocalDate;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio9 {
    /**
     * Funcion para obtener el primer lunes del mes
     * @param anio anio donde buscar
     * @param mes mes donde buscar
     * @return feccha del primer lunes del mes / null
     */
    public static LocalDate obtenerPrimerLunesDelMes(int anio, int mes) {
        if (mes < 1 || anio < 1 || mes > 12) {
            return null;            
        }
        LocalDate localDate = LocalDate.of(anio, mes, 1);
        while (localDate.getDayOfWeek().getValue() != 1) {
            localDate = localDate.plusDays(1);
        }
        return localDate;
    }
}
