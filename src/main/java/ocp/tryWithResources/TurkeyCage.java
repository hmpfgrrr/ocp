package main.java.ocp.tryWithResources;

/**
 * Created by christianneuls on 27.08.18.
 */
public class TurkeyCage implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("close");
    }

    public static void main(String[] args) {
        try(TurkeyCage t = new TurkeyCage()) {
            System.out.println("put turkeys in");

        }
    }
}
