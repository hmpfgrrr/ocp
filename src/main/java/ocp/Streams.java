package main.java.ocp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        System.out.println(stream.count());  //3


        //1234
        IntStream.range(1, 5)
                .mapToObj(i -> i)
                .forEach(System.out::print);

        System.out.println();
        //12345
        IntStream.rangeClosed(1, 5)
                .mapToObj(i -> i)
                .forEach(System.out::print);

        //12345 - create via own function with iterate
        System.out.println();
        IntStream.iterate(1, i -> (i+1))
                .limit(5).forEach((i1) -> System.out.print(i1 + " "));

        //map without collect -> outputs something like "java.util.stream.ReferencePipeline$3@7291c18f"
        System.out.println();
        Stream<LocalDate> s = Stream.of(LocalDate.now());
        UnaryOperator<LocalDate> u = localDate -> localDate;
        System.out.println(s.filter(l -> l != null).map(u));

    }


}
