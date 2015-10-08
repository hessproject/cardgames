package cardgames;

import java.util.Random;

public class Card {
    private final String mCardType;
    private final String mCardSuit;
    
    public Card(){
        mCardType = setType(randomize("type"));
        mCardSuit = setSuit(randomize("suit"));
    }
    
    public Card (int cardType, int cardSuit){
        mCardType = setType(cardType);
        mCardSuit = setSuit(cardSuit);
    }
    
    private String setType(int type){
        String cardType;
        switch(type){
            case 0: cardType = "2";
                    break;
            case 1: cardType = "3";
                    break;
            case 2: cardType = "4";
                    break;
            case 3: cardType = "5";
                    break;
            case 4: cardType = "6";
                    break;
            case 5: cardType = "7";
                    break;
            case 6: cardType = "8";
                    break;
            case 7: cardType = "9";
                    break;
            case 8: cardType = "10";
                    break;
            case 9: cardType = "J";
                    break;
            case 10:cardType = "Q";
                    break;
            case 11:cardType = "K";
                    break;
            case 12:cardType = "A";
                    break;
            case 13:cardType = "Joker";
                    break;
            default: throw new IllegalArgumentException("Not a valid card type");
        }
        return cardType;
    } 
    
    private String setSuit(int suit){
        String cardSuit;
        switch(suit){
            case 0: cardSuit = "Clubs";
                break;
            case 1: cardSuit = "Diamonds";
                break;
            case 2: cardSuit = "Hearts";
                break;
            case 3: cardSuit = "Spades";
                break;
            default: throw new IllegalArgumentException ("Not a valid Suit");
        }
        return cardSuit;
    }
    
    public String getType(){
        return mCardType;
    }
    
    public String getSuit(){
        return mCardSuit;
    }
    
    public String getCardAsString(){
        return "The " + mCardType + " of " + mCardSuit;
    }
    
    private int randomize(String partOfCard){
        Random rn = new Random();
        switch (partOfCard) {
            case "type":
                return rn.nextInt(14);
            case "suit":
                return rn.nextInt(4);
            default: throw new IllegalArgumentException("Not a valid randomize selection");
        }
    }
}
    
