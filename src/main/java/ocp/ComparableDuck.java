package main.java.ocp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by christianneuls on 23.08.18.
 */
public class ComparableDuck implements Comparable<ComparableDuck> {

    private String name;
    private int weight;

    public ComparableDuck(String name, int weight) {
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
        return "ComparableDuck{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }

    @Override
    public int compareTo(ComparableDuck d) {
        return name.compareTo(d.name);
    }

    public static void main(String[] args) {

        List<ComparableDuck> comparableDucks = new ArrayList<>();
        comparableDucks.add(new ComparableDuck("Quack", 8));
        comparableDucks.add(new ComparableDuck("Puddles", 10));

        Collections.sort(comparableDucks);
        System.out.println(comparableDucks);
        
        Comparator<ComparableDuck> byWeight = new Comparator<ComparableDuck>() {
            @Override
            public int compare(ComparableDuck d1, ComparableDuck d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };

        Comparator<ComparableDuck> byWeightLambda = (d1, d2) -> d1.getWeight() - d2.getWeight();

        Collections.sort(comparableDucks, byWeight);
        System.out.println(comparableDucks);
        Collections.sort(comparableDucks);
        System.out.println(comparableDucks);
        Collections.sort(comparableDucks, byWeightLambda);
        System.out.println(comparableDucks);

    }
}
