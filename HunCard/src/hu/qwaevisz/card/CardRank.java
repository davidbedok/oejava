package hu.qwaevisz.card;

public enum CardRank {

	l7(0, 7, false, "7"), //
	l8(1, 8, false, "8"), //
	l9(2, 9, false, "9"), //
	l10(3, 10, false, "10"), //
	Under(4, 15, true, "Also"), //
	Over(5, 20, true, "Felso"), //
	King(6, 30, true, "Kiraly"), //
	Ace(7, 50, true, "Asz");

	private int order;
	private int value;
	private boolean isFigure;
	private String label;

	private CardRank(int order, int clvalue, boolean isFigure, String label) {
		this.value = clvalue;
		this.isFigure = isFigure;
		this.order = order;
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

	public int getOrder() {
		return this.order;
	}

	public static CardRank fromOrder(int order) {
		CardRank ret = CardRank.getDefault();
		for (CardRank cr : CardRank.values()) {
			if (cr.getOrder() == order) {
				ret = cr;
			}
		}
		return ret;
	}

	public static CardRank getDefault() {
		return CardRank.l7;
	}

	@Override
	public String toString() {
		return this.label;
	}

}
