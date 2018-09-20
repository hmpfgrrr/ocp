package main.java.oca;

import java.util.Random;

public class Switch {

    public static void main(String[] args) {
        int i = new Random().nextInt();
        testSwitch(i);
    }

    private static void testSwitch(int i) {
        //int i = 0;
        final int ival1 = 0;
        switch (i) {
            case 1:
                System.out.println("1");
            case ival1:
                System.out.println("0");
            default:
                System.out.println("default");
                break;
            case 2:
                System.out.println("2");
        }
    }
}
