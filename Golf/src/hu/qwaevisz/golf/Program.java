package hu.qwaevisz.golf;

import java.util.Random;

public class Program {

	public static void main(String[] args) {
		Random rand = new Random();
		GolfGame game = new GolfGame(rand);
		System.out.println(game);

		System.out.println(game.simulate());

	}

}
