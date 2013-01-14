package hu.qwaevisz.ludo.main;

import hu.qwaevisz.ludo.model.Game;

import java.util.Random;

public class Program {

	private static void testGame(Random random) {
		Game game = new Game(random);
		game.addPlayer("Alice");
		game.addPlayer("Bob");
		game.addPlayer("Charlie");
		game.addPlayer("Delta");

		System.out.println(game);

		for (int i = 0; i < 1000; i++) {
			System.out.println(i + " - " + game.step());
			System.out.println(game.printMap());

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		Program.testGame(random);
	}

}
