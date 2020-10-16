package main.java.lesson3.primitives;

public class K_Do_while {
    public static void main(String[] args) {
        int counter = 0;

        do{
            System.out.println("Hello " + counter);
            counter++;
        } while (counter <= 10);

        while (counter >= 0) {
            System.out.println("By "+  counter);
            counter--;
        };
    }
}
