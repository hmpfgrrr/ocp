package main.java.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by christianneuls on 24.08.18.
 */
public class Functional {

    public static void main(String[] args) {

        flatMapStuff();

        collecting();
    }

    private static void flatMapStuff() {
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        Stream<List<String>> animals2 = Stream.of(zero, one, two);
        Stream<List<String>> animals3 = Stream.of(zero, one, two);

        animals.forEach((x) -> System.out.print(x + " "));
        System.out.println();
        animals2.flatMap(l -> l.stream()).forEach((s) -> System.out.print(s + " "));
        System.out.println();
        System.out.println(animals3.flatMap(l -> l.stream()).collect(Collectors.joining(" ")));
    }

    private static void collecting() {
        System.out.println("collecting map");
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        //Map<Integer, String> map = ohMy.collect(Collectors.toMap(String::length, v-> v));  -> DUPLICATE
        Map<Integer, String> map = ohMy.collect(Collectors.toMap(String::length, v -> v, (s1, s2) -> s1 + "," + s2, TreeMap::new));
        System.out.println(map);
        System.out.println(map.getClass());

        System.out.println("grouping");
        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map2 = ohMy2.collect(Collectors.groupingBy(String::length));
        System.out.println(map2);

        System.out.println("partitioning");
        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map3 = ohMy3.collect(Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map3);

    }
}
