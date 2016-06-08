package org.yeremy.sudoku.domain;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.strategies.Strategy;

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

    @Inject
    @Named("processOfElimininationStrategy")
    private Strategy processOfEliminationStrategy;

    @Override
    public Board solve(Board board, List<String> characters)
    {
        findPossibilitiesStrategy.solve(board, characters);

        if (board.isSolved())
        {
            return board;
        }

        removePossibilitiesStrategy.solve(board, characters);

        if (board.isSolved())
        {
            return board;
        }

        processOfEliminationStrategy.solve(board, characters);

        if (board.isSolved())
        {
            return board;
        }

        while (!board.isSolved() && board.isHasChanged())
        {
            removePossibilitiesStrategy.solve(board, characters);

            if (board.isSolved())
            {
                return board;
            }

            processOfEliminationStrategy.solve(board, characters);
        }

        return board;
    }
}
