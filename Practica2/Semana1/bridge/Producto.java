package bridge;

public abstract class Producto {
    protected String nombre;
    protected double precio;
    protected int unidades;

    public Producto(String nombre, double precio, int unidades) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getUnidades() { return unidades; }
    public void setUnidades(int unidades) { this.unidades = unidades; }

    public abstract Producto clonar();

    @Override
    public String toString() {
        return nombre + " | Precio: " + precio + "€ | Stock: " + unidades;
    }
}