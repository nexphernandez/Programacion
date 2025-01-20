package es.ies.puerto;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateUtils {


    public static Date createDate() {
        return new Date();
    }

    public static boolean compareDates(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        return date1.before(date2);
    }

    public static Date addDaysToDate(Date date, int days) {
        if (date == null) {
            return date;
        }
        LocalDateTime localDateTime = date.toInstant()
                                        .atZone(ZoneId.systemDefault())
                                        .toLocalDateTime();
        localDateTime = localDateTime.plusDays(days);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        return format.format(date);
    }

    public static long calculateDateDifference(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
           return  -1l;
        }
        LocalDate fecha1 = date1.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
        LocalDate fecha2 = date2.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
        Period diferencia = (Period.between(fecha2, fecha1));
        return diferencia.getDays();
    }

    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    public static LocalDate createSpecificLocalDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    public static LocalDate addDays(LocalDate date, int days) {
        if (date == null) {
            return date;
        }
        return date.plusDays(days);
    }

    public static boolean isBefore(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        return date1.isBefore(date2);
    }

    public static Period calculatePeriodBetween(LocalDate start, LocalDate end) {
        if (start == null || end == null) {
            return null;
        }
        return Period.between(start, end);
    }

    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();    
    }

    public static LocalTime addMinutes(LocalTime time, int minutes) {
        if (time == null) {
            return null;
        }
        
        return time.plusMinutes(minutes);
    }

    public static boolean isTimeBefore(LocalTime time1, LocalTime time2) {
        if (time1 == null || time2 == null) {
            return false;
        }
        return time1.isBefore(time2);
    }

    
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    public static LocalDateTime addHours(LocalDateTime dateTime, int hours) {
        if (dateTime == null) {
            return dateTime;
        }
        return dateTime.plusHours(hours);
    }

    public static LocalDateTime subtractMonths(LocalDateTime dateTime, int months) {
        if (dateTime == null) {
            return dateTime;
        }
        return dateTime.minusMonths(months);
    }

    public static ZonedDateTime getZonedDateTime(String zoneId) {
        if (zoneId == null) {
            return null;
        }
        
        return ZonedDateTime.now(ZoneId.of(zoneId));
    }

    public static ZonedDateTime convertZone(ZonedDateTime dateTime, String targetZoneId) {
        if (dateTime == null || targetZoneId == null) {
            return null;
        }
        return dateTime.withZoneSameInstant(ZoneId.of(targetZoneId));
    }

    public static LocalDate getFirstDayOfMonth(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.with(TemporalAdjusters.firstDayOfMonth());
    }

    public static LocalDate getLastDayOfMonth(LocalDate date) {
        if (date == null) {
            return date;
        }
        return date.with(TemporalAdjusters.lastDayOfMonth());
    }

    public static boolean isLeapYear(LocalDate date) {
        if (date == null) {
            return false;
        }
        return date.isLeapYear();
    }

    public static Duration measureExecutionTime(Runnable task) {
        if (task == null) {
            return null;
        }
        Instant start = Instant.now();
        task.run();
        Instant stop = Instant.now();
        return Duration.between(start, stop);
    }

    public static LocalDate parseDate(String date, String format) throws DateTimeParseException {
        if (date == null || format == null) {
            return null;
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date,formato);
    }

    public static void main(String[] args) {
        System.out.println("Vamos a probar los algoritmos");
    }
}