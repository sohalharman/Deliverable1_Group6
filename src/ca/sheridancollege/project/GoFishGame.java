package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class +++ Insert class description here +++
 * @author Harmandeep Singh Sohal
 */
public class GoFishGame extends Game{
    final private int numPlayers;
    public GoFishGame(int num){
        super("GoFish");
        this.numPlayers = num;
        ArrayList<Player> players = new ArrayList<>();
        for(int i=0; i!=num; i++){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter name for Player " + (i+1) + " :");
            String playerName = in.nextLine();
            players.add(new GoFishPlayer(playerName));
        }
        setPlayers(players);
    }
    
    
    
    public void dealCards(){
        
    }
    
    @Override
    public void play(){
        
    }
    
    @Override
    public void declareWinner(){
        
    }
    
    @Override
    public String toString(){
        ArrayList<Player> players = getPlayers();
        String out = "There are " + numPlayers + " in the GoFish game\n" +  "List of Players in GoFish Game:\n";
        for(int i=0; i!=numPlayers; i++){
            out += players.get(i).getName();
            out += "\n";
        }
        return out;
    }
}
