package hu.qwaevisz.ludo.second.main;

import hu.qwaevisz.ludo.second.model.FigureColor;
import hu.qwaevisz.ludo.second.model.Game;
import hu.qwaevisz.ludo.second.model.Player;

import java.util.Random;

public class Program {

	private static void testPlayer() {
		System.out.println("# testPlayer()");
		Player player = new Player("Alice", FigureColor.Green, 10);
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

	public static void main(String[] args) {
		System.out.println("Second version");
		Random random = new Random();
		Program.testPlayer();
		Program.testGame(random);
	}

}
