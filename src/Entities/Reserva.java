package Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import Utils.ReservaUtils;

public abstract class Reserva {
    protected String idReserva;
    protected Customer cliente;
    protected Event evento;
    protected LocalDate fecha;
    protected LocalTime horaInicio;
    protected LocalTime horaFin;
    protected boolean concretada;

    public Reserva(Customer cliente, Event evento, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.cliente = cliente;
        this.evento = evento;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.concretada = false;
        this.idReserva = ReservaUtils.generarId(fecha);  // genera ID único al crear la reserva
    }

    public String getIdReserva() {
        return idReserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public boolean isConcretada() {
        return concretada;
    }

    public Customer getCliente() {
        return cliente;
    }

    public Event getEvento() {
        return evento;
    }

    public void setConcretada(boolean concretada) {
        this.concretada = concretada;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    
}
