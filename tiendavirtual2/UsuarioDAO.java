import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection conexion;

    public UsuarioDAO() {
        conexion = ConexionBD.getInstancia().getConexion();
    }

    public boolean verificarCredenciales(String nombre, String contraseña) {
        try {
            String consulta = "SELECT * FROM usuarios WHERE nombre = ? AND contraseña = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, contraseña);
            ResultSet resultado = statement.executeQuery();
            return resultado.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean crearCuenta(String nombre, String contraseña) {
        try {
            String insercion = "INSERT INTO usuarios (nombre, contraseña) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(insercion);
            statement.setString(1, nombre);
            statement.setString(2, contraseña);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
