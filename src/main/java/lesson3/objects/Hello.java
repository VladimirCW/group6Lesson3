package main.java.lesson3.objects;

public class Hello {
    public static void main(String[] args) {
        Cat barsik = new Cat("Barsik");
        Cat barsik2 = new Cat("Chernysh", "OverridenSurname");
        Cat barsik3 = barsik;
        barsik3.name = "Vova";
//        System.out.println(barsik);
//        System.out.println(barsik2);
//        System.out.println(barsik == barsik2);


        System.out.println(barsik.name);
        System.out.println(barsik2.name);

        barsik.meow();
        barsik.sleep();
        barsik.sayHello("Vova");
        //barsik.sayHello();
        barsik.sayHello();
        barsik.sayHello("Max", 2);
        String fullName = barsik.getFullName();
        System.out.println(fullName);
        System.out.println(barsik2.getFullName());
        //barsik.sayHello(5, "Max");
    }
}
