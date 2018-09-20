package main.java.ocp.threading.forkjoin;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by christianneuls on 05.01.17.
 */
public class WeighAnimalTask extends RecursiveTask<Double> {

    private int start;
    private int end;
    private Double[] weights;

    public WeighAnimalTask(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    protected Double compute() {
        if (end - start <= 3) {
            double sum = 0;
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                System.out.println("Animal weighed: " + i);
                sum += weights[i];
            }
            return sum;
        }
        else {
            int middle = start + ((end -start)/2);
            System.out.println(start + " " + middle + " " + end);
            RecursiveTask<Double> otherTask = new WeighAnimalTask(weights, start, middle);
            otherTask.fork();
            return new WeighAnimalTask(weights, middle, end).compute() + otherTask.join();
        }

    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];

        ForkJoinTask<Double> task = new WeighAnimalTask(weights, 0, weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        Double sum = pool.invoke(task);

        //Print results
        System.out.println();
        System.out.println("Weights: ");
        Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue() + " "));
        System.out.println();
        //TODO: verify sum
        System.out.println("Sum: " + sum);
    }
}
