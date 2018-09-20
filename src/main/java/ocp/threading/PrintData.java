package main.java.ocp.threading;

/**
 * Created by christianneuls on 28.08.18.
 */
public class PrintData {

    public static void main(String[] args) {
        new Thread(new PrintDataInternal()).start();
        (new ReadInventoryThread()).start();
    }

}

class PrintDataInternal implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " Printing rec: " + i);
        }
    }
}


class ReadInventoryThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " printing zoo inventory");
    }

}
