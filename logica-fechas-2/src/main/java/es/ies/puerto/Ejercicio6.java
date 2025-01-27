package es.ies.puerto;

import java.time.LocalDateTime;
import java.util.List;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio6 {
    
    /**
     * Funcion para obtener el proximo eclipse
     * @param eclipses lista de eclipses
     * @param fechaReferencia fecha de referencia para saber el siguiente eclipse
     * @return fechahora del siguiente eclipse
     */
    public static LocalDateTime obtenerProximoEclipse(List<LocalDateTime> eclipses, LocalDateTime fechaReferencia) {
        if (fechaReferencia == null || eclipses.isEmpty() ||eclipses == null) {
            return null;
        }
        for (int i = 0; i < eclipses.size(); i++) {
            if (eclipses.get(i).isAfter(fechaReferencia)) {
                return eclipses.get(i);
            }
        }
        throw new IllegalArgumentException("No hay eclipse despues de la fecha de referencia");   
    }
}
