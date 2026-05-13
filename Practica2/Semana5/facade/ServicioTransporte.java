package facade;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioTransporte {
    private List<String> trayectos = Arrays.asList(
        "AVE: Sevilla -> Madrid",
        "Autobús: Sevilla -> Córdoba",
        "Vuelo: Barcelona -> Madrid"
    );

    public List<String> buscarTransporte(String origen, String destino, String fechaIda, String fechaVuelta) {
        String rutaBuscada = origen + " -> " + destino;
        return trayectos.stream()
            .filter(t -> t.contains(rutaBuscada))
            .map(t -> t + " [Ida: " + fechaIda + " | Vuelta: " + fechaVuelta + "]")
            .collect(Collectors.toList());
    }
}