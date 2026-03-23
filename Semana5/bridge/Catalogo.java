package bridge;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Catalogo {
    // El "puente" hacia la implementación
    protected List<Proveedor> proveedores = new ArrayList<>();

    public void agregarProveedor(Proveedor p) {
        proveedores.add(p);
    }

    // 1. Método general: Obtener todos los productos de todos los proveedores
    public List<Producto> buscarGeneral() {
        List<Producto> todos = new ArrayList<>();
        for (Proveedor p : proveedores) {
            todos.addAll(p.obtenerProductos());
        }
        return todos;
    }

    // 2. Filtro A: En stock, ordenado por precio de menor a mayor
    public List<Producto> buscarPorPrecioMenorAMayor() {
        return buscarGeneral().stream()
            .filter(p -> p.getUnidades() > 0)
            .sorted(Comparator.comparingDouble(Producto::getPrecio))
            .collect(Collectors.toList());
    }

    // 3. Filtro B: En stock, ordenado por unidades (mayor a menor), agregando stock
    public List<Producto> buscarPorUnidadesMayorAMenor() {
        Map<String, Producto> productosAgrupados = new HashMap<>();

        for (Producto p : buscarGeneral()) {
            if (p.getUnidades() > 0) {
                if (productosAgrupados.containsKey(p.getNombre())) {
                    // Si ya existe, sumamos el stock al clon
                    Producto existente = productosAgrupados.get(p.getNombre());
                    existente.setUnidades(existente.getUnidades() + p.getUnidades());
                } else {
                    // Si no existe, lo clonamos para agregarlo al mapa
                    productosAgrupados.put(p.getNombre(), p.clonar());
                }
            }
        }

        return productosAgrupados.values().stream()
            .sorted((p1, p2) -> Integer.compare(p2.getUnidades(), p1.getUnidades()))
            .collect(Collectors.toList());
    }
}