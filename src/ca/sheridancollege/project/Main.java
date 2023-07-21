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
         Scanner in = new Scanner(System.in);
         System.out.println("Please enter the number of players playing the game? 2, 3 or 4?");
         int numPlayers = 0;
         try{
             numPlayers = in.nextInt();
         }catch(InputMismatchException e){
             System.out.println("Please enter an integer value!");
         }
         
         GoFishGame goFish = new GoFishGame(numPlayers);
         goFish.dealCards();
         System.out.println(goFish.toString());
    }
}
