public class Sorter {

    /*
    The simplest sorting algorithm. It repeatadly swaps adjacent elements if they are not in the
    right order.

    Worst case: O(n^2)
     */
    public static void bubbleSort(int[] arr) {
        int counter = -1;

        while (counter != 0) {
            counter = 0;

            for (int i = 0; i < arr.length-1; i++) {
                int temp;
                if (arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    counter++;
                }
            }
        }
    }


    /*
    This algorithm repeatedly inserts unsorted elements into a sorted sub array.
    It sorts the array in-place.

    Worst case: O(n^2)
     */
    public static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    /*
    // This method implements the Merge Sort algorithm to sort an array in ascending order.
    // It divides the array into smaller sub arrays, recursively sorts them, and then merges them together.
    // Implemented with the aid of source: https://www.educative.io/answers/how-to-implement-a-merge-sort-in-java
    */
    public static void mergeSort(int[] arr, int len) {
        if (len < 2) {return;}

        int mid = len / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[len-mid];

        // Divide array into two and copy into separate arrays.
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (i < mid) {
                leftArr[i] = arr[i];
            }   else {
                rightArr[k] = arr[i];
                k++;
            }
        }

        // Recursively call method to divide sub arrays further
        mergeSort(leftArr, mid);
        mergeSort(rightArr, len-mid);

        // Calling merge method on each subdivision
        merge(leftArr, rightArr, arr, mid, len-mid);
    }

    public static void merge(int[] leftArr, int[] rightArr, int[] arr, int leftSize, int rightSize) {
        int i=0,l=0,r=0;
        // While loops check conditions for the merge
        while (l < leftSize && r < rightSize) {
            if (leftArr[l] < rightArr[r]) {
                arr[i++] = leftArr[l++];
            }   else {
                arr[i++] = rightArr[r++];
            }
        }
        while (l < leftSize) {
            arr[i++] = leftArr[l++];
        }
        while (r < rightSize) {
            arr[i++] = rightArr[r++];
        }
    }

    /*
     This code implements the Counting Sort algorithm to sort an array of integers in ascending order.
     It counts the occurrences of each element in the array, determines their positions in the sorted order,
     and then rearranges the elements accordingly.
     Implemented with the aid of source: https://www.programiz.com/dsa/counting-sort
     */
    public static void countingSort(int[] array, int size) {
        int[] output = new int[size + 1];

        // Find largest number in the array.
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] count = new int[max + 1];

        // Initialize count[] to all zeros.
        for (int i = 0; i < max; i++) {
            count[i] = 0;
        }

        // Put the count of each number into count[]
        for (int i = 0; i < size; i++) {
            count[array[i]]++;
        }

        // Store cumulative counts
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find index of each original number in count[], then place into output[], decrement its count in
        // count[].
        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy sorted numbers into original array.
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }










}
