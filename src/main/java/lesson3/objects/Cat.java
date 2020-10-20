package main.java.lesson3.objects;

import main.java.lesson3.objects.Animal;

public class Cat extends Animal {
    static int counter = 0;
    String name = "Barsik";
    //String surname = "Cotovich";
    String surname = new String("Cotovich");
    private int age = 20;

    public Cat(String name) {
        this.protectedMethod();
        counter++;
        this.name = name;
        System.out.println("********** new cat was created ***********");
    }

    public Cat(String name, String surname) {
        this(name);
        this.surname = surname;
    }

    private boolean validateAge(int age) {
        if(age > 0 && age <=20) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Cat animal) {
        if(this.age == animal.age && this.name.equals(animal.name) && this.surname.equals(animal.surname)) {
            return true;
        } else {
            return false;
        }
    }

    public void setAge(int age) {
        if(this.validateAge(age)) {
            this.age = age;
        } else {
            System.out.println("The age '" + age + "' is invalid!!!");
        }
    }

    public int getAge() {
        return this.age;
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

    public void meow() {
        System.out.println("MEOW ...");
    }

    static public int getCounter() {
        System.out.println("Get counter");
        return counter;
    }
}
