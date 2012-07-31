package hu.qwaevisz.huncard.game.simple;

import hu.qwaevisz.huncard.common.Card;
import hu.qwaevisz.huncard.common.CardRank;
import hu.qwaevisz.huncard.common.CardSuit;
import hu.qwaevisz.huncard.game.simple.Player;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayerTest {

	@Test(groups = "unit")
	public void Add_three_card_to_Player_and_return_the_appropriate_values_of_card_TestCase1() {
		Player iPlayer = new Player("Nemecsek Erno");
		iPlayer.addCard(new Card(CardSuit.Leaves, CardRank.King));
		iPlayer.addCard(CardSuit.Bells, CardRank.l8);
		iPlayer.addCard(CardSuit.Hearts, CardRank.King);

		Assert.assertEquals(iPlayer.getCardsValue(), 226);

		iPlayer.dropCards();

		Assert.assertEquals(iPlayer.getCardsValue(), 0);
	}

	@Test(groups = "unit")
	public void Add_three_card_to_Player_and_return_the_appropriate_values_of_card_TestCase2() {
		Card cardOne = Mockito.mock(Card.class);
		Card cardTwo = Mockito.mock(Card.class);
		Card cardThree = Mockito.mock(Card.class);

		Mockito.when(cardOne.getValue()).thenReturn(10);
		Mockito.when(cardTwo.getValue()).thenReturn(20);
		Mockito.when(cardThree.getValue()).thenReturn(30);

		Player iPlayer = new Player("Nemecsek Erno");

		iPlayer.addCard(cardOne);
		iPlayer.addCard(cardTwo);
		iPlayer.addCard(cardThree);

		Assert.assertEquals(iPlayer.getCardsValue(), 60);

		Mockito.verify(cardOne).getValue();
		Mockito.verify(cardTwo).getValue();
		Mockito.verify(cardThree).getValue();

		iPlayer.dropCards();

		Assert.assertEquals(iPlayer.getCardsValue(), 0);
	}

}
