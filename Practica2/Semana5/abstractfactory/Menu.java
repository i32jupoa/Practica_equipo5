package abstractfactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<Plato> platos = new ArrayList<>();

    // REFACTORIZACIÓN MANUAL (Semana 4): "Pull Up Method" (Subir Método). Se mueve la implementación
    // de calcularPrecio desde las subclases a la clase base abstracta para eliminar código duplicado.
    public float calcularPrecio() {
        float total = 0;
        for (Plato plato : platos) { // Mantenemos el nombre descriptivo de la Semana 1
            total += plato.getPrecio();
        }
        return total;
    }
    
    public List<Plato> obtenerPlatos() {
        return platos;
    }

    public void asignarPlato(Plato plato) {
        platos.add(plato);
    }

    public void mostrarMenu() {
        for (Plato plato : platos) {
            System.out.println("  - " + plato.toString());
        }
        System.out.println("  TOTAL: " + String.format("%.2f", calcularPrecio()) + "€\n");
    }
}