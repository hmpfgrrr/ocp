package main.java.ocp.threading;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by christianneuls on 28.08.18.
 */
public class Collections {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(2,3,52));
        try {
            for (Integer item : list) {
                System.out.println(item + " ");
                list.add(9);
            }
        } catch (ConcurrentModificationException e){
            System.out.println("catch ConcurrentModificationException");
            System.out.println("Size: " + list.size());
        }


        System.out.println();
        List<Integer> list2 = new CopyOnWriteArrayList<>(Arrays.asList(2,3,52));
        for (Integer item : list2) {
            System.out.print(item + " ");
            list2.add(9);
        }
        System.out.println("Size: " + list2.size());

        //Streams
        System.out.println();
        List<Integer> collect = Stream.iterate(1, i -> i + 1).limit(100).collect(Collectors.toList());

        //parallel stream -> how to sort?
        long start, duration;

        //long start = new Date().getTime();
        //long start = LocalDateTime.now().getNano();
        start = System.currentTimeMillis();
        System.out.println("sequential: ");
        collect.stream().forEach((obj) -> System.out.print(obj + " "));
        duration = System.currentTimeMillis() - start;
        System.out.println(); System.out.println("duration: " + duration);


        System.out.println();
        System.out.println("parallel ('sorted')");
        start = System.currentTimeMillis();
        //TODO: not sorted correctly - why ?
        collect.stream().parallel().sorted().forEach((obj) -> System.out.print(obj + " "));
        //collect.stream().sorted().forEach((obj) -> System.out.print(obj + " "));
        duration = System.currentTimeMillis() - start;
        System.out.println(); System.out.println("duration: " + duration);

        System.out.println();
        System.out.println("parallel (sorted)");
        start = System.currentTimeMillis();
        TreeSet<Integer> collect1 = collect.stream().parallel().collect(Collectors.toCollection(TreeSet::new));
        collect1.forEach((obj) -> System.out.print(obj + " "));
        duration = System.currentTimeMillis() - start;
        System.out.println(); System.out.println("duration: " + duration);


        Arrays.asList("jackal", "kangaroo", "lemur")
            .parallelStream()
            .map(s -> s.toUpperCase())
            .forEach(System.out::println);

        System.out.println();
        Arrays.asList("jackal", "kangaroo", "lemur")
                .parallelStream()
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .forEach(System.out::println);
    }
}
