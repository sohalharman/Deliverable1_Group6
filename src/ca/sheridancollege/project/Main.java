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
        Game goFish = new GoFishGame(numPlayers);
        goFish.play();
    }
    
    /**
     * Helper method to get the number of Players from the user before the start of the game
     */
    public static int getNumberOfPlayers(){
        Scanner in = new Scanner(System.in);
        int num;
        while(true){
            System.out.print(ConsoleTextColour.ANSI_GREEN + "Please enter the number of players playing the game: " + ConsoleTextColour.ANSI_RESET);
            try{
                num = in.nextInt();
                if(num < 2 || num > 8){
                    String temp = ConsoleTextColour.ANSI_RED + "The Game can have minimum of "+ 
                                  ConsoleTextColour.ANSI_YELLOW + "[2]" + 
                                  ConsoleTextColour.ANSI_RED + " and maximum of " + 
                                  ConsoleTextColour.ANSI_YELLOW + "[8]" + 
                                  ConsoleTextColour.ANSI_RED + " Players only!!!\n" + ConsoleTextColour.ANSI_RESET;
                    System.out.println(temp);
                    continue;
                }
                break;
            }catch(InputMismatchException e){
                System.out.println(ConsoleTextColour.ANSI_RED + "Please enter an integer value!\n" + ConsoleTextColour.ANSI_RESET);
                in.nextLine();
            }
        }
        System.out.println();
        return num;
    }
}
