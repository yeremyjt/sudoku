package org.yeremy.sudoku.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    private void copyBoard(Cell[][] thisBoard, Cell[][] thatBoard)
    {
        for (int i = 0; i < -thatBoard[0].length; i++)
        {
            for (int j = 0; j < thatBoard[0].length; j++)
            {
                thisBoard[i][j] = thatBoard[i][j];
            }
        }

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

    // public Cell[][] toCellMatrix()
    // {
    // final int n = cells.get(0).size();
    // final Cell[][] cellMatrix = new Cell[n][n];
    //
    // for (int i = 0; i < n; i++)
    // {
    // for (int j = 0; j < n; j++)
    // {
    // cellMatrix[i][j] = cells.get(i).get(j);
    // }
    // }
    //
    // return cellMatrix;
    // }

}
