package hu.qwaevisz.ludo.main;

import hu.qwaevisz.ludo.model.Dice;
import hu.qwaevisz.ludo.model.Figure;
import hu.qwaevisz.ludo.model.Game;
import hu.qwaevisz.ludo.model.Player;

import java.util.Random;

public class Program {

	private static void testFigure() {
		System.out.println("# testFigure()");
		Figure figure = Figure.Blue;
		System.out.println(figure + " sign: " + figure.getSign());
	}

	private static void testDice(Random random) {
		System.out.println("# testDice()");
		Dice dice = new Dice(random);
		for (int i = 0; i < 10; i++) {
			System.out.print(dice.roll() + " ");
		}
	}

	private static void testPlayer() {
		System.out.println("# testPlayer()");
		Player player = new Player("Alice", Figure.Green, 10);
		System.out.println(player);
		player.start();
		player.start();
		player.start();
		player.finish();
		player.finish();
		System.out.println(player.printStart());
		System.out.println(player.printEnd());
	}

	private static void testGame(Random random) {
		Game game = new Game(random);
		game.addPlayers("Alice", "Bob", "Charlie", "Delta");

		int i = 1;
		while (!game.isFinish()) {
			System.out.println("(" + i + ") " + game.step());
			System.out.println(game);
			i++;
		}
		System.out.println(game.printPalpitating());

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		Program.testFigure();
		Program.testDice(random);
		Program.testPlayer();
		Program.testGame(random);
	}

}
