package es.ies.puerto;

import java.time.LocalDate;
import java.time.Month;

public class Ejercicio6 {
    public static int obtenerFinesDeSemana(int anio, Month mes) {
        if (mes == null || anio < 1) {
            return -1;
        }
        LocalDate localDate = LocalDate.of(anio, mes, 1);
        int contador = 0;
        
        while (localDate.getMonth() == mes) {
            if (localDate.getDayOfWeek().getValue() == 6|| localDate.getDayOfWeek().getValue() == 7) {
                contador++;
            }
            localDate = localDate.plusDays(1);
        }
        return contador;
    }
}
