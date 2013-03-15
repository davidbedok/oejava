package hu.qwaevisz.huncard;

public class Player {

	public static final int NUM_OF_CARDS = 3;

	private final String name;
	private final Card[] cards;
	private int currentCardIndex;

	public Player(String name) {
		this.name = name;
		this.cards = new Card[Player.NUM_OF_CARDS];
		this.currentCardIndex = 0;
	}

	public void addCard(Card card) {
		if (this.currentCardIndex < this.cards.length) {
			this.cards[this.currentCardIndex++] = card;
		}
	}

	public void dropCards() {
		this.currentCardIndex = 0;
	}

	public int cardValues() {
		int values = 0;
		for (int i = 0; i < this.currentCardIndex; i++) {
			values += this.cards[i].value();
		}
		return values;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(40);
		info.append(this.name).append(" card values: ").append(this.cardValues()).append("\n");
		for (int i = 0; i < this.currentCardIndex; i++) {
			info.append("[").append((i + 1)).append("] ");
			info.append(this.cards[i]).append("\n");
		}
		return info.toString();
	}

}
