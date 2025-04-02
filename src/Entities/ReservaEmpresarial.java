package Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ReservaEmpresarial extends Reserva {
    private String empresa;
    private String tematica;
    private String vestimenta;
    private boolean postre;
    private int cantidadPersonas;
    private String alimento;
    private List<String> bebidas;

    public ReservaEmpresarial(Customer cliente, Event evento, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
            String empresa, String tematica, String vestimenta, boolean postre,
            int cantidadPersonas, String alimento, List<String> bebidas) {
        super(cliente, evento, fecha, horaInicio, horaFin);
        this.empresa = empresa;
        this.tematica = tematica;
        this.vestimenta = vestimenta;
        this.postre = postre;
        this.cantidadPersonas = cantidadPersonas;
        this.alimento = alimento;
        this.bebidas = bebidas;
    }
}
