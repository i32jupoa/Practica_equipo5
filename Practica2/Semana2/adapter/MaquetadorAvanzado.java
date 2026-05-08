package adapter;

import java.io.File;
import java.util.List;

public interface MaquetadorAvanzado {
    // 1) Unir dos ficheros de texto [cite: 96]
    // REFACTORIZACIÓN (Semana 1 - Nombrado): Se evitan variables con numeraciones (f1, f2) usando nombres descriptivos (Regla 4).
    void unirFicheros(File ficheroDestino, File ficheroAAnadir);

   // REFACTORIZACIÓN (Semana 1 - Nombrado): Se eliminan abreviaturas y numeraciones en los parámetros (Regla 4).
    void combinarFicheros(File fichero1, File fichero2, List<int[]> parrafosFichero1, List<int[]> parrafosFichero2, File ficheroDestinoFinal);
    // 3) Separar un fichero en varios, indicando puntos de corte [cite: 99]
    void separarFichero(File origen, List<Integer> puntosCorte, List<File> destinos);
}