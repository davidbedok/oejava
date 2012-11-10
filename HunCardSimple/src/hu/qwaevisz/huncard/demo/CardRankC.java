package hu.qwaevisz.huncard.demo;


public class CardRankC {

	public final static CardRankC r7 = new CardRankC(7, false, "7");
	public final static CardRankC r8 = new CardRankC(8, false, "8");
	public final static CardRankC r9 = new CardRankC(9, false, "9");
	public final static CardRankC r10 = new CardRankC(10, false, "10");
	public final static CardRankC Under = new CardRankC(15, true, "Also");
	public final static CardRankC Over = new CardRankC(20, true, "Felso");
	public final static CardRankC King = new CardRankC(30, true, "Kiraly");
	public final static CardRankC Ace = new CardRankC(50, true, "Asz");

	private final int value;
	private final boolean figure;
	private final String label;

	private CardRankC(int value, boolean figure, String label) {
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

	public static CardRankC getDefault() {
		return CardRankC.r7;
	}

	@Override
	public String toString() {
		return this.label;
	}

}
