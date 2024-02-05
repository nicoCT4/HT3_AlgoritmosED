import java.util.Arrays;

public class GeneradorD {

    public static void gnomeSort(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (index == 0)
                index++;
            if (arr[index] >= arr[index - 1])
                index++;
            else {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
    

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Encontrar el punto medio
            int middle = (left + right) / 2;
    
            // Ordenar las mitades
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
    
            // Mezclar las mitades ordenadas
            merge(arr, left, middle, right);
        }
    }
    
    // Método auxiliar para mezclar las mitades
    private static void merge(int[] arr, int left, int middle, int right) {
        // Tamaños de los subarrays
        int n1 = middle - left + 1;
        int n2 = right - middle;
    
        // Arrays temporales
        int[] L = new int[n1];
        int[] R = new int[n2];
    
        // Copiar datos a los arrays temporales
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[middle + 1 + j];
    
        // Mezclar los arrays temporales
    
        // Índices iniciales de los primeros y segundos subarrays
        int i = 0, j = 0;
    
        // Índice inicial del subarray arr[]
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
    
        // Copiar los elementos restantes de L[] si los hay
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
    
        // Copiar los elementos restantes de R[] si los hay
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // partitionIndex es el índice de partición, arr[partitionIndex] ya está en el lugar correcto
            int partitionIndex = partition(arr, low, high);
    
            // Ordenar recursivamente los elementos antes y después de la partición
            quickSort(arr, low, partitionIndex-1);
            quickSort(arr, partitionIndex+1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low-1); // índice del elemento más pequeño
        for (int j=low; j<high; j++) {
            // Si el elemento actual es menor que el pivote
            if (arr[j] < pivot) {
                i++;
    
                // intercambiar arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    
        // intercambiar arr[i+1] y arr[high] (o pivote)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
    
        return i+1;
    }
    
    // Un método para hacer un conteo de orden de arr[] de acuerdo a
    // el dígito representado por exp.
    private static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // arreglo de salida
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Almacenar el conteo de ocurrencias en count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Cambiar count[i] para que count[i] ahora contenga
        // la posición actual de este dígito en output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Construir el arreglo de salida
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copiar el arreglo de salida a arr[], para que arr[] ahora
        // contenga los números ordenados de acuerdo a el dígito actual
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

        // Método adicional para el algoritmo de sort nuestra elección
        public static void shellSort(int[] arr) {
        int n = arr.length;
    
        // Empezar con un intervalo grande, luego reducir el intervalo
        for (int interval = n / 2; interval > 0; interval /= 2) {
            // Hacer un ordenamiento por inserción para este intervalo. Los primeros elementos
            // interval están ya en el intervalo correcto, seguir añadiendo uno más
            // hasta que todo el arreglo esté ordenado
            for (int i = interval; i < n; i += 1) {
                // Añadir arr[i] a los elementos que han sido ordenados, guardar arr[i]
                // en temp y hacer un hueco en la posición i
                int temp = arr[i];
                
                // Mover los elementos del arreglo arr[0..i-1], que son
                // mayores que temp, a una posición adelante de su
                // posición actual
                int j;
                for (j = i; j >= interval && arr[j - interval] > temp; j -= interval) {
                    arr[j] = arr[j - interval];
                }
                
                // Poner temp (el original arr[i]) en su posición correcta
                arr[j] = temp;
            }
        }
    }


}
