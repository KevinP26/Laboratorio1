package UI.Panels;

import Entities.*;
import Utils.ReservaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
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

        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        topPanel.setBackground(new Color(240, 248, 255));

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizarTabla());

        JButton btnBanear = new JButton("Marcar como Baneado");
        btnBanear.addActionListener(e -> banearCliente());

        topPanel.add(btnActualizar);
        topPanel.add(btnBanear);

        add(topPanel, BorderLayout.NORTH);

        
        tablaReservas = new JTable();
        tablaReservas.setAutoCreateRowSorter(true);
        actualizarTabla();

        add(new JScrollPane(tablaReservas), BorderLayout.CENTER);

        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        bottomPanel.setBackground(new Color(240, 248, 255));

        JButton btnCompletar = new JButton("Marcar como Completada");
        btnCompletar.addActionListener(e -> completarReserva());

        bottomPanel.add(btnCompletar);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void actualizarTabla() {
        List<Object[]> datosReservas = reservaService.getDatosReservasPendientes();
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID Reserva", "Fecha", "Hora Inicio", "Cliente", "ID Evento", "¿Efectiva?", "Hora Fin", "Estado"}, 0) {
            
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
                    case 7: return String.class;
                    default: return Object.class;
                }
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Object[] fila : datosReservas) {
            Reserva reserva = reservaService.buscarReservaPorId((String)fila[0]);
            String estado = reserva.getCliente().isBaneado() ? "BANEADO" : "ACTIVO";
            Object[] nuevaFila = new Object[fila.length + 1];
            System.arraycopy(fila, 0, nuevaFila, 0, fila.length);
            nuevaFila[fila.length] = estado;
            model.addRow(nuevaFila);
        }

        tablaReservas.setModel(model);
    }

    private void completarReserva() {
        int filaSeleccionada = tablaReservas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String idReserva = (String) tablaReservas.getValueAt(filaSeleccionada, 0);
            Reserva reserva = reservaService.buscarReservaPorId(idReserva);

            
            if (reserva.getCliente().isBaneado()) {
                JOptionPane.showMessageDialog(this,
                    "No se puede completar la reserva de un cliente baneado",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            LocalTime horaInicio = reserva.getHoraInicio();
            
            
            while (true) {
                String horaFinStr = JOptionPane.showInputDialog(this, 
                    "Ingrese la hora de finalización (HH:mm):\nHora inicio: " + horaInicio,
                    "14:00");
                
                if (horaFinStr == null) { 
                    return;
                }
                
                try {
                    LocalTime horaFin = LocalTime.parse(horaFinStr);
                    
                    
                    if (horaFin.isBefore(horaInicio)) {
                        JOptionPane.showMessageDialog(this,
                            "La hora de finalización no puede ser anterior a la hora de inicio (" + horaInicio + ")",
                            "Error", JOptionPane.ERROR_MESSAGE);
                        continue;
                    }
                    
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
                    break;
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(this, 
                        "Formato de hora inválido. Use HH:mm (ej: 14:30)", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                "Seleccione una reserva para completar", 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void banearCliente() {
        int filaSeleccionada = tablaReservas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String idReserva = (String) tablaReservas.getValueAt(filaSeleccionada, 0);
            
            int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea banear a este cliente?",
                "Confirmar Ban",
                JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                reservaService.marcarNoAsistencia(idReserva);
                JOptionPane.showMessageDialog(this,
                    "El cliente ha sido baneado exitosamente",
                    "Cliente Baneado", JOptionPane.INFORMATION_MESSAGE);
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                "Seleccione una reserva para banear al cliente", 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}