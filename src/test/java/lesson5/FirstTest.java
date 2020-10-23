package test.java.lesson5;
import main.java.lesson3.objects.Cat;
import main.java.lesson3.objects.HW1;

public class FirstTest {

    public static void main(String[] args) {
//        setAgePositive();
//        setAgePositive2();
        getNamesTest();
    }

    public static void getNamesTest() {
        String actualResult = HW1.getNames();
        System.out.println(actualResult);
        String strArr[] = actualResult.split("\n");
        System.out.println("Lines amount: " + strArr.length);
        for (String el: strArr) {
            String namesArr[] = el.split(" ");
            System.out.println("Names in line amount: " + namesArr.length);
        }
    }

    public static void setAgePositive() {
        Cat cat = new Cat("Vova");
        int expectedAge = 1111;
        cat.setAge(expectedAge);
        int actualAge = cat.getAge();
        System.out.println("AGE: " + (expectedAge == actualAge));
        if(expectedAge != actualAge) {
            throw new Error("Validation failed");
        }
    }

    public static void setAgePositive2() {
        Cat cat = new Cat("Vova");
        int expectedAge = 11;
        cat.setAge(expectedAge);
        int actualAge = cat.getAge();
        System.out.println("AGE: " + (expectedAge == actualAge));
        if(expectedAge != actualAge) {
            throw new Error("Validation failed");
        }
    }

}
