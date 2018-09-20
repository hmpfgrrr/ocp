package main.java.ocp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by christianneuls on 23.08.18.
 */
public class Duck implements Comparable<Duck> {

    private String name;
    private int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }

    @Override
    public int compareTo(Duck d) {
        return name.compareTo(d.name);
    }

    public static void main(String[] args) {
        Comparator<Duck> byWeight = new Comparator<Duck>() {
            @Override
            public int compare(Duck d1, Duck d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };

        Comparator<Duck> byWeightLambda = (d1, d2) -> d1.getWeight() - d2.getWeight();

        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack", 8));
        ducks.add(new Duck("Puddles", 10));
        Collections.sort(ducks);
        System.out.println(ducks);
        Collections.sort(ducks, byWeight);
        System.out.println(ducks);
        Collections.sort(ducks);
        System.out.println(ducks);
        Collections.sort(ducks, byWeightLambda);
        System.out.println(ducks);

    }
}
