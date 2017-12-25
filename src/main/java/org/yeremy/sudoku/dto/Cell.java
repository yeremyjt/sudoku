package org.yeremy.sudoku.dto;

import java.util.ArrayList;
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

    public void setPossibilities(List<String> possibilities)
    {
        this.possibilities = new ArrayList<String>(possibilities);
    }

    public void clearPossibilities()
    {
        this.possibilities.clear();
    }

    public void deletePossibilities(List<String> possibilitiesToRemove)
    {
        for (final String possibility : possibilitiesToRemove)
        {
            this.possibilities.remove(possibility);
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Cell)
        {
            final Cell that = (Cell) obj;

            if (this.value == null && that.value == null)
            {
                if (this.possibilities.size() == that.possibilities.size())
                {
                    for (int i = 0; i < this.possibilities.size(); i++)
                    {
                        if (!this.possibilities.contains(that.possibilities.get(i)))
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    return false;
                }

                return true;
            }

            if (this.value == null && that.value != null) return false;
            if (this.value != null && that.value == null) return false;

            if ((this.value != null && that.value != null) && this.value.equals(that.value))
            {
                if (this.possibilities.size() == that.possibilities.size())
                {
                    for (int i = 0; i < this.possibilities.size(); i++)
                    {
                        if (!this.possibilities.contains(that.possibilities.get(i)))
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    return false;
                }

                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
