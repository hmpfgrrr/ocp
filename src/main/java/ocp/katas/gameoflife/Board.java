package main.java.ocp.katas.gameoflife;

/**
 * Created by christianneuls on 06.08.18.
 */
public class Board {

    //1 more to make processing easier and not zero based
    final Cell[][] boardArray = new Cell[5][9];

    /**
     * 4 8
     * ........
     * ....*...
     * ...**...
     * ........
     */
    public void init() {
        //TODO delay parsing -> static boardArray for now

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <=  8; j++) {
                Cell cell = new Cell(i, j);
                boardArray[i][j] = cell;

                if (((i == 2) && (j == 5)) || ((i == 3) && (j == 4)) || ((i == 3) && (j == 5))) {
                    cell.content = "*";
                }
            }
        }
        calculateNumberOfAliveNeighbours();
    }

    public void print() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 8; j++) {
                System.out.print(boardArray[i][j]);
            }
            System.out.println();
        }
    }

    /**
     *    1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
     *    2. Any live cell with more than three live neighbours dies, as if by overcrowding.
     *    3. Any live cell with two or three live neighbours lives on to the next generation.
     *    4. Any dead cell with exactly three live neighbours becomes a live cell.
     */
    public void process() {
        calculateNumberOfAliveNeighbours();
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 8; j++) {
                Cell currentCell = boardArray[i][j];
                if ((currentCell.numberOfNeighbours < 2)||(currentCell.numberOfNeighbours > 3)) {
                    currentCell.content = ".";
                } else {
                    currentCell.content = "*";
                }
            }
        }
        System.out.println();
    }

    public void calculateNumberOfAliveNeighbours() {

        int numOfNeighbours = 0;

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 8; j++) {
                //upperleft
                numOfNeighbours += isNeighbourAlive(i, j, -1, -1) ? 1 : 0;
                //upper
                numOfNeighbours += isNeighbourAlive(i, j, 0, -1) ? 1 : 0;
                //upperright
                numOfNeighbours += isNeighbourAlive(i, j, 1, -1) ? 1 : 0;
                //left
                numOfNeighbours += isNeighbourAlive(i, j, -1, 0) ? 1 : 0;
                //right
                numOfNeighbours += isNeighbourAlive(i, j, 1, 0) ? 1 : 0;
                //lowerleft
                numOfNeighbours += isNeighbourAlive(i, j, -1, 1) ? 1 : 0;
                //lower
                numOfNeighbours += isNeighbourAlive(i, j, 0, 1) ? 1 : 0;
                //lowerright
                numOfNeighbours += isNeighbourAlive(i, j, 1, 1) ? 1 : 0;


                Cell currentCell = boardArray[i][j];
                currentCell.numberOfNeighbours = numOfNeighbours;
            }
        }
    }

    private boolean isNeighbourAlive(int x, int y, int deltaX, int deltaY) {
        int targetX = x + deltaX;
        int targetY = y + deltaY;
        //System.out.println("x:"+ targetX + "y:" + targetY);
        if ((targetX > 0 && targetY > 0) && (targetX <= 8 && targetY <= 4)) {
            Cell neighbourCell = boardArray[targetY][targetX];
            return neighbourCell.content == "*";
        }
        return false;
    }
}
