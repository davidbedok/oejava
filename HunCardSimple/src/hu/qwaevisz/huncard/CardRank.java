package hu.qwaevisz.huncard;

import java.util.Random;

public enum CardRank {

	r7(7, false, "7"), //
	r8(8, false, "8"), //
	r9(9, false, "9"), //
	r10(10, false, "10"), //
	Under(15, true, "Also"), //
	Over(20, true, "Felso"), //
	King(30, true, "Kiraly"), //
	Ace(50, true, "Asz");

	private final int value;
	private final boolean figure;
	private final String label;

	private CardRank(int value, boolean figure, String label) {
		this.value = value;
		this.figure = figure;
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public int getValue() {
		return this.value;
	}

	public boolean isFigure() {
		return this.figure;
	}

	public static CardRank getDefault() {
		return CardRank.r7;
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
