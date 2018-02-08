package fillers;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

/**
 * Class that contains static methods for filling int array.
 *
 * @author Andriy Shulepa
 */
public class ArrayFiller {
    private static final Random random = new Random();

    /**
     * Method that allows you to get a sorted array.
     *
     * @param length required length of array.
     * @param min    required minimum value in array.
     * @param max    required maximum value in array.
     * @return sorted array.
     */
    @Filler
    public static int[] getSortedArray(int length, int min, int max) {
        if (length < 1) {
            return null;
        }
        if (max < min) {
            max = min;
        }

        ArrayList<Integer> data = new ArrayList<>(length);
        data.add(getRandomInt(min, max));

        boolean added;
        for (int i = 0; i < length - 1; i++) {
            added = false;
            ListIterator<Integer> itr = data.listIterator();
            int rndNum = getRandomInt(min, max);
            while (itr.hasNext() && !added) {
                Integer currentNum = itr.next();
                if (currentNum >= rndNum) {
                    itr.previous();
                    itr.add(rndNum);
                    added = true;
                }
            }

            if (!added)//add to end of arrayList
            {
                data.add(rndNum);
            }
        }

        return data.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Method that allows you to get a sorted array with a random element at the end of array.
     *
     * @param length required length of array.
     * @param min    required minimum value in array.
     * @param max    required maximum value in array.
     * @return sorted array with a random element at the end of array.
     */
    @Filler
    public static int[] getSortedArrayWithRandomElement(int length, int min, int max) {
        if (length < 1) {
            return null;
        }
        if (max < min) {
            max = min;
        }

        int[] arr = new int[length];
        System.arraycopy(getSortedArray(length - 1, min, max), 0, arr, 0, length - 1);
        arr[length - 1] = getRandomInt(min, arr[length - 2] / 2);
        return arr;
    }

    /**
     * Method that allows you to get a reverse sorted array.
     *
     * @param length required length of array.
     * @param min    required minimum value in array.
     * @param max    required maximum value in array.
     * @return reverse sorted array.
     */
    @Filler
    public static int[] getReverseSortedArray(int length, int min, int max) {
        if (length < 1) {
            return null;
        }
        if (max < min) {
            max = min;
        }

        ArrayList<Integer> data = new ArrayList<>(length);
        data.add(getRandomInt(min, max));

        boolean added;
        for (int i = 0; i < length - 1; i++) {
            added = false;
            ListIterator<Integer> itr = data.listIterator();
            int rndNum = getRandomInt(min, max);
            while (itr.hasNext() && !added) {
                Integer currentNum = itr.next();
                if (currentNum <= rndNum) {
                    itr.previous();
                    itr.add(rndNum);
                    added = true;
                }
            }

            if (!added)//add to end of arrayList
            {
                data.add(rndNum);
            }
        }

        return data.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Method that allows you to get an array filled with random elements.
     *
     * @param length required length of array.
     * @param min    required minimum value in array.
     * @param max    required maximum value in array.
     * @return array filled with random elements.
     */
    @Filler
    public static int[] getRandomArray(int length, int min, int max) {
        if (length < 1) {
            return null;
        }
        if (max < min) {
            max = min;
        }

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getRandomInt(min, max);
        }
        return arr;
    }

    private static int getRandomInt(int min, int max) {
        return min + random.nextInt(Math.abs(max - min));

    }
}
