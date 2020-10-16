package main.java.lesson3.objects;

public class Cat {
    String name = "Barsik";
    String surname = "Cotovich";
    int age = 20;

    public Cat(String name) {
        this.name = name;
        System.out.println("********** new cat was created ***********");
    }

    public Cat(String name, String surname) {
        this.name = name;
        this.surname = surname;
        System.out.println("********** new cat was created ***********");
    }


    /*public void initialize() {
        System.out.println("********** new cat was created ***********");
    }*/

    public String getFullName() {
        return name + " " + surname;
        //return this.name + " " + this.surname;
    }

    public void sayHello() {
        System.out.println("Hello, I don't know you ...");
    }

    public void sayHello(String userName) {
        System.out.printf("Hello '%s' !!! \n", userName);
    }

    public void sayHello(String userName, int amount) {
        for (int i = 0; i < amount; i++) System.out.printf("Hello '%s' !!! \n", userName);
    }

    public void sleep() {
        System.out.println("I am sleeping ....");
    }

    public void meow() {
        System.out.println("MEOW ...");
    }
}
