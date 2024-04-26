// Implementación de un casco base
public class CascoBase implements Casco {
    @Override
    public String descripcion() {
        return "Casco base";
    }

    @Override
    public double precio() {
        return 50.0;
    }
}
