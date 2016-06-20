package org.yeremy.sudoku.strategies;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yeremy.sudoku.dto.Board;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
public class FindPossibilitiesStrategyTest
{
    private final Strategy strategy = new FindPossibilitiesStrategy();

    private static Board inputBoard;
    private static Board expectedBoard;

    private final List<String> characters = new ArrayList<String>()
    {
        {
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
            add("7");
            add("8");
            add("9");
        }
    };

    private final int n = 9;

    @BeforeClass
    public static void setUp()
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("boardWithValues.txt");
        try
        {
            inputBoard = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("boardWithPossibilities.txt");
        try
        {
            expectedBoard = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindPossibilitiesStrategy_ok()
    {
        Assert.assertNotNull(inputBoard);
        Assert.assertNotNull(expectedBoard);

        strategy.solve(inputBoard, characters);
        Assert.assertEquals(expectedBoard, inputBoard);
    }

}
