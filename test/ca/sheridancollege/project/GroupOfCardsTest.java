/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Harmandeep Singh Sohal
 */
public class GroupOfCardsTest {
    
    public GroupOfCardsTest() {
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
        GroupOfCards group = new GroupOfCards(10);
        assertNotNull(group);
        assertEquals(10, group.getSize());
    }

    @Test
    public void testConstructor_isBoundary() {
        GroupOfCards group = new GroupOfCards(0);
        assertNotNull(group);
        assertEquals(0, group.getSize());
    }

    @Test
    public void testConstructor_isBad() {
        GroupOfCards group = new GroupOfCards(-1);
        assertNotNull(group);
        assertEquals(-1, group.getSize());
    }

    @Test
    public void testGetCards_isGood() {
        GroupOfCards group = new GroupOfCards(0);
        assertNotNull(group.getCards());
    }

    // There's no boundary or bad scenario for getCards, as it simply returns the card list

    @Test
    public void testShuffle_isGood() {
        GroupOfCards group = new GroupOfCards(0);
        group.createDeck();
        ArrayList<Card> original = new ArrayList<>(group.getCards());

        group.shuffle();

        // Check if the deck is shuffled by comparing it to the original deck
        assertNotEquals(original, group.getCards());
    }

    // Shuffle doesn't have any bad or boundary scenarios as it just shuffles the existing deck

    @Test
    public void testGetSize_isGood() {
        GroupOfCards group = new GroupOfCards(0);
        assertEquals(0, group.getSize());
    }
    
    // There's no boundary or bad scenario for getSize, as it simply returns the size

    @Test
    public void testSetSize_isGood() {
        GroupOfCards group = new GroupOfCards(0);
        group.setSize(10);
        assertEquals(10, group.getSize());
    }

    @Test
    public void testSetSize_isBoundary() {
        GroupOfCards group = new GroupOfCards(0);
        group.setSize(0);
        assertEquals(0, group.getSize());
    }

    @Test
    public void testSetSize_isBad() {
        GroupOfCards group = new GroupOfCards(0);
        group.setSize(-1);
        assertEquals(-1, group.getSize());
    }
    
    @Test 
    public void testAddCardTop_isGood() {
        GroupOfCards group = new GroupOfCards(0);
        group.addCardTop(new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE));

        assertEquals(1, group.getSize());
        assertEquals(CardGoFish.Suit.HEARTS, ((CardGoFish)group.getCards().get(0)).getSuit());
        assertEquals(CardGoFish.Value.ACE, ((CardGoFish)group.getCards().get(0)).getValue());
    }

    @Test
    public void testAddCardTop_isBoundary() {
        GroupOfCards group = new GroupOfCards(0);
        group.addCardTop(null);

        assertEquals(1, group.getSize());
        assertNull(group.getCards().get(0));
    }

    @Test
    public void testAddCardTop_isBad() {
        GroupOfCards group = new GroupOfCards(-1);
        group.addCardTop(new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE));

        assertEquals(0, group.getSize());
    }

    @Test
    public void testRemoveCard_isGood() {
        GroupOfCards group = new GroupOfCards(0);
        group.addCardTop(new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE));

        assertEquals(1, group.getSize());

        group.removeCard();

        assertEquals(0, group.getSize());
    }

    @Test
    public void testRemoveCard_isBoundary() {
        GroupOfCards group = new GroupOfCards(0);

        group.removeCard();

        assertEquals(0, group.getSize());
    }

    @Test
    public void testRemoveCard_isBad() {
        GroupOfCards group = new GroupOfCards(-1);

        group.removeCard();

        assertEquals(-1, group.getSize());
    }

    @Test
    public void testCreateDeck_isGood() {
        GroupOfCards group = new GroupOfCards(52);
        group.createDeck();

        assertEquals(52, group.getSize());
    }

    @Test
    public void testCreateDeck_isBoundary() {
        GroupOfCards group = new GroupOfCards(0);
        group.addCardTop(new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE));
        group.createDeck();

        // If createDeck() does not clear the group before adding cards, 
        // the size will be 53 instead of 52.
        assertNotEquals(53, group.getSize());
    }

    @Test
    public void testCreateDeck_isBad() {
        GroupOfCards group = new GroupOfCards(-1);
        group.createDeck();

        // If the group size is less than 0 before calling createDeck(), 
        // the size should not be 52 after calling createDeck().
        assertNotEquals(52, group.getSize());
    }
}
