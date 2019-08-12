package edu.oakland.test;

import org.junit.*;
import static org.junit.Assert.*;
import edu.oakland.production.*;

public class DataTest {
	
	static int count;
	private int numberOfRow;
    private int numberOfColumn;
    private char typeOfMark;
    private static char[][] board;
    private char currentPlayerMark;
    
    
    @BeforeClass
    	public static void beforeClass() {
    		count = 0;
        }    
    
    @Before
   		 public void countUp() {
   		 	 count++;
   		 }
   
    
    @Test
   		 public void writeToBoard(){
   		 	 TTTDatabase database = new TTTDatabase();
   		 	 TTTMiddleware middleware = new TTTMiddleware(database);
             TTTDisplay display = new TTTDisplay(middleware);
   		 	 database.initializeBoard();
   		 	 System.out.println("Database's value at [1][1] = "+"'"+display.displayBoardStatus()[1][1]+"'");
   		 	 database.writeToBoard(1, 1, 'O');
   		 	 System.out.println("Database's value at [1][1] after attempt to write to board = "+"'"+display.displayBoardStatus()[1][1]+"'");
   		 }
        
    @After
   		 public void testCleanup() {
    	
   		 }    
    
    @AfterClass
   		 public static void printCount() {
   		 	 System.out.println(count + " test(s) have been completed successfully.");
   		 }
 
}
