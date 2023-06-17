/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * @author Harmandeep Singh Sohal, Date: 16 June, 2023
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Harmandeep Singh Sohal, Date: 16 June, 2023
 */
public class GroupOfCards extends Card{

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        super(null,null);
        this.size = size;
        cards = new ArrayList<>();
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Add a card to the cards list using this method
     * @param suitIndex - The index of the suit of the card
     * @param valueIndex - The index of the value of the card
     */
    public void addCard(int suitIndex, int valueIndex){
        Card cardTemp = new Card(Value.values()[valueIndex], Suit.values()[suitIndex]);
        cards.add(cardTemp);
    }
    
    /**
     * Remove a card from the cards List using this method
     */
    public void removeCard(){
        if(!cards.isEmpty()){
            cards.remove(cards.size()-1);
        }
    }
    
    /**
     * This method create a pack or deck of cards 
     */
    public void createPackOfCards(){
        for(int i=0; i != Suit.values().length ; ++i){
            for(int j=0; j!=Value.values().length; ++j){
                Card cardTemp = new Card(Value.values()[j], Suit.values()[i]);
                cards.add(cardTemp);
            }
        }
    }
    
    @Override
    public String toString(){
        String listOfCards = "This group of cards contain " + size + " cards.\n";
        for(Card card:cards){
            listOfCards += card.getSuit() + " of " + card.getValue() + "\n";
        }
        return listOfCards;
    }
    

}//end class
