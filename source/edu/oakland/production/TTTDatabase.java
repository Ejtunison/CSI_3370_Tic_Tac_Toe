package edu.oakland.production;

public class TTTDatabase {

    private GameBoard gameBoard;
    private int numberOfRow;
    private int numberOfColumn;
    private char typeOfMark;
    private char[][] board;
    private char currentPlayerMark;

    /* positions on the GameBoard are indicated by "cell[i][j]" where
    "i" represents the row and "j" represents the column; rows and
    columns are indexed from [0] to [2]; therefore the center cell
    would be cell[1][1];     */


    //initialize board
    public void initializeBoard() {
            board = new char[3][3];
            // clear all values;
            // loop through rows;
            for(int i = 0; i < 3; i++) {
                // loop through columns;
                for(int j = 0; j < 3; j++) {
                    board[i][j] = '-';
                }
            }
        }
    
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
            System.out.println("--------------");
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " | ");
                }
                System.out.println();
                System.out.println("--------------");
            }
    }
    /* provide a method to return the value of cell[i][j] in order to
    check for a win or a draw;     */
    public char getCellValues(int row, int col) {
        return board[row][col];
    }

    // provide method to pass reference to board
    public char[2][2] printBoardStatus() {
        return board;
    }

    }
