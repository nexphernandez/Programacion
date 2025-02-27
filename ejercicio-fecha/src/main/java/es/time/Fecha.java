package es.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.*;

public class Fecha {

    public LocalDateTime obtenerFechaHoraActual() {
        return null;
    }

    public LocalDate obtenerFechaActual() {
        return null;
    }

    public LocalDate convertirStringALocalDate(String fechaStr, String formato) {
        return null;
    }

    public String formatearFecha(LocalDate fecha, String formato) {
        return null;
    }

    public int calcularEdad(LocalDate fechaNacimiento) {
        return 0;
    }

    public LocalDate sumarDias(LocalDate fecha, int dias) {
        return null;
    }

    public LocalDate restarDias(LocalDate fecha, int dias) {
        return null;
    }

    public LocalDate sumarMeses(LocalDate fecha, int meses) {
        return null;
    }

    public LocalDate restarMeses(LocalDate fecha, int meses) {
        return null;
    }

    public long diferenciaDias(LocalDate fecha1, LocalDate fecha2) {
        return 0l;    }

    public long diferenciaMeses(LocalDate fecha1, LocalDate fecha2) {
        return 0l;
    }

    public long diferenciaAnios(LocalDate fecha1, LocalDate fecha2) {
        return 0l;
        }

    public int compararFechas(LocalDate fecha1, LocalDate fecha2) {
        return 1000;
    }

    public boolean esBisiesto(LocalDate fecha) {
        return fecha.isLeapYear();
    }

    public String obtenerDiaSemana(LocalDate fecha) {
        return null;
    }

    public int obtenerDiaDelAnio(LocalDate fecha) {
        return -1;
    }

    public LocalDate obtenerPrimerDiaMes(LocalDate fecha) {
        return null;
    }

    public LocalDate obtenerUltimoDiaMes(LocalDate fecha) {
        return null;
    }

    public ZonedDateTime convertirZonaHoraria(LocalDateTime fechaHora, String zona) {
        return null;
    }


    public Duration calcularDiferenciaHorasMinutos(LocalDateTime inicio, LocalDateTime fin) {
        return null;
    }
}
