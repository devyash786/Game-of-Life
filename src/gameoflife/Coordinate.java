package gameoflife;

public class Coordinate
{
    private int row;
    private int column;
    
    public Coordinate()
    {
        row = 0;
        column = 0;
    }
    
    public Coordinate(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public void setRow(int row)
    {
        this.row = row;
    }
    
    public int getColumn()
    {
        return column;
    }
    
    public void setColumn(int column)
    {
        this.column = column;
    }
}
