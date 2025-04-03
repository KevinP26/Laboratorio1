package UI.Panels;

import Entities.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class NewReservePanel extends JPanel {
    private ReservaService reservaService;
    private ReservationPanel parentPanel;
    private JComboBox<String> tipoEventoCombo;
    private JPanel dynamicFormPanel;
    private CardLayout formCardLayout;
    
    private JPanel commonFieldsPanel;
    private JTextField clienteNombreField;
    private JTextField clienteDuiField;
    private JTextField clienteEdadField;
    private JTextField clienteTelefonoField;
    private JSpinner fechaSpinner;
    private JSpinner horaInicioSpinner;
    
    private JTextField cumpleNombreField;
    private JTextField cumpleEdadField;
    private JTextField cumpleColorField;
    private JTextField cumpleRegaloField;
    private JSpinner cumplePersonasSpinner;
    private JComboBox<String> cumpleComidaCombo;
    
    private JTextField familiarApellidoField;
    private JSpinner familiarPersonasSpinner;
    private JComboBox<String> familiarComidaCombo;
    private JComboBox<String> familiarBebidasCombo;
    
    private JTextField empresaNombreField;
    private JTextField empresaTematicaField;
    private JTextField empresaVestimentaField;
    private JCheckBox empresaPostreCheck;
    private JSpinner empresaPersonasSpinner;
    private JComboBox<String> empresaComidaCombo;
    private JComboBox<String> empresaBebidasCombo;

    private static final Pattern DUI_PATTERN = Pattern.compile("^\\d{8}-\\d$");
    private static final Pattern TELEFONO_PATTERN = Pattern.compile("^\\d{4}-\\d{4}$");

    public NewReservePanel(ReservaService reservaService, ReservationPanel parentPanel) {
        this.reservaService = reservaService;
        this.parentPanel = parentPanel;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createTitledBorder("Nueva Reserva"));
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(new Color(173, 216, 230));
        topPanel.add(new JLabel("Tipo de Evento:"));
        
        tipoEventoCombo = new JComboBox<>(new String[]{"Cumpleaños", "Familiar", "Empresarial"});
        tipoEventoCombo.setFont(new Font("Arial", Font.BOLD, 14));
        tipoEventoCombo.addActionListener(this::cambiarFormulario);
        topPanel.add(tipoEventoCombo);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        
        commonFieldsPanel = crearCamposComunes();
        centerPanel.add(commonFieldsPanel, BorderLayout.NORTH);
        
        formCardLayout = new CardLayout();
        dynamicFormPanel = new JPanel(formCardLayout);
        dynamicFormPanel.setBorder(BorderFactory.createTitledBorder("Detalles Específicos del Evento"));
        
        dynamicFormPanel.add(crearFormularioCumple(), "CUMPLE");
        dynamicFormPanel.add(crearFormularioFamiliar(), "FAMILIAR");
        dynamicFormPanel.add(crearFormularioEmpresarial(), "EMPRESARIAL");
        
        centerPanel.add(dynamicFormPanel, BorderLayout.CENTER);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        JButton submitBtn = new JButton("Crear Reserva");
        submitBtn.setBackground(new Color(50, 150, 50));
        submitBtn.setFont(new Font("Arial", Font.BOLD, 16));
        submitBtn.addActionListener(this::crearReserva);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.add(submitBtn);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel, BorderLayout.CENTER);
        
        formCardLayout.show(dynamicFormPanel, "CUMPLE");
    }

    private JPanel crearCamposComunes() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Información General"));
        panel.setBackground(new Color(240, 248, 255));
        
        panel.add(new JLabel("Nombre del Cliente*:"));
        clienteNombreField = new JTextField();
        panel.add(clienteNombreField);
        
        panel.add(new JLabel("DUI* (Formato: 12345678-9):"));
        clienteDuiField = new JTextField();
        panel.add(clienteDuiField);
        
        panel.add(new JLabel("Edad del Cliente*:"));
        clienteEdadField = new JTextField();
        panel.add(clienteEdadField);
        
        panel.add(new JLabel("Teléfono* (Formato: XXXX-XXXX):"));
        clienteTelefonoField = new JTextField();
        panel.add(clienteTelefonoField);
        
        panel.add(new JLabel("Fecha del Evento*:"));
        fechaSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor fechaEditor = new JSpinner.DateEditor(fechaSpinner, "dd/MM/yyyy");
        fechaSpinner.setEditor(fechaEditor);
        fechaSpinner.setValue(new Date());
        panel.add(fechaSpinner);
        
        panel.add(new JLabel("Hora de Inicio*:"));
        horaInicioSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor horaEditor = new JSpinner.DateEditor(horaInicioSpinner, "HH:mm");
        horaInicioSpinner.setEditor(horaEditor);
        horaInicioSpinner.setValue(new Date());
        panel.add(horaInicioSpinner);
        
        return panel;
    }

    private JPanel crearFormularioCumple() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 5));
        panel.setBackground(new Color(240, 248, 255));
        
        panel.add(new JLabel("Nombre del Cumpleañero*:"));
        cumpleNombreField = new JTextField();
        panel.add(cumpleNombreField);
        
        panel.add(new JLabel("Edad que Cumple*:"));
        cumpleEdadField = new JTextField();
        panel.add(cumpleEdadField);
        
        panel.add(new JLabel("Color Favorito*:"));
        cumpleColorField = new JTextField();
        panel.add(cumpleColorField);
        
        panel.add(new JLabel("Tipo de Regalo*:"));
        cumpleRegaloField = new JTextField();
        panel.add(cumpleRegaloField);
        
        panel.add(new JLabel("Número de Personas (50-75):"));
        cumplePersonasSpinner = new JSpinner(new SpinnerNumberModel(50, 50, 75, 1));
        panel.add(cumplePersonasSpinner);
        
        panel.add(new JLabel("Menú de Comida*:"));
        cumpleComidaCombo = new JComboBox<>();
        for (Food item : reservaService.getMenuComidaNormal()) {
            cumpleComidaCombo.addItem(item.getNombre());
        }
        panel.add(cumpleComidaCombo);
        
        return panel;
    }

    private JPanel crearFormularioFamiliar() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 5));
        panel.setBackground(new Color(240, 248, 255));
        
        panel.add(new JLabel("Apellido Familiar*:"));
        familiarApellidoField = new JTextField();
        panel.add(familiarApellidoField);
        
        panel.add(new JLabel("Número de Personas (4-15):"));
        familiarPersonasSpinner = new JSpinner(new SpinnerNumberModel(4, 4, 15, 1));
        panel.add(familiarPersonasSpinner);
        
        panel.add(new JLabel("Menú de Comida*:"));
        familiarComidaCombo = new JComboBox<>();
        for (Food item : reservaService.getMenuComidaNormal()) {
            familiarComidaCombo.addItem(item.getNombre());
        }
        panel.add(familiarComidaCombo);
        
        panel.add(new JLabel("Bebidas*:"));
        familiarBebidasCombo = new JComboBox<>();
        for (Drink item : reservaService.getMenuBebidasNormal()) {
            familiarBebidasCombo.addItem(item.getNombre());
        }
        panel.add(familiarBebidasCombo);
        
        return panel;
    }

    private JPanel crearFormularioEmpresarial() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 5));
        panel.setBackground(new Color(240, 248, 255));
        
        panel.add(new JLabel("Nombre de la Empresa*:"));
        empresaNombreField = new JTextField();
        panel.add(empresaNombreField);
        
        panel.add(new JLabel("Temática del Evento*:"));
        empresaTematicaField = new JTextField();
        panel.add(empresaTematicaField);
        
        panel.add(new JLabel("Código de Vestimenta*:"));
        empresaVestimentaField = new JTextField();
        panel.add(empresaVestimentaField);
        
        panel.add(new JLabel("Incluir Postre:"));
        empresaPostreCheck = new JCheckBox();
        panel.add(empresaPostreCheck);
        
        panel.add(new JLabel("Número de Personas (10-40):"));
        empresaPersonasSpinner = new JSpinner(new SpinnerNumberModel(10, 10, 40, 1));
        panel.add(empresaPersonasSpinner);
        
        panel.add(new JLabel("Menú de Comida*:"));
        empresaComidaCombo = new JComboBox<>();
        for (Food item : reservaService.getMenuComidaEmpresarial()) {
            empresaComidaCombo.addItem(item.getNombre());
        }
        panel.add(empresaComidaCombo);
        
        panel.add(new JLabel("Bebidas*:"));
        empresaBebidasCombo = new JComboBox<>();
        for (Drink item : reservaService.getMenuBebidasEmpresarial()) {
            empresaBebidasCombo.addItem(item.getNombre());
        }
        panel.add(empresaBebidasCombo);
        
        return panel;
    }

    private void cambiarFormulario(ActionEvent e) {
        String tipo = (String) tipoEventoCombo.getSelectedItem();
        switch (tipo) {
            case "Cumpleaños": formCardLayout.show(dynamicFormPanel, "CUMPLE"); break;
            case "Familiar": formCardLayout.show(dynamicFormPanel, "FAMILIAR"); break;
            case "Empresarial": formCardLayout.show(dynamicFormPanel, "EMPRESARIAL"); break;
        }
    }

    private void crearReserva(ActionEvent e) {
        try {
            
            validarCamposComunes();
            
            
            String nombreCliente = clienteNombreField.getText().trim();
            String duiCliente = clienteDuiField.getText().trim();
            int edadCliente = Integer.parseInt(clienteEdadField.getText().trim());
            String telefonoCliente = clienteTelefonoField.getText().trim();
            
            
            LocalDate fecha = ((java.util.Date)fechaSpinner.getValue()).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
            
            LocalTime horaInicio = ((java.util.Date)horaInicioSpinner.getValue()).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalTime();
            
            
            LocalDateTime ahora = LocalDateTime.now();
            LocalDateTime fechaHoraReserva = LocalDateTime.of(fecha, horaInicio);
            
            if (fechaHoraReserva.isBefore(ahora)) {
                throw new Exception("No se pueden hacer reservas en fechas/horas pasadas");
            }
            
            
            Customer cliente = new Customer(nombreCliente, duiCliente, edadCliente, telefonoCliente);
            if (reservaService.estaClienteBaneado(duiCliente)) {
                throw new Exception("Cliente baneado por no asistir a reservas anteriores");
            }
            
            
            String tipo = (String) tipoEventoCombo.getSelectedItem();
            String numeroReserva = "";
            
            switch (tipo) {
                case "Cumpleaños":
                    validarCamposCumple();
                    numeroReserva = procesarCumpleanos(cliente, fecha, horaInicio, null);
                    break;
                    
                case "Familiar":
                    validarCamposFamiliar();
                    numeroReserva = procesarFamiliar(cliente, fecha, horaInicio, null);
                    break;
                    
                case "Empresarial":
                    validarCamposEmpresarial();
                    numeroReserva = procesarEmpresarial(cliente, fecha, horaInicio, null);
                    break;
            }
            
            
            String mensajeExito = "<html><body>" +
                "<h3>Reserva creada exitosamente</h3>" +
                "<p><b>Fecha acordada de reserva:</b> " + fecha.toString() + "</p>" +
                "<p><b>Hora acordada de reserva:</b> " + horaInicio.toString() + "</p>" +
                "<p><b>Número correlativo de la reserva:</b> " + numeroReserva + "</p>" +
                "</body></html>";
            
            JOptionPane.showMessageDialog(this, mensajeExito, "Reserva Creada", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
            parentPanel.showPanel("PENDIENTES");
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad del cliente debe ser un número válido", 
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void validarCamposComunes() throws Exception {
        
        if (clienteNombreField.getText().trim().isEmpty()) {
            throw new Exception("El nombre del cliente es obligatorio");
        }
        
        
        String dui = clienteDuiField.getText().trim();
        if (dui.isEmpty() || !DUI_PATTERN.matcher(dui).matches()) {
            throw new Exception("DUI es obligatorio (Formato: 12345678-9)");
        }
        
        
        if (clienteEdadField.getText().trim().isEmpty()) {
            throw new Exception("La edad del cliente es obligatoria");
        }
        
        try {
            int edad = Integer.parseInt(clienteEdadField.getText().trim());
            if (edad < 18) {
                throw new Exception("El cliente debe ser mayor de edad");
            }
        } catch (NumberFormatException e) {
            throw new Exception("La edad debe ser un número válido");
        }
        
        
        String telefono = clienteTelefonoField.getText().trim();
        if (telefono.isEmpty() || !TELEFONO_PATTERN.matcher(telefono).matches()) {
            throw new Exception("Teléfono es obligatorio (Formato: XXXX-XXXX)");
        }
    }
    
    private void validarCamposCumple() throws Exception {
        if (cumpleNombreField.getText().trim().isEmpty()) {
            throw new Exception("El nombre del cumpleañero es obligatorio");
        }
        if (cumpleEdadField.getText().trim().isEmpty()) {
            throw new Exception("La edad que cumple es obligatoria");
        }
        if (cumpleColorField.getText().trim().isEmpty()) {
            throw new Exception("El color favorito es obligatorio");
        }
        if (cumpleRegaloField.getText().trim().isEmpty()) {
            throw new Exception("El tipo de regalo es obligatorio");
        }
    }
    
    private void validarCamposFamiliar() throws Exception {
        if (familiarApellidoField.getText().trim().isEmpty()) {
            throw new Exception("El apellido familiar es obligatorio");
        }
        if (familiarBebidasCombo.getSelectedItem() == null) {
            throw new Exception("Debe seleccionar una bebida");
        }
    }
    
    private void validarCamposEmpresarial() throws Exception {
        if (empresaNombreField.getText().trim().isEmpty()) {
            throw new Exception("El nombre de la empresa es obligatorio");
        }
        if (empresaTematicaField.getText().trim().isEmpty()) {
            throw new Exception("La temática del evento es obligatoria");
        }
        if (empresaVestimentaField.getText().trim().isEmpty()) {
            throw new Exception("El código de vestimenta es obligatorio");
        }
        if (empresaBebidasCombo.getSelectedItem() == null) {
            throw new Exception("Debe seleccionar una bebida");
        }
    }
    
    private String procesarCumpleanos(Customer cliente, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) throws Exception {
        String nombreCumple = cumpleNombreField.getText().trim();
        int edadCumple = Integer.parseInt(cumpleEdadField.getText().trim());
        String color = cumpleColorField.getText().trim();
        String regalo = cumpleRegaloField.getText().trim();
        int personasCumple = (int) cumplePersonasSpinner.getValue();
        String comidaCumple = (String) cumpleComidaCombo.getSelectedItem();
        
        return reservaService.crearReservaCumple(
            cliente, fecha, horaInicio, horaFin,
            nombreCumple, edadCumple, color, regalo, 
            personasCumple, comidaCumple
        );
    }
    
    private String procesarFamiliar(Customer cliente, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) throws Exception {
        String apellido = familiarApellidoField.getText().trim();
        int personasFamiliar = (int) familiarPersonasSpinner.getValue();
        String comidaFamiliar = (String) familiarComidaCombo.getSelectedItem();
        String bebidaFamiliar = (String) familiarBebidasCombo.getSelectedItem();
        
        return reservaService.crearReservaFamiliar(
            cliente, fecha, horaInicio, horaFin,
            apellido, personasFamiliar, comidaFamiliar, List.of(bebidaFamiliar)
        );
    }
    
    private String procesarEmpresarial(Customer cliente, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) throws Exception {
        String empresa = empresaNombreField.getText().trim();
        String tematica = empresaTematicaField.getText().trim();
        String vestimenta = empresaVestimentaField.getText().trim();
        boolean postre = empresaPostreCheck.isSelected();
        int personasEmpresa = (int) empresaPersonasSpinner.getValue();
        String comidaEmpresa = (String) empresaComidaCombo.getSelectedItem();
        String bebidaEmpresa = (String) empresaBebidasCombo.getSelectedItem();
        
        return reservaService.crearReservaEmpresarial(
            cliente, fecha, horaInicio, horaFin,
            empresa, tematica, vestimenta, postre,
            personasEmpresa, comidaEmpresa, List.of(bebidaEmpresa)
        );
    }
    
    private void limpiarFormulario() {
        
        clienteNombreField.setText("");
        clienteDuiField.setText("");
        clienteEdadField.setText("");
        clienteTelefonoField.setText("");
        
        
        fechaSpinner.setValue(new java.util.Date());
        horaInicioSpinner.setValue(new java.util.Date());
        
        
        String tipo = (String) tipoEventoCombo.getSelectedItem();
        switch (tipo) {
            case "Cumpleaños":
                cumpleNombreField.setText("");
                cumpleEdadField.setText("");
                cumpleColorField.setText("");
                cumpleRegaloField.setText("");
                cumplePersonasSpinner.setValue(50);
                cumpleComidaCombo.setSelectedIndex(0);
                break;
                
            case "Familiar":
                familiarApellidoField.setText("");
                familiarPersonasSpinner.setValue(4);
                familiarComidaCombo.setSelectedIndex(0);
                familiarBebidasCombo.setSelectedIndex(0);
                break;
                
            case "Empresarial":
                empresaNombreField.setText("");
                empresaTematicaField.setText("");
                empresaVestimentaField.setText("");
                empresaPostreCheck.setSelected(false);
                empresaPersonasSpinner.setValue(10);
                empresaComidaCombo.setSelectedIndex(0);
                empresaBebidasCombo.setSelectedIndex(0);
                break;
        }
    }
}