package main.java.oca;

public class Overloading {

    void take(int input) {
        System.out.println("int" + input);
    }
    void take(byte input) {
        System.out.println("byte" + input);
    }

    void take(Byte input) {
        System.out.println("Byte" + input);
    }


    public static void main(String[] args) {
        short val1 = 10;
        byte val2 = 20;

        Overloading load = new Overloading();
        load.take(val1);
        load.take(val2);

        load.take(20);
        load.take(new Integer(25));
    }
}
