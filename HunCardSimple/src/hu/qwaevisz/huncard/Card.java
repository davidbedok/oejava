package hu.qwaevisz.huncard;

import java.util.Random;

public class Card {

	private final CardRank rank;
	private final CardSuit suit;

	public Card(CardRank rank, CardSuit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int value() {
		return this.rank.getValue() * this.suit.getValue();
	}

	public static Card randomCard(Random rand) {
		return new Card(CardRank.randomRank(rand), CardSuit.randomSuit(rand));
	}

	@Override
	public String toString() {
		return ("Card: [" + this.suit + "-" + this.rank + "] value: " + this.value());
	}

}
