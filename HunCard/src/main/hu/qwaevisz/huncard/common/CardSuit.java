package hu.qwaevisz.huncard.common;

import java.util.Random;

public enum CardSuit {

	Acorns(1, "Makk"), //
	Bells(2, "Tok"), //
	Leaves(3, "Zold"), //
	Hearts(4, "Piros");

	private int		value;
	private String	hungarianName;

	private CardSuit(int value, String hungarianName) {
		this.value = value;
		this.hungarianName = hungarianName;
	}

	public int getValue() {
		return this.value;
	}

	public String getHungarianName() {
		return this.hungarianName;
	}

	public static CardSuit fromValue(int value) {
		CardSuit ret = CardSuit.getDefault();
		for (CardSuit cs : CardSuit.values()) {
			if (cs.getValue() == value) {
				ret = cs;
			}
		}
		return ret;
	}

	public static CardSuit getDefault() {
		return CardSuit.Acorns;
	}

	public static CardSuit randomSuit(Random rand) {
		CardSuit[] values = CardSuit.values();
		return values[rand.nextInt(values.length)];
	}

	@Override
	public String toString() {
		return this.hungarianName;
	}

}