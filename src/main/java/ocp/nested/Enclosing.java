package main.java.ocp.nested;

/**
 * Created by christianneuls on 23.08.18.
 */
public class Enclosing {

    private int val = 1;
    private static int val2 = 1;

    static class Nested {
        private int price = 6;

        private void test() {
            System.out.println(price);
            //not allowed from static context
            //System.out.println(val);
            System.out.println(val2);
        }
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.price);
    }
}
