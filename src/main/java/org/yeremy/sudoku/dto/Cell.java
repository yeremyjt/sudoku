package org.yeremy.sudoku.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cell
{
    @JsonProperty("value")
    private String value;

    @JsonProperty("possibilities")
    private List<String> possibilities;

    public String getValue()
    {
        return this.value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public List<String> getPossibilities()
    {
        return possibilities;
    }

    public void setPosibilities(List<String> posibilities)
    {
        this.possibilities = posibilities;
    }

}
