package abstractfactory;

public class Plato {
    private String nombre;
    private float precio;
    private TipoPlato tipo;
    private Acompanamiento acompanamiento;

    public Plato(String nombre, float precio, TipoPlato tipo, Acompanamiento acompanamiento) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.acompanamiento = acompanamiento;
    }

    public float getPrecio() {
        return precio;
    }

    public void asignarPrecio(float nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    @Override
    public String toString() {
        String acompStr = (acompanamiento != Acompanamiento.NINGUNO) ? " (con " + acompanamiento + ")" : "";
        return tipo + ": " + nombre + acompStr + " - " + String.format("%.2f", precio) + "€";
    }
}