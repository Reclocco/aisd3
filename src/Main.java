import java.nio.channels.Selector;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        RandomSelect randomSelect = new RandomSelect();
//        int[] arr1 = {3, 654, 7, 436, 7777, 999, 435, 0, 5555555, 455, 666, 777};
//        System.out.println(randomSelect.get(arr1, 0, arr1.length-1, arr1.length-2));
//
//        Select select = new Select();
//        int[] arr2 = {3, 654, 7, 436, 7777, 999, 435, 0, 5555555, 455, 666, 777};
//        System.out.println(select.get(arr2, 0, arr2.length-1, arr2.length-2));
        RandomSelect randomSelect = new RandomSelect();
        Select select = new Select();

        if(args[0].equals("-r")){
            Scanner in = new Scanner(System.in);
            String size = in.nextLine();
            String position = in.nextLine();
            ArrayList<Integer> ints = new ArrayList<>();

            int[] arr = new int[Integer.parseInt(size)];
            for(int i=0; i<Integer.parseInt(size)*100000; i++)
                ints.add(i);
            Collections.shuffle(ints);

            for(int i=0; i<Integer.parseInt(size); i++){
                arr[i]=ints.get(i);
            }
            System.out.println(Arrays.toString(arr));

            int k = randomSelect.get(arr, 0, arr.length-1, Integer.parseInt(position));
            k = select.get(arr, 0, arr.length-1, Integer.parseInt(position));

            for(int element: arr){
                if(element == k)
                    System.out.print("[" + element + "] ");
                else
                    System.out.print(element + " ");
            }

        } else if(args[0].equals("-p")){
            Scanner in = new Scanner(System.in);
            String size = in.nextLine();
            String position = in.nextLine();
            ArrayList<Integer> ints = new ArrayList<>();

            int[] arr = new int[Integer.parseInt(size)];
            for(int i=0; i<Integer.parseInt(size); i++)
                ints.add(i);
            Collections.shuffle(ints);

            for(int i=0; i<Integer.parseInt(size); i++){
                arr[i]=ints.get(i);
            }
            System.out.println(Arrays.toString(arr));
            int k = randomSelect.get(arr, 0, arr.length-1, Integer.parseInt(position));
            k = select.get(arr, 0, arr.length-1, Integer.parseInt(position));

            for(int element: arr){
                if(element == k)
                    System.out.println("[" + element + "] ");
                else
                    System.out.println(element + " ");
            }
        }
    }
}
