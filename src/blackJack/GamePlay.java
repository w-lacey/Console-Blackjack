package blackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class GamePlay {
	
	final Player player = new Player(false);
	final Player dealer = new Player(false);
	Player currentPlayer;
	final Deck deck = new Deck();
	final Scanner input = new Scanner(System.in);
	
	public void gameLoop() {
		//noinspection InfiniteLoopStatement
		while(true) {
			
			if(player.getStaying() && dealer.getStaying()){
				checkWinner();
			}
			else if(currentPlayer == player) {
				if(player.getStaying()) {
					currentPlayer = dealer;
					dealerTurn();
				}
				else {
					playerTurn();
				}
			}else if(currentPlayer == dealer) {
				if(dealer.getStaying()) {
					currentPlayer = player;
					playerTurn();
				}
				else {
					dealerTurn();
				}
			}
		}
	}
	
	public void gameSetup() {
		player.setPlayerHand(deck.dealCard());
		dealer.setPlayerHand(deck.dealCard());
		player.setPlayerHand(deck.dealCard());
		dealer.setPlayerHand(deck.dealCard());
		currentPlayer = player;
	}
	public void playerTurn() {
		player.displayHand();
		System.out.println(player.getHandValue());
		System.out.println("Hit or stay?: ");
		String hitOrStay = input.nextLine();
		
		if(hitOrStay.equals("hit")){
			System.out.println("You draw a card!");
			player.setPlayerHand(deck.dealCard());
		}
		else if (hitOrStay.equals("stay")) {
			System.out.println("You stay!");
			player.setStaying(true);
		}
	currentPlayer = dealer;	
	}
	
	public void dealerTurn() {
		if(dealer.getHandValue() <= 15) {
			System.out.println("Dealer draws");
			dealer.setPlayerHand(deck.dealCard());
		}
		else if(dealer.getHandValue() > 21) {
			dealer.setStaying(true);
		}
		else {
			System.out.println("dealer stays!");
			dealer.setStaying(true);
		}
		currentPlayer = player;
	}
	public void checkWinner() {
		System.out.println("Player hand value: " + player.getHandValue());
		System.out.println("Dealer hand value: " + dealer.getHandValue());
		if(dealer.getHandValue() > 21 || dealer.getHandValue() < player.getHandValue()) {
			if(player.getHandValue() <= 21) {
				System.out.println("PLAYER WINS");
			}
			else {
				System.out.println("DEALER WINS");
			}
		}
		else if(dealer.getHandValue() > player.getHandValue()){
				System.out.println("DEALER WINS");
		}
		else{
			System.out.println("DRAW!!");
		}System.exit(0);
	}
		
}

