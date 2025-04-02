package Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ReservaFamiliar extends Reserva {
    private String apellido;
    private int cantidadPersonas;
    private String alimento;
    private List<String> bebidas;

    public ReservaFamiliar(Customer cliente, Event evento, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
            String apellido, int cantidadPersonas, String alimento, List<String> bebidas) {
        super(cliente, evento, fecha, horaInicio, horaFin);
        this.apellido = apellido;
        this.cantidadPersonas = cantidadPersonas;
        this.alimento = alimento;
        this.bebidas = bebidas;
    }
}
