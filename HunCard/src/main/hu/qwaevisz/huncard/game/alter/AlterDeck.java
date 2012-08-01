package hu.qwaevisz.huncard.game.alter;

import hu.qwaevisz.huncard.api.AbstractDeck;
import hu.qwaevisz.huncard.common.Card;
import hu.qwaevisz.huncard.common.CardRank;
import hu.qwaevisz.huncard.common.CardSuit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class AlterDeck extends AbstractDeck {

	private final Stack<Card>	cards;

	public AlterDeck(Random rand) {
		super(rand);
		this.cards = new Stack<Card>();
		this.init();
	}

	protected void init() {
		for (CardSuit suit : CardSuit.values()) {
			for (CardRank rank : CardRank.values()) {
				this.cards.push(new Card(suit, rank));
			}
		}
	}

	@Override
	protected void changeCards(int indexA, int indexB) {
		Collections.swap(this.cards, indexA, indexB);
	}

	@Override
	public Card getTopCard() {
		Card topCard = null;
		if (!this.cards.isEmpty()) {
			topCard = this.cards.pop();
		}
		return topCard;
	}

	@Override
	public void backCard(Set<Card> playerCards) {
		for (Card card : playerCards) {
			this.cards.push(card);
		}
	}

	@Override
	public int getCardsCount() {
		return this.cards.size();
	}

	@Override
	public String toStringCards() {
		StringBuilder sb = new StringBuilder(500);
		List<Card> listOfCard = new ArrayList<Card>(this.cards);
		int i = 0;
		for (Card card : listOfCard) {
			sb.append("[").append(i + 1).append("] ").append(card).append("\n");
			i++;
		}
		return sb.toString();
	}

}
