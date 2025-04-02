package Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservaService {
    private List<Reserva> reservas = new ArrayList<>();
    
    private FoodMenu menuComidaNormal = MenuLoader.getMenuComidaNormal();
    private DrinkMenu menuBebidasNormal = MenuLoader.getMenuBebidasNormal();
    private FoodMenu menuComidaEmpresarial = MenuLoader.getMenuComidaEmpresarial();
    private DrinkMenu menuBebidasEmpresarial = MenuLoader.getMenuBebidasEmpresarial();

    
    public String crearReservaCumple(Customer cliente, LocalDate fecha, LocalTime horaInicio, 
                                   LocalTime horaFin, String nombreCumple, int edadCumple, 
                                   String color, String regalo, int personas, String comida) {
        try {
            validarCantidadPersonas(personas, 50, 75);
            
            Event evento = new Event("HBD-E-01", "Cumpleaños", 380.0);
            ReservaCumple reserva = new ReservaCumple(cliente, evento, fecha, horaInicio, horaFin,
                    nombreCumple, edadCumple, color, regalo, personas, comida);
            
            reservas.add(reserva);
            return "✅ Reserva de cumpleaños creada con ID: " + reserva.getIdReserva();
        } catch (Exception e) {
            throw new RuntimeException("Error al crear reserva: " + e.getMessage());
        }
    }

    public String crearReservaFamiliar(Customer cliente, LocalDate fecha, LocalTime horaInicio,
                                     LocalTime horaFin, String apellido, int personas, 
                                     String comida, List<String> bebidas) {
        try {
            validarCantidadPersonas(personas, 4, 15);
            
            Event evento = new Event("FD-E-04", "Familiar", 200.0);
            ReservaFamiliar reserva = new ReservaFamiliar(cliente, evento, fecha, horaInicio, horaFin,
                    apellido, personas, comida, bebidas);
            
            reservas.add(reserva);
            return "✅ Reserva familiar creada con ID: " + reserva.getIdReserva();
        } catch (Exception e) {
            throw new RuntimeException("Error al crear reserva familiar: " + e.getMessage());
        }
    }

    public String crearReservaEmpresarial(Customer cliente, LocalDate fecha, LocalTime horaInicio,
                                        LocalTime horaFin, String empresa, String tematica,
                                        String vestimenta, boolean postre, int personas,
                                        String comida, List<String> bebidas) {
        try {
            validarCantidadPersonas(personas, 10, 40);
            
            Event evento = new Event("ED-E-03", "Empresarial", 320.0);
            ReservaEmpresarial reserva = new ReservaEmpresarial(cliente, evento, fecha, horaInicio, horaFin,
                    empresa, tematica, vestimenta, postre, personas, comida, bebidas);
            
            reservas.add(reserva);
            return "✅ Reserva empresarial creada con ID: " + reserva.getIdReserva();
        } catch (Exception e) {
            throw new RuntimeException("Error al crear reserva empresarial: " + e.getMessage());
        }
    }

    private void validarCantidadPersonas(int personas, int min, int max) {
        if (personas < min || personas > max) {
            throw new IllegalArgumentException("Debe tener entre " + min + " y " + max + " personas");
        }
    }

    
    public List<Object[]> getDatosReservasPendientes() {
        return reservas.stream()
            .filter(r -> !r.isConcretada())
            .map(this::convertirReservaADatos)
            .collect(Collectors.toList());
    }

    public List<Object[]> getDatosReservasCompletadas() {
        return reservas.stream()
            .filter(Reserva::isConcretada)
            .map(this::convertirReservaADatos)
            .collect(Collectors.toList());
    }

    private Object[] convertirReservaADatos(Reserva reserva) {
        return new Object[]{
            reserva.getIdReserva(),
            reserva.getFecha(),
            reserva.getHoraInicio(),
            reserva.getCliente().getName(),
            reserva.getEvento().getEventCode(),
            reserva.isConcretada() ? "Sí" : "No",
            reserva.isConcretada() ? reserva.getHoraFin() : null
        };
    }

    
    public boolean marcarComoCompletada(String idReserva) {
        return reservas.stream()
            .filter(r -> r.getIdReserva().equals(idReserva))
            .findFirst()
            .map(r -> {
                r.setConcretada(true);
                return true;
            })
            .orElse(false);
    }

    public boolean actualizarHoraFin(String idReserva, LocalTime horaFin) {
        return reservas.stream()
            .filter(r -> r.getIdReserva().equals(idReserva))
            .findFirst()
            .map(r -> {
                r.setHoraFin(horaFin);
                return true;
            })
            .orElse(false);
    }

    
    public List<Food> getMenuComidaNormal() {
        return menuComidaNormal.getItems();
    }

    public List<Drink> getMenuBebidasNormal() {
        return menuBebidasNormal.getItems();
    }

    public List<Food> getMenuComidaEmpresarial() {
        return menuComidaEmpresarial.getItems();
    }

    public List<Drink> getMenuBebidasEmpresarial() {
        return menuBebidasEmpresarial.getItems();
    }

    
    public Reserva buscarReservaPorId(String idReserva) {
        return reservas.stream()
            .filter(r -> r.getIdReserva().equals(idReserva))
            .findFirst()
            .orElse(null);
    }
}

