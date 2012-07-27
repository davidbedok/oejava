package hu.qwaevisz.huncard.game;

import hu.qwaevisz.huncard.card.Card;
import hu.qwaevisz.huncard.card.CardRank;
import hu.qwaevisz.huncard.card.CardSuit;

public class Player extends java.lang.Object {

	public static final int	NUM_OF_PLAYER_CARDS	= 3;

	private final String	name;
	private final Card[]	cards;
	private int				cardIndex;

	public Player(String name) {
		this.name = name;
		this.cards = new Card[Player.NUM_OF_PLAYER_CARDS];
		this.cardIndex = 0;
	}

	public void addCard(Card card) {
		if (this.cardIndex < Player.NUM_OF_PLAYER_CARDS) {
			this.cards[this.cardIndex++] = card;
		}
	}

	// not required
	public void addCard(CardSuit cardSuit, CardRank cardRank) {
		this.addCard(new Card(cardSuit, cardRank));
	}

	public void dropCards() {
		this.cardIndex = 0;
	}

	// other way 1: return -1 if not enough cards
	// other way 2: throw NotEnoughCardsException (maybe a parameter, how many cards missing)
	public int getCardsValue() {
		int ret = 0;
		for (int i = 0; i < this.cardIndex; ++i) {
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
		for (int i = 0; i < this.cardIndex; i++) {
			sb.append("[").append(i + 1).append("] ").append(this.cards[i]).append("\n");
		}
		sb.append("------------------------------------------------\n");
		return sb.toString();
	}

}
