package edu.oakland.production;

import java.io.IOException;
import java.util.Scanner;

public class TTTDisplay {

    private TTTMiddleware middleware;
    private char[][]board;
    private boolean isWinOrDraw;
    private boolean isWin;
    private boolean isDraw;
    private char playerMark;

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


        do {
            System.out.print("\nEnter number of players (1 or 2) :: ");
            numberOfPlayers = sc.nextInt();

            if (numberOfPlayers == 1) {
            	System.out.println("\nOne player game against computer feature not currently implemented, select 2 players, please.");
            }
            else if (numberOfPlayers == 2) {
            	break;
            }
            else {
                System.out.println("\nERROR: " + numberOfPlayers + " is an invalid number of players.");
            }
        }
        while (numberOfPlayers != 2);
        
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

    /*
    Method that prompts the given player to choose a cell to put their mark in.
    It is the central 'move' function of the game for Display.
    */
    public void placeMarkOnBoard(char currentPlayerMark) {
    	
    	Scanner scan = new Scanner(System.in);
    	String cell = "";
    	char rowChar;
        int rowNumber;
        int columnNumber;
        boolean validMove = false;
                
    	do {
        
            do {
        
                System.out.print("\nSelect an empty cell to place your mark in (A0, B2...) :: ");
        
                cell = scan.nextLine();
                cell = cell.toUpperCase();
            
                rowChar = cell.charAt(0);

                switch (rowChar) {
                    case 'A': rowNumber = 0;
                                break;
                    case 'B': rowNumber = 1;
                                break;
                    case 'C': rowNumber = 2;
                                break;
                    default:  rowNumber = -1;
                                break;
                }

                columnNumber = Character.getNumericValue(cell.charAt(1));
            
                if ((rowNumber < 0 || rowNumber > 2) || (columnNumber < 0 || columnNumber > 2)) 
                {
                    System.out.println("\nERROR: " + cell + " is an invalid selection.");
                }            
            
            } while ((rowNumber < 0 || rowNumber > 2) || (columnNumber < 0 || columnNumber > 2));
        
        
            validMove = middleware.isValid(rowNumber, columnNumber);
            
            if (validMove == false)
            {
                System.out.println("\nERROR: " + cell + " already has a value.");
            }
        
        } while (validMove == false);
        
        middleware.positionSelected(rowNumber, columnNumber, currentPlayerMark);

    }

/*    public boolean checkForWinOrDraw() {
        isWinOrDraw = middleware.getResults();
        return isWinOrDraw;
    }
 */

    public boolean checkForWin() {
        isWin = middleware.checkForWin();
        return isWin;
    }
    
    public boolean checkForDraw() {
        isDraw = middleware.checkForDraw();
        return isDraw;
    }

    public char[][] displayBoardStatus(){

        return middleware.getBoard();
    }

    public char changePlayer(char mark) {
 
    	playerMark = mark;
    	
    	if (playerMark == 'X') {
			playerMark = 'O';
		}
		else {
			playerMark = 'X';
		}
    	
        middleware.changeActivePlayer(playerMark);
        return playerMark;
    }
}