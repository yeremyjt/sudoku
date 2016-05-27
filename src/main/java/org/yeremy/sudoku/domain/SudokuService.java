package org.yeremy.sudoku.domain;

import org.yeremy.sudoku.dto.Board;

public interface SudokuService
{
    Board solve(Board board);
}
