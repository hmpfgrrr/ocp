package main.java.ocp;

/**
 * Created by christianneuls on 23.08.18.
 */
public class Enum {

    public enum Season {
        WINTER("Low"), SPRING("Medium"),
        SUMMER("High") {
            @Override
            public void test() {
                System.out.println("special");
            }
        };

        private String expVisitors;

        Season(String expVisitors) {
            this.expVisitors = expVisitors;
        }

        public void printVisitors() {
            System.out.println(this.expVisitors);
        }

        public void test() {
            System.out.println("default");
        }
    }

    public static void main(String[] args) {

        Season spring = Season.SPRING;
        System.out.println(spring);
        System.out.println(spring.expVisitors);
        spring.test();

        Season summer = Season.SUMMER;
        summer.test();
    }
}
