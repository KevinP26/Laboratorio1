import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Listar reservas pendientes");
            System.out.println("2. Listar reservas terminadas");
            System.out.println("3. Agregar una nueva reserva");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            while (!sc.hasNextInt()) {
                System.out.print("Por favor, ingrese un número: ");
                sc.next();
            }

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¡Hola! ¿Cómo estás?");
                    break;
                case 2:
                    System.out.println("Hora actual: " + java.time.LocalTime.now());
                    break;
                case 3:
                    System.out.println("¡Hola! ¿Cómo estás?");
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            System.out.println(); 
        } while (opcion != 4);

        sc.close();

    }
}
