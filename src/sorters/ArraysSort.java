package sorters;

import java.util.Arrays;

/**
 * Implementation of {@link Sort} class that sorts array via {@link Arrays#sort(int[])}.
 *
 * @author Andriy Shulepa
 */
public class ArraysSort extends Sort {
    /**
     * Function for sorting  via {@link Arrays#sort(int[])}.
     *
     * @param arr int array for sorting.
     * @return sorted array.
     */
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        Arrays.sort(arr);
        return arr;
    }
}
