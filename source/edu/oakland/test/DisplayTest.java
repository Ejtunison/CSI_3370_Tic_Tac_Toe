package edu.oakland.test;

import org.junit.*;
import static org.junit.Assert.*;
import edu.oakland.production.TTTDatabase;
import edu.oakland.production.TTTDisplay;
import edu.oakland.production.TTTMiddleware;



public class DisplayTest
{
    // instance variable go here;
    static int count;

    /* @BeforeClass executes once before the start of all @Tests;
    */

    @BeforeClass
    public static void beforeClass()
    {
        count = 0;
    }

    //Before runs before each @Test to
    //initailize all classes in the system being tested
    @Before
    public void countUp()
    {
        count++;
    }

    // @Test annotates each JUnite test to be run;
    // can be any number of tests;

    @Test
    public void placeMakerTest()
    {
        //write the test methods here;
        TTTDatabase database = new TTTDatabase();
        TTTMiddleware middleware = new TTTMiddleware(database);
        TTTDisplay display = new TTTDisplay(middleware);
        display.gameWelcome();
        display.placeMarkOnBoard('X');

        char[][] sample = new char[3][3];
        sample[0][0] = 'X';

        System.out.println("\nValue Of 'A0' sample[0][0] = " +"'"+ sample[0][0]+"'");
        System.out.println("Testing sample[0][0] with display's updated gameboard");
        System.out.println("Display's value at [0][0] = "+"'"+display.displayBoardStatus()[0][0]+"'");

        assertSame(sample[0][0], display.displayBoardStatus()[0][0]);
    
    }

    @Test
    public void testWin ()
    {
       //write the test methods here;
       TTTDatabase database = new TTTDatabase();
       TTTMiddleware middleware = new TTTMiddleware(database);
       TTTDisplay display = new TTTDisplay(middleware);
       display.gameWelcome();

       char[][] win = new char[3][3];
       //loads win
       for(int i=0; i <= 2; i++)
       {
            win[0][i] = 'X';
            database.writeToBoard(0, i, 'X');
       }
 

       System.out.println("\nTesting For A Win::\n[0][0] - " +"'"+ win[0][0]+"'"
       + " | [0][1] - " +"'"+ win[0][1]+"'" +" | [0][2] - " +"'"+ win[0][2]+"'");

       System.out.println("Is This Case A Win?:: "+display.checkForWin());

       assertTrue(display.checkForWin());
    }

    // @After executes after each test for cleanup
    // before teh next @Test

    @After
    public void testCleanup()
    {

    }
/* @AfterClass executes once after all
    @Tests have completed;
*/

    @AfterClass
    public static void printCount()
    {
        System.out.println(count + " test(s) have been completed successfully.");
    }

}