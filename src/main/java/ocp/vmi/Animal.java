package main.java.ocp.vmi;

/**
 * Created by christianneuls on 23.08.18.
 */
class PlayWithAnimal {

    public static void main(String[] args) {
        //virtual method invocation
        Animal animal = new Lion();
        animal.careFore();
        animal.printName();

        Lion animal2 = new Lion();
        animal2.careFore();
        animal2.printName();
    }
}

abstract class Animal {
    String name = "???";

    public void printName() {
        System.out.println(name);
    }

    public void careFore() {
        play();
    }

    public void play() {
        System.out.println("pet animal");
    }
}

class Lion extends Animal {
    String name = "Leo";

    public void play() {
        System.out.println("toss in meat " + name);
    }
}


