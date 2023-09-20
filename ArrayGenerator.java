import java.util.HashMap;
import java.util.Random;

/*
    The purpose of this class is to create arrays with randomly generated numbers,
    which will then be sorted in the Sorter class.
 */
public class ArrayGenerator {
    private HashMap arrays;
    private int[] n;

    // Constructor takes an array of input sizes.
    public ArrayGenerator(int[] n) {
        arrays = new HashMap<Integer, Integer[]>();
        this.n = n;
    }

    /*
    Based on the input sizes stored in the n int array, each randomized array is populated with
    the relevant input size.
     */
    public HashMap<Integer, Integer[]> getRandomArrays() {
        for (int i : n) {
            arrays.put(i, null);
        }

        for (int i : n) {
            arrays.put(i, getRandomNumbers(i));
        }
        return arrays;
    }

    // Uses the Java Random class to get random numbers and populate an array, then return that
    // randomized array to the calling method.
    private Integer[] getRandomNumbers(int n) {
        Integer[] array = new Integer[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(100);
        }
        return array;
    }
}
