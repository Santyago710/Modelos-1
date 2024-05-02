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
                    menuPersonalizarCasco(scanner, cascoPersonalizado);
                    break;
                case 2:
                    menuComprarCasco(scanner, cascoBase);
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

    private static void menuPersonalizarCasco(Scanner scanner, Casco casco) {
        System.out.println("Personalizar casco:");
        System.out.println("1. Agregar visera");
        System.out.println("2. Agregar luces");
        System.out.println("3. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                casco = new CascoConVisera(casco);
                System.out.println("Se ha agregado una visera al casco.");
                break;
            case 2:
                casco = new CascoConLuces(casco);
                System.out.println("Se han agregado luces al casco.");
                break;
            case 3:
                System.out.println("Volviendo al menú principal...");
                return;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
        // Muestra la descripción y el precio actualizado del casco personalizado
        System.out.println("Descripción del casco: " + casco.descripcion());
        System.out.println("Precio del casco: $" + casco.precio());
    }

    private static void menuComprarCasco(Scanner scanner, Casco casco) {
        System.out.println("Comprar casco:");
        System.out.println("1. Comprar casco actual");
        System.out.println("2. Comprar casco básico");
        System.out.println("3. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                Comando comprarCascoCommand = new ComprarCascoCommand(casco);
                comprarCascoCommand.ejecutar();
                break;
            case 2:
                casco = new CascoBase();
                Comando comprarCascoBaseCommand = new ComprarCascoCommand(casco);
                comprarCascoBaseCommand.ejecutar();
                break;
            case 3:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
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
}
