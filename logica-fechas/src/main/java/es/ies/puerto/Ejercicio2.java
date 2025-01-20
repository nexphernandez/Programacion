package es.ies.puerto;

import java.time.LocalDate;
import java.time.Month;

public class Ejercicio2 {

    public static int obtenerDiasDelMes(int anio, Month mes) {
        if (mes == null || anio < 1) {
            return -1;
        }
        LocalDate localDate = LocalDate.of(anio, mes.getValue(),1);
        if (localDate.isLeapYear()) {
            return 29;
        }
        int numMes = localDate.getDayOfMonth();
        return numMes ;
    }
}
