package main.java.lesson3.primitives;

public class E_Comparison {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = a;
        int d = 10;

//        System.out.println(a > b);
//        System.out.println(a < b);
//        System.out.println(a <= b);
//        System.out.println(a >= b);
        boolean isEqual = !(a == b);
        boolean bool1 = true;
        boolean bool2 = true;
        //
        b = 10;
        System.out.println(isEqual);
        System.out.println(a != b);
        System.out.println(bool1 == bool2);
    }
}
