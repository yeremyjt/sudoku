package org.yeremy.sudoku.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yeremy.sudoku.strategies.BoardType;

import java.util.Set;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class CharacterCreatorTest
{
    private CharactersCreator charactersCreator = new CharactersCreatorImpl();

    @Test
    public void testCreateCharacters_NineByNine()
    {
        Set<String> characters = charactersCreator.createCharacters(BoardType.NINE_BY_NINE);
        assertTrue(characters.contains("1"));
        assertTrue(characters.contains("2"));
        assertTrue(characters.contains("3"));
        assertTrue(characters.contains("4"));
        assertTrue(characters.contains("5"));
        assertTrue(characters.contains("6"));
        assertTrue(characters.contains("7"));
        assertTrue(characters.contains("8"));
        assertTrue(characters.contains("9"));
        assertTrue(!characters.contains("10"));
    }

    @Test
    public void testCreateCharacters_SixteenBySixteen()
    {
        Set<String> characters = charactersCreator.createCharacters(BoardType.SIXTEEN_BY_SIXTEEN);
        assertTrue(characters.contains("1"));
        assertTrue(characters.contains("2"));
        assertTrue(characters.contains("3"));
        assertTrue(characters.contains("4"));
        assertTrue(characters.contains("5"));
        assertTrue(characters.contains("6"));
        assertTrue(characters.contains("7"));
        assertTrue(characters.contains("8"));
        assertTrue(characters.contains("9"));
        assertTrue(!characters.contains("10"));
        assertTrue(characters.contains("A"));
        assertTrue(characters.contains("B"));
        assertTrue(characters.contains("C"));
        assertTrue(characters.contains("D"));
        assertTrue(characters.contains("E"));
        assertTrue(characters.contains("F"));
        assertTrue(characters.contains("G"));
        assertTrue(characters.contains("H"));
        assertTrue(characters.contains("I"));
        assertTrue(characters.contains("J"));
        assertTrue(characters.contains("K"));
        assertTrue(characters.contains("L"));
        assertTrue(characters.contains("M"));
        assertTrue(characters.contains("N"));
        assertTrue(characters.contains("O"));
        assertTrue(characters.contains("P"));
        assertTrue(characters.contains("Q"));
        assertTrue(characters.contains("R"));
        assertTrue(characters.contains("S"));
        assertTrue(characters.contains("T"));
        assertTrue(characters.contains("U"));
        assertTrue(characters.contains("V"));
        assertTrue(characters.contains("W"));
        assertTrue(characters.contains("X"));
        assertTrue(characters.contains("Y"));
        assertTrue(characters.contains("Z"));
        assertTrue(!characters.contains("-"));
    }
}
