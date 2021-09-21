package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * The Go Fish game class, mainly handling user input and containing the Main method.
 * @author Vincent Ursino, 2021
 * @author Shibrah Misbah, 2021
 * @author Zain Iqbal, 2021
 * @author Hardeep Kaur, 2021
 */
public class GoFishGame extends Game {
    
    private GoFishPlayer player;
    private GoFishPlayer cpu;
    
    public GoFishGame(String givenName) {
        super(givenName);
    }
    
    @Override
    public void play() {
        // Generate a full deck of 52 cards and shuffle it
        GroupOfCards fullDeck = new GroupOfCards(52);
        fullDeck.setCards(GroupOfCards.getFullDeck());
        fullDeck.shuffle();
        
        // Generate a deck of 7 cards and assign it to the Player
        GroupOfCards playerDeck = new GroupOfCards(7);
        playerDeck.setCards(GroupOfCards.takeRandomCards(7, fullDeck.showCards()));
        player = new GoFishPlayer("Player");
        
        // Generate a deck of 7 cards and assign it to the CPU
        GroupOfCards cpuDeck = new GroupOfCards(7);
        cpuDeck.setCards(GroupOfCards.takeRandomCards(7, fullDeck.showCards()));
        cpu = new GoFishPlayer("CPU");
        
        // Initialize the remainingPile, opponentDeck, and playerDeck variables
        GoFishPlayer.setRemainingPile(fullDeck);
        GoFishPlayer.setOpponentDeck(cpuDeck);
        GoFishPlayer.setPlayerDeck(playerDeck);
        
        // Begin user I/O
        System.out.println("Welcome to Go Fish! Your deck of 7 cards is: ");
        System.out.println(playerDeck.showCards().toString() + "\n\n\n\n\n");
        
        // Pick random player to take the first turn
        int rand = (int) (Math.random() + 0.5);
        if (rand == 0)
            player.play(player.getPlayerID());
        else
            cpu.play(cpu.getPlayerID());
        
    }
    
    public static void declareWinner(String playerID, String officialStatus, int playerMatches, int cpuMatches) {
        if (playerID.equals("Player")) {
            if (officialStatus.equals("official"))
                System.out.println("You won! You made more matches than your opponent did! (Score: " + playerMatches + "-" + cpuMatches + ")");
            else
                System.out.println("You won! The remaining pile ran out of cards, but you made the most matches! (Score: " + playerMatches + "-" + cpuMatches + ")");
        } else {
            if (officialStatus.equals("official"))
                System.out.println("You lost! Your opponent made more matches than you did! (Score: " + playerMatches + "-" + cpuMatches + ")");
            else
                System.out.println("You lost! The remaining pile ran out of cards, but your opponent made the most matches! (Score: " + playerMatches + "-" + cpuMatches + ")");
        }
    }
    
    public static void declareDraw(String officialStatus, int matches) {
        if (officialStatus.equals("official"))
            System.out.println("There was a tie! You both made the same amount of matches! (Score: " + matches + "-" + matches + ")");
        else    
            System.out.println("There was a tie! The remaining pile ran out of cards, and you both made the same amount of matches! (Score: " + matches + "-" + matches + ")");
    }
    
    public static void main(String[] args) {
        GoFishGame game = new GoFishGame("Go Fish");
        Scanner sc = new Scanner(System.in);
        
        boolean playAgain = true;
        
        while (playAgain) {
            game.play();
            
            System.out.println("Would you like to play again? Please enter either 'y' or 'n'.");
            String ans;
            
            do {
                ans = sc.next();

                if (ans.equals("y") || ans.equals("n")) {
                    if (ans.equals("n"))
                        playAgain = false;
                    else
                        System.out.println("\n\n\n\n");
                } else
                    System.out.println("Error: Please enter either 'y' or 'n'!");
            } while (!ans.equals("y") && !ans.equals("n"));
        }
    }
    
}