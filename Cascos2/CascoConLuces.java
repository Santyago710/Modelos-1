// Decorador para agregar luces a un casco
// Interfaz para los diferentes tipos de cascos
// Decorador para agregar luces a un casco
public class CascoConLuces implements Casco {
    private Casco casco;

    public CascoConLuces(Casco casco) {
        this.casco = casco;
    }

    @Override
    public String descripcion() {
        return casco.descripcion() + ", con luces";
    }

    @Override
    public double precio() {
        return casco.precio() + 20.0;
    }
}
