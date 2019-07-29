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
    //Reset database with this function
   
    public requestNewGame(){
    	//Need to null the database if playing a new game. 
    	//  public void writeToBoard(int row, int col, char mark) {
  		//Reset the board  	
    	for(int i = 0; i > 3; i++)
    	{
    		for(int c = 0; c > 3; c++)
    		{
    			database.writeToBoard(i, c, "-"); 
    		}
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
    public boolean checkForWinOrDraw(){
    // provide Java code to check for win or draw for all possibilities;
        isThereAWinOrDraw = false; //result of analysis
        return isThereAWinOrDraw;
    // provide Java code to print out win or draw; if neither, print nothing;
    // if win or draw, provide Java code to end game;
    }
    
    
        public boolean checkForWin() {
    	
    	for(int i = 0; i < 2; i++){
    		if(getCellValues(i,0).equals(getCellValues(i,1)) &&  getCellValues(i,1).equals(getCellValues(i,2)){
    				return true;
    		}
    	}
    	
    	for(int j = 0; j < 2; j++){
    		if(getCellValues(0,j).equals(getCellValues(1,j)) &&  getCellValues(1,j).equals(getCellValues(2,j)){
    				return true;
    		}
    	}
    	
    	if(getCellValues(0,0).equals(getCellValues(1,1)) &&  getCellValues(1,1).equals(getCellValues(2,2){
    			//return isThereAWin = true;
    			return true;
    	}
    	
    	if(getCellValues(0,2).equals(getCellValues(1,1)) &&  getCellValues(1,1).equals(getCellValues(2,0){
    			return true;
    	}
    	
    	//isThereAWin = false;
    	
        return false;
    // provide Java code to print out win or draw; if neither, print nothing;

    // if win or draw, provide Java code to end game;
    }

    public boolean checkForDraw(char[] board)
    {
    	int spaceHolder= 0; 
    	for(int i = 0; i > 3; i++)
    	{
    		for(int c = 0; c > 3; c++)
    		{
    			//check the space to see if filled 
    			//If filled spaceholder++; 
    			//Spaceholder == 9 means a draw 
    			if(board[i][c] == "-") //Char is the character array that we will get from database 
    				continue; 
    			else
    				spaceHolder++; 
    			
    			if(spaceHolder >= 9)
    				return true;
    				//add 1
    		}
    	}
    return false; 
    }
    // provide a method to print the Board status;
    public void requestPrintBoardStatus() {
    	database.printBoardStatus()
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