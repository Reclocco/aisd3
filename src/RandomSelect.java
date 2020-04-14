import java.util.Random;

public class RandomSelect {
    public int partition(int[] arr, int beg, int end) {
        Random r = new Random();
        int pivot = arr[beg+r.nextInt(end-beg+1)];

        System.err.println("pivot: " + pivot);
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

        int part = partition(arr, beg, end);

        if(part == k){
            return arr[k];
        }
        else if (part > k) {
            return get(arr, beg, part - 1, k);
        }
        else {
            return get(arr, part + 1, end, k);
        }
    }
}
