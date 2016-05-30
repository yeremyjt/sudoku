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

    @Inject
    @Named("processOfElimininationStrategy")
    private Strategy processOfEliminationStrategy;

    @Override
    public Board solve(Board inputBoard)
    {
        Board outputBoard = findPossibilitiesStrategy.solve(inputBoard);

        if (outputBoard.isSolved())
        {
            return outputBoard;
        }

        outputBoard = removePossibilitiesStrategy.solve(outputBoard);

        if (outputBoard.isSolved())
        {
            return outputBoard;
        }

        outputBoard = processOfEliminationStrategy.solve(outputBoard);

        if (outputBoard.isSolved())
        {
            return outputBoard;
        }

        while (!outputBoard.isSolved())
        {
            outputBoard = removePossibilitiesStrategy.solve(outputBoard);

            if (outputBoard.isSolved())
            {
                return outputBoard;
            }

            outputBoard = processOfEliminationStrategy.solve(outputBoard);
        }

        return outputBoard;
    }
}
