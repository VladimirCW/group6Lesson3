package main.java.lesson3.primitives;

public class F_sout {
    public static void main(String[] args) {
        String name = "Vova";
        System.out.println("Hello '" + name + "'!!!!");
        System.out.print("************");
        System.out.println("--------------");
        System.out.printf("Hello user '%s', this is your '%d'-nth attempt to login !!!!", name, 5);
    }
}
