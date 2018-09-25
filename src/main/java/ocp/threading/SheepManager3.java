package main.java.ocp.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by christianneuls on 28.08.18.
 */
public class SheepManager3 {
    private AtomicInteger sheepCount = new AtomicInteger(0);
    private void incrementAndReport() {
        System.out.println(sheepCount.incrementAndGet() + " ");
    }

    public static void main(String[] args) {
        System.out.println("incrementing with AtomicInteger");
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);

            SheepManager3 manager = new SheepManager3();
            for (int i = 0; i < 5000; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
