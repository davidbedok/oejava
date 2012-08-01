package hu.qwaevisz.huncard.game.alter;

import hu.qwaevisz.huncard.api.AbstractPlayer;
import hu.qwaevisz.huncard.api.IPlayer;
import hu.qwaevisz.huncard.common.Card;

import java.util.HashSet;
import java.util.Set;

public class AlterPlayer extends AbstractPlayer {

	private final Set<Card>	cards;

	public AlterPlayer(String name) {
		super(name);
		this.cards = new HashSet<Card>();
	}

	@Override
	public void addCard(Card card) {
		if (this.cards.size() < IPlayer.NUM_OF_PLAYER_CARDS) {
			this.cards.add(card);
		}
	}

	@Override
	public Set<Card> dropCards() {
		Set<Card> dropCards = new HashSet<Card>(this.cards);
		this.cards.clear();
		return dropCards;
	}

	@Override
	public int getCardsValue() {
		int ret = 0;
		for (Card card : this.cards) {
			ret += card.getValue();
		}
		return ret;
	}

	@Override
	public String toStringCards() {
		StringBuilder sb = new StringBuilder(500);
		int i = 0;
		for (Card card : this.cards) {
			sb.append("[").append(i + 1).append("] ").append(card).append("\n");
			i++;
		}
		return sb.toString();
	}

}
