package abstractfactory;

public class FactoriaParaLlevar implements FactoriaAbstracta {

    // Método auxiliar para calcular el incremento del 2%
    private float aplicarIncremento(float precioBase) {
        return precioBase * 1.02f;
    }

    @Override
    public Menu crearMenuSemanal(Acompanamiento acompanamiento) {
        Menu menu = new MenuSemanal();
        menu.asignarPlato(new Plato("Sopa de picadillo", aplicarIncremento(5.0f), TipoPlato.ENTRANTE, Acompanamiento.NINGUNO));
        menu.asignarPlato(new Plato("Solomillo al punto", aplicarIncremento(12.0f), TipoPlato.PRINCIPAL, acompanamiento));
        return menu;
    }

    @Override
    public Menu crearMenuTemporada() {
        Menu menu = new MenuTemporada();
        // Los platos de temporada también tienen un incremento del 2% si son para llevar
        menu.asignarPlato(new Plato("Guiso de la abuela", aplicarIncremento(18.0f), TipoPlato.UNICO, Acompanamiento.NINGUNO));
        return menu;
    }
}