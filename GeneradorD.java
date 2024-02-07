import java.util.Arrays;

public class GeneradorD {

    public static <T extends Comparable<T>> void gnomeSort(T[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (index == 0) index++;
            if (arr[index].compareTo(arr[index - 1]) >= 0) {
                index++;
            } else {
                T temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int left, int middle, int right) {
        T[] temp = Arrays.copyOf(arr, arr.length);
        int i = left, j = middle + 1, k = left;
        while (i <= middle && j <= right) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= middle) {
            arr[k++] = temp[i++];
        }
        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void radixSort(int[] arr) {
        // Encontrar el máximo número para saber el número de dígitos
        int m = getMax(arr, arr.length);
    
        // Hacer el conteo de orden para cada dígito. Nota que en vez
        // de pasar el número de dígito, se pasa exp. exp es 10^i
        // donde i es el número de dígito actual
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, arr.length, exp);
        }
    }
    
    // Método auxiliar para obtener el valor más grande del arreglo
    private static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }
    
    // Un método para hacer un conteo de orden de arr[] de acuerdo a
    // el dígito representado por exp.
    private static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // arreglo de salida
        int[] count = new int[10];
        Arrays.fill(count, 0);
    
        // Almacenar el conteo de ocurrencias en count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
    
        // Cambiar count[i] para que count[i] ahora contenga
        // la posición actual de este dígito en output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
    
        // Construir el arreglo de salida
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
    
        // Copiar el arreglo de salida a arr[], para que arr[] ahora
        // contenga los números ordenados de acuerdo a el dígito actual
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    
    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        int n = arr.length;
        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i++) {
                T temp = arr[i];
                int j;
                for (j = i; j >= interval && arr[j - interval].compareTo(temp) > 0; j -= interval) {
                    arr[j] = arr[j - interval];
                }
                arr[j] = temp;
            }
        }
    }
}
