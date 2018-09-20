package main.java.ocp.tryWithResources;

/**
 * Created by christianneuls on 27.08.18.
 */
public class TurkeyCage2 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("close");
    }

    public static void main(String[] args) {
        try(TurkeyCage2 t = new TurkeyCage2()) {
            System.out.println("put turkeys in");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
