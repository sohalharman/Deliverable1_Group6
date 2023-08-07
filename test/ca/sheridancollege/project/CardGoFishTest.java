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
public class CardGoFishTest {

    @Test
    public void testConstructor_isGood() {
        CardGoFish card = new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE);

        assertNotNull(card);
        assertEquals(CardGoFish.Suit.HEARTS, card.getSuit());
        assertEquals(CardGoFish.Value.ACE, card.getValue());
    }

    @Test
    public void testConstructor_isBad() {
        CardGoFish card = new CardGoFish(null, null);

        assertNotNull(card);
        assertNull(card.getSuit());
        assertNull(card.getValue());
    }

    @Test
    public void testSetSuit_isGood() {
        CardGoFish card = new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE);
        card.setSuit(CardGoFish.Suit.CLUBS);

        assertEquals(CardGoFish.Suit.CLUBS, card.getSuit());
    }

    @Test
    public void testSetSuit_isBad() {
        CardGoFish card = new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE);
        card.setSuit(null);

        assertNull(card.getSuit());
    }

    @Test
    public void testSetValue_isGood() {
        CardGoFish card = new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE);
        card.setValue(CardGoFish.Value.KING);

        assertEquals(CardGoFish.Value.KING, card.getValue());
    }

    @Test
    public void testSetValue_isBad() {
        CardGoFish card = new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE);
        card.setValue(null);

        assertNull(card.getValue());
    }

    @Test
    public void testToString_isGood() {
        CardGoFish card = new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE);
        String expected = "[" + ConsoleTextColour.ANSI_YELLOW + CardGoFish.Value.ACE + ConsoleTextColour.ANSI_RESET + "] of [" + ConsoleTextColour.ANSI_YELLOW + CardGoFish.Suit.HEARTS + ConsoleTextColour.ANSI_RESET + "]\n";

        assertEquals(expected, card.toString());
    }

    @Test
    public void testToString_Boundary() {
        for (CardGoFish.Suit suit : CardGoFish.Suit.values()) {
            for (CardGoFish.Value value : CardGoFish.Value.values()) {
                CardGoFish card = new CardGoFish(suit, value);

                String expected = "[" + ConsoleTextColour.ANSI_YELLOW + value + ConsoleTextColour.ANSI_RESET + "] of [" + ConsoleTextColour.ANSI_YELLOW + suit + ConsoleTextColour.ANSI_RESET + "]\n";
                assertEquals(expected, card.toString());
            }
        }
    }

    @Test
    public void testToString_isBad() {
        CardGoFish card = new CardGoFish(CardGoFish.Suit.HEARTS, CardGoFish.Value.ACE);
        card.setSuit(null);
        card.setValue(null);

        String expected = "[" + ConsoleTextColour.ANSI_YELLOW + "null" + ConsoleTextColour.ANSI_RESET + "] of [" + ConsoleTextColour.ANSI_YELLOW + "null" + ConsoleTextColour.ANSI_RESET + "]\n";
        assertEquals(expected, card.toString());
    }
}