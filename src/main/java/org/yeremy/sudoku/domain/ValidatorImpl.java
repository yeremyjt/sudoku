package org.yeremy.sudoku.domain;

import org.yeremy.sudoku.dto.InputBoard;

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

    @Override
    public void validateSixteenBySixteen(InputBoard inputBoard)
    {
        if (inputBoard == null)
        {
            throw new IllegalArgumentException("The input board is null");
        }

        if (inputBoard.getMatrix() == null)
        {
            throw new IllegalArgumentException("The input board is empty");
        }

        final String ALPHANUMERIC_PATTERN = "[1-9A-Za-z]";
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
