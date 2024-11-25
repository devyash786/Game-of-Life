package gameoflife;

import java.util.Date;
import java.util.Random;

public class Initializer
{
    // Part 1
    public static Board initializeGlider()
    {
        Board board = new Board();

        board.setAlive(new Coordinate(1, 3), true);
        board.setAlive(new Coordinate(2, 1), true);
        board.setAlive(new Coordinate(2, 3), true);
        board.setAlive(new Coordinate(3, 2), true);
        board.setAlive(new Coordinate(3, 3), true);

        return board;
    }

    // Part 2
    public static Board initializeGliderGun()
    {
        Board board = new Board(60, 80);
        board.setAlive(new Coordinate(1, 5), true);
        board.setAlive(new Coordinate(1, 6), true);
        board.setAlive(new Coordinate(2, 5), true);
        board.setAlive(new Coordinate(2, 6), true);
        board.setAlive(new Coordinate(11, 5), true);
        board.setAlive(new Coordinate(11, 6), true);
        board.setAlive(new Coordinate(11, 7), true);
        board.setAlive(new Coordinate(12, 4), true);
        board.setAlive(new Coordinate(12, 8), true);
        board.setAlive(new Coordinate(13, 3), true);
        board.setAlive(new Coordinate(13, 9), true);
        board.setAlive(new Coordinate(14, 3), true);
        board.setAlive(new Coordinate(14, 9), true);
        board.setAlive(new Coordinate(15, 6), true);
        board.setAlive(new Coordinate(16, 4), true);
        board.setAlive(new Coordinate(16, 8), true);
        board.setAlive(new Coordinate(17, 5), true);
        board.setAlive(new Coordinate(17, 6), true);
        board.setAlive(new Coordinate(17, 7), true);
        board.setAlive(new Coordinate(18, 6), true);
        board.setAlive(new Coordinate(21, 3), true);
        board.setAlive(new Coordinate(21, 4), true);
        board.setAlive(new Coordinate(21, 5), true);
        board.setAlive(new Coordinate(22, 3), true);
        board.setAlive(new Coordinate(22, 4), true);
        board.setAlive(new Coordinate(22, 5), true);
        board.setAlive(new Coordinate(23, 2), true);
        board.setAlive(new Coordinate(23, 6), true);
        board.setAlive(new Coordinate(25, 1), true);
        board.setAlive(new Coordinate(25, 2), true);
        board.setAlive(new Coordinate(25, 6), true);
        board.setAlive(new Coordinate(25, 7), true);
        board.setAlive(new Coordinate(35, 3), true);
        board.setAlive(new Coordinate(35, 4), true);
        board.setAlive(new Coordinate(36, 3), true);
        board.setAlive(new Coordinate(36, 4), true);
        
        return board;
    }

    // Part 2
    public static Board initializeRandom()
    {
        Board board = new Board(60, 80);
        
        Random rand = new Random(new Date().getTime());
        
        for (Coordinate c : board.getAllCoordinates())
        {
            board.setAlive(c, rand.nextInt(8) == 1);
        }
        
        return board;
    }
}
