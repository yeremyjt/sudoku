package org.yeremy.sudoku.domain;

import java.util.List;

import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.InputBoard;

public interface SudokuService
{
    Board solveNineByNine(InputBoard inputBoard);

    Board solveSixteenBySixteen(InputBoard inputBoard);
}
