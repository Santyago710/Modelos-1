public class CascoConVisera implements Casco {
    private Casco casco;

    public CascoConVisera(Casco casco) {
        this.casco = casco;
    }

    @Override
    public String descripcion() {
        return casco.descripcion() + " con visera";
    }

    @Override
    public double precio() {
        return casco.precio() + 10.0; // Precio adicional por la visera
    }
}
