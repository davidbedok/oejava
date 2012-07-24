package hu.qwaevisz.card;

public enum CardSuit {

	// public static final CardSuit Acorns = new CardSuit(0,1,"Makk");
	// CardSuit.Acorns --> statikus eleres

	Acorns(0, 1, "Makk"), //
	Bells(1, 2, "Tok"), //
	Leaves(2, 3, "Zold"), //
	Hearts(3, 4, "Piros");

	private int order;
	private int value;
	private String hungarianName;

	private CardSuit(int order, int value, String hungarianName) {
		this.order = order;
		this.value = value;
		this.hungarianName = hungarianName;
	}

	public int getOrder() {
		return this.order;
	}

	public int getValue() {
		return this.value;
	}

	public String getHungarianName() {
		return this.hungarianName;
	}

	public static CardSuit fromOrder(int order) {
		CardSuit ret = CardSuit.getDefault();
		for (CardSuit cs : CardSuit.values()) {
			if (cs.getOrder() == order) {
				ret = cs;
			}
		}
		return ret;
	}

	public static CardSuit getDefault() {
		return CardSuit.Acorns;
	}

	@Override
	public String toString() {
		return this.hungarianName;
	}

}