package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models a specific Go Fish card.
 * @author Vincent Ursino, 2021
 * @author Shibrah Misbah, 2021
 * @author Zain Iqbal, 2021
 * @author Hardeep Kaur, 2021
 */
public class GoFishCard extends Card {
    
    public GoFishCard(String rank, String suit) {
        super(rank, suit);
    }
    
    @Override
    public String toString() {
        return getRank() + " of " + getSuit();
    }
    
    public static boolean validRank(String rank, ArrayList<GoFishCard> deck) {
        rank = rank.toLowerCase();
        
        if (!validInput(rank))
            return false;
        
        for (GoFishCard card : deck) {
            if (card.getRank().toLowerCase().equals(rank))
                return true;
            
        }
        
        return false;
    }
    
    private static boolean validInput(String rank) {
        switch(rank) {
            case "ace":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
            case "jack":
            case "queen":
            case "king":
                return true;
        }
        
        return false;
    }
    
}