package org.yeremy.sudoku.strategies;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yeremy.sudoku.config.TestConfig;
import org.yeremy.sudoku.dto.Board;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class RemovePossibilitiesStrategyOneIterationTest
{
    @Named("removePossibilitiesStrategy")
    @Inject
    private Strategy strategy;

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
    public static void setUp() throws IOException
    {
        final ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("first-strategy-one-iteration.json");
        try
        {
            inputBoard = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("second-strategy-one-iteration.json");
        try
        {
            expectedBoard = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream.close();
    }

    @Test

    public void testRemovePossibilitiesStrategy_oneIteration()
    {
        assertNotNull(expectedBoard);

        strategy.solve(inputBoard, characters);

        assertEquals(expectedBoard.getMatrix()[0][0], inputBoard.getMatrix()[0][0]);
        assertEquals(expectedBoard.getMatrix()[0][1], inputBoard.getMatrix()[0][1]);
        assertEquals(expectedBoard.getMatrix()[0][2], inputBoard.getMatrix()[0][2]);
        assertEquals(expectedBoard.getMatrix()[0][3], inputBoard.getMatrix()[0][3]);
        assertEquals(expectedBoard.getMatrix()[0][4], inputBoard.getMatrix()[0][4]);
        assertEquals(expectedBoard.getMatrix()[0][5], inputBoard.getMatrix()[0][5]);
        assertEquals(expectedBoard.getMatrix()[0][6], inputBoard.getMatrix()[0][6]);
        assertEquals(expectedBoard.getMatrix()[0][7], inputBoard.getMatrix()[0][7]);
        assertEquals(expectedBoard.getMatrix()[0][8], inputBoard.getMatrix()[0][8]);

        assertEquals(expectedBoard.getMatrix()[1][0], inputBoard.getMatrix()[1][0]);
        assertEquals(expectedBoard.getMatrix()[1][1], inputBoard.getMatrix()[1][1]);
        assertEquals(expectedBoard.getMatrix()[1][2], inputBoard.getMatrix()[1][2]);
        assertEquals(expectedBoard.getMatrix()[1][3], inputBoard.getMatrix()[1][3]);
        assertEquals(expectedBoard.getMatrix()[1][4], inputBoard.getMatrix()[1][4]);
        assertEquals(expectedBoard.getMatrix()[1][5], inputBoard.getMatrix()[1][5]);
        assertEquals(expectedBoard.getMatrix()[1][6], inputBoard.getMatrix()[1][6]);
        assertEquals(expectedBoard.getMatrix()[1][7], inputBoard.getMatrix()[1][7]);
        assertEquals(expectedBoard.getMatrix()[1][8], inputBoard.getMatrix()[1][8]);

        assertEquals(expectedBoard.getMatrix()[2][0], inputBoard.getMatrix()[2][0]);
        assertEquals(expectedBoard.getMatrix()[2][1], inputBoard.getMatrix()[2][1]);
        assertEquals(expectedBoard.getMatrix()[2][2], inputBoard.getMatrix()[2][2]);
        assertEquals(expectedBoard.getMatrix()[2][3], inputBoard.getMatrix()[2][3]);
        assertEquals(expectedBoard.getMatrix()[2][4], inputBoard.getMatrix()[2][4]);
        assertEquals(expectedBoard.getMatrix()[2][5], inputBoard.getMatrix()[2][5]);
        assertEquals(expectedBoard.getMatrix()[2][6], inputBoard.getMatrix()[2][6]);
        assertEquals(expectedBoard.getMatrix()[2][7], inputBoard.getMatrix()[2][7]);
        assertEquals(expectedBoard.getMatrix()[2][8], inputBoard.getMatrix()[2][8]);

        assertEquals(expectedBoard.getMatrix()[3][0], inputBoard.getMatrix()[3][0]);
        assertEquals(expectedBoard.getMatrix()[3][1], inputBoard.getMatrix()[3][1]);
        assertEquals(expectedBoard.getMatrix()[3][2], inputBoard.getMatrix()[3][2]);
        assertEquals(expectedBoard.getMatrix()[3][3], inputBoard.getMatrix()[3][3]);
        assertEquals(expectedBoard.getMatrix()[3][4], inputBoard.getMatrix()[3][4]);
        assertEquals(expectedBoard.getMatrix()[3][5], inputBoard.getMatrix()[3][5]);
        assertEquals(expectedBoard.getMatrix()[3][6], inputBoard.getMatrix()[3][6]);
        assertEquals(expectedBoard.getMatrix()[3][7], inputBoard.getMatrix()[3][7]);
        assertEquals(expectedBoard.getMatrix()[3][8], inputBoard.getMatrix()[3][8]);

        assertEquals(expectedBoard.getMatrix()[4][0], inputBoard.getMatrix()[4][0]);
        assertEquals(expectedBoard.getMatrix()[4][1], inputBoard.getMatrix()[4][1]);
        assertEquals(expectedBoard.getMatrix()[4][2], inputBoard.getMatrix()[4][2]);
        assertEquals(expectedBoard.getMatrix()[4][3], inputBoard.getMatrix()[4][3]);
        assertEquals(expectedBoard.getMatrix()[4][4], inputBoard.getMatrix()[4][4]);
        assertEquals(expectedBoard.getMatrix()[4][5], inputBoard.getMatrix()[4][5]);
        assertEquals(expectedBoard.getMatrix()[4][6], inputBoard.getMatrix()[4][6]);
        assertEquals(expectedBoard.getMatrix()[4][7], inputBoard.getMatrix()[4][7]);
        assertEquals(expectedBoard.getMatrix()[4][8], inputBoard.getMatrix()[4][8]);

        assertEquals(expectedBoard.getMatrix()[5][0], inputBoard.getMatrix()[5][0]);
        assertEquals(expectedBoard.getMatrix()[5][1], inputBoard.getMatrix()[5][1]);
        assertEquals(expectedBoard.getMatrix()[5][2], inputBoard.getMatrix()[5][2]);
        assertEquals(expectedBoard.getMatrix()[5][3], inputBoard.getMatrix()[5][3]);
        assertEquals(expectedBoard.getMatrix()[5][4], inputBoard.getMatrix()[5][4]);
        assertEquals(expectedBoard.getMatrix()[5][5], inputBoard.getMatrix()[5][5]);
        assertEquals(expectedBoard.getMatrix()[5][6], inputBoard.getMatrix()[5][6]);
        assertEquals(expectedBoard.getMatrix()[5][7], inputBoard.getMatrix()[5][7]);
        assertEquals(expectedBoard.getMatrix()[5][8], inputBoard.getMatrix()[5][8]);

        assertEquals(expectedBoard.getMatrix()[6][0], inputBoard.getMatrix()[6][0]);
        assertEquals(expectedBoard.getMatrix()[6][1], inputBoard.getMatrix()[6][1]);
        assertEquals(expectedBoard.getMatrix()[6][2], inputBoard.getMatrix()[6][2]);
        assertEquals(expectedBoard.getMatrix()[6][3], inputBoard.getMatrix()[6][3]);
        assertEquals(expectedBoard.getMatrix()[6][4], inputBoard.getMatrix()[6][4]);
        assertEquals(expectedBoard.getMatrix()[6][5], inputBoard.getMatrix()[6][5]);
        assertEquals(expectedBoard.getMatrix()[6][6], inputBoard.getMatrix()[6][6]);
        assertEquals(expectedBoard.getMatrix()[6][7], inputBoard.getMatrix()[6][7]);
        assertEquals(expectedBoard.getMatrix()[6][8], inputBoard.getMatrix()[6][8]);

        assertEquals(expectedBoard.getMatrix()[7][0], inputBoard.getMatrix()[7][0]);
        assertEquals(expectedBoard.getMatrix()[7][1], inputBoard.getMatrix()[7][1]);
        assertEquals(expectedBoard.getMatrix()[7][2], inputBoard.getMatrix()[7][2]);
        assertEquals(expectedBoard.getMatrix()[7][3], inputBoard.getMatrix()[7][3]);
        assertEquals(expectedBoard.getMatrix()[7][4], inputBoard.getMatrix()[7][4]);
        assertEquals(expectedBoard.getMatrix()[7][5], inputBoard.getMatrix()[7][5]);
        assertEquals(expectedBoard.getMatrix()[7][6], inputBoard.getMatrix()[7][6]);
        assertEquals(expectedBoard.getMatrix()[7][7], inputBoard.getMatrix()[7][7]);
        assertEquals(expectedBoard.getMatrix()[7][8], inputBoard.getMatrix()[7][8]);

        assertEquals(expectedBoard.getMatrix()[8][0], inputBoard.getMatrix()[8][0]);
        assertEquals(expectedBoard.getMatrix()[8][1], inputBoard.getMatrix()[8][1]);
        assertEquals(expectedBoard.getMatrix()[8][2], inputBoard.getMatrix()[8][2]);
        assertEquals(expectedBoard.getMatrix()[8][3], inputBoard.getMatrix()[8][3]);
        assertEquals(expectedBoard.getMatrix()[8][4], inputBoard.getMatrix()[8][4]);
        assertEquals(expectedBoard.getMatrix()[8][5], inputBoard.getMatrix()[8][5]);
        assertEquals(expectedBoard.getMatrix()[8][6], inputBoard.getMatrix()[8][6]);
        assertEquals(expectedBoard.getMatrix()[8][7], inputBoard.getMatrix()[8][7]);
        assertEquals(expectedBoard.getMatrix()[8][8], inputBoard.getMatrix()[8][8]);

        assertEquals(expectedBoard, inputBoard);
    }
}
