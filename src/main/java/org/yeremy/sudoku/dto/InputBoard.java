package org.yeremy.sudoku.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputBoard
{
    @JsonProperty("matrix")
    private String[][] matrix;

    public String[][] getMatrix()
    {
        return matrix;
    }

    public void setMatrix(String[][] matrix)
    {
        this.matrix = matrix;
    }
}
