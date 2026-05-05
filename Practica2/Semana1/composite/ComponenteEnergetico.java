package composite;

public interface ComponenteEnergetico {
    // Calcula el consumo global estimado
    double getConsumoEstimado();
    
    // Calcula el coste total en base al precio del kWh
    double getCosteEstimado(double precioKwh);
    
    // Método auxiliar para imprimir la jerarquía de forma visual
    void mostrarDetalles(String indentacion);
}