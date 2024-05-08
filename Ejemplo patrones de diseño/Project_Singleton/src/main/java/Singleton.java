public class Singleton {

    private static Singleton instance;

    // Constructor privado para evitar la creación de instancias desde fuera de la clase
    private Singleton() {
    }

    // Método estático que devuelve la única instancia de la clase
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Método de ejemplo
    public void showMessage() {
        System.out.println("Hola, soy una instancia de Singleton");
    }

    public static void main(String[] args) {
        // Obtiene la instancia de Singleton
        Singleton singleton = Singleton.getInstance();

        // Ejecuta el método showMessage
        singleton.showMessage();
    }
}