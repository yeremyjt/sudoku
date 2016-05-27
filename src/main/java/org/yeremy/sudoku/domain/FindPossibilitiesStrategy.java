package org.yeremy.sudoku.domain;

import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;

@Named("findPossibilitiesStrategy")
@Singleton
public class FindPossibilitiesStrategy implements Strategy
{

    @Override
    public Board solve(Board board)
    {
        return new Board();
    }

}
