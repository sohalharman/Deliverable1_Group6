/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import static org.junit.Assert.*;

/**
 *
 * @author harry
 */
public class GoFishGameTest {
    
    public GoFishGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void tearDown() {
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    public void testIsBad() {
        // Simulate bad input for the game
        String input = "John\nJohn\nJane\n"; // Two players with the same name
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        GoFishGame game = new GoFishGame(2);
        assertTrue(outContent.toString().contains("You cannot enter the same name for two players"));
    }

    @Test
    public void testIsBoundary() {
        // Simulate boundary input for the game
        String input = "John\nJane\n"; // Just two players
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        GoFishGame game = new GoFishGame(2);
        assertEquals(2, game.getNumPlayers());
    }

    @Test
    public void testIsGood() {
        // Simulate good input for the game
        String input = "John\nJane\nJill\n"; // Three players
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        GoFishGame game = new GoFishGame(3);
        assertEquals(3, game.getNumPlayers());
        assertTrue(outContent.toString().contains("Enter name for Player 1"));
        assertTrue(outContent.toString().contains("Enter name for Player 2"));
        assertTrue(outContent.toString().contains("Enter name for Player 3"));
    }
    
}
