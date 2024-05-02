import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // URL de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/casc0s";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "3212466607sB*";

    // Instancia única de la conexión (patrón Singleton)
    private static Connection conexion;

    // Método privado para crear la conexión a la base de datos
    private static Connection crearConexion() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conn;
    }

    // Método público para obtener la conexión a la base de datos (patrón Singleton)
    public static Connection obtenerConexion() {
        if (conexion == null) {
            conexion = crearConexion();
        }
        return conexion;
    }

    // Método para cerrar la conexión a la base de datos
    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null; // Establecer la conexión a null para que pueda ser recreada si es necesario
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
