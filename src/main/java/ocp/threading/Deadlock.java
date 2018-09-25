package main.java.ocp.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by christianneuls on 09.01.17.
 */

class Food {}
class Water {}

public class Deadlock {

    public void eatAndDrink(Food food, Water water) {
        synchronized (food) {
            System.out.println("Got Food");
            move();
            synchronized (water) {
                System.out.println("Got Water");
            }
        }
    }

    public void drinkAndEat(Food food, Water water) {
        synchronized (water) {
            System.out.println("Got Water");
            move();
            synchronized (food) {
                System.out.println("Got Food");
            }
        }
    }

    private void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            //
        }
    }


    public static void main(String[] args) {
        Deadlock foxy = new Deadlock();
        Deadlock tails = new Deadlock();
        Food food = new Food();
        Water water = new Water();

        //Process Data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> foxy.drinkAndEat(food, water));
            //service.submit(() -> tails.eatAndDrink(food, water));
            service.submit(() -> foxy.eatAndDrink(food, water));
        } finally {
            if (service != null)
                service.shutdown();
        }
    }
}
