package hu.qwaevisz.huncard.game.simple;

import hu.qwaevisz.huncard.common.Card;

import java.util.Arrays;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GameTest {

	private Game	game;

	@Mock
	private Deck	mockedDeck;
	@Mock
	private Player	mockedPlayer1;
	@Mock
	private Player	mockedPlayer2;

	private Card[]	mockedCards;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockedCards = new Card[Deck.NUM_OF_CARDS];
		for (int i = 1; i < Deck.NUM_OF_CARDS; i++) {
			this.mockedCards[i] = this.createMockedCard(i);
		}
		Mockito.when(this.mockedDeck.getTopCard()).thenReturn(this.mockedCards[0], Arrays.copyOfRange(this.mockedCards, 1, Deck.NUM_OF_CARDS));

		this.game = new Game(this.mockedDeck);

		this.mockedPlayer1 = Mockito.mock(Player.class);
		Mockito.when(this.mockedPlayer1.getCardsValue()).thenReturn(40);
		this.mockedPlayer2 = Mockito.mock(Player.class);
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
		Player winner = this.game.newGame();
		Mockito.verify(this.mockedPlayer1).dropCards();
		Mockito.verify(this.mockedPlayer2).dropCards();
		Mockito.verify(this.mockedDeck).rotate(Deck.NUM_ROTATE);
		Mockito.verify(this.mockedPlayer1).addCard(this.mockedCards[0]);
		Mockito.verify(this.mockedPlayer2).addCard(this.mockedCards[1]);
		Mockito.verify(this.mockedPlayer1).addCard(this.mockedCards[2]);
		Mockito.verify(this.mockedPlayer2).addCard(this.mockedCards[3]);
		Mockito.verify(this.mockedPlayer1).addCard(this.mockedCards[4]);
		Mockito.verify(this.mockedPlayer2).addCard(this.mockedCards[5]);
		Assert.assertEquals(winner, this.mockedPlayer2);
	}
}
