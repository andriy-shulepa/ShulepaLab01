import fillers.ArrayFiller;


public class Main {
    public static void main(String[] args) throws Exception {
//        Analyzer analyzer = new Analyzer();
//        analyzer.analyze("result.xlsx", 2, 200_000);
        for (int i : ArrayFiller.getReverseSortedArray(3, 1, 7)) {
            System.out.println(i);
        }

    }
}
