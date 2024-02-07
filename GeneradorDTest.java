import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class GeneradorDTest {

    @Test
    public void testGnomeSort() {
        // Arreglo de prueba desordenado
        Integer[] arr = {5, 3, 8, 1, 4};

        // Ordenar el arreglo usando Gnome Sort
        GeneradorD.gnomeSort(arr);

        // Arreglo esperado después de ordenar
        Integer[] expected = {1, 3, 4, 5, 8};

        // Comparar el arreglo ordenado con el arreglo esperado
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSort() {
        // Arreglo de prueba desordenado
        Integer[] arr = {5, 3, 8, 1, 4};

        // Ordenar el arreglo usando Merge Sort
        GeneradorD.mergeSort(arr, 0, arr.length - 1);

        // Arreglo esperado después de ordenar
        Integer[] expected = {1, 3, 4, 5, 8};

        // Comparar el arreglo ordenado con el arreglo esperado
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSort() {
        // Arreglo de prueba desordenado
        Integer[] arr = {5, 3, 8, 1, 4};

        // Ordenar el arreglo usando Quick Sort
        GeneradorD.quickSort(arr, 0, arr.length - 1);

        // Arreglo esperado después de ordenar
        Integer[] expected = {1, 3, 4, 5, 8};

        // Comparar el arreglo ordenado con el arreglo esperado
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRadixSort() {
        // Arreglo de prueba desordenado
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        // Ordenar el arreglo usando Radix Sort
        GeneradorD.radixSort(arr);

        // Arreglo esperado después de ordenar
        int[] expected = {2, 24, 45, 66, 75, 90, 170, 802};

        // Comparar el arreglo ordenado con el arreglo esperado
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testShellSort() {
        // Arreglo de prueba desordenado
        Integer[] arr = {5, 3, 8, 1, 4};

        // Ordenar el arreglo usando Shell Sort
        GeneradorD.shellSort(arr);

        // Arreglo esperado después de ordenar
        Integer[] expected = {1, 3, 4, 5, 8};

        // Comparar el arreglo ordenado con el arreglo esperado
        assertArrayEquals(expected, arr);
    }
}
