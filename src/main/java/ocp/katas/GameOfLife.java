package main.java.ocp.katas;

/**
 * Created by christianneuls on 23.07.18.
 *
 * First try:
 *   approx 20 min for static grid output with test data (4,8) - no parsing
 *   1h 10min still lots of problems with edge detection. determination works roughly...
 *
 */
public class GameOfLife {

    private static String[][] cells = new String[4][8];

    public static void main(String[] args) {
        
        initGrid();
        
        startSimulation();
    }

    private static void startSimulation() {
        while (1 == 1) {
            printCells();
            processLife();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *    1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
     *    2. Any live cell with more than three live neighbours dies, as if by overcrowding.
     *    3. Any live cell with two or three live neighbours lives on to the next generation.
     *    4. Any dead cell with exactly three live neighbours becomes a live cell.
     */
    private static void processLife() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                int numberOfNeighbours = determineNumberOfNeighbours(i, j);
                String cell = cells[i][j];
                String newCell = ".";
                if (numberOfNeighbours == 0)
                    newCell = "*";
                else if (numberOfNeighbours == 1)
                    newCell = "*";
            }
        }
    }

    private static int determineNumberOfNeighbours(int xPos, int yPos) {
        //String startCell = cells[startXPos][startYPos];
        int startXPos = xPos - 1;
        int startYPos = yPos - 1;
        int count = 0;
        //TODO: edge detection
        if (((startXPos < 0) || (startYPos < 0)) || (((startXPos > 8) || (startYPos > 4))))
            return 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int neighbourXPos = startXPos + i;
                int neighbourYPos = startYPos + j;
                if (((neighbourXPos == xPos) && (neighbourYPos == yPos))
                        || (neighbourXPos > 8) || (neighbourYPos > 4))
                    continue;
                if (cells[neighbourXPos][neighbourYPos] == "*")
                    count++;
            }
        }
        System.out.println(xPos + ":" + yPos + " count:" + count);
        return count;
    }

    private static void printCells() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(cells[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 4 8
     * ........
     * ....*...
     * ...**...
     * ........
     */
    private static void initGrid() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8 ; j++) {
                if (((i == 1) && (j == 4)) || ((i == 2) && ((j == 3) || (j == 4))))
                    cells[i][j] = "*";
                else
                    cells[i][j] = ".";
            }
        }
    }
}
