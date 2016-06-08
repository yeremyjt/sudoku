package org.yeremy.sudoku.search;

import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.dto.Coordinate;

public interface Search
{
    Coordinate searchInBox(Cell[][] matrix, int n, String character, int row, int column);

    int searchInColumn(Cell[][] matrix, int n, String character, int column);

    int searchInRow(Cell[][] matrix, int n, String character, int row);
}
