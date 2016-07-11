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
    @Named("processOfEliminationByRowStrategy")
    private Strategy processOfEliminationByRowStrategy;

    @Inject
    @Named("processOfEliminationByColumnStrategy")
    private Strategy processOfEliminationByColumnStrategy;

    @Inject
    @Named("processOfEliminationByBoxStrategy")
    private Strategy processOfEliminationByBoxStrategy;

    @Override
    public Board solve(Board board, List<String> characters)
    {
        // First find all the possibilities
        findPossibilitiesStrategy.solve(board, characters);

        // Iterate through the strategies until a solution is found or until it's proven it's an unsolvable board.
        while (!board.isSolved())
        {
            // Since the second strategy is the most repeated strategy, we iterate through it until we cannot find more
            // solutions, or until we solve the board. Easy boards will be solved by iterating through the second
            // strategy only.
            while (board.hasChanged() && !board.isSolved())
            {
                removePossibilitiesStrategy.solve(board, characters);
            }

            if (board.isSolved())
            {
                return board;
            }

            processOfEliminationByRowStrategy.solve(board, characters);

            if (board.hasChanged())
            {
                continue;
            }

            processOfEliminationByColumnStrategy.solve(board, characters);

            if (board.hasChanged())
            {
                continue;
            }

            processOfEliminationByBoxStrategy.solve(board, characters);

            if (board.hasChanged())
            {
                continue;
            }
            else
            {
                return board;
            }
        }

        return board;
    }
}
