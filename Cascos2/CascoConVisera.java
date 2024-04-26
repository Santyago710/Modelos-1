// Decorador para agregar visera a un casco
public class CascoConVisera extends CascoDecorador {
    public CascoConVisera(Casco casco) {
        super(casco);
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", con visera";
    }

    @Override
    public double precio() {
        return super.precio() + 10.0;
    }
}
