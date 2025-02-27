package es.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.*;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Fecha {

    /**
     * Funcion que obtiene la fecha y hora actual
     * @return fecha y hora actual
     */
    public LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now();
    }

    /**
     * Funcion que obtiene la fecha actual
     * @return fecha actual
     */
    public LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }

    /**
     * Funcion que converte una fecha en strin a localdate
     * @param fechaStr a convertir
     * @param formato requerido
     * @return LocalDate con el formato/null
     */
    public LocalDate convertirStringALocalDate(String fechaStr, String formato) {
        if (fechaStr == null || fechaStr.isEmpty() || formato == null || formato.isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return LocalDate.parse(fechaStr, formatter);
    }

    /**
     * Funcion que cambia el fromato de una fecha
     * @param fecha a al cual cambiar el formato
     * @param formato que dar a la fecha
     * @return LocaDate con el fromato cambiado/null
     */
    public String formatearFecha(LocalDate fecha, String formato) {
        if (fecha == null|| formato == null || formato.isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return fecha.format(formatter);
    }

    /**
     * Funcion que calcula la edad por la fecha de nacimiento
     * @param fechaNacimiento necesaria para calcular la edad
     * @return edad/0
     */
    public int calcularEdad(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            return 0;
        }
        LocalDate actual = obtenerFechaActual();
        Period periodo = Period.between(fechaNacimiento, actual);
        return periodo.getYears();
    }

    /**
     * Funcion que suma dias a una fecha
     * @param fecha donde sumar los dias
     * @param dias a sumar
     * @return LocalDate con los dias sumados/null
     */
    public LocalDate sumarDias(LocalDate fecha, int dias) {
        if (fecha == null) {
            return null;
        }
        return fecha.plusDays(dias);
    }

    /**
     * Funcion que resta dias a una fecha
     * @param fecha donde restar los dias
     * @param dias a restar
     * @return LocalDate con los dias restados/null
     */
    public LocalDate restarDias(LocalDate fecha, int dias) {
        if (fecha == null) {
            return null;
        }
        return fecha.minusDays(dias);
    }

    /**
     * Funcion que suma meses a una fecha
     * @param fecha donde sumar los meses
     * @param meses a sumar
     * @return LocalDate con los meses sumados/null
     */
    public LocalDate sumarMeses(LocalDate fecha, int meses) {
        if (fecha == null) {
            return null;
        }
        return fecha.plusMonths(meses);
    }

    /**
     * Funcion que resta meses a una fecha
     * @param fecha donde restar los meses
     * @param meses a restar
     * @return LocalDate con los meses restados/null
     */
    public LocalDate restarMeses(LocalDate fecha, int meses) {
        if (fecha == null) {
            return null;
        }
        return fecha.minusMonths(meses);
    }

    /**
     * Funcion que calcula la diferencia en dias entre dos fechas
     * @param fecha1 a calcular la diferencia
     * @param fecha2 a calcular la diferencia
     * @return numero de dias/-1
     */
    public long diferenciaDias(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1 == null || fecha2 == null) {
            return -1;
        }
        Period periodo = Period.between(fecha1, fecha2);
        return periodo.getDays();    
    }

    /**
     * Funcion que calcula la diferencia en meses entre dos fechas
     * @param fecha1 a calcular la diferencia
     * @param fecha2 a calcular la diferencia
     * @return numero de meses/-1
     */
    public long diferenciaMeses(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1 == null || fecha2 == null) {
            return -1;
        }
        Period periodo = Period.between(fecha1, fecha2);
        return periodo.getMonths(); 
    }

    /**
     * Funcion que calcula la diferencia en anios entre dos fechas
     * @param fecha1 a calcular la diferencia
     * @param fecha2 a calcular la diferencia
     * @return numero de anios/-1
     */
    public long diferenciaAnios(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1 == null || fecha2 == null) {
            return -1;
        }
        Period periodo = Period.between(fecha1, fecha2);
        return periodo.getYears(); 
    }


    /**
     * Funcion que compara dos fechas
     * @param fecha1 a comparar
     * @param fecha2 a comparar
     * @return 0 si se puede comparar/ -1 si no
     */
    public int compararFechas(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1 == null || fecha2 == null) {
            return -1;
        }
        return fecha1.compareTo(fecha2);
    }

    /**
     * Funcion que verifica si un anio es bisiesto o no
     * @param fecha a verificar
     * @return true/false
     */
    public boolean esBisiesto(LocalDate fecha) {
        if (fecha == null) {
            return false;
        }
        return fecha.isLeapYear();
    }

    /**
     * Funcion que obtiene el dia de la semana
     * @param fecha a obtener el dia
     * @return dia de la semana/null
     */
    public String obtenerDiaSemana(LocalDate fecha) {
        if (fecha == null) {
            return null;
        }
        return fecha.getDayOfWeek().toString();
    }

    /**
     * Funcion que obtiene el dia de la anio
     * @param fecha a obtener el dia
     * @return dia de la anio/null
     */
    public int obtenerDiaDelAnio(LocalDate fecha) {
        if (fecha == null) {
            return 0;
        }
        return fecha.getDayOfYear();
    }

    /**
     * Funcion que obtiene el primer dia del mes
     * @param fecha donde obtener el dia
     * @return fecha con el primer dia del mes/null
     */
    public LocalDate obtenerPrimerDiaMes(LocalDate fecha) {
        if (fecha == null) {
            return null;
        }
        return fecha.withDayOfMonth(1);
    }

    /**
     * Funcion que obtiene el ultimo dia del mes
     * @param fecha donde obtener el dia
     * @return fecha con el ultimo dia del mes/null
     */
    public LocalDate obtenerUltimoDiaMes(LocalDate fecha) {
        if (fecha == null) {
            return null;
        }
        
        return fecha.withDayOfMonth(fecha.lengthOfMonth());
    }

    /**
     * Funcion que cambia la hora segun la zona horaria
     * @param fechaHora a cambiar
     * @param zona a la cual cambiar la hora
     * @return Fecha con la zona horaria cambiada/null
     */
    public ZonedDateTime convertirZonaHoraria(LocalDateTime fechaHora, String zona) {
        if (fechaHora == null || zona == null || zona.isEmpty()) {
            return null;
        }
        ZoneId zoneId = ZoneId.of(zona);
        return ZonedDateTime.of(fechaHora, zoneId);
    }

    /**
     * Funcion que calcula la diferencia de dos fechas en horas y minutos
     * @param inicio a calcular
     * @param fin a calcular
     * @return la diferencia/null
     */
    public Duration calcularDiferenciaHorasMinutos(LocalDateTime inicio, LocalDateTime fin) {
        if (inicio == null || fin == null) {
            return null;
        }
        return Duration.between(inicio, fin);
    }
}
