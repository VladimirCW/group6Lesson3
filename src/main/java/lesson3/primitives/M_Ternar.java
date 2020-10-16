package main.java.lesson3.primitives;

public class M_Ternar {
    public static void main(String[] args) {
        int age = 10;

        String status = age <= 18 ? "student" : "worker";

        System.out.println(status);

        /*if(age <= 18) {
            status = "student";
        } else {
            status = "worker";
        }*/
    }
}
