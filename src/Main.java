public class Main {

    public static void main(String[] args) {
        RandomSelect randomSelect = new RandomSelect();
        int[] arr1 = {3, 654, 7, 436, 7777, 999, 435, 0, 5555555, 455, 666, 777};
        System.out.println(randomSelect.get(arr1, 0, arr1.length-1, arr1.length-2));

        Select select = new Select();
        int[] arr2 = {1 ,1};
        System.out.println(select.get(arr2, 0, arr2.length-1, arr2.length-1));

    }
}
