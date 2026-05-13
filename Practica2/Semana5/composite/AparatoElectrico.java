package composite;

public class AparatoElectrico implements ComponenteEnergetico {
    private String nombre;
    private double consumoPorHora; // En kWh
    private int horasUso;

    public AparatoElectrico(String nombre, double consumoPorHora, int horasUso) {
        this.nombre = nombre;
        this.consumoPorHora = consumoPorHora;
        this.horasUso = horasUso;
    }

    @Override
    public double getConsumoEstimado() {
        return consumoPorHora * horasUso;
    }

    @Override
    public double getCosteEstimado(double precioKwh) {
        return getConsumoEstimado() * precioKwh;
    }

    @Override
    public void mostrarDetalles(String indentacion) {
        System.out.println(indentacion + "- Aparato: " + nombre 
            + " (Consumo: " + getConsumoEstimado() + " kWh, Coste: " 
            + String.format("%.2f", getCosteEstimado(0.15)) + "€)");
    }
}