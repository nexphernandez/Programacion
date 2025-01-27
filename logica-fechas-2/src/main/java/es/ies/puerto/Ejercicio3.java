package es.ies.puerto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Ejercicio3 {
    
    /**
     * Funcion que convierte la fechahora en otra segun la zona horaria
     * @param fechaHora fechahora de origen
     * @param zonaOrigen zona de origen
     * @param zonasDestino zona de destino
     * @return map con las distintas fechashoras
     */
    public static Map<String, ZonedDateTime> convertirZonasHorarias(
            LocalDateTime fechaHora, ZoneId zonaOrigen, List<ZoneId> zonasDestino) {
            if (fechaHora == null || zonaOrigen == null || zonasDestino == null) {
                return new HashMap<>();
            }
            Map<String, ZonedDateTime> mapa = new HashMap<>();
            ZonedDateTime zonedDateTime = ZonedDateTime.of(fechaHora, zonaOrigen);

                
            for (int i = 0; i < zonasDestino.size(); i++) {
                ZoneId zona = zonasDestino.get(i);
                ZonedDateTime zonedDateTime2 = zonedDateTime.toInstant().atZone(zona);
                mapa.put(zona.toString(), zonedDateTime2);
            }            
        return mapa;
    }
}
