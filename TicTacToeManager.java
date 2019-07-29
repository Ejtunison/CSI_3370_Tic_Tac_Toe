package edu.oakland.helper;

import edu.oakland.production.*;
import java.util.*;

public class TicTacToeManager
{
	//reference variables for subsystem
	private TTTDisplay display;
	private TTTMiddleware middleware;
	private TTTDAtabase database;
	private Scanner scanner;
	private String currentPlayer;
	private char currentPlayerMark;
	private boolean isWinOrDrawResult;
	
	public static void main(String[] args)
	{
		//create instance of the TTTManager;
		TicTacToeManager manager = new TicTacToeManager();
		
		//launch and initialize all TTTgame clases;
		manager.launchApp();
		
		manager.chooseSquare();
	}
	
	public void launchApp()
	{
		//launch & initialize database, make sure all cells are empty
		//launch & initialize middleware, pass database reference
		//launch & initialize display, pass middleware reference
	}
	
	//Provide method to select board square
	public void chooseSquare()
	{
		/*Use the scanner class to request the first player's input from the
		command line, including "Player1" or "Player2", & currentPlayerMark 
		either 'X' or 'O';*/
		
		printCurrentBoard();
		
		checkForWinorDraw();
	}
	
	//Provide method to check for win or draw, if none, changes player
	public void checkForWinOrDraw()
	{
		isWinOrDraw = display.checkForWinorDraw();
		if(!isWinOrDrawResult)
		{
			changePlayers();
		}
		else
		{	
			/*provide Java code to print either a win or draw to the command
			line and game over - restart*/
		}
	}
	
	//provide method to print board status
	public void printCurrentBoard()
	{
		//add java code
	}
	
	//provide method to change players if no win or draw
	public void changePlayers()
	{
		display.changePlayer(currentPlayerMark);
		//loop back to the chooseSquare() method;
		chooseSquare();
	}
}