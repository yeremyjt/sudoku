package org.yeremy.sudoku.dto;

import java.util.ArrayList;
import java.util.List;

public class Row
{
    List<Cell> row;

    public List<Cell> getRow()
    {
        return new ArrayList<>(row);
    }

    public void setRow(List<Cell> row)
    {
        this.row.addAll(row);
    }

}
