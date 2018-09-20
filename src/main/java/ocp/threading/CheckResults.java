package main.java.ocp.threading;

import java.util.concurrent.*;

/**
 * Created by christianneuls on 28.08.18.
 */
public class CheckResults {
    private static int counter = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        futureWithoutResult();
        futureWithResult();
    }

    private static void futureWithoutResult() throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() ->  {
                for (int i = 0; i < 500; i++) CheckResults.counter++;
            });
            Object resString = result.get(10, TimeUnit.SECONDS);
            System.out.println("Obj " + resString);
            System.out.println("Counter " + counter);
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if (service != null) service.shutdown();
        }
    }

    private static void futureWithResult() throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<String> result = service.submit(() ->  {
                for (int i = 0; i < 500; i++) counter++;
                return String.valueOf(counter);
            });
            Object resString = result.get(10, TimeUnit.SECONDS);
            System.out.println("Obj " + resString);
            System.out.println("Counter " + counter);
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
