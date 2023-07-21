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
public class GroupOfCards{

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
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
     * Add a card of a to the end of the card List
     * @param card - The card to be added to the end of the list
     */
    public void addCardTop(Card card){
        cards.add(card);
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
    public void Deck(){
        for(int i=0; i != CardGoFish.Suit.values().length ; ++i){
            for(int j=0; j!=CardGoFish.Value.values().length; ++j){
                Card card = new CardGoFish(CardGoFish.Suit.values()[i], CardGoFish.Value.values()[j]);
                cards.add(card);
            }
        }
        shuffle();
    }
    
    /**
     * Here we are overriding toString method to get the list of all cards in the list
     * as a String
    **/
    @Override
    public String toString(){
        String listOfCards = "This group of cards contain " + size + " cards.\n";
        System.out.println("Here is the list of all the cards you have: ");
        for(Card card:this.cards){
            listOfCards += ((CardGoFish)card).getSuit() + " of " + ((CardGoFish)card).getValue() + "\n";
        }
        return listOfCards;
    }
    

}//end class
