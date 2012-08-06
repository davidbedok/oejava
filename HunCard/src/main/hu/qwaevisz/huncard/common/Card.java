package hu.qwaevisz.huncard.common;

import java.util.Random;

public class Card extends java.lang.Object {

	private final CardSuit	cardSuit;
	private final CardRank	cardRank;

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

	@Override
	public int hashCode() {
		return this.cardSuit.getHungarianName().hashCode() * this.cardRank.getLabel().hashCode();
	}

	@Override
	public boolean equals(Object othat) {
		if (this == othat) {
			return true;
		}
		// if ( (othat != null) && (!(othat.getClass() == this.getClass())) ) {
		if (!(othat instanceof Card)) {
			// explict check for "that == null" !! --> "null instanceof [type]" always returns false
			return false;
		}
		Card that = (Card) othat;
		if ((this.cardRank.equals(that.cardRank)) && this.cardSuit.equals(that.cardSuit)) {
			return true;
		}
		return false;
	}

	public static Card getRandomCard(Random rand) {
		return new Card(CardSuit.randomSuit(rand), CardRank.randomRank(rand));
	}

}
