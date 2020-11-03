package main.java.lesson3.objects;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class A_Set {
    public static void main(String[] args) {
        Set<String> setStr = new HashSet<>();
        setStr.add("AAA");
        setStr.add("BBB");
        setStr.add("CCC");
        setStr.add("CCC");
        setStr.add("DDD");
        setStr.remove("DDD");


        System.out.println(setStr.size());

        for (String str: setStr) {
            System.out.println(str);
        }

        int i1 = 1000;
        int i2 = 1000;
        Integer ii = new Integer(10);
        Integer iii1 = 1000;
        Integer iii2 = 1000;
        Boolean bol = true;
        Character ch = 'a';

        Set<Integer> intSet = new HashSet<>();


        Set<Animal> catSet = new HashSet<>();
        catSet.add(new Cat("A"));
        catSet.add(new Cat("A"));
        catSet.add(new Cat("A"));
        catSet.add(new Cat("A"));
        catSet.add(new Dog());
        catSet.add(new Shark());

        /*Iterator it = setStr.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }*/


        String str3[] = {"A", "A", "B", "C"};
        Set<String> str3Set = new HashSet<>(Arrays.asList(str3));

        for (String str: str3Set) {
            System.out.println(str);
        }
    }
}
