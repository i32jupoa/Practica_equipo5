package bridge;
import java.util.Arrays;
import java.util.List;

public class EmpresaA implements Proveedor {
    @Override
    public List<Producto> obtenerProductos() {
        return Arrays.asList(
            new Sofa("Sofá Chaise Longue", 450.0, 5, 3),
            new Sofa("Sofá Piel Clásico", 600.0, 0, 2) // Sin stock
        );
    }
}