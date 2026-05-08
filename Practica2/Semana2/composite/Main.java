package composite;

public class Main {
    // REFACTORIZACIÓN (Semana 2 - Comentarios y Formato): Se eliminan los comentarios de tipo "paso a paso" (1., 2., 3...) que ensucian la lectura, sustituyéndolos por un correcto espaciado vertical que agrupa los conceptos afines de manera natural (Regla 10 Comentarios y Reglas de Formato Vertical).
    public static void main(String[] args) {
        double precioKwh = 0.15;

        Espacio campus = new Espacio("Campus Rabanales", "Campus");

        Espacio edificioAulario = new Espacio("Aulario Averroes", "Edificio");
        Espacio edificioDepartamental = new Espacio("Albert Einstein", "Edificio");

        Espacio aula1 = new Espacio("Aula 1", "Sala");
        Espacio aula2 = new Espacio("Aula 2", "Sala");

        AparatoElectrico proyector1 = new AparatoElectrico("Proyector", 0.3, 5); 
        AparatoElectrico pcProfesor1 = new AparatoElectrico("PC Profesor", 0.25, 6);
        AparatoElectrico aireAcondicionado = new AparatoElectrico("Aire Acondicionado", 2.0, 8);

        aula1.agregarComponente(proyector1);
        aula1.agregarComponente(pcProfesor1);
        aula1.agregarComponente(aireAcondicionado);

        aula2.agregarComponente(new AparatoElectrico("Proyector", 0.3, 4));
        aula2.agregarComponente(new AparatoElectrico("PC Profesor", 0.25, 4));
        
        AparatoElectrico maquinaVending = new AparatoElectrico("Máquina Vending Pasillo", 0.4, 24); 
        AparatoElectrico maquinaCafe = new AparatoElectrico("Máquina Café", 0.5, 24);

        edificioAulario.agregarComponente(aula1);
        edificioAulario.agregarComponente(aula2);
        edificioAulario.agregarComponente(maquinaVending); 

        edificioDepartamental.agregarComponente(maquinaCafe);
        edificioDepartamental.agregarComponente(new AparatoElectrico("Servidor Departamental", 1.5, 24));

        campus.agregarComponente(edificioAulario);
        campus.agregarComponente(edificioDepartamental);

        System.out.println("=== REPORTE DE GASTO ENERGÉTICO ===");
        System.out.println("Precio Kwh actual: " + precioKwh + "€\n");
        campus.mostrarDetalles("");
    }
}