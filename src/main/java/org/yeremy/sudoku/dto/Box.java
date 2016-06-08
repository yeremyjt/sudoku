
package org.yeremy.sudoku.dto;

import java.util.ArrayList;
import java.util.List;

public class Box
{
    private List<Row> rows;

    private List<Column> columns;

    public List<Row> getRows()
    {
        return new ArrayList<>(rows);
    }

    public void setRows(List<Row> rows)
    {
        this.rows.addAll(rows);
    }

    public List<Column> getColumns()
    {
        return new ArrayList<>(columns);
    }

    public void setColumns(List<Column> columns)
    {
        this.columns.addAll(columns);
    }


}
