package main.java.ocp;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by christianneuls on 27.08.18.
 */
public class Dates {

    public static void main(String[] args) {
        ZoneId.getAvailableZoneIds().stream()
                .filter(z -> z.contains("Europe")) //|| z.contains("America"))
                .sorted().forEach(System.out::println);
    }
}
