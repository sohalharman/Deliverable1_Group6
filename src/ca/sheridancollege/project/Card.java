/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * @author Harmandeep Singh Sohal, Date: 16 June, 2023
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Harmandeep Singh Sohal, Date: 16 June, 2023
 */
public class Card {
    //default modifier for child classes
    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    
    private Suit suit;
    private Value value;
    
    // Constructor
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    // Getters for suit and value
    public Suit getSuit() {
        return this.suit;
    }

    public Value getValue() {
        return this.value;
    }
    
    // Setters for suit and value
    public void setSuit(Suit suit){
        this.suit = suit;
    }
    
    public void setValue(Value value){
        this.value = value;
    }
}
