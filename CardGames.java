package cardgames;
/*
*FOR NOW, this class is being used just to test the small parts of engine
*/
public class CardGames {

    public static void main(String[] args) {
        //Test of 20 random cards
        for(int i = 0; i < 20; i++){
            try{
                Card cardDefault = new Card();
                System.out.printf("SUIT: %s\n TYPE: %s\n FULL CARD: %s\n",
                    cardDefault.getSuit(),
                    cardDefault.getType(),
                    cardDefault.getCardAsString());
            } catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }        
        }
    }
}
