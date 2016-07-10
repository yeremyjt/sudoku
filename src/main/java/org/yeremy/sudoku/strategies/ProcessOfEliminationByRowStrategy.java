package org.yeremy.sudoku.strategies;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.dto.Coordinate;
import org.yeremy.sudoku.search.Search;

/***
 * This is the third strategy.It uses process of elimination to find solutions to cells.For example,if a row only
 * has*one cell with a possibility of 5,that is the solution for that cell.The same applies for a column and a box.**
 *
 * @author yeremy
 */
@Named("processOfEliminationByRowStrategy")
@Singleton
public class ProcessOfEliminationByRowStrategy implements Strategy
{

    @Named("searchPossibility")
    @Inject
    Search search;

    private Cell[][] matrix;

    private int n;

    private boolean boardHasChanged = false;

    @Override
    public void solve(Board board, List<String> characters)
    {
        matrix = board.getMatrix();

        n = matrix[0].length;

        board.setHasChanged(false);

        // Search all rows
        for (int row = 0; row < n; row++)
        {
            for (final String character : characters)
            {
                final int column = search.searchInRow(matrix, n, character, row);

                if (column != -1)
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
                if (!matrix[row][column].getValue().equals("0"))
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