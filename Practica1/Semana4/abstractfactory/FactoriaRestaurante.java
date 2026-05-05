package abstractfactory;

public class FactoriaRestaurante implements FactoriaAbstracta {

    @Override
    public Menu crearMenuSemanal(Acompanamiento acompanamiento) {
        Menu menu = new MenuSemanal();
        // El menú en el restaurante incluye entrante, principal y postre 
        menu.asignarPlato(new Plato("Sopa de picadillo", 5.0f, TipoPlato.ENTRANTE, Acompanamiento.NINGUNO));
        // Se puede elegir el acompañamiento en el menú 
        menu.asignarPlato(new Plato("Solomillo al punto", 12.0f, TipoPlato.PRINCIPAL, acompanamiento));
        menu.asignarPlato(new Plato("Tarta de queso", 4.5f, TipoPlato.POSTRE, Acompanamiento.NINGUNO));
        return menu;
    }

    @Override
    public Menu crearMenuTemporada() {
        Menu menu = new MenuTemporada();
        menu.asignarPlato(new Plato("Guiso de la abuela", 18.0f, TipoPlato.UNICO, Acompanamiento.NINGUNO));
        return menu;
    }
}