package main.java.ocp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by christianneuls on 23.08.18.
 */
public class Generics {

    static class Bird {}
    static class Sparrow extends Bird {};

    public static void main(String[] args) {
        List<? extends Bird> birds = new ArrayList<Bird>();
        //birds.add(new Sparrow());
        //birds.add(new Bird());

        List<Bird> birds2 = new ArrayList<Bird>();
        birds2.add(new Sparrow());
        birds2.add(new Bird());


        //lower bounds
        List<String> strings = new ArrayList<String>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<>(strings);

        addSound(strings);
        addSound(objects);

        add(Collections.emptyList());
    }

    private static void addSound(List<? super String> objects) {
        objects.add("quack");
    }

    public static void add(List<? super Number> list) {
    //not working - list cannot be modified
    //public static void add(List<?> list) {
    //public static void add(List<? extends Object> list) {
    //public static void add(List<? extends Number> list) {
    //working
    //public static void add(List list) {
    //public static void add(List<Integer> list) {
    //public static void add(List<Number> list) {
    //public static void add(List<? super Number> list) {
    //public static void add(List<? super Object> list) {
        list.add(123);
    }


}


