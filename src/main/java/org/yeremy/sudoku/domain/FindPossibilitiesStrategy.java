package org.yeremy.sudoku.domain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Cell;

/**
 * This is the first strategy. It cycles through the sudoku board and markes all the possible solutions for each cell in
 * the board. This strategy must run before the other two. This is the first strategy.
 *
 * @author yeremy
 *
 */
@Named("findPossibilitiesStrategy")
@Singleton
public class FindPossibilitiesStrategy implements Strategy
{

    private Cell[][] matrix;

    private int n;

    @Override
    public Board solve(Board board, List<String> characters)
    {
        n = board.getCells().get(0).size();

        matrix = board.toCellMatrix();

        for (int row = 0; row < n; row++)
        {
            for (int column = 0; column < n; column++)
            {
                // If solution has not already been found.
                if (!matrix[row][column].getValue().equals("0"))
                {
                    final List<String> possibilities = new ArrayList<>();
                    // Loop through the list of characters
                    for (final String character : characters)
                    {
                        if (!searchInRow(character, row) && !searchInColumn(character, column)
                                && !searchInBox(character, row, column))
                        {
                            possibilities.add(character);
                        }
                    }

                    matrix[row][column].setPosibilities(possibilities);
                }
            }
        }

        return new Board();
    }

    private boolean searchInBox(String character, int row, int column)
    {
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
        for (int i = boxUpperRow; i <= boxLowerRow; i++)
        {
            for (int j = boxLeftColumn; j <= boxRightColumn; j++)
            {
                if (matrix[i][j].getValue().equals(character))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchInColumn(String character, int column)
    {
        for (int row = 0; row < n; row++)
        {
            if (matrix[row][column].getValue().equals(character))
            {
                return true;
            }
        }
        return false;
    }

    private boolean searchInRow(String character, int row)
    {
        for (int column = 0; column < n; column++)
        {
            if (matrix[row][column].getValue().equals(character))
            {
                return true;
            }
        }
        return false;
    }


}
