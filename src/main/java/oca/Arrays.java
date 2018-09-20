package main.java.oca;

import java.util.ArrayList;
import java.util.List;

public class Arrays {

    public static void main(String[] args) {

        String[] grades = new String[] {"1", "2", "3"};
        String []grades2 = new String[] {"1", "2", "3"};
        String grades3 [] = new String[] {"1", "2", "3"};

        String grades4 []; grades4 = new String[] {"1", "2", "3"};
        String grades6 [] = {"1", "2", "3"};
        //not allowed
        //String grades5 []; grades5 = {"1", "2", "3"};
        Object ref = grades2;

        //System.out.println(grades);

        for (String s : grades6) {

        }

        //Lists
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList();

    }
}
