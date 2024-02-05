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

        // Generar números aleatorios
        int[] numerosAleatorios = Orden.generarNumerosAleatorios(3000);

        // Ejecutar el algoritmo seleccionado
        switch (choice) {
            case 1:
                GeneradorD.gnomeSort(numerosAleatorios);
                break;
            case 2:
                GeneradorD.mergeSort(numerosAleatorios, 0, numerosAleatorios.length - 1);
                break;

            default:
                System.out.println("Opción no válida.");
                break;
            
            case 3:
                GeneradorD.quickSort(numerosAleatorios, 0, numerosAleatorios.length - 1);
                break;

            case 4:
                GeneradorD.radixSort(numerosAleatorios);
                break;

            case 5:
                GeneradorD.shellSort(numerosAleatorios);
                break;
        }

        // Opcional: Escribir los números ordenados en un archivo o imprimirlos en consola
        Orden.escribirArchivo("numeros_ordenados.txt", numerosAleatorios);
        
        scanner.close();
    }
}
