package main.java.ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by christianneuls on 23.08.18.
 */
public class Generics {

    static class Bird {}
    static class Sparrow extends Bird {};

    public static void main(String[] args) {
        List<? extends Bird> birds = new ArrayList<Bird>();
        //birds.add(new Sparrow());
        //birds.add(new Bird());

        List<Bird> birds2 = new ArrayList<Bird>();
        birds2.add(new Sparrow());
        birds2.add(new Bird());


        //lower bounds
        List<String> strings = new ArrayList<String>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<>(strings);

        addSound(strings);
        addSound(objects);

    }

    private static void addSound(List<? super String> objects) {
        objects.add("quack");
    }


}


