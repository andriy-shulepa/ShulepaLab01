package sorters;

/**
 * Implementation of {@link Sort} class that sorts array via Selection sort
 *
 * @author Andriy Shulepa
 */
public class SelectionSort extends Sort {
    /**
     * Function for sorting array via Selection Sort.
     *
     * @param arr int array for sorting.
     * @return sorted array.
     */
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int min;
        for (int index = 0; index < arr.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < arr.length; scan++) {
                if (arr[scan] < arr[min]) {
                    min = scan;
                }
            }
            swap(arr, min, index);
        }
        return arr;
    }
}


