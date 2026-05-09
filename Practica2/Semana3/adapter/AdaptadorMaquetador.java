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
    // REFACTORIZACIÓN (Semana 3 - Funciones): Se extrae el bloque condicional repetitivo a la función privada "procesarParrafoSiExiste", reduciendo los niveles de anidamiento de la función original.
    @Override
    public void combinarFicheros(File fichero1, File fichero2, List<int[]> parrafosFichero1, List<int[]> parrafosFichero2, File ficheroDestinoFinal) {
        int maxSize = Math.max(parrafosFichero1.size(), parrafosFichero2.size());
        
        for (int i = 0; i < maxSize; i++) {
            procesarParrafoSiExiste(fichero1, parrafosFichero1, i, ficheroDestinoFinal);
            procesarParrafoSiExiste(fichero2, parrafosFichero2, i, ficheroDestinoFinal);
        }
    }

    private void procesarParrafoSiExiste(File ficheroOrigen, List<int[]> parrafos, int indiceActual, File destino) {
        if (indiceActual < parrafos.size()) {
            int[] rangoLineas = parrafos.get(indiceActual);
            String textoParrafo = maquetadorBasico.extraerParrafo(ficheroOrigen, rangoLineas[0], rangoLineas[1]);
            maquetadorBasico.anadirTextoAlFinal(textoParrafo, destino);
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