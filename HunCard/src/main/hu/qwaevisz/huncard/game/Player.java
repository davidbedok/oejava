package hu.qwaevisz.huncard.game;

import hu.qwaevisz.huncard.card.Card;
import hu.qwaevisz.huncard.card.CardRank;
import hu.qwaevisz.huncard.card.CardSuit;

public class Player extends java.lang.Object {

	public static final int	NUM_OF_PLAYER_CARDS	= 3;

	private final String	name;
	private final Card[]	cards;
	private int				cardnum;

	public Player(String name) {
		this.name = name;
		this.cards = new Card[Player.NUM_OF_PLAYER_CARDS];
		this.cardnum = 0;
	}

	public void addCard(Card card) {
		if (this.cardnum < Player.NUM_OF_PLAYER_CARDS) {
			this.cards[this.cardnum++] = card;
		}
	}

	public void addCard(CardSuit cardSuit, CardRank cardRank) {
		this.addCard(new Card(cardSuit, cardRank));
	}

	public void dropCards() {
		this.cardnum = 0;
	}

	public int getCardsValue() {
		int ret = 0;
		for (int i = 0; i < this.cardnum; ++i) {
			ret += this.cards[i].getValue();
		}
		return ret;
	}

	public String toPrint() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("Player " + this.name + ". ");
		sb.append("All card value: " + this.getCardsValue() + "\n");
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(500);
		sb.append("------------------------------------------------\n");
		sb.append(this.toPrint());
		for (int i = 0; i < this.cardnum; i++) {
			sb.append("[").append(i + 1).append("] ").append(this.cards[i]).append("\n");
		}
		sb.append("------------------------------------------------\n");
		return sb.toString();
	}

}
