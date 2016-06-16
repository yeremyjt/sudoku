package org.yeremy.sudoku.search;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Coordinate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
public class SearchPossibilityTest
{
    private static Board board;
    private final Search search = new SearchPossibility();

    private final int n = 9;

    @BeforeClass
    public static void setUp()
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        final InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("boardWithPossibilities.txt");
        try
        {
            board = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchInRow_ok()
    {
        Assert.assertNotNull(board);

        String character = "1";
        int actual = search.searchInRow(board.getMatrix(), n, character, 0);
        Assert.assertEquals(-1, actual);

        character = "2";
        actual = search.searchInRow(board.getMatrix(), n, character, 0);
        Assert.assertEquals(7, actual);

        character = "5";
        actual = search.searchInRow(board.getMatrix(), n, character, 2);
        Assert.assertEquals(2, actual);

        character = "7";
        actual = search.searchInRow(board.getMatrix(), n, character, 3);
        Assert.assertEquals(4, actual);

        character = "2";
        actual = search.searchInRow(board.getMatrix(), n, character, 5);
        Assert.assertEquals(4, actual);

        character = "5";
        actual = search.searchInRow(board.getMatrix(), n, character, 2);
        Assert.assertEquals(2, actual);

        character = "7";
        actual = search.searchInRow(board.getMatrix(), n, character, 7);
        Assert.assertEquals(5, actual);

        character = "4";
        actual = search.searchInRow(board.getMatrix(), n, character, 8);
        Assert.assertEquals(0, actual);

        character = "4";
        actual = search.searchInRow(board.getMatrix(), n, character, 4);
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testSearchInColumn_ok()
    {
        Assert.assertNotNull(board);

        String character = "7";
        int actual = search.searchInColumn(board.getMatrix(), n, character, 1);
        Assert.assertEquals(5, actual);

        character = "8";
        actual = search.searchInColumn(board.getMatrix(), n, character, 2);
        Assert.assertEquals(6, actual);

        character = "2";
        actual = search.searchInColumn(board.getMatrix(), n, character, 3);
        Assert.assertEquals(6, actual);

        character = "3";
        actual = search.searchInColumn(board.getMatrix(), n, character, 5);
        Assert.assertEquals(2, actual);

        character = "3";
        actual = search.searchInColumn(board.getMatrix(), n, character, 8);
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testSearchInBox_ok()
    {
        Assert.assertNotNull(board);

        String character = "3";
        Coordinate actual = search.searchInBox(board.getMatrix(), n, character, 0, 3);
        Coordinate expected = new Coordinate(2, 5);
        Assert.assertEquals(expected, actual);

        character = "2";
        actual = search.searchInBox(board.getMatrix(), n, character, 0, 7);
        expected = new Coordinate(0, 7);
        Assert.assertEquals(expected, actual);

        character = "2";
        actual = search.searchInBox(board.getMatrix(), n, character, 2, 8);
        expected = new Coordinate(0, 7);
        Assert.assertEquals(expected, actual);

        character = "6";
        actual = search.searchInBox(board.getMatrix(), n, character, 5, 1);
        expected = new Coordinate(4, 2);
        Assert.assertEquals(expected, actual);

        character = "2";
        actual = search.searchInBox(board.getMatrix(), n, character, 4, 5);
        expected = new Coordinate(5, 4);
        Assert.assertEquals(expected, actual);

        character = "5";
        actual = search.searchInBox(board.getMatrix(), n, character, 5, 8);
        expected = new Coordinate(3, 7);
        Assert.assertEquals(expected, actual);

        character = "4";
        actual = search.searchInBox(board.getMatrix(), n, character, 6, 0);
        expected = new Coordinate(8, 0);
        Assert.assertEquals(expected, actual);

        character = "7";
        actual = search.searchInBox(board.getMatrix(), n, character, 8, 4);
        expected = new Coordinate(7, 5);
        Assert.assertEquals(expected, actual);

        character = "3";
        actual = search.searchInBox(board.getMatrix(), n, character, 8, 6);
        expected = new Coordinate(8, 8);
        Assert.assertEquals(expected, actual);

        character = "5";
        actual = search.searchInBox(board.getMatrix(), n, character, 8, 6);
        expected = null;
        Assert.assertEquals(expected, actual);
    }

}
