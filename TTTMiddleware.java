package edu.oakland.production;

public class TTTMiddleware {

    private TTTDatabase dataBase;
    private int rowNumber;
    private int colNumber;
    private markChar; // X or O
    private boolean isBoardFull;
    private boolean isThereAWinOrDraw;

    public TTTMidleware(TTTDatabase ref) {
        dataBase = ref;
    }
    // method to select position;
    public void positionSelected(int rowValue, int colValue, char markValue) {
        rowNumber = rowValue;
        colNumber = colValue;
        markChar = markValue;
        dataBase.placeMarkAsSelected(rowNumber, colNumber, markChar);
    }
    /* provide method to check for win or draw; this involves
    (1) retrieving sets of all rows, columns and diagonal cells;
    (2) check each set for all cells containing the same player "mark"
    (3) if (1) & (2) above are false, check to see if Board is full
    which means a tie; all these conditions lead to "game over";     */
    public boolean checkForWinOrDraw() {
    // provide Java code to check for win or draw for all possibilities;
        isThereAWinOrDraw = false; //result of analysis
        return isThereAWinOrDraw;
    // provide Java code to print out win or draw; if neither, print nothing;

    // if win or draw, provide Java code to end game;
    }
    // provide a method to print the Board status;
    public void requestPrintBoardStatus() {

    }
    /*provide a method to change players; pass the mark of the
    current player; print the request for the next player with
    the opposite mark;     */
    public void changeActivePlayer(char mark) {
        /*provide Java code that will change the value of markChar based on
        move just made;         */
        markChar = mark;
        // provide Java code to print out who the next player will be;
        System.out.println("The next player will play " + markChar);
    }
}