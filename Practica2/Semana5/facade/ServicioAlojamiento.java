package facade;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioAlojamiento {
    private List<String> hotelesDisponibles = Arrays.asList(
        "Hotel Meliá (Madrid) - Disponible",
        "Hostal Sol (Madrid) - Disponible",
        "Hotel Center (Córdoba) - Disponible",
        "Apartamentos Mezquita (Córdoba) - Disponible"
    );

    public List<String> buscarAlojamiento(String ciudad, String fechaInicio, String fechaFin) {
        // Simulamos la búsqueda filtrando por la ciudad
        return hotelesDisponibles.stream()
            .filter(h -> h.contains(ciudad))
            .map(h -> h + " [Fechas: " + fechaInicio + " al " + fechaFin + "]")
            .collect(Collectors.toList());
    }
}