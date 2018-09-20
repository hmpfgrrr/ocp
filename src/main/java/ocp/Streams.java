package main.java.ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by christianneuls on 24.08.18.
 */
public class Streams {

    public static void main(String[] args) {

        //order of peek
        Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
        infinite
                .peek(System.out::print)
                .filter(x -> x % 2 == 1)
                .limit(5)
                .forEach(System.out::print);

        //streams are lazily evaluated
        System.out.println();
        List<String> cats = new ArrayList<>();
        cats.add("Annie");
        cats.add("Ripley");
        Stream<String> stream = cats.stream();
        cats.add("KC");
        System.out.println(stream.count());

    }


}
