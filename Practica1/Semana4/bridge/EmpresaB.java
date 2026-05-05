package bridge;
import java.util.Arrays;
import java.util.List;

public class EmpresaB implements Proveedor {
    @Override
    public List<Producto> obtenerProductos() {
        return Arrays.asList(
            new Mesa("Mesa Oficina Cristal", 120.0, 10, "150x80"),
            new Mesa("Mesa Comedor Madera", 200.0, 3, "200x100")
        );
    }
}
