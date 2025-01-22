package es.ies.puerto;

import java.time.LocalDate;
import java.time.Month;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio2 {

    /**
     * Funcion para obtener los dias de un mes
     * @param anio anio del cual obtener los dia del mes
     * @param mes mes del cual obtener los dias del mes
     * @return dias del mes / -1
     */
    public static int obtenerDiasDelMes(int anio, Month mes) {
        if (mes == null || anio < 1) {
            return -1;
        }
        LocalDate localDate = LocalDate.of(anio, mes,1);
        return localDate.lengthOfMonth();
    }
}
