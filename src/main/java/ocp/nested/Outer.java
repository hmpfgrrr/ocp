package main.java.ocp.nested;

/**
 * Created by christianneuls on 23.08.18.
 */
public class Outer {

    private String greeting = "Hi";

    protected class Inner {
        public int repeat = 3;
        public void go() {
            for (int i = 0; i < repeat; i++) {
                System.out.println(greeting);
            }
        }
    }

    public void callInner(){
        Inner inner = new Inner();
        inner.go();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.callInner();

        //Inner inner = new Inner();

        Outer outer2 = new Outer();
        Inner inner = outer2.new Inner();
        inner.go();
    }

}
