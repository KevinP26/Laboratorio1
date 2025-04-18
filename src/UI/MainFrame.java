package UI;

import javax.swing.*;

import UI.Panels.ReservationPanel;

import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public MainFrame() {
        setTitle("El Crustáceo Cascarudo - Inicio");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        setIconImage(new ImageIcon(getClass().getResource("../resources/Mr Krabs.png")).getImage());
        
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        
        JPanel homePanel = createHomePanel();
        cardPanel.add(homePanel, "HOME");
        
        
        cardPanel.add(new ReservationPanel(), "RESERVAS");
        
        
        add(cardPanel);
        
        
        createToolBar();
    }

    private JPanel createHomePanel() {
        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.setColor(new Color(173, 216, 230, 50));
                for (int i = 0; i < 50; i++) {
                    g.fillOval((int)(Math.random() * getWidth()), 
                              (int)(Math.random() * getHeight()), 
                              30, 30);
                }
            }
        };
        panel.setBackground(new Color(255, 239, 213));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        
        ImageIcon logo = new ImageIcon(getClass().getResource("../resources/Krusty Crab.png"));
        JLabel logoLabel = new JLabel(new ImageIcon(logo.getImage().getScaledInstance(350, 175, Image.SCALE_SMOOTH)));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(logoLabel, BorderLayout.NORTH);
        
        
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 30, 0));
        centerPanel.setOpaque(false);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));
        
        
        JButton btnReservas = createMenuButton("GESTIÓN DE RESERVAS", null);
        btnReservas.addActionListener(e -> cardLayout.show(cardPanel, "RESERVAS"));
        
        centerPanel.add(btnReservas);
        
        panel.add(centerPanel, BorderLayout.CENTER);
        

        return panel;
    }

    private JButton createMenuButton(String text, String iconPath) {
        JButton button = new JButton(text);
        
        
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(200, 0, 0)); 
        button.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false); 
    
        
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);

        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(150, 20, 20));
            }
    
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(200, 0, 0));
            }
        });
    
        return button;
    }
    

    private void createToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBackground(new Color(255, 215, 0));
        
        JButton homeBtn = new JButton("Inicio");
        homeBtn.addActionListener(e -> cardLayout.show(cardPanel, "HOME"));
        toolBar.add(homeBtn);
        
        
        add(toolBar, BorderLayout.NORTH);
    }
}