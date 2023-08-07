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

/**
 * @author Harmandeep Singh Sohal
 */
public class GoFishPlayerTest {
    
    public GoFishPlayerTest() {
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

    @Test
    public void testConstructor_isGood() {
        GoFishPlayer player = new GoFishPlayer("Test Player", 0);

        assertNotNull(player);
        assertEquals("Test Player", player.getName());
        assertEquals(0, player.getPlayerCards().getSize());
    }

    @Test
    public void testConstructor_isBoundary() {
        GoFishPlayer player = new GoFishPlayer("", 0);

        assertNotNull(player);
        assertEquals("", player.getName());
        assertEquals(0, player.getPlayerCards().getSize());
    }

    @Test
    public void testConstructor_isBad() {
        GoFishPlayer player = new GoFishPlayer(null, -1);

        assertNotNull(player);
        assertNull(player.getName());
        assertEquals(-1, player.getPlayerCards().getSize());
    }

    @Test
    public void testAddCard_isGood() {
        GoFishPlayer player = new GoFishPlayer("Test Player", 0);
        player.addCard(new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE));

        assertEquals(1, player.getPlayerCards().getSize());
        assertEquals(CardGoFish.Suit.HEARTS, ((CardGoFish)player.getPlayerCards().getCards().get(0)).getSuit());
        assertEquals(CardGoFish.Value.ACE, ((CardGoFish)player.getPlayerCards().getCards().get(0)).getValue());
    }

    @Test
    public void testAddCard_isBoundary() {
        GoFishPlayer player = new GoFishPlayer("Test Player", 0);
        player.addCard(null);

        assertEquals(1, player.getPlayerCards().getSize());
        assertNull(player.getPlayerCards().getCards().get(0));
    }
    
    @Test
    public void testGetPlayerCards_isGood() {
        GoFishPlayer player = new GoFishPlayer("Test Player", 0);
        player.addCard(new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE));

        GroupOfCards playerCards = player.getPlayerCards();

        assertNotNull(playerCards);
        assertEquals(1, playerCards.getSize());
        assertEquals(CardGoFish.Suit.HEARTS, ((CardGoFish)playerCards.getCards().get(0)).getSuit());
        assertEquals(CardGoFish.Value.ACE, ((CardGoFish)playerCards.getCards().get(0)).getValue());
    }

    @Test
    public void testGetPlayerCards_isBoundary() {
        GoFishPlayer player = new GoFishPlayer("Test Player", 0);

        GroupOfCards playerCards = player.getPlayerCards();

        assertNotNull(playerCards);
        assertEquals(0, playerCards.getSize());
    }

    @Test
    public void testGetPlayerCards_isBad() {
        GoFishPlayer player = new GoFishPlayer("Test Player", -1);

        GroupOfCards playerCards = player.getPlayerCards();

        assertNotNull(playerCards);
        assertEquals(-1, playerCards.getSize());
    }

    
}
