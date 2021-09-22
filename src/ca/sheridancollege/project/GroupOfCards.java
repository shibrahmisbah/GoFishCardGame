/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 * Modified by: Vincent Ursino (991608156) on Monday, April 19, 2021
 * Modified by: Shibrah Misbah (991593708) on Monday, April 19, 2021
 * Modified by: Zain Iqbal (991612243) on Monday, April 19, 2021
 * Modified by: Hardeep Kaur (991603024) on Monday, April 19, 2021
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <GoFishCard> cards;
    private int size;//the size of the grouping
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<GoFishCard> showCards()
    {
        return cards;
    }
    
    public void setCards(ArrayList<GoFishCard> list) {
        cards = list;
    }
    
    public static ArrayList<GoFishCard> takeRandomCards(int numCards, ArrayList<GoFishCard> otherDeck) {
        ArrayList<GoFishCard> takenCards = new ArrayList<GoFishCard>(numCards);
        
        for (int i = 0; i < numCards; i++) {
            takenCards.add(otherDeck.get(0));
            otherDeck.remove(0);
        }
        
        return takenCards;
    }
    
    public String goFish(ArrayList<GoFishCard> remainingPile) {
        String cardName = remainingPile.get(0).toString();
        showCards().add(remainingPile.get(0));
        remainingPile.remove(0);
        
        return cardName;
    }
    
    public ArrayList<GoFishCard> containsRank(String rank) {
        ArrayList<GoFishCard> matchingCards = new ArrayList<GoFishCard>();
        
        for (GoFishCard card : this.cards) {
            if (card.getRank().toLowerCase().equals(rank.toLowerCase()))
                matchingCards.add(card);
        }
        
        return matchingCards;
    }
    
    public static String checkForMatch(String playerID, GroupOfCards deck) {
        int aces = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;
        int sevens = 0;
        int eights = 0;
        int nines = 0;
        int tens = 0;
        int jacks = 0;
        int queens = 0;
        int kings = 0;
        
        for (GoFishCard card : deck.showCards()) {
            switch(card.getRank()) {
                case "Ace":
                    aces++;
                    
                    if (aces == 4) {
                        if (playerID == "Player")
                            System.out.println("You made an Aces match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made an Aces match! They will be removed from their inventory.\n\n\n\n\n");
                        return "Ace";
                    }
                    
                    break;
                    
                case "2":
                    twos++;
                    
                    if (twos == 4) {
                        if (playerID == "Player")
                            System.out.println("You made a Twos match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made a Twos match! They will be removed from their inventory.\n\n\n\n\n");
                        return "2";
                    }
                    
                    break;
                    
                case "3":
                    threes++;
                    
                    if (threes == 4) {
                        if (playerID == "Player")
                            System.out.println("You made a Threes match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made a Threes match! They will be removed from their inventory.\n\n\n\n\n");
                        return "3";
                    }
                    
                    break;
                    
                case "4":
                    fours++;
                    
                    if (fours == 4) {
                        if (playerID == "Player")
                            System.out.println("You made a Fours match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made a Fours match! They will be removed from their inventory.\n\n\n\n\n");
                        return "4";
                    }
                    
                    break;
                    
                case "5":
                    fives++;
                    
                    if (fives == 4) {
                        if (playerID == "Player")
                            System.out.println("You made a Fives match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made a Fives match! They will be removed from their inventory.\n\n\n\n\n");
                        return "5";
                    }
                    
                    break;
                    
                case "6":
                    sixes++;
                    
                    if (sixes == 4) {
                        if (playerID == "Player")
                            System.out.println("You made a Sixes match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made a Sixes match! They will be removed from their inventory.\n\n\n\n\n");
                        return "6";
                    }
                    
                    break;
                    
                case "7":
                    sevens++;
                    
                    if (sevens == 4) {
                        if (playerID == "Player")
                            System.out.println("You made a Sevens match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made a Sevens match! They will be removed from their inventory.\n\n\n\n\n");
                        return "7";
                    }
                    
                    break;
                    
                case "8":
                    eights++;
                    
                    if (eights == 4) {
                        if (playerID == "Player")
                            System.out.println("You made an Eights match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made an Eights match! They will be removed from their inventory.\n\n\n\n\n");
                        return "8";
                    }
                    
                    break;
                    
                case "9":
                    nines++;
                    
                    if (nines == 4) {
                        if (playerID == "Player")
                            System.out.println("You made a Nines match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made a Nines match! They will be removed from their inventory.\n\n\n\n\n");
                        return "9";
                    }
                    
                    break;
                    
                case "10":
                    tens++;
                    
                    if (tens == 4) {
                        if (playerID == "Player")
                            System.out.println("You made a Tens match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made a Tens match! They will be removed from their inventory.\n\n\n\n\n");
                        return "10";
                    }
                    
                    break;
                    
                case "Jack":
                    jacks++;
                    
                    if (jacks == 4) {
                        if (playerID == "Player")
                            System.out.println("You made a Jacks match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made a Jacks match! They will be removed from their inventory.\n\n\n\n\n");
                        return "Jack";
                    }
                    
                    break;
                    
                case "Queen":
                    queens++;
                    
                    if (queens == 4) {
                        if (playerID == "Player")
                            System.out.println("You made a Queens match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made a Queens match! They will be removed from their inventory.\n\n\n\n\n");
                        return "Queen";
                    }
                    
                    break;
                    
                case "King":
                    kings++;
                    
                    if (kings == 4) {
                        if (playerID == "Player")
                            System.out.println("You made a Kings match! They will be removed from your inventory.\n\n\n\n\n");
                        else
                            System.out.println("Your opponent made a Kings match! They will be removed from their inventory.\n\n\n\n\n");
                        return "King";
                    }
                    
                    break;
            }
        }
        
        return "None";
    }
    
    public boolean isEmpty() {
        return showCards().isEmpty();
    }
    
    public static ArrayList<GoFishCard> getFullDeck() {
        ArrayList<GoFishCard> fullDeck = new ArrayList<GoFishCard>(52);
        
        for (int i = 0; i < 4; i++) {
            String suit = new String();
            
            switch(i) {
                case 0:
                    suit = "Clubs";
                    break;
                    
                case 1:
                    suit = "Diamonds";
                    break;
                    
                case 2:
                    suit = "Hearts";
                    break;
                    
                default:
                    suit = "Spades";
            }
            
            for (int j = 1; j <= 13; j++) {
                String rank = new String();
                
                switch(j) {
                    case 1:
                        rank = "Ace";
                        break;
                        
                    case 11:
                        rank = "Jack";
                        break;
                        
                    case 12:
                        rank = "Queen";
                        break;
                        
                    case 13:
                        rank = "King";
                        break;
                        
                    default:
                        rank = Integer.toString(j);
                }
                
                if (rank != null)
                    fullDeck.add(new GoFishCard(rank, suit));
                
            }
        }
        
        return fullDeck;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }
    
}//end class
