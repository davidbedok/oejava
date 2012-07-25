package hu.qwaevisz.huncard.card;

import hu.qwaevisz.huncard.card.Card;
import hu.qwaevisz.huncard.card.CardRank;
import hu.qwaevisz.huncard.card.CardSuit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CardTest {

	@Test(groups = "unit")
	public void main() {
		Card card = new Card(CardSuit.Acorns, CardRank.Ace);
		Assert.assertEquals(card.getValue(), 50);
	}

}
