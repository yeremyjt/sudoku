package org.yeremy.sudoku.domain;

import org.yeremy.sudoku.dto.Board;

public interface Strategy
{
    Board solve(Board board);
}
