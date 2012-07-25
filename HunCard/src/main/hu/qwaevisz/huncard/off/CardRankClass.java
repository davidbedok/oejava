package hu.qwaevisz.huncard.off;

public class CardRankClass {

	public static final CardRankClass	l7		= new CardRankClass("7", 7);
	public static final CardRankClass	l8		= new CardRankClass("8", 8);
	public static final CardRankClass	l9		= new CardRankClass("9", 9);
	public static final CardRankClass	l10		= new CardRankClass("10", 10);
	public static final CardRankClass	Under	= new CardRankClass("Also", 15);
	public static final CardRankClass	Over	= new CardRankClass("Felso", 20);
	public static final CardRankClass	King	= new CardRankClass("Kiraly", 30);
	public static final CardRankClass	Ace		= new CardRankClass("Asz", 50);

	private final String				label;
	private final int					value;

	public CardRankClass(String label, int value) {
		this.label = label;
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.label;
	}

}