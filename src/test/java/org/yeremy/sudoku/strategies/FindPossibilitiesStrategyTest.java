package org.yeremy.sudoku.strategies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yeremy.sudoku.config.TestConfig;
import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.Cell;
import org.yeremy.sudoku.dto.InputBoard;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class FindPossibilitiesStrategyTest
{
    @Inject
    @Named("findPossibilitiesStrategy")
    private Strategy strategy;

    private static InputBoard inputBoard;
    private static Board board;
    private static Board expectedBoard;

    private final Set<String> characters = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

    private final int n = 9;

    @BeforeClass
    public static void setUp()
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("input-board.json");
        try
        {
            inputBoard = objectMapper.readValue(inputStream, InputBoard.class);

            int n = inputBoard.getMatrix()[0].length;
            board = new Board();
            board.setHasChanged(false);
            board.setSolved(false);

            Cell[][] matrix = new Cell[n][n];

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    Cell cell = new Cell();
                    if (inputBoard.getMatrix()[i][j] != null) {
                        cell.setValue(String.valueOf(inputBoard.getMatrix()[i][j].intValue()));
                    }
                    else {
                        cell.setValue(null);
                    }
                    cell.setPossibilities(new ArrayList<String>());
                    matrix[i][j] = cell;
                }
            }

            board.setMatrix(matrix);

        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("first-strategy-one-iteration.json");
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
        assertNotNull(board);
        assertNotNull(expectedBoard);

        strategy.solve(board, characters);

        assertEquals(expectedBoard.getMatrix()[0][0], board.getMatrix()[0][0]);
        assertEquals(expectedBoard.getMatrix()[0][1], board.getMatrix()[0][1]);
        assertEquals(expectedBoard.getMatrix()[0][2], board.getMatrix()[0][2]);
        assertEquals(expectedBoard.getMatrix()[0][3], board.getMatrix()[0][3]);
        assertEquals(expectedBoard.getMatrix()[0][4], board.getMatrix()[0][4]);
        assertEquals(expectedBoard.getMatrix()[0][5], board.getMatrix()[0][5]);
        assertEquals(expectedBoard.getMatrix()[0][6], board.getMatrix()[0][6]);
        assertEquals(expectedBoard.getMatrix()[0][7], board.getMatrix()[0][7]);
        assertEquals(expectedBoard.getMatrix()[0][8], board.getMatrix()[0][8]);

        assertEquals(expectedBoard.getMatrix()[1][0], board.getMatrix()[1][0]);
        assertEquals(expectedBoard.getMatrix()[1][1], board.getMatrix()[1][1]);
        assertEquals(expectedBoard.getMatrix()[1][2], board.getMatrix()[1][2]);
        assertEquals(expectedBoard.getMatrix()[1][3], board.getMatrix()[1][3]);
        assertEquals(expectedBoard.getMatrix()[1][4], board.getMatrix()[1][4]);
        assertEquals(expectedBoard.getMatrix()[1][5], board.getMatrix()[1][5]);
        assertEquals(expectedBoard.getMatrix()[1][6], board.getMatrix()[1][6]);
        assertEquals(expectedBoard.getMatrix()[1][7], board.getMatrix()[1][7]);
        assertEquals(expectedBoard.getMatrix()[1][8], board.getMatrix()[1][8]);

        assertEquals(expectedBoard.getMatrix()[2][0], board.getMatrix()[2][0]);
        assertEquals(expectedBoard.getMatrix()[2][1], board.getMatrix()[2][1]);
        assertEquals(expectedBoard.getMatrix()[2][2], board.getMatrix()[2][2]);
        assertEquals(expectedBoard.getMatrix()[2][3], board.getMatrix()[2][3]);
        assertEquals(expectedBoard.getMatrix()[2][4], board.getMatrix()[2][4]);
        assertEquals(expectedBoard.getMatrix()[2][5], board.getMatrix()[2][5]);
        assertEquals(expectedBoard.getMatrix()[2][6], board.getMatrix()[2][6]);
        assertEquals(expectedBoard.getMatrix()[2][7], board.getMatrix()[2][7]);
        assertEquals(expectedBoard.getMatrix()[2][8], board.getMatrix()[2][8]);

        assertEquals(expectedBoard.getMatrix()[3][0], board.getMatrix()[3][0]);
        assertEquals(expectedBoard.getMatrix()[3][1], board.getMatrix()[3][1]);
        assertEquals(expectedBoard.getMatrix()[3][2], board.getMatrix()[3][2]);
        assertEquals(expectedBoard.getMatrix()[3][3], board.getMatrix()[3][3]);
        assertEquals(expectedBoard.getMatrix()[3][4], board.getMatrix()[3][4]);
        assertEquals(expectedBoard.getMatrix()[3][5], board.getMatrix()[3][5]);
        assertEquals(expectedBoard.getMatrix()[3][6], board.getMatrix()[3][6]);
        assertEquals(expectedBoard.getMatrix()[3][7], board.getMatrix()[3][7]);
        assertEquals(expectedBoard.getMatrix()[3][8], board.getMatrix()[3][8]);

        assertEquals(expectedBoard.getMatrix()[4][0], board.getMatrix()[4][0]);
        assertEquals(expectedBoard.getMatrix()[4][1], board.getMatrix()[4][1]);
        assertEquals(expectedBoard.getMatrix()[4][2], board.getMatrix()[4][2]);
        assertEquals(expectedBoard.getMatrix()[4][3], board.getMatrix()[4][3]);
        assertEquals(expectedBoard.getMatrix()[4][4], board.getMatrix()[4][4]);
        assertEquals(expectedBoard.getMatrix()[4][5], board.getMatrix()[4][5]);
        assertEquals(expectedBoard.getMatrix()[4][6], board.getMatrix()[4][6]);
        assertEquals(expectedBoard.getMatrix()[4][7], board.getMatrix()[4][7]);
        assertEquals(expectedBoard.getMatrix()[4][8], board.getMatrix()[4][8]);

        assertEquals(expectedBoard.getMatrix()[5][0], board.getMatrix()[5][0]);
        assertEquals(expectedBoard.getMatrix()[5][1], board.getMatrix()[5][1]);
        assertEquals(expectedBoard.getMatrix()[5][2], board.getMatrix()[5][2]);
        assertEquals(expectedBoard.getMatrix()[5][3], board.getMatrix()[5][3]);
        assertEquals(expectedBoard.getMatrix()[5][4], board.getMatrix()[5][4]);
        assertEquals(expectedBoard.getMatrix()[5][5], board.getMatrix()[5][5]);
        assertEquals(expectedBoard.getMatrix()[5][6], board.getMatrix()[5][6]);
        assertEquals(expectedBoard.getMatrix()[5][7], board.getMatrix()[5][7]);
        assertEquals(expectedBoard.getMatrix()[5][8], board.getMatrix()[5][8]);

        assertEquals(expectedBoard.getMatrix()[6][0], board.getMatrix()[6][0]);
        assertEquals(expectedBoard.getMatrix()[6][1], board.getMatrix()[6][1]);
        assertEquals(expectedBoard.getMatrix()[6][2], board.getMatrix()[6][2]);
        assertEquals(expectedBoard.getMatrix()[6][3], board.getMatrix()[6][3]);
        assertEquals(expectedBoard.getMatrix()[6][4], board.getMatrix()[6][4]);
        assertEquals(expectedBoard.getMatrix()[6][5], board.getMatrix()[6][5]);
        assertEquals(expectedBoard.getMatrix()[6][6], board.getMatrix()[6][6]);
        assertEquals(expectedBoard.getMatrix()[6][7], board.getMatrix()[6][7]);
        assertEquals(expectedBoard.getMatrix()[6][8], board.getMatrix()[6][8]);

        assertEquals(expectedBoard.getMatrix()[7][0], board.getMatrix()[7][0]);
        assertEquals(expectedBoard.getMatrix()[7][1], board.getMatrix()[7][1]);
        assertEquals(expectedBoard.getMatrix()[7][2], board.getMatrix()[7][2]);
        assertEquals(expectedBoard.getMatrix()[7][3], board.getMatrix()[7][3]);
        assertEquals(expectedBoard.getMatrix()[7][4], board.getMatrix()[7][4]);
        assertEquals(expectedBoard.getMatrix()[7][5], board.getMatrix()[7][5]);
        assertEquals(expectedBoard.getMatrix()[7][6], board.getMatrix()[7][6]);
        assertEquals(expectedBoard.getMatrix()[7][7], board.getMatrix()[7][7]);
        assertEquals(expectedBoard.getMatrix()[7][8], board.getMatrix()[7][8]);

        assertEquals(expectedBoard.getMatrix()[8][0], board.getMatrix()[8][0]);
        assertEquals(expectedBoard.getMatrix()[8][1], board.getMatrix()[8][1]);
        assertEquals(expectedBoard.getMatrix()[8][2], board.getMatrix()[8][2]);
        assertEquals(expectedBoard.getMatrix()[8][3], board.getMatrix()[8][3]);
        assertEquals(expectedBoard.getMatrix()[8][4], board.getMatrix()[8][4]);
        assertEquals(expectedBoard.getMatrix()[8][5], board.getMatrix()[8][5]);
        assertEquals(expectedBoard.getMatrix()[8][6], board.getMatrix()[8][6]);
        assertEquals(expectedBoard.getMatrix()[8][7], board.getMatrix()[8][7]);
        assertEquals(expectedBoard.getMatrix()[8][8], board.getMatrix()[8][8]);

        assertEquals(expectedBoard, board);
    }

}
