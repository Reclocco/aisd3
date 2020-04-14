import java.util.Arrays;

public class Select {
    InsertSort insertSort = new InsertSort();
    int comparisons = 0;
    int swaps = 0;

    public int median(int[] arr, int beg, int end) {
        System.err.println("full: " + Arrays.toString(Arrays.copyOfRange(arr, beg, end+1)));
        int i = 0;
        int[] medians = new int[(int) Math.ceil(Arrays.copyOfRange(arr, beg, end+1).length / 5.0)];

        while (i + 5 <= end-beg) {
            int[] small = Arrays.copyOfRange(arr, beg + i, beg + i + 6);
            insertSort.sort(small, 0, 4);
            medians[i/5] = small[2];

            i+=5;
        }


        int[] small = Arrays.copyOfRange(arr, beg+i, end+1);
//        System.out.println("small: " + Arrays.toString(small));

        insertSort.sort(small, 0, small.length-1);
        medians[i/5] = small[small.length/2];
//        System.out.println("medians: " + Arrays.toString(medians));

        if (medians.length == 1) {
            return medians[0];
        }
        else {
            return median(medians, 0, medians.length-1);
        }
    }

    public int partition(int[] arr, int beg, int end) {
        int pivot = median(arr, beg, end);

//        System.out.println("pivot: " + pivot);
        int i = (beg-1);
        for (int j=beg; j<end; j++)
        {
            if (arr[j] < pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return i+1;
    }

    public int get(int[] arr, int beg, int end, int k) {
//        System.out.println("\ngetting: " + Arrays.toString(Arrays.copyOfRange(arr, beg, end+1)));
//        System.out.println("idx: " + beg + ", " + end);
//        System.out.println(Arrays.toString(arr) + "\n");

        int part = partition(arr, beg, end);

        if (part == k) {
//            System.out.println(Arrays.toString(arr));
            return arr[k];
        } else if (part > k) {
            comparisons++;
            return get(arr, beg, part - 1, k);
        } else {
            comparisons++;
            return get(arr, part + 1, end, k);
        }
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
