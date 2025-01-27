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

public class Ejercicio3 {
    
    public static Map<String, ZonedDateTime> convertirZonasHorarias(
            LocalDateTime fechaHora, ZoneId zonaOrigen, List<ZoneId> zonasDestino) {
            if (fechaHora == null || zonaOrigen == null || zonasDestino == null) {
                return new HashMap<>();
            }
            Map<String, ZonedDateTime> mapa = new HashMap<>();
            ZonedDateTime zonedDateTime = ZonedDateTime.of(fechaHora, zonaOrigen);

                
            for (int i = 0; i < zonasDestino.size(); i++) {
                ZoneId zona = zonasDestino.get(i);
                ZonedDateTime zonedDateTime2 = zonedDateTime.withZoneSameInstant(zona);
                mapa.put(zona.toString(), zonedDateTime2);
            }            
        return mapa;
    }
}
