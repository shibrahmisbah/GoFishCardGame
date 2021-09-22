package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Go Fish Player class, handling all logic and behaviour of the players.
 * @author Vincent Ursino, 2021
 * @author Shibrah Misbah, 2021
 * @author Zain Iqbal, 2021
 * @author Hardeep Kaur, 2021
 */
public class GoFishPlayer extends Player {
    
    private static GroupOfCards playerDeck;
    private static GroupOfCards opponentDeck;
    private static GroupOfCards remainingPile;
    
    private int turnNum = 1;
    
    private int numPlayerMatches = 0;
    private int numOpponentMatches = 0;
    
    private boolean playerGoesAgain = false;
    private boolean opponentGoesAgain = false;
    
    public GoFishPlayer(String name) {
        super(name);
    }
    
    public static void setPlayerDeck(GroupOfCards deck) {
        playerDeck = deck;
    }
    
    public static void setOpponentDeck(GroupOfCards deck) {
        opponentDeck = deck;
    }
    
    public static void setRemainingPile(GroupOfCards deck) {
        remainingPile = deck;
    }
    
    @Override
    public void play(String playerID) {
        if (playerID.equals("CPU")) {    // Handle CPU logic
            do {
                System.out.println("[ TURN " + turnNum + " ]");
                System.out.println("It's your opponent's turn!");
                
                // Make the computer ask for a random card rank
                int rand = (int) (Math.random() * (opponentDeck.showCards().size()));
                String randRank = opponentDeck.showCards().get(rand).getRank();

                System.out.println("Your opponent asks you: Do you have any " + randRank + "s?");
                
                // Check whether the Player has any matching card ranks
                ArrayList<GoFishCard> containedCards = playerDeck.containsRank(randRank);
                if (containedCards.size() > 0) {    // Player has a matching card rank
                    System.out.println("You do! You hand over your " + randRank + "s to your opponent.");
                    System.out.println("\n\n\n\n");

                    for (GoFishCard card : containedCards) {
                        playerDeck.showCards().remove(card);
                        opponentDeck.showCards().add(card);
                    }
                    
                    checkForMatches();
                    
                    if (playerDeck.isEmpty() || opponentDeck.isEmpty()) {
                        if (numPlayerMatches > numOpponentMatches)
                            GoFishGame.declareWinner("Player", "official", numPlayerMatches, numOpponentMatches);
                        else if (numOpponentMatches > numPlayerMatches)
                            GoFishGame.declareWinner("CPU", "official", numPlayerMatches, numOpponentMatches);
                        else
                            GoFishGame.declareDraw("official", numPlayerMatches);
                        return;
                    }
                    
                    opponentGoesAgain = true;    // Since the CPU got their requested card rank, they get the next turn
                    
                } else {
                    System.out.println("Go Fish! Your opponent picks up a card.");
                    opponentDeck.goFish(remainingPile.showCards());
                    
                    opponentGoesAgain = false;    // Since the CPU did not get its requested card rank, the Player gets the next turn
                }
                
                turnNum++;
                
            } while (opponentGoesAgain);
            
        } else {    // Handle Player logic
            do {
                System.out.println("[ TURN " + turnNum + " ]");
                Scanner sc = new Scanner(System.in);

                System.out.println("It's your turn! Here's your current deck: ");
                System.out.println(playerDeck.showCards().toString());
                System.out.println("Which card rank would you like to ask for? (ex. ace, 1, 10, jack, queen, king, etc.)");
                
                // Prompt Player to pick a card rank to request from the CPU
                String requestedRank = sc.next();
                
                // Error handling, ensuring the Player can only pick a rank found in its deck
                while (!GoFishCard.validRank(requestedRank, playerDeck.showCards())) {
                    System.out.println("Error: Please enter a card rank which can be found in your deck!");
                    requestedRank = sc.next();
                }
                
                // Check whether the CPU has any matching card ranks
                ArrayList<GoFishCard> containedCards = opponentDeck.containsRank(requestedRank);
                if (containedCards.size() > 0) {    // Opponent has a matching card rank
                    System.out.println("Yes! The opponent has " + containedCards.size() + " of those cards! Here you go.");
                    System.out.println("\n\n\n\n");

                    for (GoFishCard card : containedCards) {
                        opponentDeck.showCards().remove(card);
                        playerDeck.showCards().add(card);
                    }
                    
                    checkForMatches();
                    
                    if (playerDeck.isEmpty() || opponentDeck.isEmpty()) {
                        if (numPlayerMatches > numOpponentMatches)
                            GoFishGame.declareWinner("Player", "official", numPlayerMatches, numOpponentMatches);
                        else if (numOpponentMatches > numPlayerMatches)
                            GoFishGame.declareWinner("CPU", "official", numPlayerMatches, numOpponentMatches);
                        else
                            GoFishGame.declareDraw("official", numPlayerMatches);
                        return;
                    }
                    
                    playerGoesAgain = true;    // Since the Player got their requested card rank, they get the next turn

                } else {
                    String cardName = playerDeck.goFish(remainingPile.showCards());
                    System.out.println("Go Fish! The opponent does not have any of those cards, so you must pick up a card.");
                    System.out.println("You picked up: " + cardName);
                    
                    playerGoesAgain = false;    // Since the Player did not get their requested card rank, the CPU gets the next turn
                }
                
                turnNum++;
                
            } while (playerGoesAgain);
        }
        
        System.out.println("\n\n\n\n");
        
        checkForMatches();
        
        if (playerDeck.isEmpty() || opponentDeck.isEmpty()) {
            if (numPlayerMatches > numOpponentMatches)
                GoFishGame.declareWinner("Player", "official", numPlayerMatches, numOpponentMatches);
            else if (numOpponentMatches > numPlayerMatches)
                GoFishGame.declareWinner("CPU", "official", numPlayerMatches, numOpponentMatches);
            else
                GoFishGame.declareDraw("official", numPlayerMatches);
            return;
        }
        
        // At the end of every turn, check if the remaining pile is empty
        if (remainingPile.isEmpty()) {    // Remaining pile is empty, so end the game
            if (numPlayerMatches > numOpponentMatches)
                GoFishGame.declareWinner("Player", "unofficial", numPlayerMatches, numOpponentMatches);
            else if (numOpponentMatches > numPlayerMatches)
                GoFishGame.declareWinner("CPU", "unofficial", numPlayerMatches, numOpponentMatches);
            else
                GoFishGame.declareDraw("unofficial", numPlayerMatches);
        } else {    // Remaining pile is not empty, so continue the game
            if (playerID.equals("Player"))
                play("CPU");
            else
                play("Player");
        }
        
    }
    
    private void checkForMatches() {
        String playerMatches = GroupOfCards.checkForMatch("Player", playerDeck);
        String cpuMatches = GroupOfCards.checkForMatch("CPU", opponentDeck);
        
        // Check for Player matches
        if (!playerMatches.equals("None")) {    // If there is a match, increment Player's match total
            numPlayerMatches++;
            
            // Remove the matched cards from Player's inventory
            ArrayList<GoFishCard> temp = new ArrayList<GoFishCard>();

            for (GoFishCard card : playerDeck.showCards()) {
                if (card.getRank().equals(playerMatches))
                    temp.add(card);
            }
            
            for (GoFishCard card : temp)
                playerDeck.showCards().remove(card);
        }
        
        // Check for CPU matches
        if (!cpuMatches.equals("None")) {    // If there is a match, increment CPU's match total
            numOpponentMatches++;
            
            // Remove the matched cards from CPU's inventory
            ArrayList<GoFishCard> temp = new ArrayList<GoFishCard>();

            for (GoFishCard card : opponentDeck.showCards()) {
                if (card.getRank().equals(cpuMatches))
                    temp.add(card);
            }
            
            for (GoFishCard card : temp)
                opponentDeck.showCards().remove(card);
        }
    }

}