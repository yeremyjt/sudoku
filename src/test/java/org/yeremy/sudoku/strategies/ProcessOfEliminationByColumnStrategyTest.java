package org.yeremy.sudoku.strategies;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yeremy.sudoku.config.TestConfig;
import org.yeremy.sudoku.dto.Board;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ProcessOfEliminationByColumnStrategyTest
{
    @Inject
    @Named("processOfEliminationByColumnStrategy")
    private Strategy strategy;

    private static Board inputBoardThirdStrategy;
    private static Board expectedBoardFourthStrategy;

    private final Set<String> characters = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

    private final int n = 9;

    @BeforeClass
    public static void setUp() throws IOException
    {
        final ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = Thread.currentThread().getContextClassLoader()
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
                .getResourceAsStream("third-strategy-column-one-iteration.json");
        try
        {
            expectedBoardFourthStrategy = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream.close();
    }

    @Test
    public void testProcessOfEliminationByColumnStrategy_ok()
    {
        assertNotNull(inputBoardThirdStrategy);
        assertNotNull(expectedBoardFourthStrategy);

        strategy.solve(inputBoardThirdStrategy, characters);

        assertEquals(expectedBoardFourthStrategy.getMatrix()[0][0], inputBoardThirdStrategy.getMatrix()[0][0]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[0][1], inputBoardThirdStrategy.getMatrix()[0][1]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[0][2], inputBoardThirdStrategy.getMatrix()[0][2]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[0][3], inputBoardThirdStrategy.getMatrix()[0][3]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[0][4], inputBoardThirdStrategy.getMatrix()[0][4]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[0][5], inputBoardThirdStrategy.getMatrix()[0][5]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[0][6], inputBoardThirdStrategy.getMatrix()[0][6]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[0][7], inputBoardThirdStrategy.getMatrix()[0][7]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[0][8], inputBoardThirdStrategy.getMatrix()[0][8]);

        assertEquals(expectedBoardFourthStrategy.getMatrix()[1][0], inputBoardThirdStrategy.getMatrix()[1][0]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[1][1], inputBoardThirdStrategy.getMatrix()[1][1]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[1][2], inputBoardThirdStrategy.getMatrix()[1][2]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[1][3], inputBoardThirdStrategy.getMatrix()[1][3]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[1][4], inputBoardThirdStrategy.getMatrix()[1][4]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[1][5], inputBoardThirdStrategy.getMatrix()[1][5]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[1][6], inputBoardThirdStrategy.getMatrix()[1][6]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[1][7], inputBoardThirdStrategy.getMatrix()[1][7]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[1][8], inputBoardThirdStrategy.getMatrix()[1][8]);

        assertEquals(expectedBoardFourthStrategy.getMatrix()[2][0], inputBoardThirdStrategy.getMatrix()[2][0]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[2][1], inputBoardThirdStrategy.getMatrix()[2][1]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[2][2], inputBoardThirdStrategy.getMatrix()[2][2]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[2][3], inputBoardThirdStrategy.getMatrix()[2][3]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[2][4], inputBoardThirdStrategy.getMatrix()[2][4]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[2][5], inputBoardThirdStrategy.getMatrix()[2][5]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[2][6], inputBoardThirdStrategy.getMatrix()[2][6]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[2][7], inputBoardThirdStrategy.getMatrix()[2][7]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[2][8], inputBoardThirdStrategy.getMatrix()[2][8]);

        assertEquals(expectedBoardFourthStrategy.getMatrix()[3][0], inputBoardThirdStrategy.getMatrix()[3][0]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[3][1], inputBoardThirdStrategy.getMatrix()[3][1]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[3][2], inputBoardThirdStrategy.getMatrix()[3][2]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[3][3], inputBoardThirdStrategy.getMatrix()[3][3]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[3][4], inputBoardThirdStrategy.getMatrix()[3][4]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[3][5], inputBoardThirdStrategy.getMatrix()[3][5]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[3][6], inputBoardThirdStrategy.getMatrix()[3][6]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[3][7], inputBoardThirdStrategy.getMatrix()[3][7]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[3][8], inputBoardThirdStrategy.getMatrix()[3][8]);

        assertEquals(expectedBoardFourthStrategy.getMatrix()[4][0], inputBoardThirdStrategy.getMatrix()[4][0]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[4][1], inputBoardThirdStrategy.getMatrix()[4][1]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[4][2], inputBoardThirdStrategy.getMatrix()[4][2]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[4][3], inputBoardThirdStrategy.getMatrix()[4][3]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[4][4], inputBoardThirdStrategy.getMatrix()[4][4]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[4][5], inputBoardThirdStrategy.getMatrix()[4][5]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[4][6], inputBoardThirdStrategy.getMatrix()[4][6]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[4][7], inputBoardThirdStrategy.getMatrix()[4][7]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[4][8], inputBoardThirdStrategy.getMatrix()[4][8]);

        assertEquals(expectedBoardFourthStrategy.getMatrix()[5][0], inputBoardThirdStrategy.getMatrix()[5][0]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[5][1], inputBoardThirdStrategy.getMatrix()[5][1]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[5][2], inputBoardThirdStrategy.getMatrix()[5][2]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[5][3], inputBoardThirdStrategy.getMatrix()[5][3]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[5][4], inputBoardThirdStrategy.getMatrix()[5][4]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[5][5], inputBoardThirdStrategy.getMatrix()[5][5]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[5][6], inputBoardThirdStrategy.getMatrix()[5][6]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[5][7], inputBoardThirdStrategy.getMatrix()[5][7]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[5][8], inputBoardThirdStrategy.getMatrix()[5][8]);

        assertEquals(expectedBoardFourthStrategy.getMatrix()[6][0], inputBoardThirdStrategy.getMatrix()[6][0]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[6][1], inputBoardThirdStrategy.getMatrix()[6][1]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[6][2], inputBoardThirdStrategy.getMatrix()[6][2]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[6][3], inputBoardThirdStrategy.getMatrix()[6][3]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[6][4], inputBoardThirdStrategy.getMatrix()[6][4]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[6][5], inputBoardThirdStrategy.getMatrix()[6][5]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[6][6], inputBoardThirdStrategy.getMatrix()[6][6]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[6][7], inputBoardThirdStrategy.getMatrix()[6][7]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[6][8], inputBoardThirdStrategy.getMatrix()[6][8]);

        assertEquals(expectedBoardFourthStrategy.getMatrix()[7][0], inputBoardThirdStrategy.getMatrix()[7][0]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[7][1], inputBoardThirdStrategy.getMatrix()[7][1]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[7][2], inputBoardThirdStrategy.getMatrix()[7][2]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[7][3], inputBoardThirdStrategy.getMatrix()[7][3]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[7][4], inputBoardThirdStrategy.getMatrix()[7][4]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[7][5], inputBoardThirdStrategy.getMatrix()[7][5]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[7][6], inputBoardThirdStrategy.getMatrix()[7][6]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[7][7], inputBoardThirdStrategy.getMatrix()[7][7]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[7][8], inputBoardThirdStrategy.getMatrix()[7][8]);

        assertEquals(expectedBoardFourthStrategy.getMatrix()[8][0], inputBoardThirdStrategy.getMatrix()[8][0]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[8][1], inputBoardThirdStrategy.getMatrix()[8][1]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[8][2], inputBoardThirdStrategy.getMatrix()[8][2]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[8][3], inputBoardThirdStrategy.getMatrix()[8][3]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[8][4], inputBoardThirdStrategy.getMatrix()[8][4]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[8][5], inputBoardThirdStrategy.getMatrix()[8][5]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[8][6], inputBoardThirdStrategy.getMatrix()[8][6]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[8][7], inputBoardThirdStrategy.getMatrix()[8][7]);
        assertEquals(expectedBoardFourthStrategy.getMatrix()[8][8], inputBoardThirdStrategy.getMatrix()[8][8]);

        assertEquals(expectedBoardFourthStrategy, inputBoardThirdStrategy);
    }
}
