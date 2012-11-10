package hu.qwaevisz.huncard;

import java.util.Random;

public class Deck {

	private static final int ROTATE_NUM = 100;
	private final Random rand;
	private final Card[] cards;
	private int topCardIndex;

	public Deck(Random rand) {
		this.rand = rand;
		CardRank[] cardRanks = CardRank.values();
		CardSuit[] cardSuits = CardSuit.values();
		this.cards = new Card[cardRanks.length * cardSuits.length];
		int index = 0;
		for (CardSuit suit : cardSuits) {
			for (CardRank rank : cardRanks) {
				this.cards[index++] = new Card(rank, suit);
			}
		}
		this.topCardIndex = 0;
	}

	public Card topCard() {
		Card card = null;
		if (this.topCardIndex < this.cards.length) {
			card = this.cards[this.topCardIndex++];
		}
		return card;
	}

	private void changeCards(int indexA, int indexB) {
		Card card = this.cards[indexA];
		this.cards[indexA] = this.cards[indexB];
		this.cards[indexB] = card;
	}

	public void rotate() {
		this.topCardIndex = 0;
		int size = this.cards.length;
		for (int i = 0; i < Deck.ROTATE_NUM; i++) {
			this.changeCards(this.rand.nextInt(size), this.rand.nextInt(size));
		}
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		info.append("Deck:\n");
		for (int i = 0; i < this.cards.length; i++) {
			info.append(this.cards[i]);
			if (i == this.topCardIndex) {
				info.append(" <-- top card");
			}
			info.append("\n");
		}
		return info.toString();
	}

}
