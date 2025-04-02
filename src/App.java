import java.util.Scanner;

import javax.swing.SwingUtilities;

//import Entities.ReservaService;
import UI.MainFrame;
import Utils.KrabTheme;

public class App {
    public static void main(String[] args) throws Exception {

        KrabTheme.applyTheme();
        
        // Ejecutar interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
  /*Scanner sc = new Scanner(System.in);
        ReservaService servicio = new ReservaService();
        int opcion;

        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agendar nueva reserva");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine(); 

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

        sc.close();*/

    }

    
}
