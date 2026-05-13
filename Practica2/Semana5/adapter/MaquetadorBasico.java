package adapter;

import java.io.*;

public class MaquetadorBasico {

    public void anadirTextoAlFinal(String texto, File archivo) {
        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(texto);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al añadir texto: " + e.getMessage());
        }
    }

    // REFACTORIZACIÓN (Semana 3 - Funciones): Se separa la lógica de negocio del bloque de manejo de errores try/catch, delegando el algoritmo de lectura a una función auxiliar privada (Regla Excepciones 2).
    public String extraerParrafo(File archivo, int lineaInicio, int lineaFin) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            return leerLineasDelParrafo(br, lineaInicio, lineaFin);
        } catch (IOException e) {
            System.err.println("Error al extraer párrafo: " + e.getMessage());
            return "";
        }
    }

    private String leerLineasDelParrafo(BufferedReader br, int lineaInicio, int lineaFin) throws IOException {
        StringBuilder parrafo = new StringBuilder();
        String linea;
        int lineaActual = 1;
        while ((linea = br.readLine()) != null) {
            if (lineaActual >= lineaInicio && lineaActual <= lineaFin) {
                parrafo.append(linea).append("\n");
            }
            if (lineaActual > lineaFin) break;
            lineaActual++;
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