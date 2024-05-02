public class CascoPersonalizado implements Casco {
    private String descripcion;
    private double precio;

    public CascoPersonalizado(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String descripcion() {
        return descripcion;
    }

    @Override
    public double precio() {
        return precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
