package main.java.oca.lambdas;

import java.util.function.Predicate;

public class Lambdas {

    public static void main(String[] args) {
        //Predicate<String> predicate = Predicate<String>;

        Predicate<String> filter = (String s) -> s.isEmpty();
        Predicate<String> filter2 = (s) -> s.isEmpty();
        Predicate<String> filter3 = s -> s.isEmpty();
        Predicate<String> filter4 = s -> {return s.isEmpty();};
        Predicate<String> filter5 = s -> {
            System.out.println("stuff");
            return s.isEmpty();
        };

        //not allowed
        //Predicate<String> filtern1 = String s -> s.isEmpty();
        //Predicate<String> filter4 = s -> {s.isEmpty()};
    }

}
