package test.sorters;

import fillers.ArrayFiller;
import org.junit.Test;
import sorters.ArraysSort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ArraysSortTest {
    private final int SIZE = 1000;
    private final int MAX_VALUE = Integer.MAX_VALUE;
    private final int MIN_VALUE = Integer.MIN_VALUE;
    private int[] result;
    private int[] expected;
    private ArraysSort instance = new ArraysSort();

    @Test
    public void testSortedArray() {
        result = ArrayFiller.getSortedArray(SIZE, MIN_VALUE, MAX_VALUE);
        expected = Arrays.copyOf(result, result.length);
        instance.sort(result);
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortedArrayWithRandomElement() {
        result = ArrayFiller.getSortedArrayWithRandomElement(SIZE, MIN_VALUE, MAX_VALUE);
        expected = Arrays.copyOf(result, result.length);
        instance.sort(result);
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testReverseSortedArray() {
        result = ArrayFiller.getReverseSortedArray(SIZE, MIN_VALUE, MAX_VALUE);
        expected = Arrays.copyOf(result, result.length);
        instance.sort(result);
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRandomArray() {
        result = ArrayFiller.getRandomArray(SIZE, MIN_VALUE, MAX_VALUE);
        expected = Arrays.copyOf(result, result.length);
        instance.sort(result);
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testZeroLengthArray() {
        result = new int[0];
        expected = new int[0];
        instance.sort(result);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testNullArray() {
        result = null;
        expected = null;
        instance.sort(result);
        assertArrayEquals(expected, result);
    }
}
