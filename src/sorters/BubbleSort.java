package sorters;

/**
 * Abstract class that implements Bubble Sort logic but need concrete implementation.
 *
 * @author Andrriy Shulepa
 * @see FromStartBubbleSort
 * @see FromEndBubbleSort
 */
public abstract class BubbleSort extends Sort {
    int length;

    /**
     * Function for sorting array.
     *
     * @param arr int array for sorting.
     * @return sorted array.
     */
    @Override
    public final int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        length = arr.length;
        boolean swapped = true;
        for (int i = getOuterStartIndex(); canOuterMoveNext(i) && swapped; i = iterateOuter(i)) {
            swapped = false;
            for (int j = getInnerStartIndex(); canInnerMoveNext(j, i); j = iterateInner(j)) {
                if (needToSwap(arr, j)) {
                    swap(arr, j, getSecondIndexToSwap(j));
                    swapped = true;
                }
            }
        }
        return arr;
    }

    /**
     * Returns fist index for Bubble Sort outer loop.
     *
     * @return fist index for Bubble Sort outer loop.
     */
    protected abstract int getOuterStartIndex();

    /**
     * Check if next iteration of Bubble Sort outer loop can be performed.
     *
     * @param i current index of Bubble Sort outer loop.
     * @return true if next iteration of Bubble Sort outer loop can be performed.
     */
    protected abstract boolean canOuterMoveNext(int i);

    /**
     * Returns next index of Bubble Sort outer loop.
     *
     * @param i current index of Bubble Sort outer loop.
     * @return next index of Bubble Sort outer loop.
     */
    protected abstract int iterateOuter(int i);

    /**
     * Returns fist index for Bubble Sort inner loop.
     *
     * @return fist index for Bubble Sort inner loop.
     */
    protected abstract int getInnerStartIndex();

    /**
     * Check if next iteration of Bubble Sort inner loop can be performed.
     *
     * @param j current index of Bubble Sort inner loop.
     * @param i current index of Bubble Sort outer loop.
     * @return true if next iteration of Bubble Sort inner loop can be performed.
     */
    protected abstract boolean canInnerMoveNext(int j, int i);

    /**
     * Returns next index of Bubble Sort inner loop.
     *
     * @param j current index of Bubble Sort inner loop.
     * @return next index of Bubble Sort inner loop.
     */
    protected abstract int iterateInner(int j);

    /**
     * Checks if need to swap current array element and previous/next.
     *
     * @param arr array for sorting.
     * @param j   current index of Bubble Sort inner loop.
     * @return true is need to swap current array element and previous/next.
     */
    protected abstract boolean needToSwap(int[] arr, int j);

    /**
     * Returns second index for {@link Sort#swap(int[], int, int)} function.
     *
     * @param j current index of Bubble Sort inner loop.
     * @return second index for {@link Sort#swap(int[], int, int)} function.
     */
    protected abstract int getSecondIndexToSwap(int j);
}
