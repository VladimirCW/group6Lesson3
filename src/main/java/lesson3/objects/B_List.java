package main.java.lesson3.objects;

import java.util.ArrayList;
import java.util.List;

public class B_List {
    public static void main(String[] args) {
        List<Animal> catList = new ArrayList<>();
        catList.add(new Cat("d"));
        catList.add(new Dog());



        for (Animal animal: catList) {
            animal.sleep();
        }
    }
}
