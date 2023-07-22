package ca.sheridancollege.project;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class is the Main class which contains the main method. We are going to ask the
 * user the number of players. Max number of players is 4 and minimum number of players
 * is 2.
 * @author Harmandeep Singh Sohal
 */
public class Main {
    public static void main(String[]args){
        int numPlayers = getNumberOfPlayers();
        GoFishGame goFish = new GoFishGame(numPlayers);
        goFish.play();
    }
    
    /**
     * Helper method to get the number of Players from the user before the start of the game
     */
    private static int getNumberOfPlayers(){
        Scanner in = new Scanner(System.in);
        int num;
        while(true){
            System.out.print("Please enter the number of players playing the game?");
            try{
                num = in.nextInt();
                if(num < 2 || num > 8){
                    System.out.println("The Game can have minimum of 2 and maximum of 8 Players only!!!\n");
                    continue;
                }
                break;
            }catch(InputMismatchException e){
                System.out.println("Please enter an integer value!\n");
                in.nextLine();
            }
        }
        System.out.println();
        return num;
    }
}
