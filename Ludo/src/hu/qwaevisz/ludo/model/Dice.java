package hu.qwaevisz.ludo.model;

import java.util.Random;

public class Dice {

	private static final int MAX_VALUE = 6;

	private final Random random;

	public Dice(Random random) {
		this.random = random;
	}

	public int roll() {
		return this.random.nextInt(Dice.MAX_VALUE) + 1;
	}

}
