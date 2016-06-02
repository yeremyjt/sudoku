package org.yeremy.sudoku.domain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
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
                    final List<String> possibilities = new ArrayList<>();
                    // Loop through the list of characters
                    for (final String character : characters)
                    {
                        if (search.searchInRow(matrix, n, character, row) == -1
                                && search.searchInColumn(matrix, n, character, column) == -1
                                && search.searchInBox(matrix, n, character, row, column) == null)
                        {
                            possibilities.add(character);
                        }
                    }

                    // If there is only one possibility, that's the answer for that cell.
                    if (possibilities.size() == 1)
                    {
                        matrix[row][column].setValue(possibilities.get(0));
                        matrix[row][column].clearPossibilities();
                        answerCount++;
                    }

                    matrix[row][column].setPosibilities(possibilities);
                }
                // Solution has been found for this cell
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
