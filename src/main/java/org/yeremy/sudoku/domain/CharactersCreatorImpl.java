package org.yeremy.sudoku.domain;

import org.yeremy.sudoku.domain.CharactersCreator;
import org.yeremy.sudoku.strategies.BoardType;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.*;

@Named
@Singleton
public class CharactersCreatorImpl implements CharactersCreator
{
    @Override
    public Set<String> createCharacters(BoardType boardType)
    {
        if (boardType == BoardType.NINE_BY_NINE)
        {
            return new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        }
        else
        {
            return new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                    "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                    "1", "2", "3", "4", "5", "6", "7", "8", "9"
            ));
        }
    }
}
