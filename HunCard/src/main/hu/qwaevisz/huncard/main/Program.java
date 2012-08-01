package hu.qwaevisz.huncard.main;

import hu.qwaevisz.huncard.api.IDeck;
import hu.qwaevisz.huncard.common.Card;
import hu.qwaevisz.huncard.common.CardRank;
import hu.qwaevisz.huncard.common.CardSuit;
import hu.qwaevisz.huncard.game.alter.AlterGame;
import hu.qwaevisz.huncard.game.alter.AlterPlayer;
import hu.qwaevisz.huncard.game.simple.Deck;
import hu.qwaevisz.huncard.game.simple.Game;
import hu.qwaevisz.huncard.game.simple.Player;
import hu.qwaevisz.huncard.off.CardRankClass;
import hu.qwaevisz.huncard.off.Fruit;

import java.util.Random;

public class Program {

	public static void useCard(Random rand) {
		System.out.println("\nUse card...\n");
		Card iCard = new Card(CardSuit.Leaves, CardRank.King);

		System.out.println("Card instance --> " + iCard);
		System.out.println("Card value --> " + iCard.getValue());

		iCard = Card.getRandomCard(rand);
		System.out.println("card instance --> " + iCard);
	}

	public static void usePlayer(Random rand) {
		System.out.println("\nUse player...\n");

		Player iPlayer = new Player("Nemecsek Erno");
		iPlayer.addCard(new Card(CardSuit.Leaves, CardRank.King));
		iPlayer.addCard(CardSuit.Bells, CardRank.l8);
		iPlayer.addCard(Card.getRandomCard(rand));

		System.out.println(iPlayer);
	}

	public static void useDeck() {
		System.out.println("\nUse deck...\n");

		Deck iDeck = new Deck(new Random());
		System.out.println(iDeck);
		iDeck.rotate(IDeck.NUM_ROTATE);
		System.out.println("After rotate:");
		System.out.println(iDeck);

		System.out.println("Top 3 cards:");
		System.out.println(iDeck.getTopCard());
		System.out.println(iDeck.getTopCard());
		System.out.println(iDeck.getTopCard());
	}

	public static void playGame() {
		System.out.println("\nPlay game...\n");

		Game iGame = new Game(new Random());
		iGame.addPlayer(new Player("Hannibal Lexter"));
		iGame.addPlayer("Nemecsek Erno");
		iGame.addPlayer("Mekk Elek");

		System.out.println("The winner is: \n" + iGame.newGame());
		System.out.println(iGame);
		System.out.println("The winner is: \n" + iGame.newGame());
	}

	public static void playSuperGame() {
		System.out.println("\nPlay alter game...\n");

		AlterGame iGame = new AlterGame(new Random());
		iGame.addPlayer(new AlterPlayer("Hannibal Lexter"));
		iGame.addPlayer("Nemecsek Erno");
		iGame.addPlayer("Mekk Elek");

		System.out.println("==== GAME A ==== \n");
		System.out.println("The winner is: \n" + iGame.newGame());
		System.out.println(iGame);
		System.out.println("==== GAME B ==== \n");
		System.out.println("The winner is: \n" + iGame.newGame());
		System.out.println(iGame);
	}

	public static void testEnum() {
		Fruit f = Fruit.Plum;

		CardRank rank = CardRank.l10;
		rank.getValue();
		CardRankClass rankClass = CardRankClass.King;
		rankClass.getValue();
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Program.testEnum();
		Program.useCard(rand);
		Program.usePlayer(rand);
		Program.useDeck();
		Program.playGame();
		Program.playSuperGame();
	}

}
