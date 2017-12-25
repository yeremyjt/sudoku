package org.yeremy.sudoku.strategies;

import java.util.Set;

public interface CharactersCreator
{
    Set<String> createCharacters(BoardType boardType);
}
