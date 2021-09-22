/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 * Modified by: Vincent Ursino (991608156) on Monday, April 19, 2021
 * Modified by: Shibrah Misbah (991593708) on Monday, April 19, 2021
 * Modified by: Zain Iqbal (991612243) on Monday, April 19, 2021
 * Modified by: Hardeep Kaur (991603024) on Monday, April 19, 2021
 */
public abstract class Card 
{
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    private String rank;
    private String suit;
    
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public String getRank() {
        return rank;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public void setRank(String rank) {
        this.rank = rank;
    }
    
    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    @Override
    public abstract String toString();
    
}
