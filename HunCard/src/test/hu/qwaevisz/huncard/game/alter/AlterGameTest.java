package hu.qwaevisz.huncard.game.alter;

import hu.qwaevisz.huncard.api.IDeck;
import hu.qwaevisz.huncard.common.Card;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlterGameTest {

	private AlterGame	game;

	@Mock
	private AlterDeck	mockedDeck;
	@Mock
	private AlterPlayer	mockedPlayer1;
	@Mock
	private AlterPlayer	mockedPlayer2;

	private Card[]		mockedCards;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockedCards = new Card[IDeck.NUM_OF_CARDS];
		this.mockedCards[0] = this.createMockedCard(0);
		for (int i = 1; i < IDeck.NUM_OF_CARDS; i++) {
			this.mockedCards[i] = this.createMockedCard(i);
		}
		Mockito.when(this.mockedDeck.getTopCard()).thenReturn(this.mockedCards[0], Arrays.copyOfRange(this.mockedCards, 1, IDeck.NUM_OF_CARDS));

		this.game = new AlterGame(this.mockedDeck);

		this.mockedPlayer1 = Mockito.mock(AlterPlayer.class);
		Mockito.when(this.mockedPlayer1.getCardsValue()).thenReturn(40);
		this.mockedPlayer2 = Mockito.mock(AlterPlayer.class);
		Mockito.when(this.mockedPlayer2.getCardsValue()).thenReturn(42);
		this.game.addPlayer(this.mockedPlayer1);
		this.game.addPlayer(this.mockedPlayer2);
	}

	private Card createMockedCard(Integer value) {
		Card mockedCard = Mockito.mock(Card.class);
		Mockito.when(mockedCard.getValue()).thenReturn(value);
		return mockedCard;
	}

	@Test(groups = "unit")
	public void Start_new_game() {
		Set<Card> emptySet = new HashSet<Card>();
		Mockito.when(this.mockedPlayer1.dropCards()).thenReturn(emptySet);
		Mockito.when(this.mockedPlayer2.dropCards()).thenReturn(emptySet);

		AlterPlayer winner = (AlterPlayer) this.game.newGame();
		Mockito.verify(this.mockedPlayer1).dropCards();
		Mockito.verify(this.mockedDeck, Mockito.times(2)).backCard(emptySet);
		Mockito.verify(this.mockedPlayer2).dropCards();
		Mockito.verify(this.mockedDeck).rotate(IDeck.NUM_ROTATE);
		Mockito.verify(this.mockedPlayer1).addCard(this.mockedCards[0]);
		Mockito.verify(this.mockedPlayer2).addCard(this.mockedCards[1]);
		Mockito.verify(this.mockedPlayer1).addCard(this.mockedCards[2]);
		Mockito.verify(this.mockedPlayer2).addCard(this.mockedCards[3]);
		Mockito.verify(this.mockedPlayer1).addCard(this.mockedCards[4]);
		Mockito.verify(this.mockedPlayer2).addCard(this.mockedCards[5]);
		Assert.assertEquals(winner, this.mockedPlayer2);
	}

}
