package blackJack;

import java.util.ArrayList;

public class Player {
	
	final ArrayList<Card> playerHand;
	boolean busted;
	boolean staying;
	
	public boolean getStaying() {
		return staying;
	}

	public void setStaying(boolean staying) {
		this.staying = staying;
	}

	Player(boolean busted){
		this.playerHand = new ArrayList<Card>();
		this.busted = busted;
	}
	
	public boolean getBusted() {
		return busted;
	}
	public void setBusted(boolean busted) {
		this.busted = busted;
	}

	public ArrayList<Card> getPlayerHand() {
		return playerHand;
	}
	public void setPlayerHand(Card card) {
		this.playerHand.add(card);
	}
	public int getHandValue() {
		int handValue = 0;
		for(Card card : playerHand) {
			handValue += card.getRank().getCardValue();	
		}
		return handValue;
	}
	public void displayHand() {
		for(Card cards : playerHand) {
			System.out.println(cards);
		}
	}
	
}
