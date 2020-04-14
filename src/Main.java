import java.util.*;

public class Main {

    public static void main(String[] args) {
        RandomSelect randomSelect = new RandomSelect();
        Select select = new Select();

        if(args[0].equals("-r")){
            Scanner in = new Scanner(System.in);
            String size = in.nextLine();
            String position = in.nextLine();
            ArrayList<Integer> ints = new ArrayList<>();

            int[] arr1 = new int[Integer.parseInt(size)];
            int[] arr2 = new int[Integer.parseInt(size)];
            for(int i=0; i<Integer.parseInt(size)*100000; i++)
                ints.add(i);
            Collections.shuffle(ints);

            for(int i=0; i<Integer.parseInt(size); i++){
                arr1[i]=ints.get(i);
                arr2[i]=ints.get(i);
            }


            System.err.println("randomSelect: ");
            int k = randomSelect.get(arr1, 0, arr1.length-1, Integer.parseInt(position));
            System.err.println("select: ");
            k = select.get(arr2, 0, arr2.length-1, Integer.parseInt(position));

            for(int element: arr2){
                if(element == k)
                    System.out.print("[" + element + "] ");
                else
                    System.out.print(element + " ");
            }

        }
        else if(args[0].equals("-p")){
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
        else if(args[0].equals("-s")){
            double avgS=0;
            double avgRs=0;
            int[] selecto = new int[100];
            int[] randevu = new int[100];

            Random r = new Random();

            for(int i=0; i<100; i++){
                ArrayList<Integer> ints = new ArrayList<>();

                int[] arr1 = new int[1000];
                int[] arr2 = new int[1000];
                for(int j=0; j<1000000; j++)
                    ints.add(j);
                Collections.shuffle(ints);

                for(int j=0; j<1000; j++){
                    arr1[j]=ints.get(j);
                    arr2[j]=ints.get(j);
                }

                int idx = r.nextInt(1000);

                randomSelect = new RandomSelect();
                select = new Select();

                randomSelect.get(arr1, 0, arr1.length-1, idx);
                select.get(arr2, 0, arr2.length-1, idx);

                avgRs += randomSelect.comparisons;
                avgS += select.comparisons;
                selecto[i] = select.comparisons;
                randevu[i] = randomSelect.comparisons;
            }

            avgS = avgS/100;
            avgRs = avgRs/100;

            double deviantS = 0;
            double deviantRs = 0;
            for(int i=0; i<100; i++){
                deviantS += Math.pow((selecto[i]-avgS), 2);
                deviantRs += Math.pow((randevu[i]-avgRs), 2);
            }

            deviantS = Math.sqrt(deviantS/100);
            deviantRs = Math.sqrt(deviantRs/100);

            System.out.println("Select: " + deviantS);
            System.out.println("RandomSelect: " + deviantRs);
        }
    }
}
