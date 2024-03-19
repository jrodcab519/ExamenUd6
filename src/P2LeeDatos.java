import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class P2LeeDatos {

    public static void main (String[] args) throws IOException {
            File fichero = new File("marcas.dat");
            if (!fichero.exists()) {
                try (RandomAccessFile raf = new RandomAccessFile(fichero,
                        "rw")) {
                    guardarNumeroRegistros(raf, 0);
                }
            }
    }
    private static void guardarNumeroRegistros(RandomAccessFile raf, int numRegistros) throws IOException {
        raf.seek(0);
        raf.writeInt(numRegistros);
    }
    private static int leerNumeroRegistros(RandomAccessFile raf) throws IOException {
        raf.seek(0);
        return raf.readInt();
    }

    }

