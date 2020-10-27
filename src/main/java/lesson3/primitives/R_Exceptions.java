package main.java.lesson3.primitives;

public class R_Exceptions {
    public static void main(String[] args) {
        first();
    }

    public static void loopMethod() {
        int arr[] = {1,2,3,4};
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2 ==0) {
                //do smt
            }
            //do smt
            /*try{
                if(arr[i]%2 ==0) {
                    throw new Error("sdfasdasd");
                }

            } catch (Exception e) {

            }*/
        }
    }


    public static void first() {
        System.out.println("FIRST");
        try {
            second();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---------------");
    }

    public static void second() throws Exception {
        System.out.println("SECOND");
        third();
        System.out.println("AFTER THIRD");
    }

    public static void third() throws Exception{
        System.out.println("THIRD");
        /*try{
            System.out.println(10/0);
            System.out.println("***************");
        } catch (Exception e) {
            System.out.println("Error detected");
        } finally {
            System.out.println("FINALLY BLOCK");
        }*/
        int arr[] = {1};
        System.out.println(arr[15]);
    }
}
