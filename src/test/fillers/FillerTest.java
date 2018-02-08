package test.fillers;

import fillers.ArrayFiller;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FillerTest {
    private final int LENGTH = 1000;
    private final int MAX_VALUE = Integer.MAX_VALUE;
    private final int MIN_VALUE = Integer.MIN_VALUE;
    private final int ZERO_LENGTH = 0;
    private final int NEGATIVE_LENGTH = -1;
    int[] result;

    @Test
    public void testSortedArray() {
        result = ArrayFiller.getSortedArray(LENGTH, MIN_VALUE, MAX_VALUE);
        assertEquals(LENGTH, result.length);
        for (int i = 0; i < result.length - 1; i++) {
            assertEquals(true, result[i] <= result[i + 1]);
        }
    }

    @Test
    public void testSortedArrayWithRandomElement() {
        result = ArrayFiller.getSortedArrayWithRandomElement(LENGTH, MIN_VALUE, MAX_VALUE);
        assertEquals(LENGTH, result.length);
        for (int i = 0; i < result.length - 2; i++) {
            assertEquals(true, result[i] <= result[i + 1]);
        }
    }

    @Test
    public void testReverseSortedArray() {
        result = ArrayFiller.getReverseSortedArray(LENGTH, MIN_VALUE, MAX_VALUE);
        assertEquals(LENGTH, result.length);
        for (int i = 0; i < result.length - 2; i++) {
            assertEquals(true, result[i] >= result[i + 1]);
        }
    }

    @Test
    public void testRandomArray() {
        int[][] result = new int[10][];
        for (int i = 0; i < result.length; i++) {
            result[i] = ArrayFiller.getRandomArray(LENGTH, MIN_VALUE, MAX_VALUE);
            assertEquals(LENGTH, result[i].length);
        }

        for (int i = 0; i < result.length; i++) {
            //         assertEquals(false,Arrays.equals(result[i],result[i+1]));
        }
    }
}
