import java.util.Scanner;

// Clase principal que maneja la interacción con el usuario y la aplicación
public class TiendaVirtual {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Casco cascoBase = new CascoBase();
        Casco cascoPersonalizado = new CascoConVisera(new CascoConLuces(new CascoBase()));

        while (true) {
            System.out.println("Bienvenido a la tienda de cascos de motos");
            System.out.println("1. Personalizar casco");
            System.out.println("2. Comprar casco");
            System.out.println("3. Comprar accesorio");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    submenuAccesorios(scanner);
                    break;
                case 2:
                    submenuCascos(scanner);
                    break;
                case 3:
                    submenuAccesorios(scanner);
                    break;
                case 4:
                    System.out.println("Gracias por visitar nuestra tienda. ¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void submenuAccesorios(Scanner scanner) {
        System.out.println("Seleccione un accesorio:");
        System.out.println("1. Antirrobo - $20");
        System.out.println("2. Funda para casco - $15");
        // Agrega más accesorios si es necesario
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

    private static void submenuCascos(Scanner scanner) {
        System.out.println("Seleccione un casco:");
        System.out.println("1. Casco básico - $50");
        System.out.println("2. Casco con visera - $60");
        System.out.println("3. Casco con luces - $70");
        // Agrega más cascos si es necesario
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ha seleccionado: Casco básico - $50");
                break;
            case 2:
                System.out.println("Ha seleccionado: Casco con visera - $60");
                break;
            case 3:
                System.out.println("Ha seleccionado: Casco con luces - $70");
                break;
            case 0:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    }
}
