package org.yeremy.sudoku.domain;

import org.yeremy.sudoku.dto.InputBoard;
import org.yeremy.sudoku.strategies.BoardType;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Named
@Singleton
public class ValidatorImpl implements Validator
{
    private Pattern pattern;
    private Matcher matcher;

    @Override
    public void validateNineByNineBoard(InputBoard inputBoard)
    {
        if (inputBoard == null)
        {
            throw new IllegalArgumentException("The input board is null");
        }

        if (inputBoard.getMatrix() == null)
        {
            throw new IllegalArgumentException("The input board is empty");
        }

        final int NINE_BY_NINE_SIZE = 9;
        if (!isValidBoardSize(inputBoard, NINE_BY_NINE_SIZE))
        {
            throw new IllegalArgumentException("The input board is not a nine by nine board.");
        }

        final String NUMBER_PATTERN = "[1-9]";
        pattern = Pattern.compile(NUMBER_PATTERN);
        int n = inputBoard.getMatrix()[0].length;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (inputBoard.getMatrix()[i][j] == null)
                    continue;

                matcher = pattern.matcher(String.valueOf(inputBoard.getMatrix()[i][j]));
                if (!matcher.matches())
                {
                    throw new IllegalArgumentException(inputBoard.getMatrix()[i][j] + " is not a valid input for a " +
                            "nine by nine board. Please use numbers between 1 and 9");
                }
            }
        }
    }

    private boolean isValidBoardSize(InputBoard inputBoard, int size)
    {
        if (inputBoard.getMatrix().length != size) return false;
        for (int i = 0; i < size; i++) {
            if (inputBoard.getMatrix()[i].length != size) return false;
        }

        return true;
    }

    @Override
    public void validateSixteenBySixteenBoard(InputBoard inputBoard)
    {
        if (inputBoard == null)
        {
            throw new IllegalArgumentException("The input board is null");
        }

        if (inputBoard.getMatrix() == null)
        {
            throw new IllegalArgumentException("The input board is empty");
        }

        final int SIXTEEN_BY_SIXTEEN_SIZE = 16;
        if (!isValidBoardSize(inputBoard, SIXTEEN_BY_SIXTEEN_SIZE))
        {
            throw new IllegalArgumentException("The input board is not a sixteen by sixteen board.");
        }

        final String ALPHANUMERIC_PATTERN = "[1-9A-Z]";
        pattern = Pattern.compile(ALPHANUMERIC_PATTERN);
        int n = inputBoard.getMatrix()[0].length;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (inputBoard.getMatrix()[i][j] == null)
                    continue;

                matcher = pattern.matcher(String.valueOf(inputBoard.getMatrix()[i][j]));
                if (!matcher.matches())
                {
                    throw new IllegalArgumentException(inputBoard.getMatrix()[i][j] + " is not a valid input for a " +
                            "nine by nine board. Please use numbers 1-9 and letters A-Z.");
                }
            }
        }
    }
}
