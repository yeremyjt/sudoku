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
public class SearchValueTest
{
    private static Board board;
    private final Search search = new SearchValue();

    private final int n = 9;

    @BeforeClass
    public static void setUp()
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        final InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("inputBoard.txt");
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
        int result = search.searchInRow(board.getMatrix(), n, character, 3);
        Assert.assertEquals(3, result);

        character = "9";
        result = search.searchInRow(board.getMatrix(), n, character, 6);
        Assert.assertEquals(7, result);

        character = "2";
        result = search.searchInRow(board.getMatrix(), n, character, 2);
        Assert.assertEquals(0, result);

        character = "7";
        result = search.searchInRow(board.getMatrix(), n, character, 4);
        Assert.assertEquals(8, result);

        character = "4";
        result = search.searchInRow(board.getMatrix(), n, character, 5);
        Assert.assertEquals(-1, result);

    }

    @Test
    public void testSearchInColumn_ok()
    {
        Assert.assertNotNull(board);

        String character = "2";
        int result = search.searchInColumn(board.getMatrix(), n, character, 0);
        Assert.assertEquals(2, result);

        character = "7";
        result = search.searchInColumn(board.getMatrix(), n, character, 2);
        Assert.assertEquals(0, result);

        character = "8";
        result = search.searchInColumn(board.getMatrix(), n, character, 4);
        Assert.assertEquals(8, result);

        character = "3";
        result = search.searchInColumn(board.getMatrix(), n, character, 7);
        Assert.assertEquals(4, result);

        character = "4";
        result = search.searchInColumn(board.getMatrix(), n, character, 8);
        Assert.assertEquals(6, result);

        character = "9";
        result = search.searchInColumn(board.getMatrix(), n, character, 8);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testSearcnInBox_ok()
    {
        Assert.assertNotNull(board);

        String character = "7";
        Coordinate actual = search.searchInBox(board.getMatrix(), n, character, 0, 0);
        Coordinate expected = new Coordinate(0, 2);
        Assert.assertEquals(expected, actual);

        character = "8";
        actual = search.searchInBox(board.getMatrix(), n, character, 3, 3);
        expected = new Coordinate(5, 5);
        Assert.assertEquals(expected, actual);

        character = "8";
        actual = search.searchInBox(board.getMatrix(), n, character, 3, 0);
        expected = new Coordinate(4, 0);
        Assert.assertEquals(expected, actual);

        character = "5";
        actual = search.searchInBox(board.getMatrix(), n, character, 3, 0);
        expected = new Coordinate(5, 0);
        Assert.assertEquals(expected, actual);

        character = "2";
        actual = search.searchInBox(board.getMatrix(), n, character, 7, 2);
        expected = new Coordinate(8, 2);
        Assert.assertEquals(expected, actual);

        character = "3";
        actual = search.searchInBox(board.getMatrix(), n, character, 5, 5);
        expected = new Coordinate(5, 3);
        Assert.assertEquals(expected, actual);

        character = "3";
        actual = search.searchInBox(board.getMatrix(), n, character, 6, 6);
        expected = null;
        Assert.assertEquals(expected, actual);
    }

}
