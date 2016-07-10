package org.yeremy.sudoku.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

public class Board
{
    @JsonProperty("matrix")
    private Cell[][] matrix;

    @JsonProperty("solved")
    private boolean solved;

    @JsonProperty("hasChanged")
    boolean hasChanged;

    public Cell[][] getMatrix()
    {
        return this.matrix;
    }

    public void setMatrix(Cell[][] matrix)
    {
        this.matrix = matrix;
    }

    public Board copy()
    {
        Board that = new Board();
        that.hasChanged = this.hasChanged;
        that.solved = this.solved;
        that.matrix = new Cell[this.matrix[0].length][this.matrix[0].length];

        for (int i = 0; i < this.matrix[0].length; i++)
        {
            for (int j = 0; j < this.matrix[0].length; j++)
            {
                that.matrix[i][j] = this.matrix[i][j];
            }
        }

        return that;
    }

    public boolean isSolved()
    {
        return solved;
    }

    public boolean isHasChanged()
    {
        return hasChanged;
    }

    public void setHasChanged(boolean hasChanged)
    {
        this.hasChanged = hasChanged;
    }

    public void setSolved(boolean solved)
    {
        this.solved = solved;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Board)
        {
            final Board that = (Board) obj;
            if (this.hasChanged == that.hasChanged &&
                    this.solved == that.solved)
            {
                if (this.matrix.length == that.matrix.length)
                {
                    if (this.matrix.length > 0)
                    {
                        for (int i = 0; i < this.matrix[0].length; i++)
                        {
                            for (int j = 0; j < this.matrix[0].length; j++)
                            {
                                if (!this.matrix[i][j].equals(that.matrix[i][j]))
                                {
                                    return false;
                                }
                            }
                        }
                    }
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
        else
        {
            return false;
        }

        return true;
    }
}
