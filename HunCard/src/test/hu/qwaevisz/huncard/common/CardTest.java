package hu.qwaevisz.huncard.common;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CardTest {

	@Test(groups = "unit")
	public void Create_card_than_get_its_value() {
		Card card = new Card(CardSuit.Acorns, CardRank.Ace);
		Assert.assertEquals(card.getValue(), 50);
	}

	@Test(groups = "unit")
	public void Two_cards_should_be_equals_if_rank_and_suit_are_the_same() {
		Card cardOne = new Card(CardSuit.Acorns, CardRank.Ace);
		Card cardTwo = new Card(CardSuit.Acorns, CardRank.Ace);
		Card cardThree = new Card(CardSuit.Acorns, CardRank.Under);
		Assert.assertEquals(cardOne, cardTwo);
		Assert.assertEquals(cardOne, cardOne);
		Assert.assertEquals(cardTwo, cardTwo);
		Assert.assertNotEquals(cardOne, null);
		Assert.assertNotEquals(null, cardTwo);
		Assert.assertNotEquals(cardThree, cardOne);
		Assert.assertNotEquals(cardThree, cardTwo);
	}

}
