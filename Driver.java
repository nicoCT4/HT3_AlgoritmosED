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

        // Generar 3000 números aleatorios
        int[] numerosAleatorios = Orden.generarNumerosAleatorios(3000);
        
        for (int i = 10; i <= numerosAleatorios.length; i += 290) { // Ajusta el paso según lo necesites
            Integer[] numerosActuales = Arrays.stream(Arrays.copyOf(numerosAleatorios, i)).boxed().toArray(Integer[]::new);

            // Ordenar según la elección
            switch (choice) {
                case 1:
                    GeneradorD.gnomeSort(numerosActuales); 
                    Orden.escribirArchivo("numeros_ordenados_" + i + ".txt", numerosActuales);
                    break;
                case 2:
                    GeneradorD.mergeSort(numerosActuales, 0, numerosActuales.length - 1); 
                    Orden.escribirArchivo("numeros_ordenados_" + i + ".txt", numerosActuales);
                    break;
                case 3:
                    GeneradorD.quickSort(numerosActuales, 0, numerosActuales.length - 1); 
                    Orden.escribirArchivo("numeros_ordenados_" + i + ".txt", numerosActuales);
                    break;
                case 4:
                    GeneradorD.radixSort(numerosActuales);
                    Orden.escribirArchivo("numeros_ordenados_" + i + ".txt", numerosActuales);
                    break;
                case 5:
                    GeneradorD.shellSort(numerosActuales); 
                    Orden.escribirArchivo("numeros_ordenados_" + i + ".txt", numerosActuales);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
    }
}