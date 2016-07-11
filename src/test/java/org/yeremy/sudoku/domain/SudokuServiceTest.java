package org.yeremy.sudoku.domain;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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
public class SudokuServiceTest
{
    @Inject
    SudokuService service;

    private static Board inputEasyBoard;
    private static Board inputHardBoard;
    private static Board expectedEasyBoard;
    private static Board expectedHardBoard;

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
                .getResourceAsStream("input-board.json");
        try
        {
            inputEasyBoard = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("input-board-hard.json");
        try
        {
            inputHardBoard = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("second-strategy-four-iterations.json");
        try
        {
            expectedEasyBoard = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("expected-board-third-strategy.json");
        try
        {
            expectedHardBoard = objectMapper.readValue(inputStream, Board.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void testSudokuServiceEasyBoard_ok()
    {
        assertNotNull(inputEasyBoard);
        assertNotNull(expectedEasyBoard);

        service.solve(inputEasyBoard, characters);

        assertEquals(expectedEasyBoard.getMatrix()[0][0], inputEasyBoard.getMatrix()[0][0]);
        assertEquals(expectedEasyBoard.getMatrix()[0][1], inputEasyBoard.getMatrix()[0][1]);
        assertEquals(expectedEasyBoard.getMatrix()[0][2], inputEasyBoard.getMatrix()[0][2]);
        assertEquals(expectedEasyBoard.getMatrix()[0][3], inputEasyBoard.getMatrix()[0][3]);
        assertEquals(expectedEasyBoard.getMatrix()[0][4], inputEasyBoard.getMatrix()[0][4]);
        assertEquals(expectedEasyBoard.getMatrix()[0][5], inputEasyBoard.getMatrix()[0][5]);
        assertEquals(expectedEasyBoard.getMatrix()[0][6], inputEasyBoard.getMatrix()[0][6]);
        assertEquals(expectedEasyBoard.getMatrix()[0][7], inputEasyBoard.getMatrix()[0][7]);
        assertEquals(expectedEasyBoard.getMatrix()[0][8], inputEasyBoard.getMatrix()[0][8]);

        assertEquals(expectedEasyBoard.getMatrix()[1][0], inputEasyBoard.getMatrix()[1][0]);
        assertEquals(expectedEasyBoard.getMatrix()[1][1], inputEasyBoard.getMatrix()[1][1]);
        assertEquals(expectedEasyBoard.getMatrix()[1][2], inputEasyBoard.getMatrix()[1][2]);
        assertEquals(expectedEasyBoard.getMatrix()[1][3], inputEasyBoard.getMatrix()[1][3]);
        assertEquals(expectedEasyBoard.getMatrix()[1][4], inputEasyBoard.getMatrix()[1][4]);
        assertEquals(expectedEasyBoard.getMatrix()[1][5], inputEasyBoard.getMatrix()[1][5]);
        assertEquals(expectedEasyBoard.getMatrix()[1][6], inputEasyBoard.getMatrix()[1][6]);
        assertEquals(expectedEasyBoard.getMatrix()[1][7], inputEasyBoard.getMatrix()[1][7]);
        assertEquals(expectedEasyBoard.getMatrix()[1][8], inputEasyBoard.getMatrix()[1][8]);

        assertEquals(expectedEasyBoard.getMatrix()[2][0], inputEasyBoard.getMatrix()[2][0]);
        assertEquals(expectedEasyBoard.getMatrix()[2][1], inputEasyBoard.getMatrix()[2][1]);
        assertEquals(expectedEasyBoard.getMatrix()[2][2], inputEasyBoard.getMatrix()[2][2]);
        assertEquals(expectedEasyBoard.getMatrix()[2][3], inputEasyBoard.getMatrix()[2][3]);
        assertEquals(expectedEasyBoard.getMatrix()[2][4], inputEasyBoard.getMatrix()[2][4]);
        assertEquals(expectedEasyBoard.getMatrix()[2][5], inputEasyBoard.getMatrix()[2][5]);
        assertEquals(expectedEasyBoard.getMatrix()[2][6], inputEasyBoard.getMatrix()[2][6]);
        assertEquals(expectedEasyBoard.getMatrix()[2][7], inputEasyBoard.getMatrix()[2][7]);
        assertEquals(expectedEasyBoard.getMatrix()[2][8], inputEasyBoard.getMatrix()[2][8]);

        assertEquals(expectedEasyBoard.getMatrix()[3][0], inputEasyBoard.getMatrix()[3][0]);
        assertEquals(expectedEasyBoard.getMatrix()[3][1], inputEasyBoard.getMatrix()[3][1]);
        assertEquals(expectedEasyBoard.getMatrix()[3][2], inputEasyBoard.getMatrix()[3][2]);
        assertEquals(expectedEasyBoard.getMatrix()[3][3], inputEasyBoard.getMatrix()[3][3]);
        assertEquals(expectedEasyBoard.getMatrix()[3][4], inputEasyBoard.getMatrix()[3][4]);
        assertEquals(expectedEasyBoard.getMatrix()[3][5], inputEasyBoard.getMatrix()[3][5]);
        assertEquals(expectedEasyBoard.getMatrix()[3][6], inputEasyBoard.getMatrix()[3][6]);
        assertEquals(expectedEasyBoard.getMatrix()[3][7], inputEasyBoard.getMatrix()[3][7]);
        assertEquals(expectedEasyBoard.getMatrix()[3][8], inputEasyBoard.getMatrix()[3][8]);

        assertEquals(expectedEasyBoard.getMatrix()[4][0], inputEasyBoard.getMatrix()[4][0]);
        assertEquals(expectedEasyBoard.getMatrix()[4][1], inputEasyBoard.getMatrix()[4][1]);
        assertEquals(expectedEasyBoard.getMatrix()[4][2], inputEasyBoard.getMatrix()[4][2]);
        assertEquals(expectedEasyBoard.getMatrix()[4][3], inputEasyBoard.getMatrix()[4][3]);
        assertEquals(expectedEasyBoard.getMatrix()[4][4], inputEasyBoard.getMatrix()[4][4]);
        assertEquals(expectedEasyBoard.getMatrix()[4][5], inputEasyBoard.getMatrix()[4][5]);
        assertEquals(expectedEasyBoard.getMatrix()[4][6], inputEasyBoard.getMatrix()[4][6]);
        assertEquals(expectedEasyBoard.getMatrix()[4][7], inputEasyBoard.getMatrix()[4][7]);
        assertEquals(expectedEasyBoard.getMatrix()[4][8], inputEasyBoard.getMatrix()[4][8]);

        assertEquals(expectedEasyBoard.getMatrix()[5][0], inputEasyBoard.getMatrix()[5][0]);
        assertEquals(expectedEasyBoard.getMatrix()[5][1], inputEasyBoard.getMatrix()[5][1]);
        assertEquals(expectedEasyBoard.getMatrix()[5][2], inputEasyBoard.getMatrix()[5][2]);
        assertEquals(expectedEasyBoard.getMatrix()[5][3], inputEasyBoard.getMatrix()[5][3]);
        assertEquals(expectedEasyBoard.getMatrix()[5][4], inputEasyBoard.getMatrix()[5][4]);
        assertEquals(expectedEasyBoard.getMatrix()[5][5], inputEasyBoard.getMatrix()[5][5]);
        assertEquals(expectedEasyBoard.getMatrix()[5][6], inputEasyBoard.getMatrix()[5][6]);
        assertEquals(expectedEasyBoard.getMatrix()[5][7], inputEasyBoard.getMatrix()[5][7]);
        assertEquals(expectedEasyBoard.getMatrix()[5][8], inputEasyBoard.getMatrix()[5][8]);

        assertEquals(expectedEasyBoard.getMatrix()[6][0], inputEasyBoard.getMatrix()[6][0]);
        assertEquals(expectedEasyBoard.getMatrix()[6][1], inputEasyBoard.getMatrix()[6][1]);
        assertEquals(expectedEasyBoard.getMatrix()[6][2], inputEasyBoard.getMatrix()[6][2]);
        assertEquals(expectedEasyBoard.getMatrix()[6][3], inputEasyBoard.getMatrix()[6][3]);
        assertEquals(expectedEasyBoard.getMatrix()[6][4], inputEasyBoard.getMatrix()[6][4]);
        assertEquals(expectedEasyBoard.getMatrix()[6][5], inputEasyBoard.getMatrix()[6][5]);
        assertEquals(expectedEasyBoard.getMatrix()[6][6], inputEasyBoard.getMatrix()[6][6]);
        assertEquals(expectedEasyBoard.getMatrix()[6][7], inputEasyBoard.getMatrix()[6][7]);
        assertEquals(expectedEasyBoard.getMatrix()[6][8], inputEasyBoard.getMatrix()[6][8]);

        assertEquals(expectedEasyBoard.getMatrix()[7][0], inputEasyBoard.getMatrix()[7][0]);
        assertEquals(expectedEasyBoard.getMatrix()[7][1], inputEasyBoard.getMatrix()[7][1]);
        assertEquals(expectedEasyBoard.getMatrix()[7][2], inputEasyBoard.getMatrix()[7][2]);
        assertEquals(expectedEasyBoard.getMatrix()[7][3], inputEasyBoard.getMatrix()[7][3]);
        assertEquals(expectedEasyBoard.getMatrix()[7][4], inputEasyBoard.getMatrix()[7][4]);
        assertEquals(expectedEasyBoard.getMatrix()[7][5], inputEasyBoard.getMatrix()[7][5]);
        assertEquals(expectedEasyBoard.getMatrix()[7][6], inputEasyBoard.getMatrix()[7][6]);
        assertEquals(expectedEasyBoard.getMatrix()[7][7], inputEasyBoard.getMatrix()[7][7]);
        assertEquals(expectedEasyBoard.getMatrix()[7][8], inputEasyBoard.getMatrix()[7][8]);

        assertEquals(expectedEasyBoard.getMatrix()[8][0], inputEasyBoard.getMatrix()[8][0]);
        assertEquals(expectedEasyBoard.getMatrix()[8][1], inputEasyBoard.getMatrix()[8][1]);
        assertEquals(expectedEasyBoard.getMatrix()[8][2], inputEasyBoard.getMatrix()[8][2]);
        assertEquals(expectedEasyBoard.getMatrix()[8][3], inputEasyBoard.getMatrix()[8][3]);
        assertEquals(expectedEasyBoard.getMatrix()[8][4], inputEasyBoard.getMatrix()[8][4]);
        assertEquals(expectedEasyBoard.getMatrix()[8][5], inputEasyBoard.getMatrix()[8][5]);
        assertEquals(expectedEasyBoard.getMatrix()[8][6], inputEasyBoard.getMatrix()[8][6]);
        assertEquals(expectedEasyBoard.getMatrix()[8][7], inputEasyBoard.getMatrix()[8][7]);
        assertEquals(expectedEasyBoard.getMatrix()[8][8], inputEasyBoard.getMatrix()[8][8]);

        assertEquals(expectedEasyBoard, inputEasyBoard);
    }


    @Test
    public void testSudokuServiceHardBoard_ok()
    {
        assertNotNull(inputHardBoard);
        assertNotNull(expectedHardBoard);

        service.solve(inputHardBoard, characters);

        assertEquals(expectedHardBoard.getMatrix()[0][0], inputHardBoard.getMatrix()[0][0]);
        assertEquals(expectedHardBoard.getMatrix()[0][1], inputHardBoard.getMatrix()[0][1]);
        assertEquals(expectedHardBoard.getMatrix()[0][2], inputHardBoard.getMatrix()[0][2]);
        assertEquals(expectedHardBoard.getMatrix()[0][3], inputHardBoard.getMatrix()[0][3]);
        assertEquals(expectedHardBoard.getMatrix()[0][4], inputHardBoard.getMatrix()[0][4]);
        assertEquals(expectedHardBoard.getMatrix()[0][5], inputHardBoard.getMatrix()[0][5]);
        assertEquals(expectedHardBoard.getMatrix()[0][6], inputHardBoard.getMatrix()[0][6]);
        assertEquals(expectedHardBoard.getMatrix()[0][7], inputHardBoard.getMatrix()[0][7]);
        assertEquals(expectedHardBoard.getMatrix()[0][8], inputHardBoard.getMatrix()[0][8]);

        assertEquals(expectedHardBoard.getMatrix()[1][0], inputHardBoard.getMatrix()[1][0]);
        assertEquals(expectedHardBoard.getMatrix()[1][1], inputHardBoard.getMatrix()[1][1]);
        assertEquals(expectedHardBoard.getMatrix()[1][2], inputHardBoard.getMatrix()[1][2]);
        assertEquals(expectedHardBoard.getMatrix()[1][3], inputHardBoard.getMatrix()[1][3]);
        assertEquals(expectedHardBoard.getMatrix()[1][4], inputHardBoard.getMatrix()[1][4]);
        assertEquals(expectedHardBoard.getMatrix()[1][5], inputHardBoard.getMatrix()[1][5]);
        assertEquals(expectedHardBoard.getMatrix()[1][6], inputHardBoard.getMatrix()[1][6]);
        assertEquals(expectedHardBoard.getMatrix()[1][7], inputHardBoard.getMatrix()[1][7]);
        assertEquals(expectedHardBoard.getMatrix()[1][8], inputHardBoard.getMatrix()[1][8]);

        assertEquals(expectedHardBoard.getMatrix()[2][0], inputHardBoard.getMatrix()[2][0]);
        assertEquals(expectedHardBoard.getMatrix()[2][1], inputHardBoard.getMatrix()[2][1]);
        assertEquals(expectedHardBoard.getMatrix()[2][2], inputHardBoard.getMatrix()[2][2]);
        assertEquals(expectedHardBoard.getMatrix()[2][3], inputHardBoard.getMatrix()[2][3]);
        assertEquals(expectedHardBoard.getMatrix()[2][4], inputHardBoard.getMatrix()[2][4]);
        assertEquals(expectedHardBoard.getMatrix()[2][5], inputHardBoard.getMatrix()[2][5]);
        assertEquals(expectedHardBoard.getMatrix()[2][6], inputHardBoard.getMatrix()[2][6]);
        assertEquals(expectedHardBoard.getMatrix()[2][7], inputHardBoard.getMatrix()[2][7]);
        assertEquals(expectedHardBoard.getMatrix()[2][8], inputHardBoard.getMatrix()[2][8]);

        assertEquals(expectedHardBoard.getMatrix()[3][0], inputHardBoard.getMatrix()[3][0]);
        assertEquals(expectedHardBoard.getMatrix()[3][1], inputHardBoard.getMatrix()[3][1]);
        assertEquals(expectedHardBoard.getMatrix()[3][2], inputHardBoard.getMatrix()[3][2]);
        assertEquals(expectedHardBoard.getMatrix()[3][3], inputHardBoard.getMatrix()[3][3]);
        assertEquals(expectedHardBoard.getMatrix()[3][4], inputHardBoard.getMatrix()[3][4]);
        assertEquals(expectedHardBoard.getMatrix()[3][5], inputHardBoard.getMatrix()[3][5]);
        assertEquals(expectedHardBoard.getMatrix()[3][6], inputHardBoard.getMatrix()[3][6]);
        assertEquals(expectedHardBoard.getMatrix()[3][7], inputHardBoard.getMatrix()[3][7]);
        assertEquals(expectedHardBoard.getMatrix()[3][8], inputHardBoard.getMatrix()[3][8]);

        assertEquals(expectedHardBoard.getMatrix()[4][0], inputHardBoard.getMatrix()[4][0]);
        assertEquals(expectedHardBoard.getMatrix()[4][1], inputHardBoard.getMatrix()[4][1]);
        assertEquals(expectedHardBoard.getMatrix()[4][2], inputHardBoard.getMatrix()[4][2]);
        assertEquals(expectedHardBoard.getMatrix()[4][3], inputHardBoard.getMatrix()[4][3]);
        assertEquals(expectedHardBoard.getMatrix()[4][4], inputHardBoard.getMatrix()[4][4]);
        assertEquals(expectedHardBoard.getMatrix()[4][5], inputHardBoard.getMatrix()[4][5]);
        assertEquals(expectedHardBoard.getMatrix()[4][6], inputHardBoard.getMatrix()[4][6]);
        assertEquals(expectedHardBoard.getMatrix()[4][7], inputHardBoard.getMatrix()[4][7]);
        assertEquals(expectedHardBoard.getMatrix()[4][8], inputHardBoard.getMatrix()[4][8]);

        assertEquals(expectedHardBoard.getMatrix()[5][0], inputHardBoard.getMatrix()[5][0]);
        assertEquals(expectedHardBoard.getMatrix()[5][1], inputHardBoard.getMatrix()[5][1]);
        assertEquals(expectedHardBoard.getMatrix()[5][2], inputHardBoard.getMatrix()[5][2]);
        assertEquals(expectedHardBoard.getMatrix()[5][3], inputHardBoard.getMatrix()[5][3]);
        assertEquals(expectedHardBoard.getMatrix()[5][4], inputHardBoard.getMatrix()[5][4]);
        assertEquals(expectedHardBoard.getMatrix()[5][5], inputHardBoard.getMatrix()[5][5]);
        assertEquals(expectedHardBoard.getMatrix()[5][6], inputHardBoard.getMatrix()[5][6]);
        assertEquals(expectedHardBoard.getMatrix()[5][7], inputHardBoard.getMatrix()[5][7]);
        assertEquals(expectedHardBoard.getMatrix()[5][8], inputHardBoard.getMatrix()[5][8]);

        assertEquals(expectedHardBoard.getMatrix()[6][0], inputHardBoard.getMatrix()[6][0]);
        assertEquals(expectedHardBoard.getMatrix()[6][1], inputHardBoard.getMatrix()[6][1]);
        assertEquals(expectedHardBoard.getMatrix()[6][2], inputHardBoard.getMatrix()[6][2]);
        assertEquals(expectedHardBoard.getMatrix()[6][3], inputHardBoard.getMatrix()[6][3]);
        assertEquals(expectedHardBoard.getMatrix()[6][4], inputHardBoard.getMatrix()[6][4]);
        assertEquals(expectedHardBoard.getMatrix()[6][5], inputHardBoard.getMatrix()[6][5]);
        assertEquals(expectedHardBoard.getMatrix()[6][6], inputHardBoard.getMatrix()[6][6]);
        assertEquals(expectedHardBoard.getMatrix()[6][7], inputHardBoard.getMatrix()[6][7]);
        assertEquals(expectedHardBoard.getMatrix()[6][8], inputHardBoard.getMatrix()[6][8]);

        assertEquals(expectedHardBoard.getMatrix()[7][0], inputHardBoard.getMatrix()[7][0]);
        assertEquals(expectedHardBoard.getMatrix()[7][1], inputHardBoard.getMatrix()[7][1]);
        assertEquals(expectedHardBoard.getMatrix()[7][2], inputHardBoard.getMatrix()[7][2]);
        assertEquals(expectedHardBoard.getMatrix()[7][3], inputHardBoard.getMatrix()[7][3]);
        assertEquals(expectedHardBoard.getMatrix()[7][4], inputHardBoard.getMatrix()[7][4]);
        assertEquals(expectedHardBoard.getMatrix()[7][5], inputHardBoard.getMatrix()[7][5]);
        assertEquals(expectedHardBoard.getMatrix()[7][6], inputHardBoard.getMatrix()[7][6]);
        assertEquals(expectedHardBoard.getMatrix()[7][7], inputHardBoard.getMatrix()[7][7]);
        assertEquals(expectedHardBoard.getMatrix()[7][8], inputHardBoard.getMatrix()[7][8]);

        assertEquals(expectedHardBoard.getMatrix()[8][0], inputHardBoard.getMatrix()[8][0]);
        assertEquals(expectedHardBoard.getMatrix()[8][1], inputHardBoard.getMatrix()[8][1]);
        assertEquals(expectedHardBoard.getMatrix()[8][2], inputHardBoard.getMatrix()[8][2]);
        assertEquals(expectedHardBoard.getMatrix()[8][3], inputHardBoard.getMatrix()[8][3]);
        assertEquals(expectedHardBoard.getMatrix()[8][4], inputHardBoard.getMatrix()[8][4]);
        assertEquals(expectedHardBoard.getMatrix()[8][5], inputHardBoard.getMatrix()[8][5]);
        assertEquals(expectedHardBoard.getMatrix()[8][6], inputHardBoard.getMatrix()[8][6]);
        assertEquals(expectedHardBoard.getMatrix()[8][7], inputHardBoard.getMatrix()[8][7]);
        assertEquals(expectedHardBoard.getMatrix()[8][8], inputHardBoard.getMatrix()[8][8]);

        assertEquals(expectedHardBoard, inputHardBoard);
    }

}
