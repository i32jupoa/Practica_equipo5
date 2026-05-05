package facade;

public class Main {
    public static void main(String[] args) {
        // Instanciamos la fachada (el cliente solo conoce esta clase)
        BuscadorViajesFacade agenciaDeViajes = new BuscadorViajesFacade();

        // Caso de Uso 1: Viaje a Madrid
        agenciaDeViajes.buscarViajeCompleto(
            "15/10/2026", "20/10/2026",
            "Sevilla", "Madrid"
        );

        // Caso de Uso 2: Viaje a Córdoba
        agenciaDeViajes.buscarViajeCompleto(
            "01/05/2026", "05/05/2026",
            "Sevilla", "Córdoba"
        );

        // Caso de Uso 3: Viaje a una ciudad sin transporte ni turismo (simulando falta de stock)
        agenciaDeViajes.buscarViajeCompleto(
            "10/11/2026", "15/11/2026",
            "Córdoba", "Valencia"
        );
    }
}