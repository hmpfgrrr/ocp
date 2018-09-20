package main.java.oca;

interface HasHindlegs {
    //public abstract int getLegs();
    int getLegs();
}

interface CanHop extends HasHindlegs {
    public void hop();
}

interface DefaultStuff {
    void doSomething();

    public static final int int_i = 0;

    default void doDefault() {
        System.out.println("doDefault");
    }
}

interface StaticStuff {
    void doSomething();
    static void doStatic() {
        System.out.println("static");
    }
}

public class Interfaces implements CanHop, StaticStuff, DefaultStuff {

    public static void main(String[] args) {
        Interfaces interfaces = new Interfaces();
        interfaces.hop();

        interfaces.doDefault();

        interfaces.doSomething();
        //not working
        //Interfaces.doStatic();
        StaticStuff.doStatic();


    }

    public int getLegs() {
        return 0;
    }

    public void hop() {
        System.out.println("hop");
    }

    public void doSomething() {
        System.out.println("doSomething");
    }
}
