package edu.oakland.production;

public class TTTMiddleware {

    private TTTDatabase database;
    private int rowNumber;
    private int colNumber;
    private char markChar; // X or O
    private boolean isBoardFull;
    private boolean isThereAWinOrDraw;
    private int turnNum;
    public TTTMiddleware(TTTDatabase ref) {
    	turnNum = 0;
        database = ref;
    }
    //Reset database with this function

    public void requestNewGame(){
    	//Need to null the database if playing a new game.

        //reset the turn counter for draws
  		turnNum = 0;

  		database.initializeBoard();
    }
    public void positionSelected(int rowValue, int colValue, char markValue) {
        rowNumber = rowValue;
        colNumber = colValue;
        markChar = markValue;
        database.writeToBoard(rowNumber, colNumber, markChar);

        turnNum++;
        if(turnNum > 8)
        {
    	checkForDraw();
    	}
    }
    /* provide method to check for win or draw; this involves
    (1) retrieving sets of all rows, columns and diagonal cells;
    (2) check each set for all cells containing the same player "mark"
    (3) if (1) & (2) above are false, check to see if Board is full
    which means a tie; all these conditions lead to "game over";     */
    public boolean getResults(){

        if (checkForWin() || checkForDraw()){
            return true;
        }

        return false;
    }

//        public boolean checkForWin(char[][] board) {

        public boolean checkForWin() {


      	    char[][]board;
        	board = database.printBoardStatus();

        	for(int i = 0; i < 2; i++){
    		    if(board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X'){
    				return true;
    		    }
    	    }

            for(int i = 0; i < 2; i++){
                if(board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O'){
                    return true;
                }
            }

    	    for(int j = 0; j < 2; j++){
                if(board[0][j] == 'X' &&  board[1][j] == 'X' && board[2][j] == 'X'){
                    return true;
                }
            }

            for(int j = 0; j < 2; j++){
                if(board[0][j] == 'O' &&  board[1][j] == 'O' && board[2][j] == 'O'){
                    return true;
                }
            }

    	    if(board[0][0] == 'X' &&  board[1][1] == 'X' && board[2][2] == 'X'){
                return true;
            }

            if(board[0][0] == 'O' &&  board[1][1] == 'O' && board[2][2] == 'O'){
                return true;
            }

    	    if(board[0][2] == 'X' &&  board[1][1] == 'X' && board[2][0] == 'X'){
    			return true;
    	    }

            if(board[0][2] == 'O' &&  board[1][1] == 'O' && board[2][0] == 'O'){
                return true;
            }


        return false;
    }

    public boolean checkForDraw()
    {
    	if(turnNum > 8)
    		return true;
    	else
    		return false;
    }
    // provide a method to print the Board status;
    public void requestPrintBoardStatus() {
    	database.printBoardStatus();
    }

    public char[][] getBoard(){
    	//Display Asked for this method to be impletemented
    	return database.printBoardStatus();
    }

    /*provide a method to change players; pass the mark of the
    current player; print the request for the next player with
    the opposite mark;     */
    public void changeActivePlayer(char mark) {
        /*provide Java code that will change the value of markChar based on
        move just made;         */
        markChar = mark;
        // provide Java code to print out who the next player will be;
        System.out.println("\n                   *** Player " + markChar + "'s turn *** ");
    }

    public boolean isValid(int i, int j)
    {
    	if(database.getCellValues(i,j) == 'X' || database.getCellValues(i,j) == 'O')
    	{
    		return false;
    	}
    	else
    	{
    	return true;
    	}
    }
}
