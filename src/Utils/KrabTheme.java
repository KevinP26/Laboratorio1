package Utils;


import javax.swing.*;
import java.awt.*;

public class KrabTheme {
    public static void applyTheme() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            
            UIManager.put("Panel.background", new Color(255, 240, 200));
            UIManager.put("Button.background", new Color(255, 215, 0));
            UIManager.put("Button.font", new Font("Arial", Font.BOLD, 14));
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}