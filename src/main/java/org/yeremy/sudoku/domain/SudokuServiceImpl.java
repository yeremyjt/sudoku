package org.yeremy.sudoku.domain;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.dto.InputBoard;
import org.yeremy.sudoku.strategies.BoardType;
import org.yeremy.sudoku.strategies.CharactersCreator;
import org.yeremy.sudoku.strategies.Strategy;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Set;

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

    @Inject
    private Validator validator;

    @Inject
    private CharactersCreator charactersCreator;

    @Override
    public Board solveNineByNine(InputBoard inputBoard)
    {
        validator.validateNineByNineBoard(inputBoard);
        Set<String> characters = charactersCreator.createCharacters(BoardType.NINE_BY_NINE);

        Board board = convertToBoard(inputBoard);

        // First find all the possibilities
        findPossibilitiesStrategy.solve(board, characters);

        // Iterate through the strategies until a solution is found or until it's proven it's an unsolvable board.
        while (!board.isSolved())
        {
            // Since the second strategy is the most repeated strategy, we iterate through it until we cannot find more
            // solutions, or until we solve the board. Easy boards will be solved by iterating through the second
            // strategy only.BoardType.NINE_BY_NINE
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

    @Override
    public Board solveSixteenBySixteen(InputBoard inputBoard)
    {
        throw new UnsupportedOperationException("Currently, solving a sixteen by sixteen board is not supported.");
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
                if (inputBoard.getMatrix()[i][j] != null)
                {
                    cell.setValue(String.valueOf(inputBoard.getMatrix()[i][j].intValue()));
                }
                else
                {
                    cell.setValue(null);
                }
                cell.setPossibilities(new ArrayList<String>());
                matrix[i][j] = cell;
            }
        }

        board.setMatrix(matrix);
        return board;
    }
}
