package main.java.lesson3.primitives;

public class O_Array {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int arr[] = {20,30,40,50,60};
        int []arr2 = {20,30,40,50,60};
        int []arr3 = new int[10];
        //int []arr3 = {20,"30",40,50,60};
        String strs[] = {"asdasd", "dasdasdasd"};

        System.out.println(arr2.length);
        arr2[0] = 1000;
        //arr2[5] = 5000;


        /*for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * 10);
            System.out.println(arr2[i]);
        }*/

        for (int el: arr2) {
            System.out.println(el);
        }

    }
}

