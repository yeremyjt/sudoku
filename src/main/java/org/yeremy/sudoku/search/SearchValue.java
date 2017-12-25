package org.yeremy.sudoku.search;

import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.dto.Coordinate;

@Named("searchValue")
@Singleton
public class SearchValue implements Search
{

    @Override
    public Coordinate searchInBox(Cell[][] matrix, int n, String character, int row, int column)
    {
        final Coordinate coordinate = new Coordinate(-1, -1);

        final int boxSize = (int) Math.sqrt(n);

        int boxUpperRow = -1;
        int boxLowerRow = -1;
        int boxLeftColumn = -1;
        int boxRightColumn = -1;

        // Finding boxUpperRow and boxLowerRow
        for (int x = 0; x <= n; x += boxSize)
        {
            final int upperRow = x;
            final int lowerRow = x + boxSize - 1;

            if (row >= upperRow && row <= lowerRow)
            {
                boxUpperRow = upperRow;
                boxLowerRow = lowerRow;
                break;
            }
        }

        // Finding boxLeftColumn and boxRightColumn
        for (int x = 0; x <= n; x += boxSize)
        {
            final int leftColumn = x;
            final int rightColumn = x + boxSize - 1;

            if (column >= leftColumn && column <= rightColumn)
            {
                boxLeftColumn = leftColumn;
                boxRightColumn = rightColumn;
                break;
            }
        }

        // Search in the box
        for (int i = boxUpperRow; i <= boxLowerRow; i++)
        {
            for (int j = boxLeftColumn; j <= boxRightColumn; j++)
            {
                if (matrix[i][j].getValue() != null &&
                        matrix[i][j].getValue().equals(character))
                {
                    coordinate.setRow(i);
                    coordinate.setColumn(j);
                    return coordinate;
                }
            }
        }

        return null;
    }

    @Override
    public int searchInColumn(Cell[][] matrix, int n, String character, int column)
    {
        for (int row = 0; row < n; row++)
        {
            if (matrix[row][column].getValue() != null &&
                    matrix[row][column].getValue().equals(character))
            {
                return row;
            }
        }
        return -1;
    }

    @Override
    public int searchInRow(Cell[][] matrix, int n, String character, int row)
    {
        for (int column = 0; column < n; column++)
        {
            if (matrix[row][column].getValue() != null &&
                    matrix[row][column].getValue().equals(character))
            {
                return column;
            }
        }
        return -1;
    }

}
