package inteface;
import DataAccess.DAO.PacienteDAO;
import DataAccess.DTO.PacienteDTO;
import Framework.PoliSaludException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI extends JFrame {

    private JTextField txtNombre, txtApellido, txtCodigoUnico, txtEmail, txtTelefono, txtFechaNacimiento, txtDireccion;
    private JButton btnAgregar, btnEditar, btnEliminar, btnVerTodos;
    private JTable tablaPacientes;
    private DefaultTableModel tableModel;
    private PacienteDAO pacienteDAO;

    public GUI() {
        pacienteDAO = new PacienteDAO();
        setTitle("Gestión de Pacientes");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel para el formulario
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        String[] labels = {"Nombre:", "Apellido:", "Código Único:", "Email:", "Teléfono:", "Fecha de Nacimiento:", "Dirección:"};
        JTextField[] fields = {txtNombre = new JTextField(), txtApellido = new JTextField(), txtCodigoUnico = new JTextField(),
                               txtEmail = new JTextField(), txtTelefono = new JTextField(), txtFechaNacimiento = new JTextField(),
                               txtDireccion = new JTextField()};
        
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            panelFormulario.add(new JLabel(labels[i]), gbc);
            
            gbc.gridx = 1;
            gbc.weightx = 1.0;
            panelFormulario.add(fields[i], gbc);
            gbc.weightx = 0;
        }
        
        // Panel para botones
        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnVerTodos = new JButton("Ver Todos");
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnVerTodos);

        // Tabla para mostrar los pacientes
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellido");
        tableModel.addColumn("Código Único");
        tableModel.addColumn("Email");
        tableModel.addColumn("Teléfono");
        tableModel.addColumn("Fecha Nacimiento");
        tableModel.addColumn("Dirección");
        
        tablaPacientes = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tablaPacientes);

        // Añadir componentes a la ventana
        add(panelFormulario, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Event listeners para los botones
        btnAgregar.addActionListener(e -> agregarPaciente());
        btnEditar.addActionListener(e -> editarPaciente());
        btnEliminar.addActionListener(e -> eliminarPaciente());
        btnVerTodos.addActionListener(e -> mostrarTodosPacientes());
    }

    private void agregarPaciente() {
        try {
            PacienteDTO paciente = new PacienteDTO(
                    null, txtNombre.getText(), txtApellido.getText(), txtCodigoUnico.getText(),
                    txtEmail.getText(), txtTelefono.getText(), txtFechaNacimiento.getText(), txtDireccion.getText(),
                    "A", null, null
            );
            if (pacienteDAO.create(paciente)) {
                JOptionPane.showMessageDialog(this, "Paciente agregado exitosamente.");
                limpiarFormulario();
                mostrarTodosPacientes();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar paciente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarPaciente() {
        try {
            int selectedRow = tablaPacientes.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un paciente para editar.");
                return;
            }
            int idPaciente = (Integer) tableModel.getValueAt(selectedRow, 0);
            PacienteDTO paciente = new PacienteDTO(
                    idPaciente, txtNombre.getText(), txtApellido.getText(), txtCodigoUnico.getText(),
                    txtEmail.getText(), txtTelefono.getText(), txtFechaNacimiento.getText(), txtDireccion.getText(),
                    "A", null, null
            );
            if (pacienteDAO.update(paciente)) {
                JOptionPane.showMessageDialog(this, "Paciente actualizado exitosamente.");
                limpiarFormulario();
                mostrarTodosPacientes();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al editar paciente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarPaciente() {
        try {
            int selectedRow = tablaPacientes.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un paciente para eliminar.");
                return;
            }
            int idPaciente = (Integer) tableModel.getValueAt(selectedRow, 0);
            if (pacienteDAO.delete(idPaciente)) {
                JOptionPane.showMessageDialog(this, "Paciente eliminado exitosamente.");
                mostrarTodosPacientes();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar paciente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarTodosPacientes() {
        try {
            List<PacienteDTO> pacientes = pacienteDAO.readAll();
            tableModel.setRowCount(0);
            for (PacienteDTO paciente : pacientes) {
                tableModel.addRow(new Object[]{paciente.getIdPaciente(), paciente.getNombre(), paciente.getApellido(),
                        paciente.getCodigoUnico(), paciente.getEmail(), paciente.getTelefono(), paciente.getFechaNacimiento(), paciente.getDireccion()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar pacientes: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {
        txtNombre.setText(""); txtApellido.setText(""); txtCodigoUnico.setText(""); txtEmail.setText("");
        txtTelefono.setText(""); txtFechaNacimiento.setText(""); txtDireccion.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI().setVisible(true));
    }
}
