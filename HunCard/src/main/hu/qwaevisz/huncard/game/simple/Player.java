package hu.qwaevisz.huncard.game.simple;

import hu.qwaevisz.huncard.api.AbstractPlayer;
import hu.qwaevisz.huncard.api.IPlayer;
import hu.qwaevisz.huncard.common.Card;
import hu.qwaevisz.huncard.common.CardRank;
import hu.qwaevisz.huncard.common.CardSuit;

import java.util.Set;

public class Player extends AbstractPlayer {

	private final Card[]	cards;
	private int				cardIndex;

	public Player(String name) {
		super(name);
		this.cards = new Card[IPlayer.NUM_OF_PLAYER_CARDS];
		this.cardIndex = 0;
	}

	@Override
	public void addCard(Card card) {
		if (this.cardIndex < IPlayer.NUM_OF_PLAYER_CARDS) {
			this.cards[this.cardIndex++] = card;
		}
	}

	// not required
	public void addCard(CardSuit cardSuit, CardRank cardRank) {
		this.addCard(new Card(cardSuit, cardRank));
	}

	@Override
	public Set<Card> dropCards() {
		this.cardIndex = 0;
		return null;
	}

	// other way 1: return -1 if not enough cards
	// other way 2: throw NotEnoughCardsException (maybe a parameter, how many cards missing)
	@Override
	public int getCardsValue() {
		int ret = 0;
		for (int i = 0; i < this.cardIndex; ++i) {
			ret += this.cards[i].getValue();
		}
		return ret;
	}

	@Override
	public String toStringCards() {
		StringBuilder sb = new StringBuilder(500);
		for (int i = 0; i < this.cardIndex; i++) {
			sb.append("[").append(i + 1).append("] ").append(this.cards[i]).append("\n");
		}
		return sb.toString();
	}

}
