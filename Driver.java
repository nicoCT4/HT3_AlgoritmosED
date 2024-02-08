/**
 * Fernando Hernandez
 * Nicolás Concuá
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
        Scanner Scanner= new Scanner(System.in);
        System.out.println("Presione cualquier tecla para iniciar");
        String tecla = Scanner.nextLine();
        // Generar 3000 números aleatorios
        Integer[] numerosAleatorios = Arrays.stream(Orden.generarNumerosAleatorios(3000)).boxed().toArray(Integer[]::new);

        // Crear y escribir en el archivo de números desordenados
        Orden.escribirArchivo("numeros_desordenados.txt", numerosAleatorios);

        // Ordenar y escribir los números en archivos de texto para cada algoritmo de ordenamiento
        ejecutarYGuardarOrdenamientos(numerosAleatorios.clone(), "numeros_ordenados_gnome.txt", "Gnome Sort");
        ejecutarYGuardarOrdenamientos(numerosAleatorios.clone(), "numeros_ordenados_merge.txt", "Merge Sort");
        ejecutarYGuardarOrdenamientos(numerosAleatorios.clone(), "numeros_ordenados_quick.txt", "Quick Sort");
        ejecutarYGuardarOrdenamientos(numerosAleatorios.clone(), "numeros_ordenados_radix.txt", "Radix Sort");
        ejecutarYGuardarOrdenamientos(numerosAleatorios.clone(), "numeros_ordenados_shell.txt", "Shell Sort");

        System.out.println("Proceso completado.");
    }

    // Método para ejecutar un algoritmo de ordenamiento y guardar el resultado en un archivo de texto
    private static void ejecutarYGuardarOrdenamientos(Integer[] numeros, String nombreArchivo, String nombreSort) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 1; i <= 3000; i++) {
                // Tomar un grupo de i + 9 números, empezando con 10
                int hasta = Math.min(i + 9, 3000);
                Integer[] numerosActuales = Arrays.copyOfRange(numeros, 0, hasta);

                // Ordenar el subconjunto de números según el algoritmo especificado
                switch (nombreSort) {
                    case "Gnome Sort":
                        GeneradorD.gnomeSort(numerosActuales);
                        break;
                    case "Merge Sort":
                        GeneradorD.mergeSort(numerosActuales, 0, numerosActuales.length - 1);
                        break;
                    case "Quick Sort":
                        GeneradorD.quickSort(numerosActuales, 0, numerosActuales.length - 1);
                        break;
                    case "Radix Sort":
                        GeneradorD.radixSort(numerosActuales);
                        break;
                    case "Shell Sort":
                        GeneradorD.shellSort(numerosActuales);
                        break;
                    default:
                        System.out.println("Algoritmo no reconocido.");
                        return;
                }

                // Escribir los números ordenados en el archivo de texto
                for (int num : numerosActuales) {
                    bw.write(num + "\n");
                }
                bw.write("----\n"); // Separador para indicar una nueva iteración
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}