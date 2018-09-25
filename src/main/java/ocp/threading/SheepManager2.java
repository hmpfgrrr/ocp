package main.java.ocp.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by christianneuls on 28.08.18.
 */
public class SheepManager2 {
    private int sheepCount = 0;
    private void incrementAndReport() {
        synchronized (this) {
            System.out.println(++sheepCount + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("incrementing with synchronized object");
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);

            SheepManager2 manager = new SheepManager2();
            for (int i = 0; i < 5000; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
