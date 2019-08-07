package edu.oakland.test;
import org.junit.*;
import static org.junit.Assert.*;

//importing extra packages:
import edu.oakland.production.*;


public class MidTest {
	
	static int count;
	
	//Extra variables:
	private TTTDatabase database;
	private TTTMiddleware middleware;
    	private int rowNumber;
    	private int columnNumber;
    	private char[][] board;

	
	@BeforeClass
	public static void beforeClass() {
		count = 0;
	}
	
	
	@Before
	public void countUp() {
		count++;
	}
	
	
	@Test
	public void test01System() {
		
		//Create database and midware
		database = new TTTDatabase();
		middleware = new TTTMiddleware(database);
		
		//Initialize board and write a character to the first cell
		database.initializeBoard();
		System.out.println("Can we write to cell 0,0?: " + middleware.isValid(0, 0)); //should return false since X is in 0, 0
		System.out.println("Writing X to cell 0,0");
		database.writeToBoard(0, 0, 'X');
		board = database.printBoardStatus();
		
		//middleware checks if it's empty
		System.out.println("Can we write to cell now?: " + middleware.isValid(0, 0)); //should return false since X is in 0, 0
			
	}
	
	
	@Test
	public void test02System() {

	}
	
	@After
	public void testCleanup() {
		
	}
	
	
	@AfterClass
	public static void printCount() {
		System.out.println(count + " test(s) have been completed successfully.");
	}
}
