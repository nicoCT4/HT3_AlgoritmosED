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

        // Generar 3000 números aleatorios
        int[] numerosAleatorios = Orden.generarNumerosAleatorios(3000);

        // Nombre del archivo
        String nombreArchivo = "numeros_ordenados.txt";

        // Contador de números escritos en el archivo
        int numerosEscritos = 0;

        // Abrir el archivo una vez fuera del bucle for
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 10; i <= numerosAleatorios.length; i++) {
                // Calcular cuántos números aleatorios agregar en esta iteración
                int cantidadNumeros = (i < numerosAleatorios.length) ? i : numerosAleatorios.length - numerosEscritos;

                // Copiar una porción del arreglo original para ordenar
                Integer[] numerosActuales = Arrays.stream(Arrays.copyOfRange(numerosAleatorios, 0, numerosEscritos + cantidadNumeros))
                                                   .boxed().toArray(Integer[]::new);

                // Ordenar según la elección
                switch (choice) {
                    case 1:
                        GeneradorD.gnomeSort(numerosActuales); 
                        break;
                    case 2:
                        GeneradorD.mergeSort(numerosActuales, 0, numerosActuales.length - 1); 
                        break;
                    case 3:
                        GeneradorD.quickSort(numerosActuales, 0, numerosActuales.length - 1); 
                        break;
                    case 4:
                        GeneradorD.radixSort(numerosActuales);
                        break;
                    case 5:
                        GeneradorD.shellSort(numerosActuales); 
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }

                // Escribir los números ordenados en el archivo
                for (int num : numerosActuales) {
                    bw.write(num + "\n");
                }

                // Actualizar el contador de números escritos en el archivo
                numerosEscritos += cantidadNumeros;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}


