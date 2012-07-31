package hu.qwaevisz.huncard.common;

import java.util.Random;

public enum CardRank {

	l7(7, false, "7"), //
	l8(8, false, "8"), //
	l9(9, false, "9"), //
	l10(10, false, "10"), //
	Under(15, true, "Also"), //
	Over(20, true, "Felso"), //
	King(30, true, "Kiraly"), //
	Ace(50, true, "Asz");

	private final int		value;
	private final boolean	isFigure;
	private final String	label;

	private CardRank(int clvalue, boolean isFigure, String label) {
		this.value = clvalue;
		this.isFigure = isFigure;
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public int getValue() {
		return this.value;
	}

	public boolean isFigure() {
		return this.isFigure;
	}

	public static CardRank getDefault() {
		return CardRank.l7;
	}

	public static CardRank randomRank(Random rand) {
		CardRank[] values = CardRank.values();
		return values[rand.nextInt(values.length)];
	}

	@Override
	public String toString() {
		return this.label;
	}

}
