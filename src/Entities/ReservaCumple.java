package Entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaCumple extends Reserva {
    private String nombreCumpleanero;
    private int edad;
    private String colorFavorito;
    private String regalo;
    private int cantidadPersonas;
    private String alimento; // temporalmente como String

    public ReservaCumple(Customer cliente, Event evento, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
            String nombreCumpleanero, int edad, String colorFavorito,
            String regalo, int cantidadPersonas, String alimento) {
        super(cliente, evento, fecha, horaInicio, horaFin);
        this.nombreCumpleanero = nombreCumpleanero;
        this.edad = edad;
        this.colorFavorito = colorFavorito;
        this.regalo = regalo;
        this.cantidadPersonas = cantidadPersonas;
        this.alimento = alimento;
    }

   
}
