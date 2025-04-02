import java.util.Scanner;

import Entities.ReservaService;

public class App {
    public static void main(String[] args) throws Exception {

  Scanner sc = new Scanner(System.in);
        ReservaService servicio = new ReservaService();
        int opcion;

        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agendar reserva de cumpleaños");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar el buffer

            switch (opcion) {
                case 1:
                    servicio.agendarReservaDesdeConsola();
                    break;
                case 2:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println();

        } while (opcion != 2);

        sc.close();

    }
}
