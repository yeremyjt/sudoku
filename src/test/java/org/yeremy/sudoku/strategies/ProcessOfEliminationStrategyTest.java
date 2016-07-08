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
public class ProcessOfEliminationStrategyTest
{

    @Named("removePossibilitiesStrategy")
    @Inject
    private Strategy secondStrategy;

    @Named("processOfEliminationStrategy")
    @Inject
    private Strategy thirdStrategy;

    private static Board inputBoardSecondStrategy;
    private static Board expectedBoardSecondStrategy;
    private static Board inputBoardThirdStrategy;
    private static Board expectedBoardThirdStrategy;

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
                .getResourceAsStream("input-board-third-strategy.json");
        try
        {
            inputBoardSecondStrategy = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("input-board-third-strategy.json");
        try
        {
            inputBoardThirdStrategy = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("input-board-third-strategy.json");
        try
        {
            expectedBoardSecondStrategy = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("third-strategy-one-iteration.json");
        try
        {
            expectedBoardThirdStrategy = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream.close();
    }

    @Test
    public void testRemovePossibilitiesMakesNoChange()
    {
        assertNotNull(inputBoardSecondStrategy);

        secondStrategy.solve(inputBoardSecondStrategy, characters);
        assertEquals(expectedBoardSecondStrategy, inputBoardSecondStrategy);
    }

    @Test
    public void testProcessOfEliminationStrategy_ok()
    {
        assertNotNull(inputBoardThirdStrategy);
        assertNotNull(expectedBoardThirdStrategy);

        thirdStrategy.solve(inputBoardThirdStrategy, characters);
        assertEquals(expectedBoardThirdStrategy, inputBoardThirdStrategy);
    }
}
