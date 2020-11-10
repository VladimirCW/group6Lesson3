package main.java.lesson3.objects;

public interface IEatable {

    void eat();

    default void eat2() {
        System.out.println("asdfsdfs");
    };
}
