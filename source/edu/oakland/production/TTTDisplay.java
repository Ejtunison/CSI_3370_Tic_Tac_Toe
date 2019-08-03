package edu.oakland.production;

import java.io.IOException;
import java.util.Scanner;

public class TTTDisplay {

    private TTTMiddleware middleware;
    private int rowNumber;
    private int columnNumber;
    private char playerMark;
    private char[][]board;
    private boolean isWinOrDraw;
    
    public TTTDisplay(TTTMiddleware ref) {
        middleware = ref;
    }

    public void gameWelcome() {

    	middleware.requestNewGame();
    	        
    	printCurrentBoard();
    	
        Scanner sc = new Scanner(System.in);
        String prompt = "\nWelcome to CSI3370 Summer 2019 Tic Tac Toe!\n\nWould you like to start a new game (yes/no)? :: ";
        String newGame = "";
        int numberOfPlayers = 0;

        System.out.print(prompt);

        newGame = sc.nextLine();
        
        newGame = newGame.toLowerCase();

        if (! newGame.equals("yes")){
        	System.out.println("\nExiting...\n");
            System.exit(0);
        }
        
        System.out.print("\nEnter number of players (1 or 2) :: ");
        numberOfPlayers = sc.nextInt();

        if (numberOfPlayers == 1) {
          	System.out.println("\nOne player game against computer feature not currently implemented, select 2 players, please.");
        }
          	
        while (numberOfPlayers != 2) {
            System.out.println("\nERROR: " + numberOfPlayers + " is an invalid number of players.");
            System.out.print("\nEnter number of players (1 or 2) :: ");
            numberOfPlayers = sc.nextInt();
            
            if (numberOfPlayers == 1) {
            	System.out.println("\nOne player game against computer feature not currently implemented, select 2 players, please.");
            }   
        }        
    }

    public void printCurrentBoard() {

        board = middleware.getBoard();        
                
        System.out.println();
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

        }

        System.out.println("+-------------------------------------------------------------+");       
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
    		 row = input.charAt(0);
    		 column = Integer.parseInt("" + input.charAt(1));
    		
            placeMarkOnBoard(row, column, playerMark);    		    		
        }
    }

    public boolean checkForWinOrDraw() {
        isWinOrDraw = middleware.checkForWin();
        return isWinOrDraw;
    }

    public void displayBoardStatus(){

        middleware.requestPrintBoardStatus();
    }

    public char changePlayer(char mark) {
        playerMark = mark;
        middleware.changeActivePlayer(playerMark);
        return playerMark;
    }
}