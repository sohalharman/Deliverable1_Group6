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
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author harry
 */
public class MainTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testGetNumberOfPlayers_isGood() {
        ByteArrayInputStream in = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(in);
        assertEquals(5, Main.getNumberOfPlayers());
    }

    @Test
    public void testGetNumberOfPlayers_isBoundary() {
        ByteArrayInputStream in = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(in);
        assertEquals(3, Main.getNumberOfPlayers());
    }

    @Test
    public void testGetNumberOfPlayers_isBad() {
        ByteArrayInputStream in = new ByteArrayInputStream("bad\n3\n".getBytes());
        System.setIn(in);
        assertEquals(3, Main.getNumberOfPlayers());
        assertTrue(outContent.toString().contains("Please enter an integer value!"));
    }
    
}
