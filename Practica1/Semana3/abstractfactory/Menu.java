package abstractfactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<Plato> platos = new ArrayList<>();

    public abstract float calcularPrecio();
    
    public List<Plato> obtenerPlatos() {
        return platos;
    }

    public void asignarPlato(Plato plato) {
        platos.add(plato);
    }

    public void mostrarMenu() {
        for (Plato p : platos) {
            System.out.println("  - " + p.toString());
        }
        System.out.println("  TOTAL: " + String.format("%.2f", calcularPrecio()) + "€\n");
    }
}