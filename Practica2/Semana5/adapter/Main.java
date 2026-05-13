package adapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File doc1 = new File("doc1.txt");
        File doc2 = new File("doc2.txt");
        File docDestino = new File("destinoCombinado.txt");
        
        crearFicheroPrueba(doc1, "Linea 1 D1\nLinea 2 D1\nLinea 3 D1\nLinea 4 D1\nLinea 5 D1");
        crearFicheroPrueba(doc2, "Linea 1 D2\nLinea 2 D2\nLinea 3 D2\nLinea 4 D2\nLinea 5 D2");

        MaquetadorAvanzado maquetador = new AdaptadorMaquetador();

        // REFACTORIZACIÓN AUTOMÁTICA (Semana 5): Se ha utilizado la herramienta "Extract Method" del IDE 
        // para encapsular la lógica de cada bloque de pruebas en sus propias funciones, limpiando el método main.
        probarUnirFicheros(maquetador, doc1, doc2);
        probarCombinarFicheros(maquetador, doc1, doc2, docDestino);
        probarSepararFichero(maquetador, doc2);
    }

    private static void probarUnirFicheros(MaquetadorAvanzado maquetador, File doc1, File doc2) {
        System.out.println("Ejecutando unirFicheros(doc1, doc2)...");
        maquetador.unirFicheros(doc1, doc2);
        System.out.println("Revisa 'doc1.txt' para ver el resultado.");
    }

    private static void probarCombinarFicheros(MaquetadorAvanzado maquetador, File doc1, File doc2, File docDestino) {
        System.out.println("\nEjecutando combinarFicheros()...");
        maquetador.combinarFicheros(
            doc1, doc2, 
            Arrays.asList(new int[]{1, 2}, new int[]{4, 5}), 
            Arrays.asList(new int[]{1, 1}, new int[]{3, 3}), 
            docDestino
        );
        System.out.println("Revisa 'destinoCombinado.txt' para ver el resultado.");
    }

    private static void probarSepararFichero(MaquetadorAvanzado maquetador, File doc2) {
        System.out.println("\nEjecutando separarFichero() en 'doc2.txt'...");
        maquetador.separarFichero(
            doc2, Arrays.asList(3), Arrays.asList(new File("parte1.txt"), new File("parte2.txt"))
        );
        System.out.println("Revisa 'parte1.txt' y 'parte2.txt'.");
    }

    private static void crearFicheroPrueba(File archivo, String contenido) {
        try (FileWriter fw = new FileWriter(archivo)) {
            fw.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}