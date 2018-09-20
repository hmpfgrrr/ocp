package main.java.ocp.katas.gameoflife;

/**
 * Second try:
 *   more OOP and more promising, but after 1:45h still not working properly.
 */
public class Game {

    private static final Board board = new Board();

    public static void main(String[] args) {
        Game game = new Game();
        board.init();
        board.print();

        for (int i = 0; i < 5; i++) {
            board.process();
            board.print();
        }
    }

}
