package Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservaService {

    FoodMenu menuComidaNormal = MenuLoader.getMenuComidaNormal();
    DrinkMenu menuBebidasNormal = MenuLoader.getMenuBebidasNormal();

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

        // Menu de la comida para la reserva

        System.out.println("Menú de comidas disponibles:");
        List<Food> comidas = menuComidaNormal.getItems();
        for (int i = 0; i < comidas.size(); i++) {
            System.out.println((i + 1) + ". " + comidas.get(i).getNombre() + " - " + comidas.get(i).getDescripcion());
        }
        System.out.print("Seleccione una opción de comida (1-" + comidas.size() + "): ");
        int comidaIndex = Integer.parseInt(sc.nextLine()) - 1;
        if (comidaIndex < 0 || comidaIndex >= comidas.size()) {
            System.out.println("Opción inválida. Reserva cancelada.");
            return;
        }
        Food comidaSeleccionada = comidas.get(comidaIndex);

        Event evento = new Event("HBD-E-01", "Cumpleaños", 380.0);

        ReservaCumple reserva = new ReservaCumple(cliente, evento, fecha, horaInicio, horaFin,
                nombreCumple, edadCumple, color, regalo, personas, comidaSeleccionada.getNombre());

        reservas.add(reserva);
        System.out.println("✅ Reserva registrada con éxito con ID: " + reserva.getIdReserva());
    }
}
