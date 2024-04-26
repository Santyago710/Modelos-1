// Comando para comprar un accesorio
public class ComprarAccesorioCommand implements Comando {
    private String accesorio;

    public ComprarAccesorioCommand(String accesorio) {
        this.accesorio = accesorio;
    }

    @Override
    public void ejecutar() {
        System.out.println("Comprando accesorio: " + accesorio);
    }
}
