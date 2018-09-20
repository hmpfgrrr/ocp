package main.java.ocp;

/**
 * Created by christianneuls on 24.08.18.
 */
public class GorillaFamily {
    String walk = "walk";
    void everyonePlay(boolean baby) {
        String approach = "amble";
        //approach = "run";

        play(() -> walk);
        play(() -> baby ? "hitch a ride": "run");
        play(() -> approach);
    }

    void play(Gorilla g){
        System.out.println(g.move());
    }
}

interface Gorilla {
    String move();
}
