package adapter;

import java.io.*;

public class MaquetadorBasico {

    // REFACTORIZACIÓN (Semana 2 - Comentarios): Se eliminan los comentarios redundantes en la cabecera de los métodos, ya que los nombres de los métodos y sus parámetros son suficientemente claros y autoexplicativos (Regla 4).
    
    public void anadirTextoAlFinal(String texto, File archivo) {
        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(texto);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al añadir texto: " + e.getMessage());
        }
    }

    public String extraerParrafo(File archivo, int lineaInicio, int lineaFin) {
        StringBuilder parrafo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int lineaActual = 1;
            while ((linea = br.readLine()) != null) {
                if (lineaActual >= lineaInicio && lineaActual <= lineaFin) {
                    parrafo.append(linea).append("\n");
                }
                if (lineaActual > lineaFin) break;
                lineaActual++;
            }
        } catch (IOException e) {
            System.err.println("Error al extraer párrafo: " + e.getMessage());
        }
        return parrafo.toString();
    }

    public void dividirFichero(File archivoOrigen, int lineaCorte, File archivoDestino1, File archivoDestino2) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoOrigen));
             BufferedWriter bw1 = new BufferedWriter(new FileWriter(archivoDestino1));
             BufferedWriter bw2 = new BufferedWriter(new FileWriter(archivoDestino2))) {
            
            String linea;
            int lineaActual = 1;
            while ((linea = br.readLine()) != null) {
                if (lineaActual < lineaCorte) {
                    bw1.write(linea);
                    bw1.newLine();
                } else {
                    bw2.write(linea);
                    bw2.newLine();
                }
                lineaActual++;
            }
        } catch (IOException e) {
            System.err.println("Error al dividir fichero: " + e.getMessage());
        }
    }
}