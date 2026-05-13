package facade;

public class Main {
    public static void main(String[] args) {
        BuscadorViajesFacade agenciaDeViajes = new BuscadorViajesFacade();

        // REFACTORIZACIÓN AUTOMÁTICA (Semana 5): Se utiliza la herramienta "Extract Variable" del IDE 
        // para extraer las fechas literales a variables descriptivas, mejorando la legibilidad de la llamada.
        
        // Caso de Uso 1: Viaje a Madrid
        String fechaIdaMadrid = "15/10/2026";
        String fechaVueltaMadrid = "20/10/2026";
        agenciaDeViajes.buscarViajeCompleto(fechaIdaMadrid, fechaVueltaMadrid, "Sevilla", "Madrid");

        // Caso de Uso 2: Viaje a Córdoba
        String fechaIdaCordoba = "01/05/2026";
        String fechaVueltaCordoba = "05/05/2026";
        agenciaDeViajes.buscarViajeCompleto(fechaIdaCordoba, fechaVueltaCordoba, "Sevilla", "Córdoba");

        // Caso de Uso 3: Viaje a Valencia
        String fechaIdaValencia = "10/11/2026";
        String fechaVueltaValencia = "15/11/2026";
        agenciaDeViajes.buscarViajeCompleto(fechaIdaValencia, fechaVueltaValencia, "Córdoba", "Valencia");
    }
}