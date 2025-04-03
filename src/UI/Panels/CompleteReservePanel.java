package UI.Panels;

import Entities.*;
import Utils.ReservaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CompleteReservePanel extends JPanel {
    private ReservaService reservaService;
    private ReservationPanel parentPanel;
    private JTable tablaReservas;

    public CompleteReservePanel(ReservaService reservaService, ReservationPanel parentPanel) {
        this.reservaService = reservaService;
        this.parentPanel = parentPanel;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        topPanel.setBackground(new Color(240, 248, 255));

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizarTabla());

        topPanel.add(btnActualizar);

        add(topPanel, BorderLayout.NORTH);

        
        tablaReservas = new JTable();
        tablaReservas.setAutoCreateRowSorter(true);
        actualizarTabla();

        add(new JScrollPane(tablaReservas), BorderLayout.CENTER);

        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(240, 248, 255));
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void actualizarTabla() {
        List<Object[]> datosReservas = reservaService.getDatosReservasCompletadas();
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID Reserva", "Fecha", "Hora Inicio", "Cliente", "ID Evento", "¿Efectiva?", "Hora Fin"}, 0) {
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0: return String.class;
                    case 1: return String.class;
                    case 2: return String.class;
                    case 3: return String.class;
                    case 4: return String.class;
                    case 5: return String.class;
                    case 6: return String.class;
                    default: return Object.class;
                }
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Object[] fila : datosReservas) {
            model.addRow(fila);
        }

        tablaReservas.setModel(model);
    }
}