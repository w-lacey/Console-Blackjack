package blackJack;

public class Card {
	
	final Rank rank;
	final Suit suit;
	
	Card(Rank rank, Suit suit){
		this.suit = suit;
		this.rank = rank;
	}
	public Rank getRank() {
	    return rank;
	}

}
	
	

