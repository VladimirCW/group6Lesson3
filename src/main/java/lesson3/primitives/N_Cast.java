package main.java.lesson3.primitives;

public class N_Cast {
    public static void main(String[] args) {
        int a = 456;
        long b = a;
        b = 1234567890123456l;
        int c = (int)b;
        System.out.println(c);
    }
}
