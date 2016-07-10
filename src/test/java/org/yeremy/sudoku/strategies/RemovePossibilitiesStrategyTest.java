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
public class RemovePossibilitiesStrategyTest
{
    @Named("removePossibilitiesStrategy")
    @Inject
    private Strategy strategy;

    private static Board inputBoard;
    private static Board inputBoardOneIteration;
    private static Board inputBoardTwoIterations;
    private static Board inputBoardThreeIterations;
    private static Board expectedBoard;
    private static Board expectedBoardTwoIterations;
    private static Board expectedBoardThreeIterations;
    private static Board expectedBoardFourIterations;


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

        // Objects first iteration

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

        // Objects second iteration

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("second-strategy-one-iteration.json");
        try
        {
            inputBoardOneIteration = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream.close();

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("second-strategy-two-iterations.json");
        try
        {
            expectedBoardTwoIterations = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        // Objects third iteration

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("second-strategy-two-iterations.json");
        try
        {
            inputBoardTwoIterations = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("second-strategy-three-iterations.json");
        try
        {
            expectedBoardThreeIterations = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        // Objects fourth iteration

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("second-strategy-three-iterations.json");
        try
        {
            inputBoardThreeIterations = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("second-strategy-four-iterations.json");
        try
        {
            expectedBoardFourIterations = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemovePossibilitiesStrategy_oneIteration()
    {
        assertNotNull(inputBoard);
        assertNotNull(expectedBoard);

        strategy.solve(inputBoard, characters);
        assertEquals(expectedBoard, inputBoard);
    }

    @Test
    public void testRemovePossibilitiesStrategy_twoIterations()
    {
        assertNotNull(inputBoardOneIteration);
        assertNotNull(expectedBoardTwoIterations);

        strategy.solve(inputBoardOneIteration, characters);
        assertEquals(expectedBoardTwoIterations, inputBoardOneIteration);
    }

    @Test
    public void testRemovePossibilitiesStrategy_threeIterations()
    {
        assertNotNull(inputBoardTwoIterations);
        assertNotNull(expectedBoardThreeIterations);

        strategy.solve(inputBoardTwoIterations, characters);
        assertEquals(expectedBoardThreeIterations, inputBoardTwoIterations);
    }

    @Test
    public void testRemovePossibilitiesStrategy_fourIterations()
    {
        assertNotNull(inputBoardThreeIterations);
        assertNotNull(expectedBoardFourIterations);

        strategy.solve(inputBoardThreeIterations, characters);
        assertEquals(expectedBoardFourIterations, inputBoardThreeIterations);
    }
}
