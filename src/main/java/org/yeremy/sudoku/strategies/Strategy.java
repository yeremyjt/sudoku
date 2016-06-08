package org.yeremy.sudoku.strategies;

import java.util.List;

import org.yeremy.sudoku.dto.Board;

public interface Strategy
{
    void solve(Board board, List<String> characters);
}
