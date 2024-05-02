import java.util.Scanner;

public class TiendaVirtual {

    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioDAO usuarioDAO = new UsuarioDAO(); // Suponiendo que tienes una clase UsuarioDAO para manejar la interacción con la base de datos

    public static void main(String[] args) {
        iniciarPrograma();
    }

    private static void iniciarPrograma() {
        while (true) {
            System.out.println("Bienvenido a la tienda de cascos de motos");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Crear cuenta");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    crearCuenta();
                    break;
                case 3:
                    System.out.println("Gracias por visitar nuestra tienda. ¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void iniciarSesion() {
        System.out.println("Iniciar sesión:");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.next();
        System.out.print("Contraseña: ");
        String contraseña = scanner.next();

        // Verificar las credenciales en la base de datos
        if (usuarioDAO.verificarCredenciales(nombreUsuario, contraseña)) {
            System.out.println("Inicio de sesión exitoso.");
            // Llamar a la función principal del programa, después de iniciar sesión
            menuPrincipal();
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
    }

    private static void crearCuenta() {
        System.out.println("Crear cuenta:");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.next();
        System.out.print("Contraseña: ");
        String contraseña = scanner.next();

        // Guardar la información de la cuenta en la base de datos
        if (usuarioDAO.crearCuenta(nombreUsuario, contraseña)) {
            System.out.println("Cuenta creada exitosamente.");
        } else {
            System.out.println("Error al crear la cuenta. Inténtelo de nuevo.");
        }
    }

    // Función principal del programa, después de iniciar sesión
    private static void menuPrincipal() {
        // Crear instancias de los cascos
        Casco cascoBase = new CascoBase();  
        Casco cascoPersonalizado = new CascoConVisera(new CascoConLuces(new CascoBase()));

        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Personalizar casco");
            System.out.println("2. Comprar casco");
            System.out.println("3. Comprar accesorio");
            System.out.println("4. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuPersonalizarCasco(scanner, cascoPersonalizado);
                    break;
                case 2:
                    menuComprarCasco(scanner, cascoBase);
                    break;
                case 3:
                    submenuAccesorios(scanner);
                    break;
                case 4:
                    System.out.println("Cerrando sesión...");
                    return; // Regresar al menú principal
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void menuPersonalizarCasco(Scanner scanner, Casco casco) {
        System.out.println("Personalizando casco...");
        // Aquí puedes agregar la lógica para personalizar el casco
        System.out.println("El casco ha sido personalizado.");
    }

    private static void menuComprarCasco(Scanner scanner, Casco casco) {
        System.out.println("Comprando casco...");
        // Aquí puedes agregar la lógica para comprar un casco
        System.out.println("El casco ha sido comprado.");
    }

    private static void submenuAccesorios(Scanner scanner) {
        System.out.println("Comprando accesorio...");
        // Aquí puedes agregar la lógica para comprar un accesorio
        System.out.println("El accesorio ha sido comprado.");
    }
}
