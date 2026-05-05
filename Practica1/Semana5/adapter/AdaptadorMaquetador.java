package adapter;

import java.io.File;
import java.util.List;

public class AdaptadorMaquetador implements MaquetadorAvanzado {
    
    private MaquetadorBasico maquetadorBasico;

    public AdaptadorMaquetador() {
        this.maquetadorBasico = new MaquetadorBasico();
    }

    @Override
    public void unirFicheros(File f1, File f2) {
        // Extraemos todo el contenido de f2 (poniendo un número de línea fin muy alto)
        String contenidoF2 = maquetadorBasico.extraerParrafo(f2, 1, Integer.MAX_VALUE);
        // Lo añadimos al final de f1 utilizando la operación básica
        maquetadorBasico.anadirTextoAlFinal(contenidoF2, f1);
    }

    @Override
    public void combinarFicheros(File f1, File f2, List<int[]> parrafosF1, List<int[]> parrafosF2, File destino) {
        int maxSize = Math.max(parrafosF1.size(), parrafosF2.size());
        
        for (int i = 0; i < maxSize; i++) {
            // Extraer e insertar párrafo del fichero 1
            if (i < parrafosF1.size()) {
                int[] p1 = parrafosF1.get(i);
                String textoP1 = maquetadorBasico.extraerParrafo(f1, p1[0], p1[1]);
                maquetadorBasico.anadirTextoAlFinal(textoP1, destino);
            }
            // Extraer e insertar párrafo del fichero 2
            if (i < parrafosF2.size()) {
                int[] p2 = parrafosF2.get(i);
                String textoP2 = maquetadorBasico.extraerParrafo(f2, p2[0], p2[1]);
                maquetadorBasico.anadirTextoAlFinal(textoP2, destino);
            }
        }
    }

    @Override
    public void separarFichero(File origen, List<Integer> puntosCorte, List<File> destinos) {
        File ficheroActual = origen;
        
        for (int i = 0; i < puntosCorte.size(); i++) {
            File destinoActual = destinos.get(i);
            
            // Si es el último punto de corte, el resto va al último destino
            File resto = (i == puntosCorte.size() - 1) ? destinos.get(i + 1) : new File("temp_" + i + ".txt");
            
            // Ajustar la línea de corte porque el 'ficheroActual' va siendo cada vez más pequeño
            int lineaCorte = (i == 0) ? puntosCorte.get(i) : puntosCorte.get(i) - puntosCorte.get(i - 1) + 1;
            
            maquetadorBasico.dividirFichero(ficheroActual, lineaCorte, destinoActual, resto);
            
            ficheroActual = resto; // Para la siguiente iteración, el origen es lo que sobró
        }
        
        // Limpieza de ficheros temporales si se crearon
        for (int i = 0; i < puntosCorte.size() - 1; i++) {
            new File("temp_" + i + ".txt").delete();
        }
    }
}