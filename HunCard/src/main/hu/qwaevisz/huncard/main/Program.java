package hu.qwaevisz.huncard.main;

import hu.qwaevisz.huncard.card.Card;
import hu.qwaevisz.huncard.card.CardRank;
import hu.qwaevisz.huncard.card.CardSuit;
import hu.qwaevisz.huncard.game.Deck;
import hu.qwaevisz.huncard.game.Game;
import hu.qwaevisz.huncard.game.Player;
import hu.qwaevisz.huncard.off.Fruit;

public class Program {

	public static void useCard() {
		System.out.println("\nUse card...\n");
		Card iCard = new Card(CardSuit.Leaves, CardRank.King);

		System.out.println("Card instance --> " + iCard);
		System.out.println("Card value --> " + iCard.getValue());

		iCard = Card.getRandomCard();
		System.out.println("card instance --> " + iCard);
	}

	public static void usePlayer() {
		System.out.println("\nUse player...\n");

		Player iPlayer = new Player("Nemecsek Erno");
		iPlayer.addCard(new Card(CardSuit.Leaves, CardRank.King));
		iPlayer.addCard(CardSuit.Bells, CardRank.l8);
		iPlayer.addCard(Card.getRandomCard());

		System.out.println(iPlayer);
	}

	public static void useDeck() {
		System.out.println("\nUse deck...\n");

		Deck iDeck = new Deck();
		System.out.println(iDeck);
		iDeck.rotate(Deck.NUM_ROTATE);
		System.out.println("After rotate:");
		System.out.println(iDeck);

		System.out.println("Top 3 cards:");
		System.out.println(iDeck.getTopCard());
		System.out.println(iDeck.getTopCard());
		System.out.println(iDeck.getTopCard());
	}

	public static void playGame() {
		System.out.println("\nPlay game...\n");

		Game iGame = new Game();
		iGame.addPlayer(new Player("Hannibal Lexter"));
		iGame.addPlayer("Nemecsek Erno");
		iGame.addPlayer("Mekk Elek");

		System.out.println("The winner is: \n" + iGame.newGame());
		System.out.println(iGame);
		System.out.println("The winner is: \n" + iGame.newGame());
	}

	public static void testEnum() {
		Fruit f = Fruit.Plum;
		if (f.equals(Fruit.Appricot)) {

		}

	}

	public static void main(String[] args) {
		// Program.testEnum();
		// Program.useCard();
		// Program.usePlayer();
		// Program.useDeck();
		Program.playGame();
	}

}
