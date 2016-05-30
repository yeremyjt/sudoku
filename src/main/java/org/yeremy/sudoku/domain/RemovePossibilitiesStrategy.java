package org.yeremy.sudoku.domain;

import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;

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

    @Override
    public Board solve(Board board)
    {
        return new Board();
    }

}
