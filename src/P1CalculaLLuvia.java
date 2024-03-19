import java.io.*;
import java.util.*;

public class P1CalculaLLuvia implements Serializable {
    public static void main(String[] args) throws IOException {

        try(Scanner s = new Scanner(System.in)) {
            Map<String, List<Integer>> lluvias = new HashMap<>();
            int cantidad;
            System.out.println("Introduce la cantidad de lluvia mínima: ");
            cantidad = s.nextInt();

            while (true) {

                String nombreMes;
                s.nextLine();
                System.out.println("Introduce nombre del mes :");
                do {
                    nombreMes = s.nextLine();
                } while (nombreMes.isEmpty());
                if (nombreMes.equalsIgnoreCase("FIN")) break;

                List<Integer> registros = new ArrayList<>();
                System.out.println("Introduce la cantidad resgistrada ese mes (-1 para terminar): ");
                while (true) {
                    int registro = s.nextInt();
                    if (registro == -1)
                        break;
                    registros.add(registro);
                }

                lluvias.put(nombreMes, registros);


                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lluvia.txt"))) {
                    oos.writeInt(cantidad);
                    oos.writeObject(lluvias);
                }
            }

        }
    }
}
