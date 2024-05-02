import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }
    // Método para verificar las credenciales de inicio de sesión
    public boolean verificarCredenciales(String nombreUsuario, String contraseña) {
        String consulta = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contraseña = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, nombreUsuario);
            ps.setString(2, contraseña);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Devuelve true si se encontró un usuario con las credenciales proporcionadas
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar las credenciales: " + e.getMessage());
            return false;
        }
    }

    // Método para crear una nueva cuenta de usuario
    public boolean crearCuenta(String nombreUsuario, String contraseña) {
        String insercion = "INSERT INTO usuarios (nombre_usuario, contraseña) VALUES (?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(insercion)) {
            ps.setString(1, nombreUsuario);
            ps.setString(2, contraseña);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; // Devuelve true si se insertó correctamente el nuevo usuario
        } catch (SQLException e) {
            System.err.println("Error al crear la cuenta: " + e.getMessage());
            return false;
        }
    }
}
