package adapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1. Crear ficheros de prueba
        File doc1 = new File("doc1.txt");
        File doc2 = new File("doc2.txt");
        File docDestino = new File("destinoCombinado.txt");
        
        crearFicheroPrueba(doc1, "Linea 1 D1\nLinea 2 D1\nLinea 3 D1\nLinea 4 D1\nLinea 5 D1");
        crearFicheroPrueba(doc2, "Linea 1 D2\nLinea 2 D2\nLinea 3 D2\nLinea 4 D2\nLinea 5 D2");

        // 2. Instanciar el adaptador (el cliente solo ve la interfaz avanzada)
        MaquetadorAvanzado maquetador = new AdaptadorMaquetador();

        // --- PRUEBA 1: Unir Ficheros ---
        System.out.println("Ejecutando unirFicheros(doc1, doc2)...");
        maquetador.unirFicheros(doc1, doc2);
        System.out.println("Revisa 'doc1.txt' para ver el resultado.");

        // --- PRUEBA 2: Combinar Ficheros ---
        System.out.println("\nEjecutando combinarFicheros()...");
        maquetador.combinarFicheros(
            new File("doc1.txt"), 
            new File("doc2.txt"), 
            Arrays.asList(new int[]{1, 2}, new int[]{4, 5}), // Párrafos doc 1 (Líneas 1-2, 4-5)
            Arrays.asList(new int[]{1, 1}, new int[]{3, 3}), // Párrafos doc 2 (Línea 1, Línea 3)
            docDestino
        );
        System.out.println("Revisa 'destinoCombinado.txt' para ver el resultado.");
        
        // --- PRUEBA 3: Separar Ficheros ---
        System.out.println("\nEjecutando separarFichero() en 'doc2.txt'...");
        maquetador.separarFichero(
            new File("doc2.txt"), 
            Arrays.asList(3), // Cortar en la línea 3
            Arrays.asList(new File("parte1.txt"), new File("parte2.txt"))
        );
        System.out.println("Revisa 'parte1.txt' y 'parte2.txt'.");
    }

    // Método auxiliar rápido para crear los ficheros de texto para la prueba
    private static void crearFicheroPrueba(File archivo, String contenido) {
        try (FileWriter fw = new FileWriter(archivo)) {
            fw.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}