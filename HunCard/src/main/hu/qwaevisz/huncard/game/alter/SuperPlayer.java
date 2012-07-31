package hu.qwaevisz.huncard.game.alter;

import hu.qwaevisz.huncard.common.Card;
import hu.qwaevisz.huncard.game.simple.Player;

import java.util.HashSet;
import java.util.Set;

public class SuperPlayer {

	public static final int	NUM_OF_PLAYER_CARDS	= 3;

	private final String	name;
	private final Set<Card>	cards;

	public SuperPlayer(String name) {
		this.name = name;
		this.cards = new HashSet<Card>();
	}

	public void addCard(Card card) {
		if (this.cards.size() < Player.NUM_OF_PLAYER_CARDS) {
			this.cards.add(card);
		}
	}

	public Set<Card> dropCards() {
		Set<Card> dropCards = new HashSet<Card>(this.cards);
		this.cards.clear();
		return dropCards;
	}

	// other way 1: return -1 if not enough cards
	// other way 2: throw NotEnoughCardsException (maybe a parameter, how many cards missing)
	public int getCardsValue() {
		int ret = 0;
		for (Card card : this.cards) {
			ret += card.getValue();
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
		int i = 0;
		for (Card card : this.cards) {
			sb.append("[").append(i + 1).append("] ").append(card).append("\n");
			i++;
		}
		sb.append("------------------------------------------------\n");
		return sb.toString();
	}

}
