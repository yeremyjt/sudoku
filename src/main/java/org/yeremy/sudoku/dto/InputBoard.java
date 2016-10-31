package org.yeremy.sudoku.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputBoard
{
    @JsonProperty("matrix")
    private Integer[][] matrix;

    public Integer[][] getMatrix()
    {
        return matrix;
    }

    public void setMatrix(Integer[][] matrix)
    {
        this.matrix = matrix;
    }
}
