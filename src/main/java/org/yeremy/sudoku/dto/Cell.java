package org.yeremy.sudoku.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cell
{
    @JsonProperty("value")
    private String value;

    @JsonProperty("posibilities")
    private List<String> posibilities;

    public String getValue()
    {
        return this.value;
    }

    public void setValue(String value)
    {
        this.value = value;
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
