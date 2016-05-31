package org.yeremy.sudoku.domain;

import java.util.List;

import org.yeremy.sudoku.dto.Board;

public interface SudokuService
{
    Board solve(Board inputBoard, List<String> characters);
}
