package adapter;

import java.io.File;
import java.util.List;

public interface MaquetadorAvanzado {
    // 1) Unir dos ficheros de texto [cite: 96]
    void unirFicheros(File f1, File f2);

    // 2) Combinar el contenido de ambos ficheros intercalando párrafos [cite: 97, 98]
    void combinarFicheros(File f1, File f2, List<int[]> parrafosF1, List<int[]> parrafosF2, File destino);

    // 3) Separar un fichero en varios, indicando puntos de corte [cite: 99]
    void separarFichero(File origen, List<Integer> puntosCorte, List<File> destinos);
}