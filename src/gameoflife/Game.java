package gameoflife;

import java.awt.Color;
import java.awt.Graphics;

public class Game 
{
    private Board board;
    
    public Game(Board board)
    {
        this.board = board;
    }
    
    public void advance() throws CloneNotSupportedException
    {   Board boardCopy = (Board)board.clone() ;
    

        for (Coordinate coordinate : boardCopy.getAllCoordinates())
        {
            int aliveNeighbors = boardCopy.countAliveNeighbors(coordinate);
            
            // Alive cells only stay alive with 2 or 3 alive neighbors
            if (boardCopy.isAlive(coordinate) &&
                (aliveNeighbors < 2 || aliveNeighbors > 3))
            {
                board.setAlive(coordinate, false);
            }
            
            // Dead cells come alive with 3 alive neighbors
            if (!boardCopy.isAlive(coordinate) &&
                aliveNeighbors == 3)
            {
                board.setAlive(coordinate, true);
            }
            if(boardCopy.isAlive(coordinate) && (aliveNeighbors==2 || aliveNeighbors==3)){
                board.setAlive(coordinate, true);
            }
        }
        //board=boardCopy;
    }
    
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        for (Coordinate coordinate : board.getAllCoordinates())
        {
            if (board.isAlive(coordinate))
            {
                int y = coordinate.getRow();
                int x = coordinate.getColumn();
                g.fillRect(x * 10, y * 10, 10, 10);
            }
        }
    }
}
