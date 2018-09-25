package main.java.ocp.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by christianneuls on 24.09.18.
 */
public class FileLines {
    public static void main(String[] args) {

        Path path = Paths.get("food.csv");
        try {
            Files.lines(path)
                    .flatMap(p -> Stream.of(p.split(",")))
                    .map(s -> s.length())
                    .collect(Collectors.toList())
                    .forEach(System.out::print);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
