package main.java.ocp.nested;

/**
 * Created by christianneuls on 23.08.18.
 */
public class Outer2 {

    private int length = 5;
    public void calculate() {
        //final or effectivly final
        final int width = 20;
        class Inner {
            public void multiply() {
                System.out.println(length * width);
            }
        }

        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        outer2.calculate();
    }
}
