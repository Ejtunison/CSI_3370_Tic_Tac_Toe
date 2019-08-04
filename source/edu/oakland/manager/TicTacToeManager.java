package edu.oakland.helper;

import edu.oakland.production.*;
import java.util.*;
import java.util.Scanner;

public class TicTacToeManager
{
	//reference variables for subsystem
	private static TTTDisplay display;
	private static TTTMiddleware middleware;
	private static TTTDatabase database;
	private Scanner scanner;
	private String currentPlayer;
	private char currentPlayerMark;
	private boolean isWinOrDrawResult;

	public static void main(String[] args)
	{
		//create instance of the TTTManager;
		TicTacToeManager manager = new TicTacToeManager();
		database = new TTTDatabase();
		middleware = new TTTMiddleware(database);
		display = new TTTDisplay(middleware);

		//launch and initialize all TTTgame clases;
		manager.launchApp();

		manager.chooseSquare();
	}

	public void launchApp()
	{
		//launch & initialize database, make sure all cells are empty
		//launch & initialize middleware, pass database reference
		//launch & initialize display, pass middleware reference

		display.gameWelcome();

		currentPlayerMark = display.changePlayer('X');
	}

	//Provide method to select board square
	public void chooseSquare()
	{
		/*Use the scanner class to request the first player's input from the
		command line, including "Player1" or "Player2", & currentPlayerMark
		either 'X' or 'O';*/

		selectMove();

		checkForWinOrDraw();

		printCurrentBoard();

		chooseSquare();
	}

	//provide method to choose board move
	public void selectMove()
	{
		display.placeMarkOnBoard(currentPlayerMark);
	}

	//Provide method to check for win or draw, if none, changes player
	public void checkForWinOrDraw()
	{
		isWinOrDrawResult = display.checkForWinOrDraw();

		if(!isWinOrDrawResult)
		{
			changePlayers();
		}
		else
		{
			launchApp();
		}
	}


	//provide method to print board status
	public void printCurrentBoard()
	{
		display.printCurrentBoard();
	}

	//provide method to change players if no win or draw
	public void changePlayers()
	{
		display.changePlayer(currentPlayerMark);

		//loop back to the chooseSquare() method;
		chooseSquare();
	}
}
