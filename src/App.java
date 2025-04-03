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
  
    }

    
}
