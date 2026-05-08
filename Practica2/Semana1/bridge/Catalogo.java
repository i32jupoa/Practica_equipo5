package bridge;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Catalogo {
    protected List<Proveedor> proveedores = new ArrayList<>();

    // REFACTORIZACIÓN (Semana 1 - Nombrado): Se cambia la variable de una letra 'p' por 'nuevoProveedor' (Regla 6).
    public void agregarProveedor(Proveedor nuevoProveedor) {
        proveedores.add(nuevoProveedor);
    }

    // REFACTORIZACIÓN (Semana 1 - Nombrado): Se cambia la variable 'p' por 'proveedor' (Regla 6).
    public List<Producto> buscarGeneral() {
        List<Producto> todos = new ArrayList<>();
        for (Proveedor proveedor : proveedores) {
            todos.addAll(proveedor.obtenerProductos());
        }
        return todos;
    }

    // REFACTORIZACIÓN (Semana 1 - Nombrado): Se cambia la variable 'p' por 'producto' en las expresiones Lambda (Regla 6).
    public List<Producto> buscarPorPrecioMenorAMayor() {
        return buscarGeneral().stream()
            .filter(producto -> producto.getUnidades() > 0)
            .sorted(Comparator.comparingDouble(Producto::getPrecio))
            .collect(Collectors.toList());
    }

    public List<Producto> buscarPorUnidadesMayorAMenor() {
        Map<String, Producto> productosAgrupados = new HashMap<>();

        for (Producto producto : buscarGeneral()) {
            if (producto.getUnidades() > 0) {
                if (productosAgrupados.containsKey(producto.getNombre())) {
                    Producto existente = productosAgrupados.get(producto.getNombre());
                    existente.setUnidades(existente.getUnidades() + producto.getUnidades());
                } else {
                    productosAgrupados.put(producto.getNombre(), producto.clonar());
                }
            }
        }

        // REFACTORIZACIÓN (Semana 1 - Nombrado): Se sustituye numeración en variables p1, p2 por producto1, producto2 (Regla 4 y 6).
        return productosAgrupados.values().stream()
            .sorted((producto1, producto2) -> Integer.compare(producto2.getUnidades(), producto1.getUnidades()))
            .collect(Collectors.toList());
    }
}