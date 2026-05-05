package bridge;

public class Mesa extends Producto {
    private String dimensiones;

    public Mesa(String nombre, double precio, int unidades, String dimensiones) {
        super(nombre, precio, unidades);
        this.dimensiones = dimensiones;
    }

    public String getDimensiones() { return dimensiones; }

    @Override
    public Producto clonar() {
        return new Mesa(this.nombre, this.precio, this.unidades, this.dimensiones);
    }

    @Override
    public String toString() {
        return "[Mesa] " + super.toString() + " | Dimensiones: " + dimensiones;
    }
}