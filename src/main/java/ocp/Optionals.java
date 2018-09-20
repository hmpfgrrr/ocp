package main.java.ocp;

import java.util.Optional;

/**
 * Created by christianneuls on 24.08.18.
 */
public class Optionals {

    public static void main(String[] args) {
        Optional<Integer> optional = Optional.empty();
        threeDigit(optional);
        Optional<Integer> optional2 = Optional.of(123);
        threeDigit(optional2);
    }

    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::print);
    }

}
