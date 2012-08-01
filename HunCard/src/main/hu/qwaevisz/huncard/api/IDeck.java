package hu.qwaevisz.huncard.api;

import hu.qwaevisz.huncard.common.Card;
import hu.qwaevisz.huncard.common.CardRank;
import hu.qwaevisz.huncard.common.CardSuit;

import java.util.Set;

public interface IDeck {

	int	NUM_OF_CARDS	= CardSuit.values().length * CardRank.values().length;
	int	NUM_ROTATE		= 100;

	void rotate();

	void rotate(int time);

	Card getTopCard();

	void backCard(Set<Card> playerCards);

	int getCardsCount();

}
