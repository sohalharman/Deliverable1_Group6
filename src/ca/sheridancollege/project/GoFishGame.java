package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class +++ Insert class description here +++
 * @author Harmandeep Singh Sohal
 */
public class GoFishGame extends Game{
    private int numPlayers;
    private GroupOfCards drawPile;
    private ArrayList<GoFishPlayer>goFishPlayers;
    
    public GoFishGame(int num){
        super("GoFish");
        this.numPlayers = num;
        goFishPlayers = new ArrayList<>();
        for(int i=0; i!=num; i++){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter name for Player " + (i+1) + " :");
            String playerName = in.nextLine();
            goFishPlayers.add(new GoFishPlayer(playerName, 5));
        }
    }
    
    
    
    public void dealCards(){
        drawPile = new GroupOfCards(52);
        
        System.out.println("Creating a deck of all cards...");
        drawPile.createDeck();
        System.out.println("Dealing 5 cards to each of the Players...");
        for(int i=0; i!=5*numPlayers;i++){
            goFishPlayers.get(i%(numPlayers-1)).addCard(drawPile.getCards().get(i));
            drawPile.removeCard();
        }
        
    }
    
    @Override
    public void play(){
        dealCards();
    }
    
    @Override
    public void declareWinner(){
        
    }
    
    @Override
    public String toString(){
        String out = "There are " + numPlayers + " in the GoFish game\n" +  "List of Players in GoFish Game along with the cards:\n";
        for(int i=0; i!=numPlayers; i++){
            out += goFishPlayers.get(i).getName() + " : " + goFishPlayers.get(i).getPlayerCards().toString() + "\n";
        }
        return out;
    }
}
