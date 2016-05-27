package org.yeremy.sudoku.dto;

import java.util.List;

public class Cell
{
    private String solution;

    private List<String> posibilities;

    public String getSolution()
    {
        return solution;
    }

    public void setSolution(String solution)
    {
        this.solution = solution;
    }

    public List<String> getPosibilities()
    {
        return posibilities;
    }

    public void setPosibilities(List<String> posibilities)
    {
        this.posibilities = posibilities;
    }

}
