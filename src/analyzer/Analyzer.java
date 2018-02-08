package analyzer;

import excel.ExcelWriter;
import fillers.Filler;
import sorters.Sort;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Class for analyzing efficiency of different sorting algorithms. It uses all non-abstract {@link sorters.Sort}
 * subclasses. Each algorithm tests against different arrays generated via methods annotated with
 * {@link fillers.Filler} annotation. Statistic of time needed for sorting writes to .xlsx file.
 */
public class Analyzer {
    /**
     * Key of list of arrays size.
     */
    public static final String ARRAY_SIZE_KEY = "Array Size";

    /**
     * Calculate time needed for sorting array with different algorithms and write statistic to .xlsx file.
     *
     * @param pathname Pathname of .xlsx file. For example, "result.xlsx".
     * @param minSize  Minimum length of array.
     * @param maxSize  Maximum length of array.
     */
    public void analyze(String pathname, int minSize, int maxSize) {


        Set<Class<? extends Sort>> sorters = ReflectionUtils.getNonAbstractSubtypes(Sort.class);
        Set<Method> fillers = ReflectionUtils.getMethodsAnnotatedWith(Filler.class);
        int[] arr;
        for (Method filler : fillers) {
            Map<String, List<Long>> resultMap = new HashMap<>();
            resultMap.put(ARRAY_SIZE_KEY, new ArrayList<>());
            for (int i = minSize; i <= maxSize; i *= 10) {
                arr = fillArray(filler, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
                resultMap.get(ARRAY_SIZE_KEY).add((long) i);
                for (Class<? extends Sort> sorter : sorters) {
                    long time = getSortingTime(sorter, Arrays.copyOf(arr, arr.length));
                    if (!resultMap.containsKey(sorter.getSimpleName())) {
                        resultMap.put(sorter.getSimpleName(), new ArrayList<>());
                    }
                    resultMap.get(sorter.getSimpleName()).add(time);
                }
            }

            try {
                ExcelWriter.writeSpreadsheet(pathname, filler.getName(), resultMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    //fill array with some filler
    private int[] fillArray(Method filler, Integer length, Integer min, Integer max) {
        int[] arr = new int[length];
        Object result = null;
        try {
            result = filler.invoke(null, length, min, max);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        if (result.getClass().isArray()) {
            for (int i = 0; i < length; i++)
                arr[i] = (int) Array.get(result, i);
        }
        return arr;
    }

    //calculate time needed for sorting
    private long getSortingTime(Class<? extends Sort> sorter, int[] arr) {
        Method sort = null;
        try {
            sort = sorter.getMethod("sort", int[].class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        long timeStart = 0;
        long timeEnd = 0;
        try {
            timeStart = System.nanoTime();
            sort.invoke(sorter.newInstance(), arr);
            timeEnd = System.nanoTime();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return timeEnd - timeStart;

    }

}
