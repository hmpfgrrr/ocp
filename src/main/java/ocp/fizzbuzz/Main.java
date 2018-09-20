package main.java.ocp.fizzbuzz;

/**
 * FizzBuzz algo
 *   first time 9min 30sec
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("starting");

        ConsoleBasedFizzBuzz buzzer = new ConsoleBasedFizzBuzz();
        buzzer.print(1,100);
    }
}
