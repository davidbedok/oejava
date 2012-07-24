package hu.qwaevisz.card;

import java.util.Random;

public class Card extends java.lang.Object {

	private final CardSuit cardSuit;
	private final CardRank cardRank;

	public Card(CardSuit cardSuit, CardRank cardRank) {
		this.cardSuit = cardSuit;
		this.cardRank = cardRank;
	}

	public int getValue() {
		return (this.cardSuit.getValue() * this.cardRank.getValue());
	}

	@Override
	public String toString() {
		return ("Card: [" + this.cardSuit + "-" + this.cardRank + "] value: " + this.getValue());
	}

	public static Card getRandomCard() {
		Random rand = new Random();
		int randSuit = rand.nextInt(4);
		int randRank = rand.nextInt(8);
		CardSuit iCardSuit = CardSuit.fromOrder(randSuit);
		CardRank iCardRank = CardRank.fromOrder(randRank);
		return new Card(iCardSuit, iCardRank);
	}

}
