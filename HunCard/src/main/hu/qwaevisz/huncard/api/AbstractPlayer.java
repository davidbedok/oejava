package hu.qwaevisz.huncard.api;

public abstract class AbstractPlayer implements IPlayer {

	private final String	name;

	public AbstractPlayer(String name) {
		this.name = name;
	}

	public String toPrint() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("Player " + this.name + ". ");
		sb.append("All card value: " + this.getCardsValue() + "\n");
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(500);
		sb.append("------------------------------------------------\n");
		sb.append(this.toPrint());
		sb.append(this.toStringCards());
		sb.append("------------------------------------------------\n");
		return sb.toString();
	}

	public abstract String toStringCards();

}
