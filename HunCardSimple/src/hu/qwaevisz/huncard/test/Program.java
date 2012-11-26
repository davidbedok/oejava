package hu.qwaevisz.huncard.test;

import hu.qwaevisz.huncard.Card;
import hu.qwaevisz.huncard.CardRank;
import hu.qwaevisz.huncard.CardSuit;
import hu.qwaevisz.huncard.Deck;
import hu.qwaevisz.huncard.Game;
import hu.qwaevisz.huncard.Player;
import hu.qwaevisz.huncard.demo.CardRankC;

import java.util.Random;

public class Program {

	private static void testEnum(Random rand) {
		System.out.println("# Test Enum");
		CardRank cardRank = CardRank.King;
		System.out.println("Value of " + cardRank + ": " + cardRank.getValue());
		System.out.println(CardRank.randomRank(rand));
	}

	private static void testEnumAsClass() {
		System.out.println("# Test Enum as Class");
		CardRankC cardRank = CardRankC.King;
		System.out.println("Value of " + cardRank + ": " + cardRank.getValue());
	}

	private static void testRandom() {
		Random r1 = new Random();
		Random r2 = new Random();
		Random r3 = new Random();
		System.out.println(r1.nextInt());
		System.out.println(r2.nextInt());
		System.out.println(r3.nextInt());
		System.out.println(r1.nextInt());
		System.out.println(r2.nextInt());
		System.out.println(r3.nextInt());
	}

	private static void testForEach() {
		String[] names = { "Alice", "Bob", "Charli", "Delta", "India" };
		for (String name : names) {
			System.out.println(name);
		}
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}

	private static void testCard(Random rand) {
		System.out.println("# Test Card");
		Card card = new Card(CardRank.Ace, CardSuit.Leaves);
		System.out.println(card);
		System.out.println("Value of card: " + card.value());
		System.out.println(Card.randomCard(rand));
	}

	private static void testDeck(Random rand) {
		System.out.println("# Test Deck");
		Deck deck = new Deck(rand);
		System.out.println(deck);
		System.out.println(deck.topCard());
		System.out.println(deck.topCard());
		System.out.println(deck.topCard());
		System.out.println(deck);
		deck.rotate();
		System.out.println(deck);
	}

	private static void testPlayer() {
		System.out.println("# Test Player");
		Player player = new Player("Nemecsek Erno");
		player.addCard(new Card(CardRank.King, CardSuit.Hearts));
		player.addCard(new Card(CardRank.r7, CardSuit.Leaves));
		player.addCard(new Card(CardRank.Over, CardSuit.Bells));
		System.out.println(player);
		player.dropCards();
		System.out.println(player);
	}

	private static void testGame(Random rand) {
		System.out.println("# Test Game");
		Game game = new Game(rand);
		game.addPlayer("Nemecsek Erno");
		game.addPlayer("Darth Vader");
		game.addPlayer("Anakin Skywalker");
		System.out.println(game.play());
		System.out.println(game);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Program.testEnum(rand);
		// Program.testEnumAsClass();
		// Program.testRandom();
		// Program.testForEach();
		Program.testCard(rand);
		Program.testDeck(rand);
		Program.testPlayer();
		Program.testGame(rand);
	}

}
