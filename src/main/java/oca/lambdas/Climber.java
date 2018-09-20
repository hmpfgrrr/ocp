package main.java.oca.lambdas;

interface Climb {
    boolean isTooHigh(int h, int l);
}

public class Climber {

    public static void main(String [] args) {
        Climber climber = new Climber();
        climber.check((h, l) -> h > l, 5);
    }

    private void check(Climb climb, int h) {
        if (climb.isTooHigh(h, 10)) {
            System.out.println("too high");
        } else {
            System.out.println("ok");
        }
    }
}
