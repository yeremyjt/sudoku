package org.yeremy.sudoku.dto;

public class Coordinate
{
    private int row;

    private int column;

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

    public Coordinate(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Coordinate)
        {
            final Coordinate c = (Coordinate) obj;

            if (this.row == c.getRow() && this.column == c.getColumn())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
