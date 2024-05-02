import java.util.Scanner;

public class TiendaVirtual {

    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static Casco cascoPersonalizado;

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

        if (usuarioDAO.verificarCredenciales(nombreUsuario, contraseña)) {
            System.out.println("Inicio de sesión exitoso.");
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

        if (usuarioDAO.crearCuenta(nombreUsuario, contraseña)) {
            System.out.println("Cuenta creada exitosamente.");
        } else {
            System.out.println("Error al crear la cuenta. Inténtelo de nuevo.");
        }
    }

    private static void menuPrincipal() {
        //Casco CascoBase = new CascoBase();
        cascoPersonalizado = new CascoConVisera(new CascoConLuces(new CascoBase()));

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
                    personalizarCasco();
                    break;
                case 2:
                    comprarCasco();
                    break;
                case 3:
                    comprarAccesorio();
                    break;
                case 4:
                    System.out.println("Cerrando sesión...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void personalizarCasco() {
        System.out.println("Personalizar casco:");
        System.out.println("1. Agregar visera");
        System.out.println("2. Agregar luces");
        System.out.println("3. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                cascoPersonalizado = new CascoConVisera(cascoPersonalizado);
                System.out.println("Se ha agregado una visera al casco.");
                break;
            case 2:
                cascoPersonalizado = new CascoConLuces(cascoPersonalizado);
                System.out.println("Se han agregado luces al casco.");
                break;
            case 3:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    }

    private static void comprarCasco() {
        System.out.println("Comprar casco:");
        System.out.println("1. Comprar casco actual");
        System.out.println("2. Comprar casco básico");
        System.out.println("3. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                Comando comprarCascoCommand = new ComprarCascoCommand(cascoPersonalizado);
                comprarCascoCommand.ejecutar();
                break;
            case 2:
                Casco cascoBasico = new CascoBase();
                Comando comprarCascoBaseCommand = new ComprarCascoCommand(cascoBasico);
                comprarCascoBaseCommand.ejecutar();
                break;
            case 3:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    }

    private static void comprarAccesorio() {
        System.out.println("Comprar accesorio:");
        System.out.println("Seleccione un accesorio:");
        System.out.println("1. Antirrobo - $20");
        System.out.println("2. Funda para casco - $15");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ha seleccionado: Antirrobo - $20");
                break;
            case 2:
                System.out.println("Ha seleccionado: Funda para casco - $15");
                break;
            case 0:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    }

}
