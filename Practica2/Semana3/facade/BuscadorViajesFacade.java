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

    // REFACTORIZACIÓN (Semana 3 - Funciones): Se divide una función enorme que hacía demasiadas cosas en varias funciones privadas más pequeñas, respetando el principio de responsabilidad única (Reglas 1 y 3 de Funciones).
    public void buscarViajeCompleto(String fechaInicio, String fechaFin, String origen, String destino) {
        imprimirCabecera(origen, destino, fechaInicio, fechaFin);
        mostrarOpcionesTransporte(origen, destino, fechaInicio, fechaFin);
        mostrarOpcionesAlojamiento(destino, fechaInicio, fechaFin);
        mostrarActividadesCulturales(destino, fechaInicio, fechaFin);
        System.out.println("=========================================================\n");
    }

    private void imprimirCabecera(String origen, String destino, String fechaInicio, String fechaFin) {
        System.out.println("\n=========================================================");
        System.out.println("BÚSQUEDA DE VIAJE: " + origen + " -> " + destino);
        System.out.println("Fechas: " + fechaInicio + " al " + fechaFin);
        System.out.println("=========================================================");
    }

    private void mostrarOpcionesTransporte(String origen, String destino, String fechaInicio, String fechaFin) {
        System.out.println("\n✈️  Opciones de Transporte:");
        List<String> transportes = transporte.buscarTransporte(origen, destino, fechaInicio, fechaFin);
        if (transportes.isEmpty()) System.out.println("   No hay transportes disponibles.");
        else transportes.forEach(t -> System.out.println("   - " + t));
    }

    private void mostrarOpcionesAlojamiento(String destino, String fechaInicio, String fechaFin) {
        System.out.println("\n🏨 Opciones de Alojamiento:");
        List<String> alojamientos = alojamiento.buscarAlojamiento(destino, fechaInicio, fechaFin);
        if (alojamientos.isEmpty()) System.out.println("   No hay alojamientos disponibles.");
        else alojamientos.forEach(a -> System.out.println("   - " + a));
    }

    private void mostrarActividadesCulturales(String destino, String fechaInicio, String fechaFin) {
        System.out.println("\n🎭 Actividades en destino:");
        if (destino.equalsIgnoreCase("Madrid")) {
            List<String> actividades = turismoMadrid.buscarEventosPorFecha(fechaInicio);
            actividades.forEach(act -> System.out.println("   - " + act));
        } else if (destino.equalsIgnoreCase("Córdoba")) {
            List<String> actividades = turismoCordoba.buscarEventos("Cultural", fechaInicio, fechaFin);
            actividades.forEach(act -> System.out.println("   - " + act));
        } else {
            System.out.println("   No tenemos oficina de turismo registrada para " + destino);
        }
    }
}