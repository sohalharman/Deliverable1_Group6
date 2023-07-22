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
        Scanner in = new Scanner(System.in);
        for(int i=0; i!=num; i++){
            System.out.print("Enter name for Player " + (i+1) + " :");
            String playerName = in.nextLine();
            System.out.println();
            goFishPlayers.add(new GoFishPlayer(playerName, 0));
        }
        
    }
    
        
    public void dealCards(){
        drawPile = new GroupOfCards(52);
        
        System.out.println("Creating a deck of all cards...");
        drawPile.createDeck();
        System.out.println("Dealing 5 cards to each of the Players...\n");
        for(int i=0; i!=5*numPlayers;i++){
            goFishPlayers.get(i%(numPlayers)).addCard(drawPile.getCards().get(51 - i));
            drawPile.removeCard();
        }
        
    }
    
    @Override
    public void play(){
        dealCards();
        for(int i=0; drawPile.getSize()!=0; i++){
            goFishPlayers.get(i%numPlayers).play();
            printPlayers();
            int playerSelectedIndex = selectPlayer();
            
            System.out.println();
        }
    }
    
    /**
     * This private helper method Prints the name of all the Players in the current Game
     */
    private void printPlayers(){
        System.out.println("Here is a list of all players: ");
        for(int j=0; j!=numPlayers; j++){
            System.out.println(goFishPlayers.get(j).getName());
        }
        System.out.println();
    }
    
    /**
     * This private helper method asks the current player to select a Player to ask for a card by his/her name and
     * returns the index of the player selected by the current Player who is playing.
     */
    private int selectPlayer(){
        int playerSelectedIndex = -1;
        while(true){
            Scanner in = new Scanner(System.in);
            System.out.print("Choose the player you want to ask for a card: ");
            String name = in.nextLine();
            boolean playerFound = false;

            for(int k=0; k<numPlayers ; k++){
                if(name.equalsIgnoreCase(goFishPlayers.get(k).getName())){
                    playerSelectedIndex = k;
                    playerFound = true;
                    break;
                }
            }

            if(!playerFound) {
                System.out.println("There is no player in the game with the name " + name + ". Please try again!!!\n");
            } 
            else {
                System.out.println();
                break;
            }
        }
        return playerSelectedIndex;
    }
    
    @Override
    public void declareWinner(){
        
    }
    
    /**
     * This overridden toString method prints the list of all the players in the GoFish game along with the cards that they
     * currently hold and also prints all the cards in the draw Pile.
     */
    @Override
    public String toString(){
        String out = "There are " + numPlayers + " players in the GoFish game\n\n" +  "List of Players in GoFish Game along with the cards:\n";
        for(int i=0; i!=numPlayers; i++){
            out += goFishPlayers.get(i).getName() + " : " + goFishPlayers.get(i).getPlayerCards().toString() + "\n";
        }
        
        out += "Draw Pile " + drawPile.toString();
        return out;
    }
}
