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
    	//  public void writeToBoard(int row, int col, char mark) {
  		//Reset the board  
  		
  		database.initializeBoard(); 
  		//Commenting out code below due to it DB already having a wipe board function 

  		// method to select position;
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
    		    if(board[i][0] == board[i][1] && board[i][1]== board[i][2]){
    				return true;
    		    }
    	    }
    	
    	    for(int j = 0; j < 2; j++){
    		    if(board[0][j] == board[1][j] &&  board[1][j] == board[2][j]){
    				return true;
    		    }
    	    }
    	
    	    if(board[0][0] == board[1][1] &&  board[1][1] == board[2][2]){
    			//return isThereAWin = true;
    			return true;
    	    }
    	
    	    if(board[0][2] == board[1][1] &&  board[1][1] == board[2][0]){
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
        System.out.println("\n *** Player " + markChar + "'s turn *** ");
    }
    
    public boolean isValid(int i, int j)
    {	
    	if(database.getCellValues(i,j).equals('X') || database.getCellValues(i,j).equals('O'))
    	{
    		return false;	
    	}
    	else
    	{
    	return true;	
    	}
    }
}