package main.java.lesson3.objects;

public abstract class Animal implements IMovable, IEatable{

    protected void protectedMethod() {
        System.out.println("I am protected method!!!");
    }
    public void sleep() {
        System.out.println("I am sleeping");
    }
}
