package org.yeremy.sudoku.domain;

import org.yeremy.sudoku.strategies.BoardType;

import java.util.Set;

public interface CharactersCreator
{
    Set<String> createCharacters(BoardType boardType);
}
