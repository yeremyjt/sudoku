package org.yeremy.sudoku.domain;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.dto.Coordinate;

/**
 * This is the third strategy. It uses process of elimination to find solutions to cells. For example, if a row only has
 * one cell with a possibility of 5, that is the solution for that cell. The same applies for a column and a box.
 *
 * @author yeremy
 *
 */
@Named("processOfElimininationStrategy")
@Singleton
public class ProcessOfEliminationStrategy implements Strategy
{

    @Named("searchPossibility")
    Search search;

    private Cell[][] matrix;

    private int n;

    @Override
    public void solve(Board board, List<String> characters)
    {
        matrix = board.getMatrix();

        n = matrix[0].length;

        // Search all rows
        for (int row = 0; row < n; row++)
        {
            for (final String character: characters)
            {
                final int column = search.searchInRow(matrix, n, character, row);

                if (column != -1)
                {
                    matrix[row][column].setValue(character);
                    matrix[row][column].clearPossibilities();
                }
            }
        }

        // Search all columns
        for (int column = 0; column < n; column++)
        {
            for (final String character: characters)
            {
                final int row = search.searchInColumn(matrix, n, character, column);

                if (row != -1)
                {
                    matrix[row][column].setValue(character);
                    matrix[row][column].clearPossibilities();
                }
            }
        }

        // Search all boxes
        final int squareRoot =(int)  Math.sqrt(n);
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

        if (answerCount == n * n)
        {
            board.setSolved(true);
        }
    }

}