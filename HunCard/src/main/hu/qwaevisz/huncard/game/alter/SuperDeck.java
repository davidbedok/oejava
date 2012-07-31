package hu.qwaevisz.huncard.game.alter;

import hu.qwaevisz.huncard.common.Card;
import hu.qwaevisz.huncard.common.CardRank;
import hu.qwaevisz.huncard.common.CardSuit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class SuperDeck extends java.lang.Object {

	public static final int		NUM_OF_CARDS	= CardSuit.values().length * CardRank.values().length;
	public static final int		NUM_ROTATE		= 100;

	private final Stack<Card>	cards;
	private final Random		rand;

	public SuperDeck(Random rand) {
		this.cards = new Stack<Card>();
		this.init();
		this.rand = rand;
	}

	protected void init() {
		int i = 0;
		for (CardSuit suit : CardSuit.values()) {
			for (CardRank rank : CardRank.values()) {
				this.cards.push(new Card(suit, rank));
			}
		}
	}

	private void changeCards(int indexA, int indexB) {
		Collections.swap(this.cards, indexA, indexB);
	}

	public void rotate() {
		this.rotate(SuperDeck.NUM_ROTATE);
	}

	public void rotate(int time) {
		for (int i = 0; i < time; i++) {
			this.changeCards(this.rand.nextInt(SuperDeck.NUM_OF_CARDS), this.rand.nextInt(SuperDeck.NUM_OF_CARDS));
		}
	}

	public Card getTopCard() {
		Card topCard = null;
		if (!this.cards.isEmpty()) {
			topCard = this.cards.pop();
		}
		return topCard;
	}

	public void backCard(Set<Card> playerCards) {
		for (Card card : playerCards) {
			this.cards.push(card);
		}
	}

	public int getCardsCount() {
		return this.cards.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(500);
		List<Card> listOfCard = new ArrayList<Card>(this.cards);
		sb.append("###############################################\n");
		sb.append("Cards:\n");
		int i = 0;
		for (Card card : listOfCard) {
			sb.append("[").append(i + 1).append("] ").append(card).append("\n");
			i++;
		}
		sb.append("###############################################\n");
		return sb.toString();
	}

}
