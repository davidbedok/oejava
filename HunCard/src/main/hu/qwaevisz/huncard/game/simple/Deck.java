package hu.qwaevisz.huncard.game.simple;

import hu.qwaevisz.huncard.api.AbstractDeck;
import hu.qwaevisz.huncard.api.IDeck;
import hu.qwaevisz.huncard.common.Card;
import hu.qwaevisz.huncard.common.CardRank;
import hu.qwaevisz.huncard.common.CardSuit;

import java.util.Random;
import java.util.Set;

public class Deck extends AbstractDeck {

	private final Card[]	cards;
	private int				topcardindex;

	public Deck(Random rand) {
		super(rand);
		this.cards = new Card[IDeck.NUM_OF_CARDS];
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

	@Override
	protected void changeCards(int indexA, int indexB) {
		Card tmp = this.cards[indexA];
		this.cards[indexA] = this.cards[indexB];
		this.cards[indexB] = tmp;
	}

	@Override
	public Card getTopCard() {
		if (this.topcardindex >= IDeck.NUM_OF_CARDS) {
			this.rotate();
			// this is not too realistic..
		}
		return this.cards[this.topcardindex++];
	}

	@Override
	public int getCardsCount() {
		return IDeck.NUM_OF_CARDS;
	}

	@Override
	public void backCard(Set<Card> playerCards) {
		this.topcardindex = 0;
	}

	@Override
	public String toStringCards() {
		StringBuilder sb = new StringBuilder(500);
		for (int i = 0; i < IDeck.NUM_OF_CARDS; i++) {
			sb.append("[").append(i + 1).append("] ").append(this.cards[i]).append("\n");
		}
		return sb.toString();
	}

}
