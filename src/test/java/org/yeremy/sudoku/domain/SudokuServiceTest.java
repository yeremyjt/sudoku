package org.yeremy.sudoku.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yeremy.sudoku.config.TestConfig;
import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.InputBoard;

import javax.inject.Inject;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class SudokuServiceTest
{
    @Inject
    SudokuService service;

    private static InputBoard inputEasyBoard;
    private static InputBoard inputHardBoard;
    private static Board expectedEasyBoard;
    private static Board expectedHardBoard;

    private final int n = 9;

    @BeforeClass
    public static void setUp()
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("input-board.json");
        try
        {
            inputEasyBoard = objectMapper.readValue(inputStream, InputBoard.class);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("input-board-hard.json");
        try
        {
            inputHardBoard = objectMapper.readValue(inputStream, InputBoard.class);
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

        Board outputBoard = service.solveNineByNine(inputEasyBoard);

        assertEquals(expectedEasyBoard.getMatrix()[0][0], outputBoard.getMatrix()[0][0]);
        assertEquals(expectedEasyBoard.getMatrix()[0][1], outputBoard.getMatrix()[0][1]);
        assertEquals(expectedEasyBoard.getMatrix()[0][2], outputBoard.getMatrix()[0][2]);
        assertEquals(expectedEasyBoard.getMatrix()[0][3], outputBoard.getMatrix()[0][3]);
        assertEquals(expectedEasyBoard.getMatrix()[0][4], outputBoard.getMatrix()[0][4]);
        assertEquals(expectedEasyBoard.getMatrix()[0][5], outputBoard.getMatrix()[0][5]);
        assertEquals(expectedEasyBoard.getMatrix()[0][6], outputBoard.getMatrix()[0][6]);
        assertEquals(expectedEasyBoard.getMatrix()[0][7], outputBoard.getMatrix()[0][7]);
        assertEquals(expectedEasyBoard.getMatrix()[0][8], outputBoard.getMatrix()[0][8]);

        assertEquals(expectedEasyBoard.getMatrix()[1][0], outputBoard.getMatrix()[1][0]);
        assertEquals(expectedEasyBoard.getMatrix()[1][1], outputBoard.getMatrix()[1][1]);
        assertEquals(expectedEasyBoard.getMatrix()[1][2], outputBoard.getMatrix()[1][2]);
        assertEquals(expectedEasyBoard.getMatrix()[1][3], outputBoard.getMatrix()[1][3]);
        assertEquals(expectedEasyBoard.getMatrix()[1][4], outputBoard.getMatrix()[1][4]);
        assertEquals(expectedEasyBoard.getMatrix()[1][5], outputBoard.getMatrix()[1][5]);
        assertEquals(expectedEasyBoard.getMatrix()[1][6], outputBoard.getMatrix()[1][6]);
        assertEquals(expectedEasyBoard.getMatrix()[1][7], outputBoard.getMatrix()[1][7]);
        assertEquals(expectedEasyBoard.getMatrix()[1][8], outputBoard.getMatrix()[1][8]);

        assertEquals(expectedEasyBoard.getMatrix()[2][0], outputBoard.getMatrix()[2][0]);
        assertEquals(expectedEasyBoard.getMatrix()[2][1], outputBoard.getMatrix()[2][1]);
        assertEquals(expectedEasyBoard.getMatrix()[2][2], outputBoard.getMatrix()[2][2]);
        assertEquals(expectedEasyBoard.getMatrix()[2][3], outputBoard.getMatrix()[2][3]);
        assertEquals(expectedEasyBoard.getMatrix()[2][4], outputBoard.getMatrix()[2][4]);
        assertEquals(expectedEasyBoard.getMatrix()[2][5], outputBoard.getMatrix()[2][5]);
        assertEquals(expectedEasyBoard.getMatrix()[2][6], outputBoard.getMatrix()[2][6]);
        assertEquals(expectedEasyBoard.getMatrix()[2][7], outputBoard.getMatrix()[2][7]);
        assertEquals(expectedEasyBoard.getMatrix()[2][8], outputBoard.getMatrix()[2][8]);

        assertEquals(expectedEasyBoard.getMatrix()[3][0], outputBoard.getMatrix()[3][0]);
        assertEquals(expectedEasyBoard.getMatrix()[3][1], outputBoard.getMatrix()[3][1]);
        assertEquals(expectedEasyBoard.getMatrix()[3][2], outputBoard.getMatrix()[3][2]);
        assertEquals(expectedEasyBoard.getMatrix()[3][3], outputBoard.getMatrix()[3][3]);
        assertEquals(expectedEasyBoard.getMatrix()[3][4], outputBoard.getMatrix()[3][4]);
        assertEquals(expectedEasyBoard.getMatrix()[3][5], outputBoard.getMatrix()[3][5]);
        assertEquals(expectedEasyBoard.getMatrix()[3][6], outputBoard.getMatrix()[3][6]);
        assertEquals(expectedEasyBoard.getMatrix()[3][7], outputBoard.getMatrix()[3][7]);
        assertEquals(expectedEasyBoard.getMatrix()[3][8], outputBoard.getMatrix()[3][8]);

        assertEquals(expectedEasyBoard.getMatrix()[4][0], outputBoard.getMatrix()[4][0]);
        assertEquals(expectedEasyBoard.getMatrix()[4][1], outputBoard.getMatrix()[4][1]);
        assertEquals(expectedEasyBoard.getMatrix()[4][2], outputBoard.getMatrix()[4][2]);
        assertEquals(expectedEasyBoard.getMatrix()[4][3], outputBoard.getMatrix()[4][3]);
        assertEquals(expectedEasyBoard.getMatrix()[4][4], outputBoard.getMatrix()[4][4]);
        assertEquals(expectedEasyBoard.getMatrix()[4][5], outputBoard.getMatrix()[4][5]);
        assertEquals(expectedEasyBoard.getMatrix()[4][6], outputBoard.getMatrix()[4][6]);
        assertEquals(expectedEasyBoard.getMatrix()[4][7], outputBoard.getMatrix()[4][7]);
        assertEquals(expectedEasyBoard.getMatrix()[4][8], outputBoard.getMatrix()[4][8]);

        assertEquals(expectedEasyBoard.getMatrix()[5][0], outputBoard.getMatrix()[5][0]);
        assertEquals(expectedEasyBoard.getMatrix()[5][1], outputBoard.getMatrix()[5][1]);
        assertEquals(expectedEasyBoard.getMatrix()[5][2], outputBoard.getMatrix()[5][2]);
        assertEquals(expectedEasyBoard.getMatrix()[5][3], outputBoard.getMatrix()[5][3]);
        assertEquals(expectedEasyBoard.getMatrix()[5][4], outputBoard.getMatrix()[5][4]);
        assertEquals(expectedEasyBoard.getMatrix()[5][5], outputBoard.getMatrix()[5][5]);
        assertEquals(expectedEasyBoard.getMatrix()[5][6], outputBoard.getMatrix()[5][6]);
        assertEquals(expectedEasyBoard.getMatrix()[5][7], outputBoard.getMatrix()[5][7]);
        assertEquals(expectedEasyBoard.getMatrix()[5][8], outputBoard.getMatrix()[5][8]);

        assertEquals(expectedEasyBoard.getMatrix()[6][0], outputBoard.getMatrix()[6][0]);
        assertEquals(expectedEasyBoard.getMatrix()[6][1], outputBoard.getMatrix()[6][1]);
        assertEquals(expectedEasyBoard.getMatrix()[6][2], outputBoard.getMatrix()[6][2]);
        assertEquals(expectedEasyBoard.getMatrix()[6][3], outputBoard.getMatrix()[6][3]);
        assertEquals(expectedEasyBoard.getMatrix()[6][4], outputBoard.getMatrix()[6][4]);
        assertEquals(expectedEasyBoard.getMatrix()[6][5], outputBoard.getMatrix()[6][5]);
        assertEquals(expectedEasyBoard.getMatrix()[6][6], outputBoard.getMatrix()[6][6]);
        assertEquals(expectedEasyBoard.getMatrix()[6][7], outputBoard.getMatrix()[6][7]);
        assertEquals(expectedEasyBoard.getMatrix()[6][8], outputBoard.getMatrix()[6][8]);

        assertEquals(expectedEasyBoard.getMatrix()[7][0], outputBoard.getMatrix()[7][0]);
        assertEquals(expectedEasyBoard.getMatrix()[7][1], outputBoard.getMatrix()[7][1]);
        assertEquals(expectedEasyBoard.getMatrix()[7][2], outputBoard.getMatrix()[7][2]);
        assertEquals(expectedEasyBoard.getMatrix()[7][3], outputBoard.getMatrix()[7][3]);
        assertEquals(expectedEasyBoard.getMatrix()[7][4], outputBoard.getMatrix()[7][4]);
        assertEquals(expectedEasyBoard.getMatrix()[7][5], outputBoard.getMatrix()[7][5]);
        assertEquals(expectedEasyBoard.getMatrix()[7][6], outputBoard.getMatrix()[7][6]);
        assertEquals(expectedEasyBoard.getMatrix()[7][7], outputBoard.getMatrix()[7][7]);
        assertEquals(expectedEasyBoard.getMatrix()[7][8], outputBoard.getMatrix()[7][8]);

        assertEquals(expectedEasyBoard.getMatrix()[8][0], outputBoard.getMatrix()[8][0]);
        assertEquals(expectedEasyBoard.getMatrix()[8][1], outputBoard.getMatrix()[8][1]);
        assertEquals(expectedEasyBoard.getMatrix()[8][2], outputBoard.getMatrix()[8][2]);
        assertEquals(expectedEasyBoard.getMatrix()[8][3], outputBoard.getMatrix()[8][3]);
        assertEquals(expectedEasyBoard.getMatrix()[8][4], outputBoard.getMatrix()[8][4]);
        assertEquals(expectedEasyBoard.getMatrix()[8][5], outputBoard.getMatrix()[8][5]);
        assertEquals(expectedEasyBoard.getMatrix()[8][6], outputBoard.getMatrix()[8][6]);
        assertEquals(expectedEasyBoard.getMatrix()[8][7], outputBoard.getMatrix()[8][7]);
        assertEquals(expectedEasyBoard.getMatrix()[8][8], outputBoard.getMatrix()[8][8]);

        assertEquals(expectedEasyBoard, outputBoard);
    }

    @Test
    public void testSudokuServiceHardBoard_ok()
    {
        assertNotNull(inputHardBoard);
        assertNotNull(expectedHardBoard);

        Board outputBoard = service.solveNineByNine(inputHardBoard);

        assertEquals(expectedHardBoard.getMatrix()[0][0], outputBoard.getMatrix()[0][0]);
        assertEquals(expectedHardBoard.getMatrix()[0][1], outputBoard.getMatrix()[0][1]);
        assertEquals(expectedHardBoard.getMatrix()[0][2], outputBoard.getMatrix()[0][2]);
        assertEquals(expectedHardBoard.getMatrix()[0][3], outputBoard.getMatrix()[0][3]);
        assertEquals(expectedHardBoard.getMatrix()[0][4], outputBoard.getMatrix()[0][4]);
        assertEquals(expectedHardBoard.getMatrix()[0][5], outputBoard.getMatrix()[0][5]);
        assertEquals(expectedHardBoard.getMatrix()[0][6], outputBoard.getMatrix()[0][6]);
        assertEquals(expectedHardBoard.getMatrix()[0][7], outputBoard.getMatrix()[0][7]);
        assertEquals(expectedHardBoard.getMatrix()[0][8], outputBoard.getMatrix()[0][8]);

        assertEquals(expectedHardBoard.getMatrix()[1][0], outputBoard.getMatrix()[1][0]);
        assertEquals(expectedHardBoard.getMatrix()[1][1], outputBoard.getMatrix()[1][1]);
        assertEquals(expectedHardBoard.getMatrix()[1][2], outputBoard.getMatrix()[1][2]);
        assertEquals(expectedHardBoard.getMatrix()[1][3], outputBoard.getMatrix()[1][3]);
        assertEquals(expectedHardBoard.getMatrix()[1][4], outputBoard.getMatrix()[1][4]);
        assertEquals(expectedHardBoard.getMatrix()[1][5], outputBoard.getMatrix()[1][5]);
        assertEquals(expectedHardBoard.getMatrix()[1][6], outputBoard.getMatrix()[1][6]);
        assertEquals(expectedHardBoard.getMatrix()[1][7], outputBoard.getMatrix()[1][7]);
        assertEquals(expectedHardBoard.getMatrix()[1][8], outputBoard.getMatrix()[1][8]);

        assertEquals(expectedHardBoard.getMatrix()[2][0], outputBoard.getMatrix()[2][0]);
        assertEquals(expectedHardBoard.getMatrix()[2][1], outputBoard.getMatrix()[2][1]);
        assertEquals(expectedHardBoard.getMatrix()[2][2], outputBoard.getMatrix()[2][2]);
        assertEquals(expectedHardBoard.getMatrix()[2][3], outputBoard.getMatrix()[2][3]);
        assertEquals(expectedHardBoard.getMatrix()[2][4], outputBoard.getMatrix()[2][4]);
        assertEquals(expectedHardBoard.getMatrix()[2][5], outputBoard.getMatrix()[2][5]);
        assertEquals(expectedHardBoard.getMatrix()[2][6], outputBoard.getMatrix()[2][6]);
        assertEquals(expectedHardBoard.getMatrix()[2][7], outputBoard.getMatrix()[2][7]);
        assertEquals(expectedHardBoard.getMatrix()[2][8], outputBoard.getMatrix()[2][8]);

        assertEquals(expectedHardBoard.getMatrix()[3][0], outputBoard.getMatrix()[3][0]);
        assertEquals(expectedHardBoard.getMatrix()[3][1], outputBoard.getMatrix()[3][1]);
        assertEquals(expectedHardBoard.getMatrix()[3][2], outputBoard.getMatrix()[3][2]);
        assertEquals(expectedHardBoard.getMatrix()[3][3], outputBoard.getMatrix()[3][3]);
        assertEquals(expectedHardBoard.getMatrix()[3][4], outputBoard.getMatrix()[3][4]);
        assertEquals(expectedHardBoard.getMatrix()[3][5], outputBoard.getMatrix()[3][5]);
        assertEquals(expectedHardBoard.getMatrix()[3][6], outputBoard.getMatrix()[3][6]);
        assertEquals(expectedHardBoard.getMatrix()[3][7], outputBoard.getMatrix()[3][7]);
        assertEquals(expectedHardBoard.getMatrix()[3][8], outputBoard.getMatrix()[3][8]);

        assertEquals(expectedHardBoard.getMatrix()[4][0], outputBoard.getMatrix()[4][0]);
        assertEquals(expectedHardBoard.getMatrix()[4][1], outputBoard.getMatrix()[4][1]);
        assertEquals(expectedHardBoard.getMatrix()[4][2], outputBoard.getMatrix()[4][2]);
        assertEquals(expectedHardBoard.getMatrix()[4][3], outputBoard.getMatrix()[4][3]);
        assertEquals(expectedHardBoard.getMatrix()[4][4], outputBoard.getMatrix()[4][4]);
        assertEquals(expectedHardBoard.getMatrix()[4][5], outputBoard.getMatrix()[4][5]);
        assertEquals(expectedHardBoard.getMatrix()[4][6], outputBoard.getMatrix()[4][6]);
        assertEquals(expectedHardBoard.getMatrix()[4][7], outputBoard.getMatrix()[4][7]);
        assertEquals(expectedHardBoard.getMatrix()[4][8], outputBoard.getMatrix()[4][8]);

        assertEquals(expectedHardBoard.getMatrix()[5][0], outputBoard.getMatrix()[5][0]);
        assertEquals(expectedHardBoard.getMatrix()[5][1], outputBoard.getMatrix()[5][1]);
        assertEquals(expectedHardBoard.getMatrix()[5][2], outputBoard.getMatrix()[5][2]);
        assertEquals(expectedHardBoard.getMatrix()[5][3], outputBoard.getMatrix()[5][3]);
        assertEquals(expectedHardBoard.getMatrix()[5][4], outputBoard.getMatrix()[5][4]);
        assertEquals(expectedHardBoard.getMatrix()[5][5], outputBoard.getMatrix()[5][5]);
        assertEquals(expectedHardBoard.getMatrix()[5][6], outputBoard.getMatrix()[5][6]);
        assertEquals(expectedHardBoard.getMatrix()[5][7], outputBoard.getMatrix()[5][7]);
        assertEquals(expectedHardBoard.getMatrix()[5][8], outputBoard.getMatrix()[5][8]);

        assertEquals(expectedHardBoard.getMatrix()[6][0], outputBoard.getMatrix()[6][0]);
        assertEquals(expectedHardBoard.getMatrix()[6][1], outputBoard.getMatrix()[6][1]);
        assertEquals(expectedHardBoard.getMatrix()[6][2], outputBoard.getMatrix()[6][2]);
        assertEquals(expectedHardBoard.getMatrix()[6][3], outputBoard.getMatrix()[6][3]);
        assertEquals(expectedHardBoard.getMatrix()[6][4], outputBoard.getMatrix()[6][4]);
        assertEquals(expectedHardBoard.getMatrix()[6][5], outputBoard.getMatrix()[6][5]);
        assertEquals(expectedHardBoard.getMatrix()[6][6], outputBoard.getMatrix()[6][6]);
        assertEquals(expectedHardBoard.getMatrix()[6][7], outputBoard.getMatrix()[6][7]);
        assertEquals(expectedHardBoard.getMatrix()[6][8], outputBoard.getMatrix()[6][8]);

        assertEquals(expectedHardBoard.getMatrix()[7][0], outputBoard.getMatrix()[7][0]);
        assertEquals(expectedHardBoard.getMatrix()[7][1], outputBoard.getMatrix()[7][1]);
        assertEquals(expectedHardBoard.getMatrix()[7][2], outputBoard.getMatrix()[7][2]);
        assertEquals(expectedHardBoard.getMatrix()[7][3], outputBoard.getMatrix()[7][3]);
        assertEquals(expectedHardBoard.getMatrix()[7][4], outputBoard.getMatrix()[7][4]);
        assertEquals(expectedHardBoard.getMatrix()[7][5], outputBoard.getMatrix()[7][5]);
        assertEquals(expectedHardBoard.getMatrix()[7][6], outputBoard.getMatrix()[7][6]);
        assertEquals(expectedHardBoard.getMatrix()[7][7], outputBoard.getMatrix()[7][7]);
        assertEquals(expectedHardBoard.getMatrix()[7][8], outputBoard.getMatrix()[7][8]);

        assertEquals(expectedHardBoard.getMatrix()[8][0], outputBoard.getMatrix()[8][0]);
        assertEquals(expectedHardBoard.getMatrix()[8][1], outputBoard.getMatrix()[8][1]);
        assertEquals(expectedHardBoard.getMatrix()[8][2], outputBoard.getMatrix()[8][2]);
        assertEquals(expectedHardBoard.getMatrix()[8][3], outputBoard.getMatrix()[8][3]);
        assertEquals(expectedHardBoard.getMatrix()[8][4], outputBoard.getMatrix()[8][4]);
        assertEquals(expectedHardBoard.getMatrix()[8][5], outputBoard.getMatrix()[8][5]);
        assertEquals(expectedHardBoard.getMatrix()[8][6], outputBoard.getMatrix()[8][6]);
        assertEquals(expectedHardBoard.getMatrix()[8][7], outputBoard.getMatrix()[8][7]);
        assertEquals(expectedHardBoard.getMatrix()[8][8], outputBoard.getMatrix()[8][8]);

        assertEquals(expectedHardBoard, outputBoard);
    }

}
