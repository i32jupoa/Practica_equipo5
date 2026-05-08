package composite;

public class Main {
    public static void main(String[] args) {
        // Precio simulado del kWh
        double precioKwh = 0.15;

        // 1. Crear el Campus (Nivel más alto)
        Espacio campus = new Espacio("Campus Rabanales", "Campus");

        // 2. Crear Edificios
        Espacio edificioAulario = new Espacio("Aulario Averroes", "Edificio");
        Espacio edificioDepartamental = new Espacio("Albert Einstein", "Edificio");

        // 3. Crear Salas para el Aulario
        Espacio aula1 = new Espacio("Aula 1", "Sala");
        Espacio aula2 = new Espacio("Aula 2", "Sala");

        // 4. Crear Aparatos Eléctricos para las aulas
        AparatoElectrico proyector1 = new AparatoElectrico("Proyector", 0.3, 5); // 0.3 kWh, 5h
        AparatoElectrico pcProfesor1 = new AparatoElectrico("PC Profesor", 0.25, 6);
        AparatoElectrico aireAcondicionado = new AparatoElectrico("Aire Acondicionado", 2.0, 8);

        // Asignar aparatos a las aulas
        aula1.agregarComponente(proyector1);
        aula1.agregarComponente(pcProfesor1);
        aula1.agregarComponente(aireAcondicionado);

        aula2.agregarComponente(new AparatoElectrico("Proyector", 0.3, 4));
        aula2.agregarComponente(new AparatoElectrico("PC Profesor", 0.25, 4));
        // 5. Crear aparatos fuera de las salas (ej. Máquina vending en el pasillo del edificio)
        AparatoElectrico maquinaVending = new AparatoElectrico("Máquina Vending Pasillo", 0.4, 24); // 24h encendida
        AparatoElectrico maquinaCafe = new AparatoElectrico("Máquina Café", 0.5, 24);

        // 6. Construir el árbol (Composición)
        edificioAulario.agregarComponente(aula1);
        edificioAulario.agregarComponente(aula2);
        edificioAulario.agregarComponente(maquinaVending); // Aparato directo al edificio

        edificioDepartamental.agregarComponente(maquinaCafe);
        edificioDepartamental.agregarComponente(new AparatoElectrico("Servidor Departamental", 1.5, 24));

        campus.agregarComponente(edificioAulario);
        campus.agregarComponente(edificioDepartamental);

        // 7. Mostrar resultados
        System.out.println("=== REPORTE DE GASTO ENERGÉTICO ===");
        System.out.println("Precio Kwh actual: " + precioKwh + "€\n");
        campus.mostrarDetalles("");
    }
}