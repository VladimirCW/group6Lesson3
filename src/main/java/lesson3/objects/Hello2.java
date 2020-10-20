package main.java.lesson3.objects;

import main.java.lesson3.objects.Cat;

public class Hello2 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vasiliy");
        Cat cat2 = new Cat("Vasiliy");
        Cat cat3 = new Cat("Vasiliy");
        Cat cat4 = new Cat("Vasiliy", "Vasilievich");
        System.out.println("Cats amount: " + Cat.getCounter());

        //cat1.age = 0;
        cat1.setAge(20);
        ///cat1.age = 1000;
        //cat1.sleep();

        //cat1.protectedMethod();
        Shark shark = new Shark();
        //shark.sleep();
        //cat1 == cat2

        //System.out.println("Age is: " + cat1.getAge());
        System.out.println(cat1.equals(cat2));
    }
}
