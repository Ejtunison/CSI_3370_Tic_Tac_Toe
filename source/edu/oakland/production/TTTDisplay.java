package edu.oakland.production;

public class TTTDisplay {
    private TTTMiddleware middleware;
    private int rowNumber;
    private int columnNumber;
    private char playerMark;
    private char[][]boardStatus;
    private boolean isWinOrDraw;
    
    /* TODO: --*/

    // constructor to receive TTTMiddleware ref from Manager Class;
    TTTDisplay(TTTMiddleware ref) {
        middleware = ref;
    }

    /* Provide method to place mark in cell
     * Params:
     *      row: player input
     *      coulum: player input
     *      mark: player input
     */
    public void placeMarkOnBoard(int row, int column, char mark) {
        rowNumber = row;
        columnNumber = column;
        playerMark = mark;
        middleware.positionSelected(rowNumber, columnNumber, playerMark);

    }

    /* Provide method to get results of a check for win or draw;
     * Calls Middleware to check game status
     */
    public boolean checkforWinOrDraw() {
        isWinOrDraw = middleware.getResults();
        return isWinOrDraw;
    }

    // provide method to print Board status;
    public void displayBoardStatus(){

        middleware.requestPrintBoardStatus();
    }

    // provide a method to change active player;
    public void changePlayer(char mark) {
        playerMark = mark;
        middleware.changeActivePlayer(playerMark);
    }
}