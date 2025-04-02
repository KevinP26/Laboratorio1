package UI.Panels;

import Entities.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalTime;
import java.util.List;

public class PendingReservePanel extends JPanel {
    private ReservaService reservaService;
    private ReservationPanel parentPanel;
    private JTable tablaReservas;

    public PendingReservePanel(ReservaService reservaService, ReservationPanel parentPanel) {
        this.reservaService = reservaService;
        this.parentPanel = parentPanel;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        tablaReservas = new JTable();
        tablaReservas.setAutoCreateRowSorter(true);
        actualizarTabla();

        add(new JScrollPane(tablaReservas), BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizarTabla());

        JButton btnCompletar = new JButton("Marcar como Completada");
        btnCompletar.addActionListener(e -> completarReserva());

        JButton btnNueva = new JButton("Nueva Reserva");
        btnNueva.addActionListener(e -> parentPanel.showPanel("NUEVA"));

        buttonPanel.add(btnActualizar);
        buttonPanel.add(btnCompletar);
        buttonPanel.add(btnNueva);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void actualizarTabla() {
        List<Object[]> datosReservas = reservaService.getDatosReservasPendientes();
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

    private void completarReserva() {
        int filaSeleccionada = tablaReservas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String idReserva = (String) tablaReservas.getValueAt(filaSeleccionada, 0);

            
            String horaFinStr = JOptionPane.showInputDialog(this, 
                "Ingrese la hora de finalización (HH:mm):", "14:00");
            
            try {
                LocalTime horaFin = LocalTime.parse(horaFinStr);
                
                if (reservaService.marcarComoCompletada(idReserva)) {
                    reservaService.actualizarHoraFin(idReserva, horaFin);
                    JOptionPane.showMessageDialog(this, 
                        "Reserva marcada como completada exitosamente");
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Error al marcar la reserva como completada", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, 
                    "Formato de hora inválido. Use HH:mm", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                "Seleccione una reserva para completar", 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}