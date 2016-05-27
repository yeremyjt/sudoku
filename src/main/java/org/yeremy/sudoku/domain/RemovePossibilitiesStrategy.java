package org.yeremy.sudoku.domain;

import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;

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
