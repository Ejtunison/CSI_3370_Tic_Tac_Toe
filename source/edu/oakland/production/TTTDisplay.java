package edu.oakland.production;

import java.io.IOException;

public class TTTDisplay {

    private TTTMiddleware middleware;
    private int rowNumber;
    private int columnNumber;
    private char playerMark;
    private char[][]boardStatus;
    private boolean isWinOrDraw;
    
    TTTDisplay(TTTMiddleware ref) {
        middleware = ref;
    }

    public void gameWelcome() {

    	printCurrentBoard();
    	
        Scanner sc = new Scanner(System.in);
        String prompt = "Welcome to Tic-Tac-Toe. Would you like to start a new game? Enter Yes or No ";
        String newGame = "";
        int numberOfPlayers = 0;

        System.out.println(prompt);

        newGame = sc.nextLine();
        
        newGame = newGame.toLowerCase();

        if (newGame.equals("no")){
            System.exit(0);
        }

        System.out.println("Enter number of players. Enter 1 or 2: ");
        numberOfPlayers = sc.nextInt();
        
        do {
            System.out.println("You entered an invalid number of player. ");
            System.out.println("Enter number of players. Enter 1 or 2: ");
            numberOfPlayers = sc.nextInt();
        } while (numberOfPlayers > 2);
        
        middleware.requestNewGame();
    
    }

    public void printCurrentBoard() {

        board = middleware.getBoard();

        try {        
            if( System.getProperty( "os.name" ).startsWith( "Window" ) )
            Runtime.getRuntime().exec("cls");
        else
            Runtime.getRuntime().exec("clear");
        }

        catch (IOException e) {
            for(int i = 0; i < 1000; i++) {
             System.out.println();
        } }
                
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("| ############ CSI3370 Summer 2019 - Tic Tac Toe ############ |");        
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|       Current Board          |        Coordinate Guide      |");
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                              |                              |");
        
        for(int i = 0; i < 3; i++) 
        {
            System.out.print("|         ");
                
            for(int j = 0; j < 3; j++) 
            {
                if (j != 2)
                {
                    System.out.print(board[i][j] + " | ");
                }
 
               else 
                {
                    if (i == 0)
                    {
                        System.out.print(board[i][j] + "            |         A0 | A1 | A2         |");
                    }
                    
                    else if (i == 1)
                    {
                        System.out.print(board[i][j] + "            |         B0 | B1 | B2         |");
                    }
                    
                    else
                    {
                        System.out.print(board[i][j] + "            |         C0 | C1 | C2         |");
                    }
                }
            }
        
            System.out.println();

            if (i != 2) 
            {
                System.out.println("|        -----------           |         --------------       |");
            }            
            else
            {
                System.out.println("|                              |                              |");
            }

        System.out.println("+-------------------------------------------------------------+");
        
        }
    }

    public void placeMarkOnBoard(int row, int column, char mark) {
        rowNumber = row;
        columnNumber = column;
        playerMark = mark;
        middleware.positionSelected(rowNumber, columnNumber, playerMark);

        if (middleware.isValid() == false) {    		
    		 System.out.println("Invalid move (Mark has already been placed there). Try again - Enter a char for row, 'A', 'B', or 'C' and Enter an int for column, '1', '2', or '3':");
    		 Scanner in = new Scanner(System.in);
    		 String input = in.nextLine();
    		 char row = input.charAt(0);
    		 int column = Integer.parseInt("" + input.chartAt(1));
    		
            placeMarkOnBoard(row, column, playerMark);    		    		
        }
    }

    public boolean checkforWinOrDraw() {
        isWinOrDraw = middleware.getResults();
        return isWinOrDraw;
    }

    public void displayBoardStatus(){

        middleware.requestPrintBoardStatus();
    }

    public void changePlayer(char mark) {
        playerMark = mark;
        middleware.changeActivePlayer(playerMark);
    }
}
