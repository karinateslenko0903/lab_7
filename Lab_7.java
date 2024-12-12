import java.util.Arrays;

public class Lab_7 {
    public static void main(String[] args) {
        double[] array = {3.5, -1.2, 7.8, 0, 5.6, -3.4};


        Sorter quickSorter = (double[] arr) -> quickSort(arr, 0, arr.length - 1);

        Sorter optimizedSorter = (double[] arr) -> Arrays.sort(arr);


        double[] quickSortArray = Arrays.copyOf(array, array.length); // Копія масиву
        quickSorter.sort(quickSortArray);
        System.out.println("Сортування (QuickSort через лямбда): " + Arrays.toString(quickSortArray));


        double[] optimizedSortArray = Arrays.copyOf(array, array.length); // Копія масиву
        optimizedSorter.sort(optimizedSortArray);
        System.out.println("Сортування (Optimized через лямбда): " + Arrays.toString(optimizedSortArray));
    }


    private static void quickSort(double[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }


    private static int partition(double[] array, int low, int high) {
        double pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }


    private static void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
