package composite;

import java.util.ArrayList;
import java.util.List;

public class Espacio implements ComponenteEnergetico {
    private String nombre;
    private String tipoEspacio; // Ej: "Campus", "Edificio", "Sala"
    private List<ComponenteEnergetico> componentes;

    public Espacio(String nombre, String tipoEspacio) {
        this.nombre = nombre;
        this.tipoEspacio = tipoEspacio;
        this.componentes = new ArrayList<>();
    }

    public void agregarComponente(ComponenteEnergetico componente) {
        componentes.add(componente);
    }

    public void eliminarComponente(ComponenteEnergetico componente) {
        componentes.remove(componente);
    }

    @Override
    public double getConsumoEstimado() {
        double consumoTotal = 0;
        for (ComponenteEnergetico componente : componentes) {
            consumoTotal += componente.getConsumoEstimado();
        }
        return consumoTotal;
    }

    @Override
    public double getCosteEstimado(double precioKwh) {
        double costeTotal = 0;
        for (ComponenteEnergetico componente : componentes) {
            costeTotal += componente.getCosteEstimado(precioKwh);
        }
        return costeTotal;
    }

    @Override
    public void mostrarDetalles(String indentacion) {
        System.out.println(indentacion + "[" + tipoEspacio + "] " + nombre
            + " -> TOTAL Consumo: " + getConsumoEstimado() + " kWh, TOTAL Coste: "
            + String.format("%.2f", getCosteEstimado(0.15)) + "€");
        for (ComponenteEnergetico componente : componentes) {
            componente.mostrarDetalles(indentacion + "    ");
        }
    }
}