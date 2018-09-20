package main.java.ocp.tryWithResources;

/**
 * Created by christianneuls on 27.08.18.
 */
public class JammedTurkeyCage implements AutoCloseable {

    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }

    public static void main(String[] args) {
        tryOne();
        tryTwo();

    }

    private static void tryOne() {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            System.out.println("put turkeys in");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
        }
    }

    private static void tryTwo() {
        System.out.println("----");
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new IllegalStateException("turkeys ran off");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
            for (Throwable t: e.getSuppressed()) {
                System.out.println(t.getMessage());
            }
        }
    }
}
