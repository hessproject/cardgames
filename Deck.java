package cardgames;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private static final int MAX_CARDS = 56; //52 standard + 4 jokers per deck
    private ArrayList<Card> mDeckCards;
    private ArrayList<Card> mUsedCards;
    private int mCurrentCardsInDeck;
    
    public Deck(){
        populateStandardDeck(false);
    }
    
    public Deck(boolean includeJokers){
        populateStandardDeck(includeJokers);
    }   
    /*TODO: Add custom decks, like decks without certain suit or other customizations */
    private void populateStandardDeck(boolean includeJokers){
        if (includeJokers){
            mDeckCards = new ArrayList(MAX_CARDS);
            mUsedCards = new ArrayList(MAX_CARDS);
            addJokers();
        } else {
            mDeckCards = new ArrayList(52);
            mUsedCards = new ArrayList(MAX_CARDS);
        }
            for(int i=0; i <=3; i++){
                for(int y=0;y<=12;y++){
                    Card card = new Card(y,i);
                    mDeckCards.add(card);
                    mCurrentCardsInDeck++;
                }
            }
    }
    
    private void addJokers(){
        Card card = new Card(13,-1);//Jokers with null suit
        for(int i=0; i < 4; i++){
            mDeckCards.add(card);
        }
    }
    
    public int getCurrentCardsinDeck(){
        return mCurrentCardsInDeck;
    }
    
    public void shuffle(){
        Collections.shuffle(mDeckCards);
    }
    
    public Card dealCard(){
        if (!isEmpty()){
            Card card = mDeckCards.get(0);
            mDeckCards.remove(0);
            mUsedCards.add(card);
            mCurrentCardsInDeck--;
            System.out.printf("Card dealt: %s\n",card.toString());
            return card;
        } else {
            throw new IndexOutOfBoundsException("No cards in deck");
        }
    }
    
    public void replaceSingleCard(Card card){
        mUsedCards.remove(card);
        mDeckCards.add(card);
    }
    
    /**
     * Put all cards from mUsedCards back into deck
     */
    public void replaceAllCards(){
        //When using, be sure to check that card is not somewhere else, like in somebody's hand.
        mUsedCards.stream().forEach((card) -> {
            mDeckCards.add(card);
            System.out.printf("adding %s back to deck\n", card.toString());
        });
        mUsedCards.clear();
    }
    
    public boolean isEmpty(){
        return mDeckCards.size() < 0;
    }
    
}
