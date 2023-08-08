package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;



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
            System.out.print(ConsoleTextColour.ANSI_CYAN + "Enter name for Player " + (i+1) + ": " + ConsoleTextColour.ANSI_RESET);
            String playerName = in.nextLine(); 
            boolean toContinue = false;
            for(int j=0; j!=goFishPlayers.size(); j++){
                if(goFishPlayers.get(j).getName().equalsIgnoreCase(playerName)){
                    System.out.println(ConsoleTextColour.ANSI_RED + "You cannot enter the same name for two players!!!" + ConsoleTextColour.ANSI_RESET + "\n");
                    toContinue = true;
                }
            }
            if(toContinue){
                i--;
                continue;
            }      
            System.out.println();
            goFishPlayers.add(new GoFishPlayer(playerName, 0));
        }
        
    }
    
    // Getters
    public int getNumPlayers(){
        return this.numPlayers;
    }
    
    public GroupOfCards getDrawPile(){
        return this.drawPile;
    }
    
    /**
     * In this method we first create a deck of cards and then deal 5 cards to each of the players 
     * and then the remaining cards will be left in drawPile variable.
     */ 
    void dealCards(){
        drawPile = new GroupOfCards(52);
        
        System.out.println(ConsoleTextColour.ANSI_YELLOW + "Creating a deck of all cards..." + ConsoleTextColour.ANSI_RESET);
        drawPile.createDeck();
        System.out.println(ConsoleTextColour.ANSI_YELLOW + "Dealing 5 cards to each of the Players...\n" + ConsoleTextColour.ANSI_RESET);
        for(int i=0; i!=5*numPlayers;i++){
            goFishPlayers.get(i%(numPlayers)).addCard(drawPile.getCards().get(51 - i));
            drawPile.removeCard();
        }
        
    }
    
    /**
     * This is welcome message that introduces the game when the user starts it
     */
    public void welcomeMessage(){
        System.out.println(ConsoleTextColour.ANSI_BLUE + "________________________________________________________________________________________" + ConsoleTextColour.ANSI_RESET);
        String text =  
                      "  ________         ___________.__       .__\n" +    
                      " /  _____/  ____   \\_   _____/|__| _____|  |__\n" +  
                      "/   \\  ___ /  _ \\   |    __)  |  |/  ___/  |  \\ \n" +
                      "\\    \\_\\  (  <_> )  |     \\   |  |\\___ \\|   Y  \\\n" +
                      " \\______  /\\____/   \\___  /   |__/____  >___|  /\n" +
                      "        \\/              \\/            \\/     \\/ ";

        final int consoleWidth = 80;
        String[] lines = text.split("\n");

        for (String line : lines) {
            int paddingSize = (consoleWidth - line.length()) / 2;
            for (int i = 0; i < paddingSize; i++) {
                System.out.print(" ");
            }
            System.out.println(ConsoleTextColour.ANSI_GREEN + line + ConsoleTextColour.ANSI_RESET);
        }
        System.out.println(ConsoleTextColour.ANSI_BLUE + "________________________________________________________________________________________" + ConsoleTextColour.ANSI_RESET);
        System.out.println("\n");
    }
    
    /**
     * This is the main method that will be called by the user to start the game. It contains the game logic.
     */
    @Override
    public void play(){
        welcomeMessage();
        dealCards();
        for(int i=0; drawPile.getSize()!=0; i++){
            int currentPlayerIndex = i%numPlayers;
            goFishPlayers.get(currentPlayerIndex).play();
            printPlayers(currentPlayerIndex);
            int playerSelectedIndex = selectPlayer(currentPlayerIndex);
            int cardChosen = askCard(currentPlayerIndex, playerSelectedIndex);
            
            boolean isGoFish = true;
            CardGoFish.Value valueChosen = ((CardGoFish)(goFishPlayers.get(currentPlayerIndex).getPlayerCards().getCards().get(cardChosen))).getValue();
            for(int j=0; j!=(goFishPlayers.get(playerSelectedIndex).getPlayerCards().getSize()) - 1; j++){
                CardGoFish.Value valuePlayerSelected = ((CardGoFish)(goFishPlayers.get(playerSelectedIndex).getPlayerCards().getCards().get(j))).getValue();
                if(valuePlayerSelected.equals(valueChosen)){
                    Card cardAsked = goFishPlayers.get(playerSelectedIndex).getPlayerCards().getCards().get(j);
                    System.out.println(goFishPlayers.get(playerSelectedIndex).getName() + " gave you " + cardAsked.toString());
                    goFishPlayers.get(currentPlayerIndex).getPlayerCards().addCardTop(cardAsked);
                    goFishPlayers.get(playerSelectedIndex).getPlayerCards().removeCard();
                    isGoFish = false;
                }
            }
            if(isGoFish){
                System.out.println("GO FISH!!!");
                Card drawPileCard = drawPile.getCards().get(drawPile.getSize() - 1);
                goFishPlayers.get(currentPlayerIndex).getPlayerCards().addCardTop(drawPileCard);
                drawPile.removeCard();
            }
            
            
            System.out.println();
        }
        declareWinner();
    }
    
    /**
     * This private helper method asks the current player to ask for any card from his Pile from the other Player he selected.
     * This method returns the index of the card in the Player's Pile of cards. The index starts from 1 not 0.
     */
    private int askCard(int currentPlayerIndex, int playerSelectedIndex){
        Scanner in = new Scanner(System.in);
        int cardChosenIndex;
        int numPlayerCards = 0;
        while(true){
            System.out.print("Please ask " + "[" + ConsoleTextColour.ANSI_PURPLE + goFishPlayers.get(playerSelectedIndex).getName() + ConsoleTextColour.ANSI_RESET + "]" + " for any card Value from your Pile by selecting its index: ");
            try{
                cardChosenIndex = in.nextInt();
                --cardChosenIndex;
                numPlayerCards = goFishPlayers.get(currentPlayerIndex).getPlayerCards().getSize();
                if(cardChosenIndex < 0 || cardChosenIndex >= numPlayerCards){
                    System.out.println(ConsoleTextColour.ANSI_RED + "Please chose a card Value index between 1 and " + numPlayerCards + "!!!\n" + ConsoleTextColour.ANSI_RESET);
                    continue;
                }
                break;
            }catch(InputMismatchException e){
                System.out.println(ConsoleTextColour.ANSI_RED + "Please enter an integer value!!!\n" + ConsoleTextColour.ANSI_RESET);
                in.nextLine();
            }
        }
        return cardChosenIndex;
    }
    
    /**
     * This private helper method Prints the name of all the Players in the current Game
     */
    private void printPlayers(int currentPlayerIndex){
        System.out.println("Here is a list of all players: ");
        for(int j=0; j!=numPlayers; j++){
            System.out.println((j+1) + ". " + ConsoleTextColour.ANSI_PURPLE + goFishPlayers.get(j).getName() + ConsoleTextColour.ANSI_RESET);
        }
        System.out.println();
        System.out.print("[" + ConsoleTextColour.ANSI_PURPLE + goFishPlayers.get(currentPlayerIndex).getName() + ConsoleTextColour.ANSI_RESET + "]" + ", please select a player to ask for a card from your group of cards: ");
    }
    
    /**
     * This private helper method asks the current player to select a Player to ask for a card by his/her name and
     * returns the index of the player selected by the current Player who is playing.
     */
    private int selectPlayer(int currentPlayerIndex){
        int playerSelectedIndex = -1;
        while(true){
            boolean playerSelectedSelf = false;
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            boolean playerFound = false;

            for(int k=0; k<numPlayers ; k++){
                if(name.equalsIgnoreCase(goFishPlayers.get(k).getName())){
                    if(k==currentPlayerIndex){
                        System.out.println(ConsoleTextColour.ANSI_RED + "You cannot choose yourself!!!\n");
                        System.out.print("[" + ConsoleTextColour.ANSI_PURPLE + goFishPlayers.get(currentPlayerIndex).getName() + ConsoleTextColour.ANSI_RESET + "]" + ", please select a player to ask for a card from your group of cards: ");
                        playerSelectedSelf = true;
                        break;
                    }
                    playerSelectedIndex = k;
                    playerFound = true;
                    break;
                }
            }

            if(playerSelectedSelf){
                continue;
            }
            if(!playerFound) {
                System.out.println(ConsoleTextColour.ANSI_RED + "There is no player in the game with the name " + name + ". Please try again!!!\n" + ConsoleTextColour.ANSI_RESET);
                System.out.print("[" + ConsoleTextColour.ANSI_PURPLE + goFishPlayers.get(currentPlayerIndex).getName() + ConsoleTextColour.ANSI_RESET + "]" + ", please select a player to ask for a card from your group of cards: ");
            } 
            else {
                System.out.println();
                break;
            }
        }
        return playerSelectedIndex;
    }
   
   // 
    
    
    
    
    
    private int calculateBooks(GoFishPlayer player) {
    int books = 0;
    GroupOfCards playerCards = player.getPlayerCards();

    // will put the occurences of each card into an array
    int[] Occurences = new int[CardGoFish.Value.values().length];
    
    
    for (Card card : playerCards.getCards()) {
        CardGoFish.Value value = ((CardGoFish) card).getValue();//to get the value of card
        Occurences[value.ordinal()]++;//will increment the value by one in the occurences array
    }

    // Count the number of books
    //sets of four
    for (int count : Occurences) {
        books += count / 4;
    }

    return books;
}
 @Override
public void declareWinner() {
    int maxBooks = -1; 
    GoFishPlayer winner = null;

    // with this for loop it will iterate over each player to find the number of books
    for (GoFishPlayer player : goFishPlayers) {
         
       int books = calculateBooks(player); 
     // if any player has more books than the maxBooks he will be declared winner
        if (books > maxBooks) {
            maxBooks = books;
            winner = player;
        
            //For the scenario when two or more players have books equal to manBooks
        } else if (books == maxBooks) {
        
            // current number of cards of the player
            //Book*4 means total book cards, (book has 4 cards)
            // minus it from total cards gives us current cards
          
            int currentCards = player.getPlayerCards().getSize() - (books * 4);
            
            // current number of cards of the winner
            int currentWinnerCards = winner.getPlayerCards().getSize() - (maxBooks * 4);

            if (currentCards > currentWinnerCards) {
                winner = player;
            }
        }
    }

    if (winner != null) {
        System.out.println("Congratulations, the winner is: " + winner.getName());
    } else {
        System.out.println("Nobody won this game.");
    }

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
