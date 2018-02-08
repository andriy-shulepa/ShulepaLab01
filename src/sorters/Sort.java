package sorters;

/**
 * Abstract class that defines common function {@link sorters.Sort#sort(int[])}.
 *
 * @author Andriy Shulepa
 * @see BubbleSort
 * @see FromEndBubbleSort
 * @see FromStartBubbleSort
 * @see MergeSort
 * @see QuickSort
 * @see SelectionSort
 * @see ArraysSort
 */
public abstract class Sort {
    /**
     * Function for sorting array.
     *
     * @param arr int array for sorting.
     * @return sorted array.
     */
    public abstract int[] sort(int[] arr);

    /**
     * Swap parameters in array.
     *
     * @param array array where swapping is needed.
     * @param i     index of first element.
     * @param j     index of second element.
     */
    protected void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

