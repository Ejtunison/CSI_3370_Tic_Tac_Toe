package edu.oakland.helper;

public class GameBoard {

    private char[][] board;
    private char currentPlayerMark;

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();

        gameBoard.initializeBoard();

        gameBoard.printBoard();
    }
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
        public void printBoard() {
            System.out.println("--------------");
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " | ");
                }
                System.out.println();
                System.out.println("--------------");
            }
        }
}