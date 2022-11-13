package blackJack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private final ArrayList<Card> deck;
	
	Deck(){
		
		this.deck = new ArrayList<Card>();
		
		for(Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				Card card = new Card(rank, suit);
				deck.add(card);
			}
			Collections.shuffle(deck);
		}
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	public Card dealCard() {
		return deck.remove(0);
	}
}
