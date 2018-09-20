package main.java.oca.inheritance;

import main.java.oca.inheritance.re.Deer;
import main.java.oca.inheritance.re.Reindeer;

public class Inheritance extends Deer {


    public static void main(String[] args) {
        Deer deer = new Deer();
        deer.simple();

        deer.make();
        Deer.make();

        Deer deer2 = null;
        //deer2.simple();
        deer2.make();


        Reindeer reindeer = new Reindeer();
        //reindeer.jump();
        Deer reindeer2 = new Reindeer();
        //reindeer2.jump();
    }
}
