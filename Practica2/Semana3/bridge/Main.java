package bridge;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Proveedor empA = new EmpresaA(); // Sofás
        Proveedor empB = new EmpresaB(); // Mesas
        Proveedor empC = new EmpresaC(); // Sofás y Mesas

        System.out.println("=== 1. CATÁLOGO DE MESAS (Proveedores B y C) ===");
        CatalogoMesas catalogoMesas = new CatalogoMesas();
        catalogoMesas.agregarProveedor(empB);
        catalogoMesas.agregarProveedor(empC);
        
        System.out.println("-> Búsqueda específica: Mesas de 150x80");
        imprimir(catalogoMesas.buscarMesasPorDimensiones("150x80"));

        System.out.println("\n=== 2. CATÁLOGO DE SOFÁS (Proveedores A y C) ===");
        CatalogoSofas catalogoSofas = new CatalogoSofas();
        catalogoSofas.agregarProveedor(empA);
        catalogoSofas.agregarProveedor(empC);

        System.out.println("-> Búsqueda específica: Sofás de 3 plazas");
        imprimir(catalogoSofas.buscarSofasPorPlazas(3));

        System.out.println("\n=== 3. BÚSQUEDAS AVANZADAS GLOBALES ===");
        // Para usar todos los productos, podemos instanciar cualquier catálogo y añadir todos
        // o crear un CatalogoGeneral. Usaremos CatalogoMesas como base agregando a todos.
        Catalogo catalogoGlobal = new CatalogoMesas(); 
        catalogoGlobal.agregarProveedor(empA);
        catalogoGlobal.agregarProveedor(empB);
        catalogoGlobal.agregarProveedor(empC);

        System.out.println("-> a) Por precio (Menor a Mayor) - Excluye sin stock");
        imprimir(catalogoGlobal.buscarPorPrecioMenorAMayor());

        System.out.println("\n-> b) Por Unidades Disponibles (Mayor a Menor) - Sumando stock de empresas");
        imprimir(catalogoGlobal.buscarPorUnidadesMayorAMenor());
    }

    private static void imprimir(List<? extends Producto> productos) {
        if (productos.isEmpty()) System.out.println("No se encontraron productos.");
        for (Producto p : productos) {
            System.out.println("   " + p.toString());
        }
    }
}