package ca.sheridancollege.project;

/**
 * This class +++ Insert class description here +++
 * @author Harmandeep Singh Sohal
 */
public class GoFishPlayer extends Player{
    // This variable will hold all the cards that are held by any player at a given time
    private GroupOfCards cards;
    
    // Constructor for the class
    public GoFishPlayer(String name, int n){
        super(name);
        cards = new GroupOfCards(n);
    }
    
    // Getter: To get all the cards held by a player at any given time
    public GroupOfCards getPlayerCards(){
        return cards;
    }
    
    // Method to add a card to the cards already held by a player
    public void addCard(Card card1){
        cards.addCardTop(card1);
    }
    
    /**
     * This method is called inside GoFishGame play method. It basically tells the user which Player's turn is it.
     * It also tells the user the list of all the cards they have so that they can ask any other player for a card
     * from their Pile
     */
    @Override
    public void play(){
        System.out.println("It is " + getName() + "'s turn");
        System.out.print("Here are the cards you have. ");
        System.out.println(cards.toString());
        System.out.print("Select a player to ask for a card from your group of cards. ");
    }
    
    
}
