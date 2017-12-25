package org.yeremy.sudoku.strategies;

import java.util.Set;

import org.yeremy.sudoku.dto.Board;

public interface Strategy
{
    void solve(Board board, Set<String> characters);
}
