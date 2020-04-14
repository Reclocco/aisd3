public class RandomSelect {
    int comparisons = 0;
    int swaps = 0;

    public int partition(int[] arr, int beg, int end) {
        int pivot = arr[end];
        int tmp;

        for (int i = beg; i < end; i++) {
            comparisons++;
            if (arr[i] < pivot) {
                swaps ++;
                tmp = arr[i];
                arr[i] = arr[beg];
                arr[beg] = tmp;
                beg++;
            }
        }
        swaps ++;
        tmp = arr[beg];
        arr[beg] = pivot;
        arr[end] = tmp;

        return beg;
    }
    public int get(int[] arr, int beg, int end, int k) {

        int part = partition(arr, beg, end);

        if(part == k){
            return arr[k];
        }
        else if (part > k) {
            comparisons++;
            return get(arr, beg, part - 1, k);
        }
        else {
            comparisons++;
            return get(arr, part + 1, end, k);
        }
    }

    public int getComparisons(){
        return comparisons;
    }
    public int getSwaps(){
        return swaps;
    }
}
