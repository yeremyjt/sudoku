package org.yeremy.sudoku.strategies;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.dto.Coordinate;
import org.yeremy.sudoku.search.Search;

@Named("processOfEliminationByBoxStrategy")
@Singleton
public class ProcessOfEliminationByBoxStrategy implements Strategy
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
