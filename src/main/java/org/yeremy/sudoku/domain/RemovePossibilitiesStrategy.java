package org.yeremy.sudoku.domain;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Cell;

/**
 * This is the second strategy. After the FindPossibilitiesStrategy has ran, this removes possible solutios in cells
 * that are no longer possible because and answer has been found in a different cell on a given row, column, or box.
 *
 * @author yeremy
 *
 */
@Named("removePossibilitiesStrategy")
@Singleton
public class RemovePossibilitiesStrategy implements Strategy
{
    @Inject
    @Named("searchValue")
    Search search;

    private Cell[][] matrix;

    private int n;

    @Override
    public void solve(Board board, List<String> characters)
    {
        matrix = board.getMatrix();

        n = matrix[0].length;

        int answerCount = 0;

        for (int row = 0; row < n; row++)
        {
            for (int column = 0; column < n; column++)
            {
                // If solution has not already been found.
                if (!matrix[row][column].getValue().equals("0"))
                {
                    final List<String> possibilities = matrix[row][column].getPossibilities();

                    for (final String possibility : possibilities)
                    {
                        if (search.searchInRow(matrix, n, possibility, row) != -1
                                || search.searchInColumn(matrix, n, possibility, column) != -1
                                || search.searchInBox(matrix, n, possibility, row, column) != null)
                        {
                            possibilities.remove(possibility);
                        }
                    }

                    // If there is only one possibility, that's the answer for that cell.
                    if (possibilities.size() == 1)
                    {
                        matrix[row][column].setValue(possibilities.get(0));
                        matrix[row][column].clearPossibilities();
                        answerCount++;
                    }
                }
                else
                {
                    answerCount++;
                }
            }
        }

        board.setMatrix(matrix);

        if (answerCount == n * n)
        {
            board.setSolved(true);
        }
    }

}
