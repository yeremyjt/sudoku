package org.yeremy.sudoku.strategies;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.search.Search;

/**
 * This is the second strategy. After the FindPossibilitiesStrategy has ran, this removes possible solutions in cells
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

        board.setHasChanged(false);

        for (int row = 0; row < n; row++)
        {
            for (int column = 0; column < n; column++)
            {

                if (row == 1 && column == 3)
                {
                    System.out.println(column);
                }
                // If solution has not already been found.
                if (matrix[row][column].getValue().equals("0"))
                {
                    final List<String> markedForDeletion = new ArrayList<>();

                    final List<String> possibilities = new ArrayList<>(matrix[row][column].getPossibilities());

                    for (final String possibility : possibilities)
                    {
                        if (search.searchInRow(matrix, n, possibility, row) != -1
                                || search.searchInColumn(matrix, n, possibility, column) != -1
                                || search.searchInBox(matrix, n, possibility, row, column) != null)
                        {
                            markedForDeletion.add(possibility);
                        }
                    }

                    matrix[row][column].deletePossibilities(markedForDeletion);

                    // If there is only one possibility, that's the answer for that cell.
                    if (matrix[row][column].getPossibilities().size() == 1)
                    {
                        matrix[row][column].setValue(matrix[row][column].getPossibilities().get(0));
                        matrix[row][column].clearPossibilities();
                        answerCount++;

                        board.setHasChanged(true);
                        continue;
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
