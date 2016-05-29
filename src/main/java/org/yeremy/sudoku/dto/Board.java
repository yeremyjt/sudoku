package org.yeremy.sudoku.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Board
{
    @JsonProperty("cells")
    private List<List<Cell>> cells;

    @JsonProperty("solved")
    private boolean solved;

    public List<List<Cell>> getCells()
    {
        return this.cells;
    }

    public void setCells(List<List<Cell>> cells)
    {
        this.cells = cells;
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

    public void setSolved(boolean solved)
    {
        this.solved = solved;
    }

}
