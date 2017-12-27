package org.yeremy.sudoku.domain;

import org.yeremy.sudoku.dto.InputBoard;

public interface Validator
{
    void validateNineByNineBoard(InputBoard inputBoard);

    void validateSixteenBySixteenBoard(InputBoard inputBoard);
}
