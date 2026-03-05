package abstractfactory;

public class MenuTemporada extends Menu {
    @Override
    public float calcularPrecio() {
        float total = 0;
        for (Plato p : platos) {
            total += p.getPrecio();
        }
        return total;
    }
}