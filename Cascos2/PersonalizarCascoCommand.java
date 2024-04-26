// Comando para personalizar un casco
public class PersonalizarCascoCommand implements Comando {
    private Casco casco;

    public PersonalizarCascoCommand(Casco casco) {
        this.casco = casco;
    }

    @Override
    public void ejecutar() {
        System.out.println("Personalizando casco: " + casco.descripcion());
    }
}
