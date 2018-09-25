package main.java.ocp.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by christianneuls on 28.08.18.
 */
public class SheepManager {
    private int sheepCount = 0;
    private void incrementAndReport() {
        System.out.println(++sheepCount + " ");
    }

    public static void main(String[] args) {
        System.out.println("incrementing unguarded in parallel can yield race conditions");
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);

            SheepManager manager = new SheepManager();
            for (int i = 0; i < 5000; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
