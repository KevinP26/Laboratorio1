package Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservaService {

    private List<Reserva> reservas = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private FoodMenu menuComidaNormal = MenuLoader.getMenuComidaNormal();
    private DrinkMenu menuBebidasNormal = MenuLoader.getMenuBebidasNormal();
    private FoodMenu menuComidaEmpresarial = MenuLoader.getMenuComidaEmpresarial();
    private DrinkMenu menuBebidasEmpresarial = MenuLoader.getMenuBebidasEmpresarial();

    public void agendarReservaDesdeConsola() {
        System.out.println("=== AGENDAR NUEVA RESERVA ===");
        System.out.println("Tipo de evento:");
        System.out.println("1. Cumpleaños");
        System.out.println("2. Familiar");
        System.out.println("3. Empresarial");
        System.out.print("Seleccione una opción: ");
        int tipo = Integer.parseInt(sc.nextLine());

        switch (tipo) {
            case 1:
                agendarReservaCumple();
                break;
            case 2:
                agendarReservaFamiliar();
                break;
            case 3:
                agendarReservaEmpresarial();
                break;
            default:
                System.out.println("❌ Opción no válida.");
        }
    }

    public void agendarReservaEmpresarial() {
        System.out.println("=== NUEVA RESERVA EMPRESARIAL ===");

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

        System.out.print("Nombre de la empresa: ");
        String empresa = sc.nextLine();

        System.out.print("Temática de colores: ");
        String tematica = sc.nextLine();

        System.out.print("Código de vestimenta: ");
        String vestimenta = sc.nextLine();

        System.out.print("¿Requiere postre? (true/false): ");
        boolean postre = Boolean.parseBoolean(sc.nextLine());

        System.out.print("Cantidad de personas (10-40): ");
        int personas = Integer.parseInt(sc.nextLine());
        if (personas < 10 || personas > 40) {
            System.out.println("Cantidad fuera de rango. Reserva cancelada.");
            return;
        }

        // Menú de comida empresarial
        System.out.println("Menú de comidas empresariales:");
        List<Food> comidas = menuComidaEmpresarial.getItems();
        for (int i = 0; i < comidas.size(); i++) {
            System.out.println((i + 1) + ". " + comidas.get(i).getNombre());
        }
        System.out.print("Seleccione una comida (1-" + comidas.size() + "): ");
        int comidaIndex = Integer.parseInt(sc.nextLine()) - 1;
        if (comidaIndex < 0 || comidaIndex >= comidas.size()) {
            System.out.println("Opción inválida.");
            return;
        }
        String comidaSeleccionada = comidas.get(comidaIndex).getNombre();

        // Menú de bebidas empresariales
        System.out.println("Bebidas disponibles (puede elegir varias separadas por coma):");
        List<Drink> bebidas = menuBebidasEmpresarial.getItems();
        for (int i = 0; i < bebidas.size(); i++) {
            System.out.println((i + 1) + ". " + bebidas.get(i).getNombre());
        }
        System.out.print("Seleccione las bebidas (ej: 1,3): ");
        String[] indices = sc.nextLine().split(",");
        List<String> bebidasSeleccionadas = new ArrayList<>();
        for (String s : indices) {
            int idx = Integer.parseInt(s.trim()) - 1;
            if (idx >= 0 && idx < bebidas.size()) {
                bebidasSeleccionadas.add(bebidas.get(idx).getNombre());
            }
        }

        Event evento = new Event("ED-E-03", "Empresarial", 320.0);

        ReservaEmpresarial reserva = new ReservaEmpresarial(cliente, evento, fecha, horaInicio, horaFin,
                empresa, tematica, vestimenta, postre, personas, comidaSeleccionada, bebidasSeleccionadas);

        reservas.add(reserva);
        System.out.println("✅ Reserva empresarial creada con ID: " + reserva.getIdReserva());
    }

    public void agendarReservaCumple() {
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

    public void agendarReservaFamiliar() {
        System.out.println("=== NUEVA RESERVA FAMILIAR ===");

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

        System.out.print("Apellido de la familia: ");
        String apellido = sc.nextLine();

        System.out.print("Cantidad de personas (4-15): ");
        int personas = Integer.parseInt(sc.nextLine());

        if (personas < 4 || personas > 15) {
            System.out.println("Cantidad inválida. Debe estar entre 4 y 15. Cancelando reserva.");
            return;
        }

        System.out.println("Menú de comidas disponibles:");
        List<Food> comidas = menuComidaNormal.getItems();
        for (int i = 0; i < comidas.size(); i++) {
            System.out.println((i + 1) + ". " + comidas.get(i).getNombre());
        }
        System.out.print("Seleccione una comida (1-" + comidas.size() + "): ");
        int comidaIndex = Integer.parseInt(sc.nextLine()) - 1;
        if (comidaIndex < 0 || comidaIndex >= comidas.size()) {
            System.out.println("Opción inválida.");
            return;
        }
        String comidaSeleccionada = comidas.get(comidaIndex).getNombre();

        System.out.println("Bebidas disponibles (puede elegir varias separadas por coma):");
        List<Drink> bebidas = menuBebidasNormal.getItems();
        for (int i = 0; i < bebidas.size(); i++) {
            System.out.println((i + 1) + ". " + bebidas.get(i).getNombre());
        }
        System.out.print("Seleccione las bebidas (ej: 1,3): ");
        String[] indices = sc.nextLine().split(",");
        List<String> bebidasSeleccionadas = new ArrayList<>();
        for (String s : indices) {
            int idx = Integer.parseInt(s.trim()) - 1;
            if (idx >= 0 && idx < bebidas.size()) {
                bebidasSeleccionadas.add(bebidas.get(idx).getNombre());
            }
        }

        Event evento = new Event("FD-E-04", "Familiar", 200.0);

        ReservaFamiliar reserva = new ReservaFamiliar(cliente, evento, fecha, horaInicio, horaFin,
                apellido, personas, comidaSeleccionada, bebidasSeleccionadas);

        reservas.add(reserva);
        System.out.println("✅ Reserva familiar creada con ID: " + reserva.getIdReserva());
    }
}
