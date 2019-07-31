package edu.oakland.production;

public class TTTDatabase {

    private GameBoard gameBoard;
    private int numberOfRow;
    private int numberOfColumn;
    private char typeOfMark;

    /* positions on the GameBoard are indicated by "cell[i][j]" where
    "i" represents the row and "j" represents the column; rows and
    columns are indexed from [0] to [2]; therefore the center cell
    would be cell[1][1];     */

    // provide method to enter character in a cell;
    public boolean writeToBoard(int row, int col, char mark) {
        // use the helper class "GameBoard.java" for all Board instructions;
        // check if row and column are in bounds of the board
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = mark;
                    return true;
                }
            }
        }

        return false;
    }
    
    // provide method to print board after each player move;
    public void printBoardStatus() {
        gameBoard.printBoard()
    }
    /* provide a method to return the value of cell[i][j] in order to
    check for a win or a draw;     */
    public char getCellValues() {

    }
}
