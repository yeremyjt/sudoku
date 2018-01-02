package org.yeremy.sudoku.strategies;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.dto.Coordinate;
import org.yeremy.sudoku.search.Search;

/***
 * This is the third strategy. It uses process of elimination to find solutions to cells. For example, if a row only
 * has one cell with a possibility of 5,that is the solution for that cell. The same applies for a column and a box.
 *
 * @author yeremy
 */
@Named("processOfEliminationByBoxStrategy")
@Singleton
public class ProcessOfEliminationByBoxStrategy implements Strategy
{
    @Inject
    @Named("searchPossibility")
    private Search search;

    @Override
    public void solve(Board board, Set<String> characters)
    {
        Cell[][] matrix;
        int n;
        boolean boardHasChanged = false;
        matrix = board.getMatrix();
        n = matrix[0].length;
        board.setHasChanged(false);

        // Search all boxes
        final int squareRoot = (int) Math.sqrt(n);
        for (int row = 0; row < n; row += squareRoot)
        {
            for (int column = 0; column < n; column += squareRoot)
            {
                for (final String character : characters)
                {
                    final Coordinate coordinate = search.searchInBox(matrix, n, character, row, column);

                    if (coordinate != null)
                    {
                        matrix[coordinate.getRow()][coordinate.getColumn()].setValue(character);
                        matrix[coordinate.getRow()][coordinate.getColumn()].clearPossibilities();
                        boardHasChanged = true;
                    }
                }
            }
        }

        // Check if board is full
        int answerCount = 0;
        for (int row = 0; row < n; row++)
        {
            for (int column = 0; column < n; column++)
            {
                if (matrix[row][column].getValue() != null)
                {
                    answerCount++;
                }
            }
        }

        board.setHasChanged(boardHasChanged);

        if (answerCount == n * n)
        {
            board.setSolved(true);
        }
    }
}
