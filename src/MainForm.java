import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainForm {
    private JComboBox<String> comboBox1;
    private JPanel panel1;
    private JTextField textField1;
    private JButton agregarMesButton;

    private DatabaseConnection dbConnection;

    public MainForm() {
        // Inicializar la clase DatabaseConnection
        dbConnection = new DatabaseConnection();
        // Establecer la conexión a la base de datos
        Connection connection = dbConnection.conectar();

        if (connection != null) {
            cargarMeses();
        } else {
            JOptionPane.showMessageDialog(panel1, "Error al conectar con la base de datos.");
        }
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        textField1.setPreferredSize(new Dimension(200, 30));
        agregarMesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto ingresado por el usuario en el campo de texto
                String nuevoMes = textField1.getText();

                // Verificar si el campo de texto no está vacío
                if (!nuevoMes.isEmpty()) {
                    comboBox1.addItem(nuevoMes);
                    // Insertar el nuevo mes en la base de datos
                    if (dbConnection.insertarMes(nuevoMes)) {
                        JOptionPane.showMessageDialog(panel1, "Mes agregado exitosamente!");
                    } else {
                        JOptionPane.showMessageDialog(panel1, "Error al agregar el mes.");
                    }
                    // Limpiar el campo de texto
                    textField1.setText("");
                } else {
                    // Si el campo de texto está vacío, mostrar un mensaje de advertencia
                    JOptionPane.showMessageDialog(panel1, "Por favor, ingresa un mes.");
                }
            }
        });
    }

    // Método para cargar los meses desde la base de datos en el JComboBox
    private void cargarMeses() {
        try {
            // Obtener el ResultSet con los meses de la base de datos
            ResultSet rs = dbConnection.cargarMeses();

            // Recorrer el ResultSet y agregar los meses al ComboBox
            while (rs.next()) {
                comboBox1.addItem(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(panel1, "Error al cargar los meses.");
        }
    }

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        JFrame frame = new JFrame("Agregar Mes");
        frame.setContentPane(new MainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


