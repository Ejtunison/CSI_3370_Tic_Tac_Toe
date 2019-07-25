package edu.oakland.production;

public class TTTDisplay {
    private TTTMiddleware middleware;
    private int rowNumber;
    private int columnNumber;
    private char playerMark;
    private char[][]boardStatus;
    private boolean isWinOrDraw;

    // constructor to receive TTTMiddleware ref;
    TTTDisplay(TTTMiddleware ref) {
        middleware = ref;
    }

    // provide method to place mark in cell;
    public void placeMarkOnBoard(int row, int column, char mark) {
        rowNumber = row;
        columnNumber = column;
        playerMark = mark;
        middleware.positionSelected(rowNumber, columnNumber, playerMark);

    }

    // provide method to get results of a check for win or draw;
    public boolean checkforWinOrDraw() {
        isWinOrDraw = middleware.getResults();
        return isWinOrDraw;
    }

    // provide method to print Board status;
    public void displayBoardStatus {

        middleware.requestPrintBoardStatus();
    }

    // provide a method to change active player;
    public void changePlayer(char mark) {
        playerMark = mark;
        middleware.changeActivePlayer(playerMark);
    }
}