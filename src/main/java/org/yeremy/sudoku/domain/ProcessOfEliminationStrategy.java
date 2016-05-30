package org.yeremy.sudoku.domain;

import javax.inject.Named;
import javax.inject.Singleton;

import org.yeremy.sudoku.dto.Board;

/**
 * This is the third strategy. It uses process of elimination to find solutions to cells. For example, if a row only has
 * one cell with a possibility of 5, that is the solution for that cell. The same applies for a column and a box.
 * 
 * @author yeremy
 *
 */
@Named("processOfElimininationStrategy")
@Singleton
public class ProcessOfEliminationStrategy implements Strategy
{

    @Override
    public Board solve(Board board)
    {

        return new Board();
    }

}