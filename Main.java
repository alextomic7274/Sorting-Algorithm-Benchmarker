import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    private static int[] inputSizes = {10, 100, 500, 1000, 1500, 3000, 4000, 5000, 6500, 8000, 10000};
    private static HashMap<Integer, Integer[]> randomArrays;
    private static double[][] results = new double[5][inputSizes.length];

    /*
    Calls the measure algorithm method for each sorting algorithm, then it uses the ResultOutputter class
    to output the results to the console.

    inputSizes array can be amended to change input sizes as needed.
     */
    public static void main(String[] args) {
        ArrayGenerator generator = new ArrayGenerator(inputSizes);
        randomArrays = generator.getRandomArrays();
        Main m = new Main();
        String[] sortingAlgos = {"bubble", "insertion", "selection", "merge", "counting"};

        for (String algo : sortingAlgos) {
            m.measureSortingAlgorithm(algo);
        }

        ResultOutputter outputter = new ResultOutputter(results, inputSizes);
        outputter.outputResults();

    }

    /*
    The primary method for the benchmarking process. It includes nested for loops, the first of
    which iterates over each input array size and the second which times the selected algorithm (specified in the method parameter) 10 times and adds the average to the durations array..

    Once benchmarking is completed, the results for the specific sorting algorithm are added to the results array.

     */
    public void measureSortingAlgorithm(String algorithmName) {
        double[] averageDurations = new double[inputSizes.length];
        // This variable is set in the switch chain, so the method knows the right row to populate in the results array.
        int index = 0;
        // Iterates for every n size
        for (int n = 0; n < inputSizes.length; n++) {
            // Creates copy of random array to sort, fetches from hashmap
            int[] unsortedNumbers = convertToIntArray(randomArrays.get(inputSizes[n]));
            double milliseconds = 0;

            // Runs the sort 10 times, for each iteration, it adds the duration to milliseconds variable then
            // divides milliseconds by 10 to get the average.
            for (int i = 0; i < 10; i++) {
                int[] toSort = unsortedNumbers.clone();
                double startTime = System.nanoTime();
                switch (algorithmName) {
                    case "bubble":
                        Sorter.bubbleSort(toSort);
                        index = 0;
                        break;
                    case "insertion":
                        Sorter.insertionSort(toSort);
                        index = 1;
                        break;
                    case "selection":
                        Sorter.selectionSort(toSort);
                        index = 2;
                        break;
                    case "merge":
                        Sorter.mergeSort(toSort, toSort.length);
                        index = 3;
                        break;
                    case "counting":
                        Sorter.countingSort(toSort, toSort.length);
                        index = 4;
                        break;
                }
                double endTime = System.nanoTime();
                milliseconds += ((endTime - startTime) / 1_000_000);
            }

            // Adds the average time for this n input size.
            averageDurations[n] = milliseconds / 10;
        }
        addToResults(averageDurations, index);
    }

    /*
    Adds the average times for each input size to the results array, index specifies row e.g index = 0 is for bubble sort and so forth.
     */
    private static void addToResults (double[] avgTimes, int index) {
        for (int i = 0; i < inputSizes.length; i++) {
            results[index][i] = avgTimes[i];
        }
    }

    /*
    Converts an Integer[] to an int[] using java streams.

    As the randomArray Hashmap uses int wrapper object types, this will
    improve efficiency by converting Integer[] to a primitive type array before any sorting is performed.
     */
            private int[] convertToIntArray (Integer[]arr){
                int[] array = Arrays.stream(arr)
                        .mapToInt(Integer::intValue)
                        .toArray();

                return array;
            }
}