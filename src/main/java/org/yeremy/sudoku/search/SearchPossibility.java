package org.yeremy.sudoku.search;

import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.dto.Coordinate;

public class SearchPossibility implements Search
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

            if (row >= leftColumn && row <= rightColumn)
            {
                boxLeftColumn = leftColumn;
                boxRightColumn = rightColumn;
                break;
            }
        }

        // Search in the box
        int counter = 0;
        for (int i = boxUpperRow; i <= boxLowerRow; i++)
        {
            for (int j = boxLeftColumn; j <= boxRightColumn; j++)
            {
                // Solution has been found for this character in this box
                if (matrix[i][j].getValue().equals("0"))
                {
                    return null;
                }

                if (matrix[i][j].getPossibilities().contains(character))
                {
                    counter++;
                    coordinate.setRow(i);
                    coordinate.setColumn(j);

                    if (counter > 1)
                    {
                        return null;
                    }
                }
            }
        }

        if (counter == 1)
        {
            return coordinate;
        }

        return null;

    }

    @Override
    public int searchInColumn(Cell[][] matrix, int n, String character, int column)
    {
        int counter = 0;
        int rowToReturn = -1;

        for (int row = 0; row < n; row++)
        {
            // Solution has been found
            if (matrix[row][column].getValue().equals("0"))
            {
                return -1;
            }

            if (matrix[row][column].getPossibilities().contains(character))
            {
                counter++;
                rowToReturn = column;

                if (counter > 1)
                {
                    return -1;
                }
            }
        }

        if (counter == 1)
        {
            return rowToReturn;
        }

        return -1;
    }

    @Override
    public int searchInRow(Cell[][] matrix, int n, String character, int row)
    {
        int counter = 0;
        int columnToReturn = -1;

        for (int column = 0; column < n; column++)
        {
            // Solution has been found
            if (matrix[row][column].getValue().equals("0"))
            {
                return -1;
            }

            if (matrix[row][column].getPossibilities().contains(character))
            {
                counter++;
                columnToReturn = column;
            }
        }

        if (counter > 1)
        {
            return -1;
        }

        if (counter == 1)
        {
            return columnToReturn;
        }

        return -1;
    }

}
