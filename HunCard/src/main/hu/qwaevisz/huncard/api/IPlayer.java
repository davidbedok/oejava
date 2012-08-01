package hu.qwaevisz.huncard.api;

import hu.qwaevisz.huncard.common.Card;

import java.util.Set;

public interface IPlayer {

	int	NUM_OF_PLAYER_CARDS	= 3;

	void addCard(Card card);

	Set<Card> dropCards();

	int getCardsValue();

}
