package main.java.ocp.katas.gameoflife;

/**
 * Created by christianneuls on 06.08.18.
 */
public class Cell {
    public final int x;
    public final int y;

    public String content = ".";
    public int numberOfNeighbours = 0;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return content;
        //return Integer.toString(numberOfNeighbours);
    }
}
