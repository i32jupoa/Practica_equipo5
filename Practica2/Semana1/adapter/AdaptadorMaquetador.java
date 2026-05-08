package adapter;

import java.io.File;
import java.util.List;

public class AdaptadorMaquetador implements MaquetadorAvanzado {
    
    private MaquetadorBasico maquetadorBasico;

    public AdaptadorMaquetador() {
        this.maquetadorBasico = new MaquetadorBasico();
    }

    // REFACTORIZACIÓN (Semana 1 - Nombrado): Se evitan variables con numeraciones (f1, f2) (Regla 4).
    @Override
    public void unirFicheros(File ficheroDestino, File ficheroAAnadir) {
        String contenidoAAnadir = maquetadorBasico.extraerParrafo(ficheroAAnadir, 1, Integer.MAX_VALUE);
        maquetadorBasico.anadirTextoAlFinal(contenidoAAnadir, ficheroDestino);
    }

    // REFACTORIZACIÓN (Semana 1 - Nombrado): Se sustituyen abreviaturas (p1, p2) y variables numeradas por nombres con sentido (Regla 4).
    @Override
    public void combinarFicheros(File fichero1, File fichero2, List<int[]> parrafosFichero1, List<int[]> parrafosFichero2, File ficheroDestinoFinal) {
        int maxSize = Math.max(parrafosFichero1.size(), parrafosFichero2.size());
        
        for (int i = 0; i < maxSize; i++) {
            if (i < parrafosFichero1.size()) {
                int[] rangoLineasFichero1 = parrafosFichero1.get(i);
                String textoParrafo1 = maquetadorBasico.extraerParrafo(fichero1, rangoLineasFichero1[0], rangoLineasFichero1[1]);
                maquetadorBasico.anadirTextoAlFinal(textoParrafo1, ficheroDestinoFinal);
            }
            if (i < parrafosFichero2.size()) {
                int[] rangoLineasFichero2 = parrafosFichero2.get(i);
                String textoParrafo2 = maquetadorBasico.extraerParrafo(fichero2, rangoLineasFichero2[0], rangoLineasFichero2[1]);
                maquetadorBasico.anadirTextoAlFinal(textoParrafo2, ficheroDestinoFinal);
            }
        }
    }

    @Override
    public void separarFichero(File origen, List<Integer> puntosCorte, List<File> destinos) {
        File ficheroActual = origen;
        
        for (int i = 0; i < puntosCorte.size(); i++) {
            File destinoActual = destinos.get(i);
            File resto = (i == puntosCorte.size() - 1) ? destinos.get(i + 1) : new File("temp_" + i + ".txt");
            int lineaCorte = (i == 0) ? puntosCorte.get(i) : puntosCorte.get(i) - puntosCorte.get(i - 1) + 1;
            
            maquetadorBasico.dividirFichero(ficheroActual, lineaCorte, destinoActual, resto);
            ficheroActual = resto; 
        }
        
        for (int i = 0; i < puntosCorte.size() - 1; i++) {
            new File("temp_" + i + ".txt").delete();
        }
    }
}