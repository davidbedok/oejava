package hu.qwaevisz.huncard;

import java.util.Random;

public enum CardSuit {

	Acorns(1, "Makk"), //
	Bells(2, "Tok"), //
	Leaves(3, "Zold"), //
	Hearts(4, "Piros");

	private int value;
	private String label;

	private CardSuit(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public int getValue() {
		return this.value;
	}

	public String getLabel() {
		return this.label;
	}

	public static CardSuit fromValue(int value) {
		CardSuit ret = CardSuit.getDefault();
		CardSuit[] cardSuits = CardSuit.values();
		int i = 0;
		while ((i < cardSuits.length) && (cardSuits[i].getValue() != value)) {
			i++;
		}
		if (i < cardSuits.length) {
			ret = cardSuits[i];
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
		return this.label;
	}

}