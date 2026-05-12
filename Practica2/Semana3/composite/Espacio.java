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

    // REFACTORIZACIÓN MANUAL (Semana 4): "Replace Loop with Pipeline". Se sustituyen los bucles for
    // tradicionales por la API de Streams de Java para calcular el total matemáticamente.
    @Override
    public double getConsumoEstimado() {
        return componentes.stream().mapToDouble(ComponenteEnergetico::getConsumoEstimado).sum();
    }

    // REFACTORIZACIÓN MANUAL (Semana 4): "Replace Loop with Pipeline".
    @Override
    public double getCosteEstimado(double precioKwh) {
        return componentes.stream().mapToDouble(comp -> comp.getCosteEstimado(precioKwh)).sum();
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