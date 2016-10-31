package org.yeremy.sudoku.domain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.dto.InputBoard;
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
    public Board solve(InputBoard inputBoard, List<String> characters)
    {
        Board board = convertToBoard(inputBoard);

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

    private Board convertToBoard(InputBoard inputBoard)
    {
        int n = inputBoard.getMatrix()[0].length;
        Board board = new Board();
        board.setHasChanged(false);
        board.setSolved(false);

        Cell[][] matrix = new Cell[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                Cell cell = new Cell();
                cell.setValue(String.valueOf(inputBoard.getMatrix()[i][j].intValue()));
                cell.setPossibilities(new ArrayList<String>());
                matrix[i][j] = cell;
            }
        }

        board.setMatrix(matrix);
        return board;
    }
}
