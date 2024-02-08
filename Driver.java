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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Driver {
    public static void main(String[] args) {
        // Generar 3000 números aleatorios
        Integer[] numerosAleatorios = Arrays.stream(Orden.generarNumerosAleatorios(3000)).boxed().toArray(Integer[]::new);

        // Ejecutar y guardar los resultados de cada algoritmo de ordenamiento
        ejecutarYGuardar(numerosAleatorios.clone(), "numeros_desordenados.txt", "Desordenados");

        // Crear copia de los números para cada algoritmo de ordenamiento
        Integer[] numerosGnome = numerosAleatorios.clone();
        Integer[] numerosMerge = numerosAleatorios.clone();
        Integer[] numerosQuick = numerosAleatorios.clone();
        Integer[] numerosRadix = numerosAleatorios.clone();
        Integer[] numerosShell = numerosAleatorios.clone();

        // Ordenar y guardar los números con cada algoritmo de ordenamiento
        ejecutarYGuardar(numerosGnome, "numeros_ordenados_gnome.txt", "Gnome Sort");
        ejecutarYGuardar(numerosMerge, "numeros_ordenados_merge.txt", "Merge Sort");
        ejecutarYGuardar(numerosQuick, "numeros_ordenados_quick.txt", "Quick Sort");
        ejecutarYGuardar(numerosRadix, "numeros_ordenados_radix.txt", "Radix Sort");
        ejecutarYGuardar(numerosShell, "numeros_ordenados_shell.txt", "Shell Sort");

        System.out.println("Proceso completado.");
    }

    // Método para ejecutar un algoritmo de ordenamiento y guardar el resultado en un archivo de texto
    private static void ejecutarYGuardar(Integer[] numeros, String nombreArchivo, String nombreSort) {
        // Ordenar los números según el algoritmo especificado
        switch (nombreSort) {
            case "Desordenados":
                break; // No se realiza ordenamiento
            case "Gnome Sort":
                GeneradorD.gnomeSort(numeros);
                break;
            case "Merge Sort":
                GeneradorD.mergeSort(numeros, 0, numeros.length - 1);
                break;
            case "Quick Sort":
                GeneradorD.quickSort(numeros, 0, numeros.length - 1);
                break;
            case "Radix Sort":
                GeneradorD.radixSort(numeros);
                break;
            case "Shell Sort":
                GeneradorD.shellSort(numeros);
                break;
            default:
                System.out.println("Algoritmo no reconocido.");
                return;
        }
        // Guardar los números en un archivo de texto utilizando el buffer
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 10; i <= numeros.length; i++) {
                // Calcular cuántos números aleatorios agregar en esta iteración
                int cantidadNumeros = (i < numeros.length) ? i : numeros.length;

                // Copiar una porción del arreglo original para ordenar
                Integer[] numerosActuales = Arrays.copyOf(numeros, cantidadNumeros);

                // Ordenar el subconjunto de números
                switch (nombreSort) {
                    case "Desordenados":
                        break; // No se realiza ordenamiento
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





