package facade;
import java.util.List;

public class BuscadorViajesFacade {
    private ServicioTransporte transporte;
    private ServicioAlojamiento alojamiento;
    private OficinaTurismoMadrid turismoMadrid;
    private OficinaTurismoCordoba turismoCordoba;

    public BuscadorViajesFacade() {
        this.transporte = new ServicioTransporte();
        this.alojamiento = new ServicioAlojamiento();
        this.turismoMadrid = new OficinaTurismoMadrid();
        this.turismoCordoba = new OficinaTurismoCordoba();
    }

    public void buscarViajeCompleto(String fechaInicio, String fechaFin, String origen, String destino) {
        System.out.println("\n=========================================================");
        System.out.println("BÚSQUEDA DE VIAJE: " + origen + " -> " + destino);
        System.out.println("Fechas: " + fechaInicio + " al " + fechaFin);
        System.out.println("=========================================================");

        // 1. Buscar Transporte
        System.out.println("\n✈️  Opciones de Transporte:");
        List<String> transportes = transporte.buscarTransporte(origen, destino, fechaInicio, fechaFin);
        if (transportes.isEmpty()) System.out.println("   No hay transportes disponibles.");
        else transportes.forEach(t -> System.out.println("   - " + t));

        // 2. Buscar Alojamiento
        System.out.println("\n🏨 Opciones de Alojamiento:");
        List<String> alojamientos = alojamiento.buscarAlojamiento(destino, fechaInicio, fechaFin);
        if (alojamientos.isEmpty()) System.out.println("   No hay alojamientos disponibles.");
        else alojamientos.forEach(a -> System.out.println("   - " + a));

        // 3. Buscar Actividades Culturales (Adaptándose a las APIs específicas)
        System.out.println("\n🎭 Actividades en destino:");
        if (destino.equalsIgnoreCase("Madrid")) {
            // Madrid solo busca por un día específico, asumimos que sugerimos cosas para el primer día
            List<String> actividades = turismoMadrid.buscarEventosPorFecha(fechaInicio);
            actividades.forEach(act -> System.out.println("   - " + act));
        } else if (destino.equalsIgnoreCase("Córdoba")) {
            // Córdoba busca por tipo y rango completo
            List<String> actividades = turismoCordoba.buscarEventos("Cultural", fechaInicio, fechaFin);
            actividades.forEach(act -> System.out.println("   - " + act));
        } else {
            System.out.println("   No tenemos oficina de turismo registrada para " + destino);
        }
        System.out.println("=========================================================\n");
    }
}