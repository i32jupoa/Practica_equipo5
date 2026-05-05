package facade;
import java.util.Arrays;
import java.util.List;

public class OficinaTurismoCordoba {
    // Esta oficina requiere buscar por tipo de evento y rango de fechas
    public List<String> buscarEventos(String tipoEvento, String fechaInicio, String fechaFin) {
        return Arrays.asList(
            tipoEvento + ": Visita Guiada Mezquita-Catedral (Córdoba) [" + fechaInicio + " a " + fechaFin + "]",
            tipoEvento + ": Ruta Patios (Córdoba) [" + fechaInicio + " a " + fechaFin + "]"
        );
    }
}