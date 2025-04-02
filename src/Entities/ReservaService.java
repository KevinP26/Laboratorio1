package Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservaService {

    private List<Reserva> reservas = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void agendarReservaDesdeConsola() {
        System.out.println("=== NUEVA RESERVA DE CUMPLEAÑOS ===");

        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();

        System.out.print("DUI: ");
        String dui = sc.nextLine();

        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        Customer cliente = new Customer(nombre, dui, edad, telefono);

        System.out.print("Fecha del evento (yyyy-MM-dd): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());

        System.out.print("Hora de inicio (HH:mm): ");
        LocalTime horaInicio = LocalTime.parse(sc.nextLine());

        System.out.print("Hora de finalización (HH:mm): ");
        LocalTime horaFin = LocalTime.parse(sc.nextLine());

        System.out.print("Nombre del cumpleañero: ");
        String nombreCumple = sc.nextLine();

        System.out.print("Edad que cumple: ");
        int edadCumple = Integer.parseInt(sc.nextLine());

        System.out.print("Color favorito: ");
        String color = sc.nextLine();

        System.out.print("Regalo: ");
        String regalo = sc.nextLine();

        System.out.print("Cantidad de personas (50-75): ");
        int personas = Integer.parseInt(sc.nextLine());

        if (personas < 50 || personas > 75) {
            System.out.println("La cantidad debe estar entre 50 y 75. Reserva cancelada.");
            return;
        }

       
        String alimento = "Cangreburguer con Queso";

        Event evento = new Event("HBD-E-01", "Cumpleaños", 380.0);

        ReservaCumple reserva = new ReservaCumple(cliente, evento, fecha, horaInicio, horaFin,
                nombreCumple, edadCumple, color, regalo, personas, alimento);

        reservas.add(reserva);

        System.out.println("✅ Reserva registrada con éxito con ID: " + reserva.getIdReserva());
    }
}
