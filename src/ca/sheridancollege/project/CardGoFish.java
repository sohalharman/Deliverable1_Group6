package ca.sheridancollege.project;

/**
 * This class extends the Card class for our GoFish game. We are extending the Card class 
 * because there are many card games and we want loose coupling for this game so that other
 * developers can extend this Code with their own card games. In this class we will be using
 * a standard deck of 52 cards. We will be implementing the overridden toString method here.
 * @author Harmandeep Singh Sohal
 */
class CardGoFish extends Card {
    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    //default modifier for child classes
    Suit suit;
    Value value;
    
    // Constructor 
    public CardGoFish(Suit suit, Value value){
        super();
        this.suit = suit;
        this.value = value;
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
    
    // Method to print the Value and Suit in a Card
    @Override
    public String toString(){
        return "[" + ConsoleTextColour.ANSI_YELLOW + value + ConsoleTextColour.ANSI_RESET + "] of [" + ConsoleTextColour.ANSI_YELLOW + suit + ConsoleTextColour.ANSI_RESET + "]\n";
    }
}
