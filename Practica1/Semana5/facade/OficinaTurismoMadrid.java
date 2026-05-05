package facade;
import java.util.Arrays;
import java.util.List;

public class OficinaTurismoMadrid {
    // Esta oficina solo permite buscar pasando una única fecha puntual
    public List<String> buscarEventosPorFecha(String fecha) {
        return Arrays.asList(
            "Musical El Rey León (Madrid) el " + fecha,
            "Tour Bernabéu (Madrid) el " + fecha
        );
    }
}