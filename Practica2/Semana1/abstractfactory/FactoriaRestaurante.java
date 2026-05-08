package abstractfactory;

public class FactoriaRestaurante implements FactoriaAbstracta {

    // REFACTORIZACIÓN (Semana 2 - Comentarios y Formato): Se eliminan comentarios redundantes que explicaban la intención del código. Además, se añade espaciado vertical para agrupar lógicamente la instanciación y la asignación de platos (Formato Vertical).
    @Override
    public Menu crearMenuSemanal(Acompanamiento acompanamiento) {
        Menu menu = new MenuSemanal();
        
        menu.asignarPlato(new Plato("Sopa de picadillo", 5.0f, TipoPlato.ENTRANTE, Acompanamiento.NINGUNO));
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