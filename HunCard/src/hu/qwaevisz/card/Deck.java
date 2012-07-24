package hu.qwaevisz.card;

import java.util.Random;

public class Deck extends java.lang.Object {

	public static final int NUM_OF_CARDS = CardSuit.values().length * CardRank.values().length;
	public static final int NUM_ROTATE = 100;

	private final Card[] cards;
	private int topcardindex;

	public Deck() {
		this.cards = new Card[Deck.NUM_OF_CARDS];
		this.init();
	}

	protected void init() {
		int i = 0;
		for (CardSuit suit : CardSuit.values()) {
			for (CardRank rank : CardRank.values()) {
				this.cards[i++] = new Card(suit, rank);
			}
		}
		this.topcardindex = 0;
	}

	private void changeCards(int indexA, int indexB) {
		Card tmp = this.cards[indexA];
		this.cards[indexA] = this.cards[indexB];
		this.cards[indexB] = tmp;
	}

	public void rotate() {
		this.rotate(Deck.NUM_ROTATE);
		// Collections.shuffle(deck);
	}

	public void rotate(int time) {
		Random rand = new Random();
		for (int i = 0; i < time; i++) {
			this.changeCards(rand.nextInt(Deck.NUM_OF_CARDS), rand.nextInt(Deck.NUM_OF_CARDS));
		}
		this.topcardindex = 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(500);
		sb.append("###############################################\n");
		sb.append("Cards:\n");
		for (int i = 0; i < Deck.NUM_OF_CARDS; i++) {
			sb.append("[").append(i + 1).append("] ").append(this.cards[i]).append("\n");
		}
		sb.append("###############################################\n");
		return sb.toString();
	}

	public Card getTopCard() {
		if (this.topcardindex >= Deck.NUM_OF_CARDS) {
			this.rotate(Deck.NUM_ROTATE);
			// this is not too realistic..
		}
		return this.cards[this.topcardindex++];
	}

}
