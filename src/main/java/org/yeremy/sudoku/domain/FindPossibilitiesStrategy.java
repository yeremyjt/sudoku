package org.yeremy.sudoku.domain;

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
    public Board solve(Board board)
    {
        n = board.getCells().get(0).size();

        matrix = board.toCellMatrix();

        return new Board();
    }



}
