

public class ComprarCascoCommand implements Comando {
    private Casco casco;

    public ComprarCascoCommand(Casco casco) {
        this.casco = casco;
    }

    @Override
    public void ejecutar() {
        System.out.println("Comprando casco: " + casco.descripcion());
        System.out.println("Precio: $" + casco.precio());
    }
}
