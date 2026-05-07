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
// REFACTORIZACIÓN (Semana 1 - Nombrado): Se cambia la variable de una sola letra 'p' por un nombre descriptivo 'plato' (Regla 6).
    public void mostrarMenu() {
        for (Plato plato : platos) {
            System.out.println("  - " + plato.toString());
        }
        System.out.println("  TOTAL: " + String.format("%.2f", calcularPrecio()) + "€\n");
    }
}