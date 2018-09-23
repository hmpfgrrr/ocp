package main.java.ocp;

import main.java.oca.Strings;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * Created by christianneuls on 24.08.18.
 */
public class Maps {

    public static void main(String[] args) {
        Map<String, String> favorites = new TreeMap<>();
        favorites.put("Jenny", "Tram");
        favorites.put("Jenny", "Tram2");
        favorites.put("Jenny", "Tram3");

        favorites.put("Jenny2", null);
        favorites.put("Jenny2", "Tram");
        favorites.putIfAbsent("Jenny2", "Tram2");
        favorites.putIfAbsent("Jenny3", "Tram2");
        favorites.put("Jenny4", null);
        favorites.putIfAbsent("Jenny4", "Tram2");

        System.out.println(favorites);


        //merge
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        Map<String, String> favorites2 = new HashMap<>();
        favorites2.put("Jenny", "Bus Tour");
        favorites2.put("Tom", "Tram");

        String jenny = favorites2.merge("Jenny", "Skyride", mapper);
        String tom = favorites2.merge("Tom", "Skyride", mapper);

        System.out.println(favorites2);
        System.out.println(jenny);
        System.out.println(tom);

        //ConcurrentModificationException
        Map<String, Object> foodData = new HashMap<>();
        try {
            foodData.put("penguin", 1);
            foodData.put("flamingo", 2);
            for (String key : foodData.keySet()) {
                foodData.remove(key);
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(foodData.size());
        }

        Map<String, Object> foodData2 = new ConcurrentHashMap<>();
        foodData2.put("penguin", 1);
        foodData2.put("flamingo", 2);
        for (String key : foodData2.keySet()) {
            foodData2.remove(key);
        }
        System.out.println(foodData2.size());

        System.out.println("synchronized collection methods do not synchronize on iterators, only on direct data access");
        Map<String, Object> foodData3 = new HashMap<>();
        foodData3.put("penguin", 1);
        foodData3.put("flamingo", 2);
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(foodData3);
        for (String key : synchronizedMap.keySet()) {
            foodData3.remove(key);
        }
        System.out.println(foodData3.size());

    }
}
