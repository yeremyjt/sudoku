package org.yeremy.sudoku.dto;

import java.util.ArrayList;
import java.util.List;

public class Column
{
    List<Cell> column;

    public List<Cell> getColumn()
    {
        return new ArrayList<>(column);
    }

    public void setColumn(List<Cell> column)
    {
        this.column.addAll(column);
    }
}
