public class InsertSort {
    int comparisons = 0;
    int swaps = 0;

    public void sort(int[] arr, int beg, int end) {
        int q = 1;
        int p = 0;
        int tmp;
        while (q < arr.length) {
            comparisons++;
            while (q - 1 - p >= 0 && arr[q - 1 - p] > arr[q - p]) {
                comparisons++;
                swaps++;
                tmp = arr[q - p];
                arr[q - p] = arr[q - p - 1];
                arr[q - p - 1] = tmp;
                p++;
            }
            q++;
            p = 0;
        }
    }

    public int getComparisons(){
        return comparisons;
    }
    public int getSwaps(){
        return swaps;
    }
}
