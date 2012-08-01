package hu.qwaevisz.huncard.api;

import java.util.Random;

public abstract class AbstractDeck implements IDeck {

	protected final Random	rand;

	public AbstractDeck(Random rand) {
		this.rand = rand;
	}

	@Override
	public void rotate() {
		this.rotate(IDeck.NUM_ROTATE);
		// Collections.shuffle(deck);
	}

	@Override
	public void rotate(int time) {
		for (int i = 0; i < time; i++) {
			this.changeCards(this.rand.nextInt(IDeck.NUM_OF_CARDS), this.rand.nextInt(IDeck.NUM_OF_CARDS));
		}
	}

	protected abstract void changeCards(int indexA, int indexB);

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(500);
		sb.append("###############################################\n");
		sb.append("Cards:\n");
		sb.append(this.toStringCards());
		sb.append("###############################################\n");
		return sb.toString();
	}

	public abstract String toStringCards();

}
