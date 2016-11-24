package hu.qwaevisz.ludo.first.main;

import java.util.Random;

import hu.qwaevisz.ludo.first.model.Dice;
import hu.qwaevisz.ludo.first.model.FigureColor;
import hu.qwaevisz.ludo.first.model.Game;
import hu.qwaevisz.ludo.first.model.Player;
import hu.qwaevisz.ludo.first.model.Table;

public class Program {

	private static void testFigure() {
		System.out.println("# testFigure()");
		FigureColor figure = FigureColor.Blue;
		System.out.println(figure + " sign: " + figure.getSign());
	}

	private static void testDice(Random random) {
		System.out.println("# testDice()");
		Dice dice = new Dice(random);
		for (int i = 0; i < 10; i++) {
			System.out.print(dice.roll() + " ");
		}
		System.out.println();
	}

	private static void testPlayer() {
		System.out.println("# testPlayer()");
		Player player = new Player("Alice", FigureColor.Green, 20);
		System.out.println(player);
		player.start();
		player.start();
		player.start();
		player.finish();
		player.finish();
		System.out.println(player.printStart());
		System.out.println(player.printEnd());
	}

	private static void testTable() {
		System.out.println("# testTable()");

		Table table = new Table();
		Player player = new Player("Charlie", FigureColor.Green, table.getPlayersDistance() * 2);
		table.initFigure(player);

		System.out.println(table);
		table.moveFigure(player, 6);
		System.out.println(table);
		table.moveFigure(player, 3);
		System.out.println(table);
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
		System.out.println("First version");
		Random random = new Random();
		Program.testFigure();
		Program.testDice(random);
		Program.testPlayer();
		Program.testTable();
		// Program.testGame(random);
	}

}
