package org.yeremy.sudoku.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yeremy.sudoku.dto.InputBoard;

@RunWith(SpringJUnit4ClassRunner.class)
public class ValidatorTest
{
    private Validator validator = new ValidatorImpl();

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNineByNineBoard_NullInputBoard()
    {
        validator.validateNineByNineBoard(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNineByNineBoard_NullMatrix()
    {
        InputBoard inputBoard = new InputBoard();
        validator.validateNineByNineBoard(inputBoard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNineByNineBoard_WrongBoardSize1()
    {
        InputBoard inputBoard = new InputBoard();
        String[][] matrix = new String[10][9];
        inputBoard.setMatrix(matrix);
        validator.validateNineByNineBoard(inputBoard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNineByNineBoard_WrongBoardSize2()
    {
        InputBoard inputBoard = new InputBoard();
        String[][] matrix = new String[9][10];
        inputBoard.setMatrix(matrix);
        validator.validateNineByNineBoard(inputBoard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNineByNineBoard_WrongBoardSize3()
    {
        InputBoard inputBoard = new InputBoard();
        String[][] matrix = new String[8][9];
        inputBoard.setMatrix(matrix);
        validator.validateNineByNineBoard(inputBoard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNineByNineBoard_InvalidCharacter()
    {
        InputBoard inputBoard = new InputBoard();
        String[][] matrix = new String[9][9];
        matrix[0][0] = "A";
        inputBoard.setMatrix(matrix);
        validator.validateNineByNineBoard(inputBoard);
    }

    @Test
    public void testValidateNineByNineBoard_Ok()
    {
        InputBoard inputBoard = new InputBoard();
        String[][] matrix = new String[9][9];
        matrix[0][0] = "1";
        matrix[1][1] = "2";
        matrix[2][2] = "3";
        matrix[3][3] = "4";
        matrix[4][4] = "5";
        matrix[5][5] = "6";
        matrix[6][6] = "7";
        matrix[7][7] = "8";
        matrix[8][8] = "9";
        inputBoard.setMatrix(matrix);
        validator.validateNineByNineBoard(inputBoard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateSixteenBySixteenBoard_NullInputBoard()
    {
        validator.validateSixteenBySixteenBoard(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateSixteenBySixteenBoard_NullMatrix()
    {
        InputBoard inputBoard = new InputBoard();
        validator.validateSixteenBySixteenBoard(inputBoard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateSixteenBySixteenBoard_WrongBoardSize1()
    {
        InputBoard inputBoard = new InputBoard();
        String[][] matrix = new String[17][16];
        inputBoard.setMatrix(matrix);
        validator.validateSixteenBySixteenBoard(inputBoard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateSixteenBySixteenBoard_WrongBoardSize2()
    {
        InputBoard inputBoard = new InputBoard();
        String[][] matrix = new String[16][17];
        inputBoard.setMatrix(matrix);
        validator.validateSixteenBySixteenBoard(inputBoard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateSixteenBySixteenBoard_WrongBoardSize3()
    {
        InputBoard inputBoard = new InputBoard();
        String[][] matrix = new String[15][16];
        inputBoard.setMatrix(matrix);
        validator.validateSixteenBySixteenBoard(inputBoard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateSixteenBySixteenBoard_InvalidCharacter()
    {
        InputBoard inputBoard = new InputBoard();
        String[][] matrix = new String[9][9];
        matrix[0][0] = "a";
        inputBoard.setMatrix(matrix);
        validator.validateSixteenBySixteenBoard(inputBoard);
    }

    @Test
    public void testValidateSixteenBySixteenBoard_Ok()
    {
        InputBoard inputBoard = new InputBoard();
        String[][] matrix = new String[16][16];
        matrix[0][0] = "1";
        matrix[1][1] = "2";
        matrix[2][2] = "3";
        matrix[3][3] = "4";
        matrix[4][4] = "5";
        matrix[5][5] = "6";
        matrix[6][6] = "7";
        matrix[7][7] = "8";
        matrix[8][8] = "9";
        matrix[9][9] = "A";
        matrix[10][10] = "B";
        matrix[11][11] = "C";
        inputBoard.setMatrix(matrix);
        validator.validateSixteenBySixteenBoard(inputBoard);
    }
}
