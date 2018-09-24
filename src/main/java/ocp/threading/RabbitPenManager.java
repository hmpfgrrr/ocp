package main.java.ocp.threading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by christianneuls on 24.09.18.
 */
public class RabbitPenManager {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2, () -> System.out.println("barrier cycle done"));

        //would wait forever since it runs single threaded and waits for someone else entering the barrier
        //IntStream.iterate(1, i -> 1)
        //        .limit(2).forEach(i -> await(cb));

        //also waiting forever with only a single thread
        //ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(() -> await(cb));
        service.submit(() -> await(cb));
        service.submit(() -> await(cb));
        service.submit(() -> await(cb));
        System.out.println("done submitting");
        service.shutdown();
    }

    private static void await(CyclicBarrier cb) {
        try {
            System.out.println("barrier reached");
            cb.await();
            System.out.println("barrier passed");
        } catch (InterruptedException | BrokenBarrierException e) {
            //
        }
    }
}
