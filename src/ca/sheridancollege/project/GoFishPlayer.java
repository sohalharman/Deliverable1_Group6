package ca.sheridancollege.project;

/**
 * This class +++ Insert class description here +++
 * @author Harmandeep Singh Sohal
 */
public class GoFishPlayer extends Player{
    private GroupOfCards cards;
    
    public GoFishPlayer(String name, int n){
        super(name);
        cards = new GroupOfCards(n);
    }
    
    public GroupOfCards getPlayerCards(){
        return cards;
    }
    
    public void addCard(Card card1){
        cards.addCardTop(card1);
    }
    
    @Override
    public void play(){
        System.out.println("It is " + getName() + "'s turn");
        System.out.print("Here are the cards you have. ");
        System.out.println(cards.toString());
        System.out.print("Select a player to ask for a card from your group of cards. ");
    }
    
    
}
