package org.yeremy.sudoku.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;

@Named
@Singleton
public class SudokuServiceImpl implements SudokuService
{
    @Inject
    @Named("findPossibilitiesStrategy")
    private Strategy findPossibilitiesStrategy;

    @Inject
    @Named("removePossibilitiesStrategy")
    private Strategy removePossibilitiesStrategy;

    @Override
    public Board solve(Board board)
    {
        final Board boardAfterFindingPossibilities = findPossibilitiesStrategy.solve(board);
        return removePossibilitiesStrategy.solve(boardAfterFindingPossibilities);
    }
}
