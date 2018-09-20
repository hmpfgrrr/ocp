package main.java.oca;

import java.io.IOException;

public class Exceptions {

    public void eat() throws NullPointerException {}
    public void eat2() throws IOException {}

    public static void main(String[] args) throws IOException {
        Exceptions exceptions = new Exceptions();
        exceptions.eat();
        exceptions.eat2();
        System.out.println("done");
    }
}
