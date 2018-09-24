package main.java.ocp.nested;

/**
 * Created by christianneuls on 24.09.18.
 */
public class Color {

    private int hue = 10;

    public static void main(String[] args) {
        //cannot be referenced from a static context
        //System.out.println(new Shade().hue);
        System.out.println(new Color().new Shade().hue);
    }

    public class Shade {
        public int hue = Color.this.hue;
    }
}
