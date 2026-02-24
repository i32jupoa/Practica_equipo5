package abstractfactory;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos las factorías
        FactoriaAbstracta factoriaRestaurante = new FactoriaRestaurante();
        FactoriaAbstracta factoriaParaLlevar = new FactoriaParaLlevar();

        System.out.println("=== PEDIDOS EN EL RESTAURANTE ===");
        
        System.out.println("Menú Semanal (con ensalada):");
        Menu semanalLocal = factoriaRestaurante.crearMenuSemanal(Acompanamiento.ENSALADA);
        semanalLocal.mostrarMenu();

        System.out.println("Menú Temporada:");
        Menu temporadaLocal = factoriaRestaurante.crearMenuTemporada();
        temporadaLocal.mostrarMenu();

        System.out.println("=== PEDIDOS PARA LLEVAR ===");
        
        System.out.println("Menú Semanal (con patatas):");
        Menu semanalLlevar = factoriaParaLlevar.crearMenuSemanal(Acompanamiento.PATATAS);
        semanalLlevar.mostrarMenu();

        System.out.println("Menú Temporada:");
        Menu temporadaLlevar = factoriaParaLlevar.crearMenuTemporada();
        temporadaLlevar.mostrarMenu();
    }
}