public class ResultOutputter {
    private double[][] results;
    private String bubbleSortRow;
    private String insertionSortRow;
    private String selectionSortRow;
    private String countingSortRow;
    private String mergeSortRow;
    private String output;
    private int[] n;

    // Constructor method for a ResultOutputter object.
    public ResultOutputter(double[][] results, int[] inputSizes) {
        this.results = results;
        n = inputSizes;
    }

    /*
    The outputResults() method prints a table
    showing execution times of five sorting algorithms for different input sizes.

    The rationale behind printing the results after doing the benchmarking is mainly an effort
    to improve the performance of the app by waiting to finish the benchmarking process before
    printing the already populated results array.
     */
    public void outputResults() {
        String[] sortNames = {"Bubble Sort", "Insertion Sort", "Selection Sort", "Counting Sort", "Merge Sort"};

        System.out.printf("%-17s", "Size");
        for (int j = 0; j < n.length; j++) {
            System.out.printf("%-10d", n[j]);
        }
        System.out.println();

        for (int i = 0; i < results.length; i++) {
            System.out.printf("%-17s", sortNames[i]);
            for (int j = 0; j < results[i].length; j++) {
                System.out.printf("%-10.3f", results[i][j]);
            }
            System.out.println();
        }
    }
}
