import java.io.*;
import java.util.List;
import java.util.Map;

public class leerP1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lluvia.txt"))) {
            int suma = 0;
            int cantidad = ois.readInt();
            Map<String, List<Integer>> lluvia = (Map<String, List<Integer>>) ois.readObject();
            for (Map.Entry<String, List<Integer>> e : lluvia.entrySet()) {
                List<Integer> registro = e.getValue();
                for (Integer registros : registro) {
                    System.out.format("%.2f\n", registros);
                    suma += registros;
                }
                if (suma > cantidad)
                    System.out.println(e.getKey() + suma);
            }


            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("salida.txt"))) {
                oos.writeInt(suma);
            }
        }


    }
}
