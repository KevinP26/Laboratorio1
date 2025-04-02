// src/main/java/com/krustykrab/ui/panels/ReservationPanel.java
package UI.Panels;


import Entities.ReservaService;
import javax.swing.*;
import java.awt.*;

public class ReservationPanel extends JPanel {
    private ReservaService reservaService;
    private CardLayout cardLayout;
    private JPanel cardsPanel;

    public ReservationPanel() {
        reservaService = new ReservaService();
        setLayout(new BorderLayout());
        
        
        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);
        
        
        cardsPanel.add(new NewReservePanel(reservaService, this), "NUEVA");
        cardsPanel.add(new PendingReservePanel(reservaService, this), "PENDIENTES");
        cardsPanel.add(new CompleteReservePanel(reservaService, this), "COMPLETADAS");
        
        
        add(createNavigationPanel(), BorderLayout.NORTH);
        add(cardsPanel, BorderLayout.CENTER);
        
        
        showPanel("NUEVA");
    }

    private JPanel createNavigationPanel() {
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(70, 130, 180));
        
        JButton btnNueva = createNavButton("Nueva Reserva");
        btnNueva.addActionListener(e -> showPanel("NUEVA"));
        
        JButton btnPendientes = createNavButton("Reservas Pendientes");
        btnPendientes.addActionListener(e -> showPanel("PENDIENTES"));
        
        JButton btnCompletadas = createNavButton("Reservas Completadas");
        btnCompletadas.addActionListener(e -> showPanel("COMPLETADAS"));
        
        navPanel.add(btnNueva);
        navPanel.add(btnPendientes);
        navPanel.add(btnCompletadas);
        
        return navPanel;
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(255, 215, 0));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        return button;
    }

    public void showPanel(String panelName) {
        cardLayout.show(cardsPanel, panelName);
    }
}