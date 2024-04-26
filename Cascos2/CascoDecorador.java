// Clase abstracta para los decoradores de cascos
public abstract class CascoDecorador implements Casco {
    protected Casco casco;

    public CascoDecorador(Casco casco) {
        this.casco = casco;
    }

    @Override
    public String descripcion() {
        return casco.descripcion();
    }

    @Override
    public double precio() {
        return casco.precio();
    }
}
