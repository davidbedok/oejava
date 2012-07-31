package hu.qwaevisz.huncard.game.simple;

import hu.qwaevisz.huncard.common.Card;
import hu.qwaevisz.huncard.common.CardRank;
import hu.qwaevisz.huncard.common.CardSuit;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeckTest {

	@Test(groups = "unit")
	public void The_whole_deck_is_ready_to_use() {
		Deck hunDeck = new Deck(new Random());

		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Acorns, CardRank.l7));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Acorns, CardRank.l8));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Acorns, CardRank.l9));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Acorns, CardRank.l10));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Acorns, CardRank.Under));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Acorns, CardRank.Over));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Acorns, CardRank.King));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Acorns, CardRank.Ace));

		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Bells, CardRank.l7));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Bells, CardRank.l8));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Bells, CardRank.l9));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Bells, CardRank.l10));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Bells, CardRank.Under));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Bells, CardRank.Over));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Bells, CardRank.King));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Bells, CardRank.Ace));

		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Leaves, CardRank.l7));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Leaves, CardRank.l8));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Leaves, CardRank.l9));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Leaves, CardRank.l10));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Leaves, CardRank.Under));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Leaves, CardRank.Over));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Leaves, CardRank.King));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Leaves, CardRank.Ace));

		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Hearts, CardRank.l7));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Hearts, CardRank.l8));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Hearts, CardRank.l9));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Hearts, CardRank.l10));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Hearts, CardRank.Under));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Hearts, CardRank.Over));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Hearts, CardRank.King));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Hearts, CardRank.Ace));
	}

	@Test(groups = "unit")
	public void After_custom_rotate_of_deck_every_cards_remains_unique() {
		Deck hunDeck = new Deck(new Random());
		Set<Card> setOfCards = new HashSet<Card>();
		for (int i = 0; i < 32; i++) {
			setOfCards.add(hunDeck.getTopCard());
		}
		Assert.assertEquals(setOfCards.size(), 32);
	}

	@Test(groups = "unit")
	public void Rotate_deck_with_mock() {
		Random mockedRandom = Mockito.mock(Random.class);
		Mockito.when(mockedRandom.nextInt(32)).thenReturn(0).thenReturn(1);
		Deck hunDeck = new Deck(mockedRandom);
		hunDeck.rotate(1);
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Acorns, CardRank.l8));
		Assert.assertEquals(hunDeck.getTopCard(), new Card(CardSuit.Acorns, CardRank.l7));
	}

}
