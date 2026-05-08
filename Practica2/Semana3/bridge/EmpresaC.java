package bridge;
import java.util.Arrays;
import java.util.List;

public class EmpresaC implements Proveedor {
    @Override
    public List<Producto> obtenerProductos() {
        return Arrays.asList(
            new Sofa("Sofá Chaise Longue", 480.0, 2, 3), // Mismo nombre que EmpresaA, distinto precio
            new Mesa("Mesa Oficina Cristal", 110.0, 5, "150x80")
        );
    }
}