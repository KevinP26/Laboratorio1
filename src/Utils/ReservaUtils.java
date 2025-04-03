package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class ReservaUtils {
    public static String generarId(LocalDate fecha) {
        int numero = (int) (Math.random() * 99 + 1); // Número entre 1 y 99
        char letra1 = (char) ('A' + (int) (Math.random() * 26));
        char letra2 = (char) ('A' + (int) (Math.random() * 26));
        String fechaStr = fecha.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        return String.format("KB-%02dT%c%c-%s", numero, letra1, letra2, fechaStr);
    }
}
