package edu.oakland.production;

import java.io.IOException;
import java.util.Scanner;

public class TTTDisplay {

    private TTTMiddleware middleware;
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


        do {
            System.out.print("\nEnter number of players (1 or 2) :: ");
            numberOfPlayers = sc.nextInt();

            if (numberOfPlayers == 1) {
            	System.out.println("\nOne player game against computer feature not currently implemented, select 2 players, please.");
            }
            else {
                System.out.println("\nERROR: " + numberOfPlayers + " is an invalid number of players.");
            }
        }
        while (numberOfPlayers != 2);

        sc.close();
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

        System.out.print("\nPlayer " + currentPlayerMark + "\'s Turn: Select an empty cell to place your mark in (Ex. B2) :: ");
		Scanner scanner = new Scanner(System.in);
        boolean hasPlacedMark = false;
        do {
            String cell = scanner.nextLine().toUpperCase();
            char rowChar = cell.charAt(0);
            int rowNumber;

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

            /* positionSelected returns True if a mark has been placed on the board
               (input was valid) and False if not (invalid) */
            hasPlacedMark = middleware.positionSelected(rowNumber, columnNumber, currentPlayerMark);
            if(!hasPlacedMark) {
                System.out.println("Error: Mark has already been placed there or invalid input. Try again, Player " + currentPlayerMark + " :: ");
            }
        }
        while(!hasPlacedMark);

        scanner.close();
    }

    public boolean checkForWinOrDraw() {
        isWinOrDraw = middleware.getResults();
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
