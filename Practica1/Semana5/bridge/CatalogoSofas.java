package bridge;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoSofas extends Catalogo {
    public List<Sofa> buscarSofasPorPlazas(int plazas) {
        return buscarGeneral().stream()
            .filter(p -> p instanceof Sofa)
            .map(p -> (Sofa) p)
            .filter(s -> s.getPlazas() == plazas && s.getUnidades() > 0)
            .collect(Collectors.toList());
    }
}