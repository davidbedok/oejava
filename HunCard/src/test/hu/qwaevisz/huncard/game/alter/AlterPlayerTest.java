package hu.qwaevisz.huncard.game.alter;

import hu.qwaevisz.huncard.common.Card;
import hu.qwaevisz.huncard.common.CardRank;
import hu.qwaevisz.huncard.common.CardSuit;

import java.util.Set;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlterPlayerTest {

	@Test(groups = "unit")
	public void Add_three_card_to_Player_and_return_the_appropriate_values_of_card_TestCase1() {
		AlterPlayer player = new AlterPlayer("Nemecsek Erno");
		player.addCard(new Card(CardSuit.Leaves, CardRank.King));
		player.addCard(new Card(CardSuit.Bells, CardRank.l8));
		player.addCard(new Card(CardSuit.Hearts, CardRank.King));

		Assert.assertEquals(player.getCardsValue(), 226);

		player.dropCards();

		Assert.assertEquals(player.getCardsValue(), 0);
	}

	@Test(groups = "unit")
	public void Add_three_card_to_Player_and_return_the_appropriate_values_of_card_TestCase2() {
		Card cardOne = Mockito.mock(Card.class);
		Card cardTwo = Mockito.mock(Card.class);
		Card cardThree = Mockito.mock(Card.class);

		Mockito.when(cardOne.getValue()).thenReturn(10);
		Mockito.when(cardTwo.getValue()).thenReturn(20);
		Mockito.when(cardThree.getValue()).thenReturn(30);

		AlterPlayer player = new AlterPlayer("Nemecsek Erno");

		player.addCard(cardOne);
		player.addCard(cardTwo);
		player.addCard(cardThree);

		Assert.assertEquals(player.getCardsValue(), 60);

		Mockito.verify(cardOne).getValue();
		Mockito.verify(cardTwo).getValue();
		Mockito.verify(cardThree).getValue();

		Set<Card> dropCards = player.dropCards();

		Assert.assertEquals(player.getCardsValue(), 0);
		Assert.assertEquals(dropCards.size(), 3);
		Assert.assertTrue(dropCards.contains(cardOne));
		Assert.assertTrue(dropCards.contains(cardTwo));
		Assert.assertTrue(dropCards.contains(cardThree));
	}

}
