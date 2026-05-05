package bridge;

public class Sofa extends Producto {
    private int plazas;

    public Sofa(String nombre, double precio, int unidades, int plazas) {
        super(nombre, precio, unidades);
        this.plazas = plazas;
    }

    public int getPlazas() { return plazas; }

    @Override
    public Producto clonar() {
        return new Sofa(this.nombre, this.precio, this.unidades, this.plazas);
    }

    @Override
    public String toString() {
        return "[Sofá] " + super.toString() + " | Plazas: " + plazas;
    }
}