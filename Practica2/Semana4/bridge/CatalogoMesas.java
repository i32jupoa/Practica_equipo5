package bridge;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoMesas extends Catalogo {
    public List<Mesa> buscarMesasPorDimensiones(String dimensiones) {
        return buscarGeneral().stream()
            .filter(p -> p instanceof Mesa)
            .map(p -> (Mesa) p)
            .filter(m -> m.getDimensiones().equalsIgnoreCase(dimensiones) && m.getUnidades() > 0)
            .collect(Collectors.toList());
    }
}