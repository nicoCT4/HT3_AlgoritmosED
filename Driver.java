/**
 * Clase principal que ejecuta el programa. Ofrece un menú para que el usuario
 * seleccione uno de los algoritmos de ordenamiento disponibles para ordenar
 * un conjunto de 3000 números enteros aleatorios. Los resultados se pueden guardar
 * en un archivo.
 * 
 * <p>Algoritmos de ordenamiento soportados:</p>
 * <ul>
 *   <li>Gnome Sort</li>
 *   <li>Merge Sort</li>
 *   <li>Quick Sort</li>
 *   <li>Radix Sort</li>
 *   <li>Shell Sort</li>
 * </ul>
 *
 * <p>Después de ejecutar el algoritmo seleccionado, los números ordenados se
 * guardan en un archivo denominado "numeros_ordenados.txt".</p>
 *
 * @param args Los argumentos de la línea de comandos no se utilizan.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige una opción de algoritmo de ordenamiento:");
        System.out.println("1. Gnome Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Quick Sort");
        System.out.println("4. Radix Sort");
        System.out.println("5. Shell Sort");
        System.out.print("Tu elección: ");
        int choice = scanner.nextInt();

        // Generar 3000 números aleatorios y guardarlos en un archivo
        int[] numerosAleatorios = Orden.generarNumerosAleatorios(3000);
        Orden.escribirArchivo("numeros_ordenados.txt", Arrays.stream(numerosAleatorios).boxed().toArray(Integer[]::new));

        // Definir el nombre del archivo basado en la elección del algoritmo
        String nombreArchivoSort = obtenerNombreArchivoSort(choice);
        
        if (nombreArchivoSort.equals("")) {
            System.out.println("Opción no válida.");
            scanner.close();
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoSort))) {
            for (int i = 1; i <= 3000; i++) {
                // Tomar un grupo de i + 9 números, empezando con 10
                int hasta = Math.min(i + 9, 3000);
                // Primero, crea un subarreglo de tipo primitivo int[]
                int[] subArrayInt = Arrays.copyOfRange(numerosAleatorios, 0, hasta);

                // Luego, convierte ese subarreglo a Integer[]
                Integer[] numerosActuales = Arrays.stream(subArrayInt)
                                                .boxed()
                                                .toArray(Integer[]::new);

                // Ordenar el subconjunto de números
                ordenarNumeros(numerosActuales, choice);

                // Escribir los números ordenados en el archivo correspondiente
                for (Integer num : numerosActuales) {
                    bw.write(num + "\n");
                }
                bw.write("----\n"); // Separador para indicar una nueva iteración
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    private static String obtenerNombreArchivoSort(int choice) {
        switch (choice) {
            case 1: return "gnome_sort.txt";
            case 2: return "merge_sort.txt";
            case 3: return "quick_sort.txt";
            case 4: return "radix_sort.txt";
            case 5: return "shell_sort.txt";
            default: return "";
        }
    }

    private static void ordenarNumeros(Integer[] numeros, int choice) {
        switch (choice) {
            case 1:
                GeneradorD.gnomeSort(numeros);
                break;
            case 2:
                GeneradorD.mergeSort(numeros, 0, numeros.length - 1);
                break;
            case 3:
                GeneradorD.quickSort(numeros, 0, numeros.length - 1);
                break;
            case 4:
                GeneradorD.radixSort(numeros);
                break;
            case 5:
                GeneradorD.shellSort(numeros);
                break;
        }
    }
}



