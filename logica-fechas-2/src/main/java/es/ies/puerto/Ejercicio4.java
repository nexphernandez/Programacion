package es.ies.puerto;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio4 {
    
    /**
     * Funcion para obtener los dias bisiestos de un anio desde la fecha actual
     * @param aniosFuturos anios futuros
     * @return Lista con los dias bisiestos
     */
    public static List<LocalDate> obtenerDiasBisiestos(int aniosFuturos) {
        if (aniosFuturos <= 0) {
            throw new IllegalArgumentException("El número de años futuros debe ser mayor a 0.");
        }
        LocalDate localDate = LocalDate.now();
        List<LocalDate> lista = new ArrayList<>();
        for (int i = 0; i <= aniosFuturos; i++) {
            LocalDate temporal = localDate.plusYears(i);
            if (temporal.isLeapYear()) {
                lista.add(temporal.of(temporal.getYear(),Month.FEBRUARY, 29));
            }
        }
        return lista;
    }
}
