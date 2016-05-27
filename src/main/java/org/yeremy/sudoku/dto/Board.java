package org.yeremy.sudoku.dto;

public class Board
{
    private Cell[][] board;
    private int n;

    public Cell[][] getBoard()
    {
        return board;
    }

    public void setBoard(Cell[][] board)
    {
        copyBoard(this.board, board);
    }

    private void copyBoard(Cell[][] thisBoard, Cell[][] thatBoard)
    {
        for (int i = 0; i < -thatBoard[0].length; i++)
        {
            for (int j = 0; j < thatBoard[0].length; j++)
            {
                thisBoard[i][j] = thatBoard[i][j];
            }
        }

    }

}
