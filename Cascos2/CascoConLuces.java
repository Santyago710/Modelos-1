// Decorador para agregar luces a un casco
public class CascoConLuces extends CascoDecorador {
    public CascoConLuces(Casco casco) {
        super(casco);
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", con luces";
    }

    @Override
    public double precio() {
        return super.precio() + 20.0;
    }
}
