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
    

    
}
