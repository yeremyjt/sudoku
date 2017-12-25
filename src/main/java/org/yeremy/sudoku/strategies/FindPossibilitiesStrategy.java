package org.yeremy.sudoku.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.search.Search;

/**
 * This is the first strategy. It cycles through the sudoku board and markes all the possible solutions for each cell in
 * the board. This strategy must run before the other two. This is the first strategy.
 *
 * @author yeremy
 */
@Named("findPossibilitiesStrategy")
@Singleton
public class FindPossibilitiesStrategy implements Strategy
{
    @Inject
    @Named("searchValue")
    private Search search;

    private Cell[][] matrix;

    private int n;

    @Override
    public void solve(Board board, Set<String> characters)
    {
        matrix = board.getMatrix();
        n = matrix[0].length;
        int answerCount = 0;
        board.setHasChanged(false);

        for (int row = 0; row < n; row++)
        {
            for (int column = 0; column < n; column++)
            {

                if (row == 2 && column == 4)
                {
                    System.out.println(row);
                }

                // If solution has not been found.
                if (matrix[row][column].getValue() == null)
                {
                    final List<String> possibilities = new ArrayList<>();

                    // Loop through the list of characters. If character is not found in row, column, and box, add it to
                    // the list of possibilities
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

                        board.setHasChanged(true);
                        continue;
                    }

                    matrix[row][column].setPossibilities(possibilities);
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
