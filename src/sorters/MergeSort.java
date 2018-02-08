package sorters;

/**
 * Implementation of {@link Sort} class that sorts array via Merge sort.
 *
 * @author Andriy Shulepa
 */
public class MergeSort extends Sort {

    private int[] numbers;
    private int[] helper;

    private int number;

    /**
     * Function for sorting via Merge Sort.
     *
     * @param arr int array for sorting.
     * @return sorted array.
     */
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        this.numbers = arr;
        number = arr.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
        return arr;
    }

    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }
//    private static void merge(int[] first, int[] second, int[] result) {
//        //Index Position in first array - starting with first element
//        int iFirst = 0;
//
//        //Index Position in second array - starting with first element
//        int iSecond = 0;
//
//        //Index Position in merged array - starting with first position
//        int iMerged = 0;
//
//        //Compare elements at iFirst and iSecond,
//        //and move smaller element at iMerged
//        while (iFirst < first.length && iSecond < second.length) {
//            if (first[iFirst] < (second[iSecond])) {
//                result[iMerged] = first[iFirst];
//                iFirst++;
//            } else {
//                result[iMerged] = second[iSecond];
//                iSecond++;
//            }
//            iMerged++;
//        }
//        //copy remaining elements from both halves - each half will have already sorted elements
//        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
//        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
//    }
//
//    public void sort(int[] arr) {
//        //If list is empty; no need to do anything
//        if (arr.length <= 1) {
//            return;
//        }
//
//        //Split the array in half in two parts
//        int[] first = new int[arr.length / 2];
//        int[] second = new int[arr.length - first.length];
//        System.arraycopy(arr, 0, first, 0, first.length);
//        System.arraycopy(arr, first.length, second, 0, second.length);
//
//        //Sort each half recursively
//        sort(first);
//        sort(second);
//
//        //Merge both halves together, overwriting to original array
//        merge(first, second, arr);
//    }
}

