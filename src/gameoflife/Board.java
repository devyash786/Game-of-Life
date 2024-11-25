package gameoflife;

import java.util.LinkedList;
import java.util.List;

public class Board implements Cloneable
{
    private boolean[][] board;
    
    public Board()
    {
        board = new boolean[25][25];
    }
    
    public Board(int height, int width)
    {
        throw new RuntimeException("Unimplemented");
    }
    
    /**
     * @param coordinate The coordinate to check
     * @return Number of alive neighbors
     */
    public int countAliveNeighbors(Coordinate coordinate)
    {
        int count = 0;
        for (Coordinate neighbor : getNeighbors(coordinate))
        {
            if (isAlive(neighbor))
            {
                count++;
            }
        }
        return count;
    }
    
    /**
     * @param coordinate The coordinate to check
     * @return true if alive
     */
    public boolean isAlive(Coordinate coordinate)
    {
        if(coordinate.getRow()<0 || coordinate.getColumn() <0 ||
          coordinate.getRow()>=board.length || coordinate.getColumn() >=board[0].length)
          {
              return false;
          }
        return board[coordinate.getRow()][coordinate.getColumn()];
    }
    
    /**
     * @param coordinate The coordinate to set
     * @param alive True to set the coordinate to alive, false to set it to dead
     */
    public void setAlive(Coordinate coordinate, boolean alive)
    { 
        if(coordinate.getRow()<0 || coordinate.getColumn() <0 ||
        coordinate.getRow()>=board.length || coordinate.getColumn() >=board[0].length)
        {
            return;
        }
        board[coordinate.getRow()][coordinate.getColumn()] = alive;
    }
    
    /**
     * @return A list of valid coordinates for the board
     */
    public List<Coordinate> getAllCoordinates()
    {
        List<Coordinate> coordinates = new LinkedList<Coordinate>();
        for (int row = 0; row < 25; row++)
        {
            for (int col = 0; col < 25; col++)
            {
                coordinates.add(new Coordinate(row, col));
            }
        }
        return coordinates;
    }
    
    /**
     * @param coordinate The coordinate to get neighbors for
     * @return A list of neighbor coordinates
     */
    private List<Coordinate> getNeighbors(Coordinate coordinate)
    {
        List<Coordinate> coordinates = new LinkedList<Coordinate>();
        
        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                if (i == 0 && j == 0)
                {
                    continue;
                }
                
                    coordinates.add(
                        new Coordinate(coordinate.getRow() + i,
                                       coordinate.getColumn() + j));
                
            }
        }
        
        return coordinates;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Board clonedBoard = new Board(/* parameters for creating a new board */);
        for (Coordinate coordinate : this.getAllCoordinates()) {
            clonedBoard.setAlive(coordinate, this.isAlive(coordinate));
        }
        return clonedBoard;
    }
}
