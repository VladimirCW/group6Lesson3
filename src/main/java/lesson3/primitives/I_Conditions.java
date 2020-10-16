package main.java.lesson3.primitives;

public class I_Conditions {
    public static void main(String[] args) {
        int age = 500;
        //boolean isyoung = age <= 18;
        if(age <= 18) {
            System.out.println("***********************************");
            System.out.println("Access denied. You are too young!!!");
            System.out.println("***********************************");
        } else if(age > 18 && age < 70) {
            System.out.println("***********************************");
            System.out.println("Hello");
            System.out.println("***********************************");
        } else {
            System.out.println("Access denied. You are too old!!!!");
        }

        if(age <= 18) {
            System.out.println("Access denied. You are too young!!!");
        } else if (true) {
            System.out.println("Hello");
        } else {
            System.out.println("Dasdada");
        }

        if(age <=18) System.out.println("Access denied. You are too young!!!");
        else if(true) System.out.println("asdasdasdadasda");
        else System.out.println("Hello");


        //--------- LOGIC

        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || false);
        System.out.println(true && (true || false));

        System.out.println(false && true);

    }
}
