package ca.sheridancollege.project;

/**
 * This class +++ Insert class description here +++
 * @author Harmandeep Singh Sohal
 */
public class GoFishPlayer extends Player{
    GroupOfCards cards;
    public GoFishPlayer(String name){
        super(name);
    }
    
    @Override
    public void play(){
        cards.toString();
        System.out.println("Select a player to ask for a card from your group of cards");
        
    }
}
