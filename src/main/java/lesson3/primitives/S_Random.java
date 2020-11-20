package main.java.lesson3.primitives;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S_Random {
    public static void main(String[] args) {
        String name = "Vova";
        List<String> list = new ArrayList<>();
        list.add("Hello0");
        list.add("Hello1");
        list.add("Hello2");
        list.add("Hello3");
        list.add("Hello4");
        list.add("Hello5");

        Set<String> set = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            int max = list.size() - 1;
            int min = 2;
            int randI = (int)(Math.random() * (max - min + 1)) + min;
            set.add(list.get(randI));
            //System.out.println(list.get(randI));
        }

        for (String  str: set) System.out.println(str);
    }
}
