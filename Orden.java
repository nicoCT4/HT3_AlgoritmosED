import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Orden {

    // Método para generar un arreglo de números aleatorios
    public static int[] generarNumerosAleatorios(int cantidad) {
        Random rand = new Random();
        int[] arr = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            arr[i] = rand.nextInt(1000); // Genera un número aleatorio entre 0 y 999
        }
        return arr;
    }

    // Método para escribir el arreglo en un archivo
    public static void escribirArchivo(String nombreArchivo, Integer[] arr) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int num : arr) {
                bw.write(num + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para imprimir los números en la consola
    public static void imprimirNumeros(Integer[] arr) {
        System.out.println("Números generados:");
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
