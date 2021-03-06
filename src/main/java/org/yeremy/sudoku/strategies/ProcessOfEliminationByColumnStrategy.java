package org.yeremy.sudoku.strategies;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.search.Search;

/***
 * This is the third strategy. It uses process of elimination to find solutions to cells. For example, if a row only
 * has one cell with a possibility of 5,that is the solution for that cell. The same applies for a column and a box.
 *
 * @author yeremy
 */
@Named("processOfEliminationByColumnStrategy")
@Singleton
public class ProcessOfEliminationByColumnStrategy implements Strategy
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

        // Search all columns
        for (int column = 0; column < n; column++)
        {
            for (final String character : characters)
            {
                final int row = search.searchInColumn(matrix, n, character, column);

                if (row != -1)
                {
                    matrix[row][column].setValue(character);
                    matrix[row][column].clearPossibilities();
                    boardHasChanged = true;
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
