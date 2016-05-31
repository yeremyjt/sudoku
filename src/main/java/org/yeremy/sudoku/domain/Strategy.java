package org.yeremy.sudoku.domain;

import java.util.List;

import org.yeremy.sudoku.dto.Board;

public interface Strategy
{
    Board solve(Board board, List<String> characters);
}
