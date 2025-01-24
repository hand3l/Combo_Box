import java.sql.*;

public class DatabaseConnection {
    private Connection connection;

    // Método para establecer la conexión a la base de datos
    public Connection conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/calendario";
            String usuario = "root";
            String contrasena = "123456";

            connection = DriverManager.getConnection(url, usuario, contrasena);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para cargar los meses desde la base de datos
    public ResultSet cargarMeses() {
        try {
            String query = "SELECT nombre FROM meses";
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para insertar un mes en la base de datos
    public boolean insertarMes(String mes) {
        try {
            String query = "INSERT INTO meses (nombre) VALUES (?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, mes);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
